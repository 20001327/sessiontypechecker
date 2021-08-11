%%%-------------------------------------------------------------------
%%% @author Lorenzo
%%% @copyright (C) 2021, <COMPANY>
%%% @doc
%%% @end
%%%-------------------------------------------------------------------
-module(bob).
-include_lib("eunit/include/eunit.hrl").
-include_lib("records.hrl").

-export([start/0, loop/1, loop_delegate/1]).


-define(ADDRESS, "Passo del fossato di San Barnaba").
-define(SERVER, ?MODULE).


%%%===================================================================
%%% Spawning and gen_server implementation
%%%===================================================================


start()->
    register(?MODULE, spawn(?MODULE, loop, [#buyer_actor{}])).


loop(State)->
    NewState = receive
        {message,From,_To,get_state} ->
            From ! State,
            State;
        {message,_From,_To,Input = {quote,_Quote}} ->
            do_interaction(State, Input);
        {message,_From,_To,Input = {myquote,_MyQuote}} ->
            io:format("BOB: receive his contr ~p~n", [_MyQuote]),
            do_interaction(State, Input);
        {message,From,_To,{time, _Time}} ->
            St = if (State#buyer_actor.quote =/= undefined) andalso
                    (State#buyer_actor.myquote =/= undefined) andalso
                    (State#buyer_actor.buy == true) ->
                      io:format("BOB: receive time from ~p: ~p~n", [From,_Time]),
                      three_buyer:send_message(bob,alice,okay),
                      #buyer_actor{};
                 true -> State
            end,
            St;
        {message,_From,_To,end_delegation} ->
            #buyer_actor{};
        {message,_From,_To,quit} ->
              St = if State#buyer_actor.buy == false ->
                exit(ok),
              #buyer_actor{};
              true -> State
            end,
            St;
        _Message ->
            io:format("Alice received: ~p~n",[_Message]),
            State
    end,
    loop(NewState).


do_interaction(State, Input) ->
  Res = case Input of
    {quote, Num} ->
      MyQuote = State#buyer_actor.myquote,
      Quote = Num,
      do_interaction(inner,Quote,MyQuote,State);
    {myquote, Num} ->
      Quote = State#buyer_actor.quote,
      MyQuote = Num,
      do_interaction(inner,Quote,MyQuote,State)
       end,
  Res.

do_interaction(inner,Quote,MyQuote,State) ->
  Res = if (Quote =/= undefined) and (MyQuote =/= undefined) ->
    if Quote - MyQuote < 100 ->
      three_buyer:send_message(bob,seller,okay),
      three_buyer:send_message(bob,seller,{address,?ADDRESS}),
      State#buyer_actor{quote = Quote, myquote = MyQuote, buy = true};
    true ->
      three_buyer:send_message(bob,carol,{start_delegation,fun loop_delegate/1}),
      NState = State#buyer_actor{delegate=carol},
      three_buyer:send_message(bob,carol,{myquote,(Quote-MyQuote-99)}),
      NState
    end;
          true ->
            State#buyer_actor{quote = Quote, myquote = MyQuote}
        end,
  Res.

loop_delegate(State)->
    NewState = receive
        {message,From,_To,get_state} ->
            From ! State,
            State;
        {message,From,_To,{myquote,MyQuote}} ->
            io:format("~p(~p) receive his contribute ~p~n", [_To,?MODULE,MyQuote]),
            Res = if MyQuote < 100 ->
              three_buyer:send_message(State#buyer_actor.delegating,seller,okay),
              three_buyer:send_message(State#buyer_actor.delegating,seller,{address,?ADDRESS}),
              State#buyer_actor{myquote = MyQuote, buy = true};
            true ->
              io:format("~p sending quit~n", [_To]),
              three_buyer:send_message(State#buyer_actor.delegating,seller,quit),
              three_buyer:send_message(State#buyer_actor.delegating,alice,quit),
              three_buyer:send_message(From,State#buyer_actor.delegating,end_delegation),
              #buyer_actor{buy = false}
            end,
            Res;
        {message,From,_To,{time, _Time}} ->
            St = if (State#buyer_actor.myquote =/= undefined) andalso
                    (State#buyer_actor.buy == true) ->
                      io:format("~p(~p) receive time from ~p: ~p~n", [_To,?MODULE,From,_Time]),
                      three_buyer:send_message(?MODULE,alice,okay),
                      three_buyer:send_message(_To,bob,end_delegation),
                      #buyer_actor{};
                 true -> State
            end,
            St;
        _Message ->
            io:format("~p received: ~p~n",[State#buyer_actor.delegating,_Message]),
            State
    end,
    loop_delegate(NewState).
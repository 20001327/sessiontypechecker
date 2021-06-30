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
            State#buyer_actor{delegate=undefined};
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
      three_buyer:send_message(bob,carol,start_delegation),
      State#buyer_actor{delegate=carol}
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
            io:format("~p receive his contribute ~p~n", [From,MyQuote]),
            if MyQuote < 100 ->
              three_buyer:send_message(From,seller,okay),
              three_buyer:send_message(From,seller,{address,?ADDRESS}),
              State#buyer_actor{myquote = MyQuote, buy = true};
            true ->
              three_buyer:send_message(From,seller,quit),
              three_buyer:send_message(From,alice,quit),
              three_buyer:send_message(From,State#buyer_actor.delegating,end_delegation),
              #buyer_actor{buy = false}
            end;
        {message,From,_To,{time, _Time}} ->
            St = if (State#buyer_actor.myquote =/= undefined) andalso
                    (State#buyer_actor.buy == true) ->
                      io:format("BOB: receive time from ~p: ~p~n", [From,_Time]),
                      three_buyer:send_message(From,alice,okay),
                      three_buyer:send_message(From,State#buyer_actor.delegating,end_delegation),
                      #buyer_actor{};
                 true -> State
            end,
            St;
        _Message ->
            io:format("Alice received: ~p~n",[_Message]),
            State
    end,
    loop(NewState).
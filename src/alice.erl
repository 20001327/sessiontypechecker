-module(alice).

-include_lib("records.hrl").

-export([start/0, loop/1]).
-define(NO,2).

start()->
    register(?MODULE, spawn(?MODULE, loop, [#buyer_actor{number=?NO}])).


loop(State)->
    NewState = receive
        {message,From,_To,get_state} ->
            From ! State,
            State;
        {message,_From,_To,{quote,Quote}} ->
              St = if State#buyer_actor.quote == undefined ->
                  io:format("ALICE: quote receive from seller ~p~n", [Quote]),
                  three_buyer:send_message(alice,bob,{myquote,Quote/2}),
                  State#buyer_actor{quote = Quote};
                true -> State
              end,
              St;
        {message,_From,_To,okay} ->
            St = if State#buyer_actor.quote =/= undefined ->
              io:format("alice: received ok ~n"),
              #buyer_actor{number=?NO};
              true ->  State
              end,
              St;
        {message,_From,_To,quit} ->
              St = if State#buyer_actor.quote =/= undefined ->
                exit(ok),
              #buyer_actor{number=?NO};
              true -> State
            end,
            St;
        start_protocol ->
            three_buyer:send_message(alice,seller,{title,"Torah"}),
            State#buyer_actor{title = "Torah"};
        _Message ->
            io:format("Alice received: ~p~n",[_Message]),
            State
    end,
    loop(NewState).


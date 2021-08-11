-module(carol).

-include_lib("records.hrl").

-export([start/0, loop/1]).

start()->
    register(?MODULE, spawn(?MODULE, loop, [#buyer_actor{}])).


loop(State)->
    NewState = receive
        {message,From,_To,get_state} ->
                From ! State,
                State;
        {message,From,_To,{start_delegation,Fun}} ->
            Fun(State#buyer_actor{delegating=From});
        {message,_From,_To,quit} ->
              exit(ok);
        _Message ->
            io:format("Carol received: ~p~n",[_Message]),
            State
    end,
    loop(NewState).


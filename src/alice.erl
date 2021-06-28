-module(alice).

-include_lib("records.hrl").

-export([start/0, prova/0, loop/1]).

start()->
    register(?MODULE, spawn(?MODULE, loop, [#buyer_actor{number=1}])).


loop(State)->
    receive
        {message,From,_To,get_state} ->
            From ! State;
        _Message ->
            io:format("Alice received: ~p~n",[_Message])
    end,
    loop(State).

prova()->ok.

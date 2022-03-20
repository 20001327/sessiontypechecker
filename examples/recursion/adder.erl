-module(adder).

-export([start/0, init/0]).

start()->register(adder,spawn(adder, init, [])).

-type init() :: 'rec$init.client?add.client!tot<Int>.$init'.
init()->
  receive
    {client, 'add'} ->
        %io:format("ADDER: ~p + ~p~n", [Qta1,Qta2]),
        Tot = 1 + 1,
        client!{adder, 'tot', Tot},
        init()
  end.

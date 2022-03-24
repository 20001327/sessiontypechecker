-module(adder).

-export([start/0, init/0]).

start()->register(adder,spawn(adder, init, [])).

-type init() :: 'rec$init.client?add<Int,Int>.client!tot<Int>.$init'.
init()->
  receive
    {client, 'add', A1, A2} ->
        %io:format("ADDER: ~p + ~p~n", [Qta1,Qta2]),
        Tot = A1 + A2,
        client!{adder, 'tot', Tot},
        init();
    {client, 'stop'} ->
        'End'
  end.

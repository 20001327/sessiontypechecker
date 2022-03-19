-module(adder).

-export([start/0, init/0]).

start()->register(adder,spawn(adder, init, [])).

-type init() :: 'rec$t.client?add<Int,Int>.client!tot<Int>.$t'.
init()->
  receive
    {client, 'add', Qta1, Qta2} ->
        %io:format("ADDER: ~p + ~p~n", [Qta1,Qta2]),
        Tot = Qta1 + Qta2,
        client!{adder, 'tot', Tot},
        init();
  end.

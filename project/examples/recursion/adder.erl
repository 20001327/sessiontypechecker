-module(adder).

-export([start/0, init/0]).

start()->register(adder,spawn(adder, init, [])).

-spec init()->'#rec$loop.&(client?add<Int,Int>.client!t<Int>.$loop,client?stop.End)'.
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

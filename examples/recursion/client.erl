-module(client).

-export([start/0, init/0, loop/1]).

start()->
  register(client,spawn(client, init, [])).

-type init() :: 'rec$loop.@(adder!add.adder?tot<Int>.$loop,adder!stop.End)'.
init()->
  loop(10).

-type loop() :: 'Int->rec$loop.@(adder!add.adder?tot<Int>.$loop,adder!stop.End)'.
loop(Ending)->
    NewEnding = Ending - 1,
    case Ending>0 of
        true->
            adder!{client,'add'},
            receive
                {adder, 'tot', Tot} -> loop(NewEnding)
            end;
        false->
            adder!{client,'stop'},
            'End'
    end.



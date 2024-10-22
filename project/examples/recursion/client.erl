-module(client).

-export([start/0, init/0, loop/1]).

start()->
  register(client,spawn(client, init, [])).

-spec init()->'#rec$loop.@(adder!add<Int,Int>.adder?tot<Int>.$loop,adder!stop.End)'.
init()->
  loop(10).

-spec loop('#Int')->'#rec$loop.@(adder!add<Int,Int>.adder?tot<Int>.$loop,adder!stop.End)'.
loop(Ending)->
    NewEnding = Ending - 1,
    case Ending>0 of
        true->
            adder!{client,'add', 3, 4},
            receive
                {adder, 'tot', Tot} -> loop(NewEnding)
            end;
        false->
            adder!{client,'stop'},
            'End'
    end.



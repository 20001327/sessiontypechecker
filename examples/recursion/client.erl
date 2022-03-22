-module(client).

-export([start/0, init/0, loop/1]).

start()->
  register(client,spawn(client, init, [])).

-type init() :: '@(rec$internal.adder!add.adder?tot<Int>.$internal,adder!stop.End)'.
init()->
  loop(10).

-type loop() :: 'Int->@(rec$internal.adder!add.adder?tot<Int>.$internal,adder!stop.End)'.
loop(Ending)->
    NewEnding = Ending - 1,
    case Ending>0 of
    true->
        internal();
    false->
        adder!{client,'stop'},
        'End'
    end.

-type internal() :: 'rec$internal.adder!add.adder?tot<Int>.$internal'.
internal()->
    adder!{client,'add'},
    receive
        {adder, 'tot', Tot} ->
        %io:format("tot ~p~n", [Tot]),
        adder!{client,'add'}
    end,
    loop(NewEnding);
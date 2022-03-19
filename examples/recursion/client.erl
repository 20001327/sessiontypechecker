-module(client).

-export([start/0, init/0]).

start()->
  register(client,spawn(client, init, [])).

-type init() :: 'adder!add<Int,Int>.adder?tot<Int>.adder!add<Int,Int>.adder?tot<Int>.End'.
init()->
  adder!{client,'add',4,5},
  receive
    {adder, 'tot', Tot} ->
      %io:format("tot ~p~n", [Tot]),
      adder!{client,'add',2,5},
        receive
          {adder, 'tot', Tot1} ->
            %io:format("tot ~p~n", [Tot1]),
            adder!{client,'difference',6,5}
        end
  end.

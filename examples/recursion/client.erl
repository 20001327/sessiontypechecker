-module(client).

-export([start/0, init/0]).

start()->
  register(client,spawn(client, init, [])).

-type init() :: 'adder!add.adder?tot<Int>.adder!add.adder?tot<Int>.End'.
init()->
  adder!{client,'add'},
  receive
    {adder, 'tot', Tot} ->
      %io:format("tot ~p~n", [Tot]),
      adder!{client,'add'},
        receive
          {adder, 'tot', Tot1} ->
            'End'
        end
  end.

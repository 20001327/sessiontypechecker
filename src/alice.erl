-module(alice).

-export([start/0, init/0]).

start() ->
  register(alice, spawn(alice, init, [])).

-type init() :: 'alice prova'.
init() ->
  'seller'!{'alice','title',"Toy Story"},
  receive
    {'seller', 'quote', Quote} ->
      %%io:format("ALICE: quote receive from seller ~p~n", [Quote]),
      'bob' ! {'alice', 'myquote', Quote / 2},
      receive
        {'bob', 'ok'} ->
          'ok';
          %%io:format("ALICE: ok from bob ~n");
        {'bob', 'quit'} ->
          'quit'
          %%io:format("ALICE: quit from bob ~n")
      end
  end,
  unregister('alice').


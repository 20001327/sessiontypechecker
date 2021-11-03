-module(alice).

-export([start/0, init/0]).

start() ->
  register(alice, spawn(alice, init, [])).

-type init() :: 'seller!title<String>.seller?quote<Int>.bob!myquote<Int>.&(bob?ok.End,bob?quit.End)'.
init() ->
  seller!{alice,title,"Toy Story"},
  receive
    {seller, quote, Quote} ->
      BobQuote = Quote / 2,
      bob ! {alice, myquote, BobQuote},
      receive
        {bob, ok} ->
          case 10 < 4 of
            true ->
                ok;
            false ->
                ok
          end;
        {bob, quit} ->
          'End'
      end,
  end.


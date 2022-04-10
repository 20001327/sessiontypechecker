-module(alice).

-export([start/0, init/0]).

start() ->
  register(alice, spawn(alice, init, [])).

-spec init()->'#seller!title<String>.seller?quote<Int>.bob!myquote<Int>.&(bob?ok.End,bob?quit.End)'.
init() ->
  seller!{alice,title,"Toy Story"},
  receive
    {seller, quote, Quote} ->
      BobQuote = Quote / 2,
      bob ! {alice, myquote, BobQuote},
      receive
        {bob, ok} ->
           funny(2);
        {bob, quit} ->
          'End'
      end
  end.

-spec funny('#Int')->'#Boolean'.
funny(Exp) ->
  case Exp < 10 of
    true ->
        ok;
    false ->
        ok
  end.



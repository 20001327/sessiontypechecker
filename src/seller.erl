-module(seller).
-export([start/0, init/0]).


start() ->
  register(seller, spawn(seller, init, [])).

-type init() :: 'alice?title<String>.bob!quote<Int>.alice!quote<Int>.&(bob?ok.bob?address<String>.bob!date<String>.End,bob?quit.End)'.
init() ->
  receive
    {alice, title, Title} ->
      Quote=20,
      bob ! {seller, quote, Quote},
      alice ! {seller, quote, Quote},
      receive
        {bob, ok} ->
          receive
            {bob, address, Address} ->
              bob ! {seller, date, "09-09-2021"},
              'End'
          end;
        {bob, quit} ->
          'End'
      end
  end.


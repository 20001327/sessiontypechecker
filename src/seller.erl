-module(seller).
-export([start/0, init/0]).


start() ->
  register(seller, spawn(seller, init, [])).

-type init() :: 'alice?title<String>.alice!price<Int>.bob!price<Int>.
                 &(bob?ok.bob?address<String>.bob!End,bob?quit.End)'.
init() ->
  receive
    {alice, title, Title} ->
      %%io:format("Title:  ~p~n", [Title]),
      Quote=320,
      bob ! {seller, quote, Quote},
      alice ! {seller, quote, Quote},
      receive
        {bob, ok} ->
          %%io:format("seller: received ok ~n"),
          receive
            {bob, address, Address} ->
              %%io:format("seller: received address ~p ~n", [Address]),
              bob ! {seller, date, "09-09-2021"},
              'End'
          end;
        {bob, quit} ->
          'End'
      %%io:format("seller: quit from bob ~n")
      end
  end,
  unregister(seller).


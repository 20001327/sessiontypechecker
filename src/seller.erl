-module(seller).
-export([start/0, init/0]).


start() ->
  register(seller, spawn(seller, init, [])).

-type init() :: 'seller prova'.
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
              bob ! {seller, date, "09-09-2021"}
          end;
        {bob, quit} ->
          quit
      %%io:format("seller: quit from bob ~n")
      end
  end,
  unregister(seller).


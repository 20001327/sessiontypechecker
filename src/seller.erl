-module(seller).
-export([start/0, init/0]).


start() ->
  register(?MODULE, spawn(?MODULE, init, [])).


init() ->
  receive
    {alice, title, Title} ->
      %%io:format("Title:  ~p~n", [Title]),
      Quote=320,
      bob ! {?MODULE, quote, Quote},
      alice ! {?MODULE, quote, Quote},
      receive
        {bob, ok} ->
          %%io:format("seller: received ok ~n"),
          receive
            {bob, address, Address} ->
              %%io:format("seller: received address ~p ~n", [Address]),
              bob ! {?MODULE, date, {{2021, 6, 9}, {11, 2, 15}}}
          end;
        {bob, quit} ->
          quit
      %%io:format("seller: quit from bob ~n")
      end
  end,
  unregister(?MODULE),
  exit(ok).


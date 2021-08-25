-module(carol).
-export([start/0, init/0]).
start() ->
  register(carol, spawn(carol, init, [])).


init() ->
  receive
    {bob, quote, MyQuote} ->
      receive
        {bob, start_delegation, {Name, ReturnPid}} ->
          unregister(Name),
          unregister(carol),
          register(Name, self()),
          case MyQuote < 100 of
            true ->
              seller ! {Name, ok},
              alice ! {Name, ok},
              seller ! {Name, address, "Address"},
              receive
                {seller, date, Date} ->
                    Date
              end;
            false ->
              alice ! {Name, quit},
              seller ! {Name, quit}
          end,
          io:format("carol delegating: received Date ~n"),
          unregister(Name),
          register(Name,ReturnPid),
          register(carol, self()),
          bob ! {carol, end_delegation},
          case MyQuote < 100 of
            true ->
              bob ! {carol, ok};
            false->
              bob ! {carol, quit}
          end
      end;
    {bob,quit} ->
       ok
  end,
  unregister(carol).
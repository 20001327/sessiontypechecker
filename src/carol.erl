-module(carol).
-export([start/0, init/0]).
start() ->
  register(carol, spawn(carol, init, [])).


init() ->
  receive
    {bob, quote, MyQuote} ->
      receive
        {bob, start_delegation, {Name, ReturnPid}} ->
          case MyQuote < 100 of
            true -> unregister(carol),
              register(Name, self()),
              seller ! {Name, ok},
              alice ! {Name, ok},
              seller ! {Name, address, "Address"},
              receive
                {seller, date, Date} ->
                  io:format("carol delegating: received Date ~n"),
                  unregister(Name),
                  register(carol, self()),
                  ReturnPid ! {carol, end_delegation},
                  ReturnPid ! {carol, ok}
              end;
            false ->
              alice ! {Name, quit},
              seller ! {Name, quit},
              unregister(Name),
              register(carol, self()),
              ReturnPid ! {carol, end_delegation},
              ReturnPid ! {carol, quit}
          end
      end
  end,
  unregister(carol).
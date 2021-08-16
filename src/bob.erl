-module(bob).

-export([start/0, init/0]).

start() ->
  register(bob, spawn(bob, init, [])).

init() ->
  receive
    {seller, quote, Quote} ->
      %%io:format("BOB: received QUOTE ~n"),
      receive
        {alice, myquote, MyQuote} ->
          case Quote - MyQuote < 100 of
            true ->
              seller ! {bob, ok},
              alice ! {bob, ok},
              seller ! {bob, address, "Address"},
              receive
                {seller, date, Date} ->
                  Date
              %%io:format("BOB: received Date ~n")
              end;
            false ->
              unregister(bob),
              carol ! {bob, quote,Quote - MyQuote - 99},
              carol ! {bob, start_delegation, {bob, self()}},
              receive
                {carol, end_delegation} ->
                  register(bob,self()),
                  receive
                    {carol, quit} ->
                      quit;
                    {carol, ok} ->
                      ok
                  end
              end
          end
      end
  end,
  carol!{bob,quit},
  unregister(bob).

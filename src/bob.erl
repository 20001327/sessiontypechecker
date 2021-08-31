-module(bob).

-export([start/0, init/0]).

start() ->
  register(bob, spawn(bob, init, [])).

-type init() :: 'seller?quote<Int>.alice?myquote<Int>.
                 @(seller!ok.alice!ok.seller!address<String>.seller?date<String>.,
                    carol!quote<Int>.<<carol.carol>>.
                    &(carol?quit.End,carol?ok.End))'.
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
              carol ! {bob, quote,Quote - MyQuote - 99},
              carol ! {bob, start_delegation, bob, self()},
              receive
                {carol, end_delegation} ->
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
  unregister(bob).

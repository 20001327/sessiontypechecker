-module(bob).

-export([start/0, init/0]).
-define(SERVER, ?MODULE).

start() ->
  register(?MODULE, spawn(?MODULE, init, [])).


init() ->
  receive
    {seller, quote, Quote} ->
      %%io:format("BOB: received QUOTE ~n"),
      receive
        {alice, myquote, MyQuote} when Quote - MyQuote < 100 ->
          seller ! {?MODULE, ok},
          alice ! {?MODULE, ok},
          seller ! {?MODULE, address, "Address"},
          receive
            {seller, date, Date} ->
              Date
          %%io:format("BOB: received Date ~n")
          end;
        {alice, myquote, MyQuote} when Quote - MyQuote >= 100 ->
          carol:start(),
          unregister(?MODULE),
          carol ! {?MODULE, start_delegation, {?MODULE, self(), Quote - MyQuote - 99}},
          receive
            {carol, end_delegation, ok} ->
              %%io:format("Carol received ok from end del~n~n"),
              register(?MODULE,self());
            {carol, end_delegation, quit} ->
              %%io:format("bob received quit from end del~n~n"),
              register(?MODULE,self())
          end
      end
  end,
  unregister(?MODULE),
  exit(ok).

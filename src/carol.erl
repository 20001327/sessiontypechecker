-module(carol).
-export([start/0, init/0]).
start() ->
  register(carol, spawn(carol, init, [])).

-type init() :: 'bob?quote<Int>.bob<<.@(seller!ok.alice!ok.seller!address<String>.seller?date<String>.>>bob.End,alice!quit.seller!quit.>>bob.End)'.

init() ->
  receive
    {bob, quote, MyQuote} ->
      receive
        {bob, start_delegation, Name, ReturnPid} ->
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
                     unregister(Name),
                     register(Name,ReturnPid),
                     register(carol, self()),
                     bob ! {carol, end_delegation},
                    'End'
              end;
            false ->
              alice ! {Name, quit},
              seller ! {Name, quit},
              unregister(Name),
              register(Name,ReturnPid),
              register(carol, self()),
              bob ! {carol, end_delegation},
              'End'
          end
      end
  end,
  ok.
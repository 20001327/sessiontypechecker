-module(bank).

-export([start/0, init/0]).
-define(PRICE, 50).

start() ->
  register(bank, spawn(bank, init, [])).

-type init() :: 'seller?price<Int>.seller<<.client!pay<Int>.client?card<String>.>>seller.@(seller!ok.End,seller!ko.End)'.
init() ->
  receive
    {seller, price, Price} ->
      receive
        {seller, start_delegation, Name, From} ->
          unregister(Name),
          unregister(bank),
          register(Name, self()),
          client ! {Name, pay, Price},
          receive
            {client, card, CardNumber} ->
              unregister(Name),
              register(Name,From),
              register(bank, self()),
              seller ! {bank, end_delegation},
              case length(CardNumber)==16 of
                true ->
                  seller ! {bank, ok},
                  'End';
                false ->
                  seller ! {bank, ko},
                  'End'
              end
          end
      end
  end,
  unregister(bank).


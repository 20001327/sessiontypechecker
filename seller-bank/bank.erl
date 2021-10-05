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
          unregister(bank),
          unregister(seller),
          register(Name, self()),
          client ! {Name, pay, Price},
          receive
            {client, card, CardNumber} ->
              unregister(Name),
              register(Name,From),
              register(bank, self()),
              seller ! {bank, end_delegation},
              case length(CardNumber) of
                16 ->
                  seller ! {bank, ok},
                  'End';
                _ ->
                  seller ! {bank, ko},
                  'End'
              end
          end
      end
  end,
  unregister(?MODULE).


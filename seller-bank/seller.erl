-module(seller).

-export([start/0, init/0]).

start() ->
  register(seller, spawn(seller, init, [])).

-type init() :: 'client?title<String>.client!price<Int>.&(client?ok.bank!price<Int>.<<bank.bank>>.@(bank?ok.client!date<String>.End,bank?ko.client!ko.End),client?ko.End)'.
init() ->
  Price = 50,
  receive
    {client, title, _Title} ->
      client ! {seller, price, Price},
      receive
        {client,ok} ->
          bank ! {seller, price, Price},
          bank ! {seller, start_delegation, seller, self()},
          receive
            {bank, end_delegation} ->
              receive
                {bank, ok} ->
                  client ! {seller, date, now()},
                  'End';
                {bank, ko} ->
                  client ! {seller, ko},
                  'End'
              end
          end;
        {client, title, ko} ->
          'End'
      end
  end,
  unregister(seller).

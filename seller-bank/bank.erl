-module(bank).

-export([start/0, init/0]).
-define(PRICE, 50).

start() ->
  register(bank, spawn(bank, init, [])).

init() ->
  receive
    {seller, price, Price} ->
      receive
        {seller, start_delegation, {Name, From}} ->
          io:format("bank received start delegation~n"),
          unregister(bank),
          register(Name, self()),
          client ! {Name, pay, Price},
          receive
            {client, card, CardNumber} ->
              io:format("bank cardReceived~n"),
              unregister(Name),
              register(bank, self()),
              From ! {bank, end_delegation},
              case length(CardNumber) of
                16 ->
                  io:format("bank ok, 16 digit~n"),
                  From ! {bank, ok};
                _ ->
                  io:format("bank ko, wrong no. of digit~n"),
                  From ! {bank, ko}
              end
          end
      end
  end,
  unregister(?MODULE).


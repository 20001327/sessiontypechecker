-module(seller).

-export([start/0, init/0]).

start() ->
  register(seller, spawn(seller, init, [])).

-spec init() ->
  'C?title<string>.
      C!price<int>.... '.

init() ->
  Price = 50,
  receive
    {client, title, _Title} ->
      io:format("seller got title~n"),
      client ! {seller, price, Price},
      receive
        {client, price, ok} ->
          bank ! {seller, price, Price},
          unregister(seller),
          bank ! {seller, start_delegation, {seller, self()}},
          receive
            {bank, end_delegation} ->
              register(seller, self()),
              receive
                {bank, ko} ->
                  client ! {seller, date, now()};
                {bank, ko} ->
                  client ! {seller, ko}
              end
          end;
        {client, title, ko} ->
          ok
      end
  end,
  unregister(seller).

-module(client).

-export([start/0, init/0]).

start()->
  register(client,spawn(client, init, [])).

init()->
  seller!({client,title,"Novecento"}),
  receive
    {seller, price, Price} when Price =< 50 ->
      io:format("client got price ~n"),
      seller!{client,price,ok},
      receive
        {seller, pay, Price} ->
          io:format("client got pay ~n"),
          seller!{client,card,"0000000000000000"},
          receive
            {seller, date, _Date} ->
              ok;
            {seller, ko} ->
              ko
          end
      end;
    {seller, price, Price} when Price > 50 ->
      seller!{client,price,ok}
  end,
  unregister(client).

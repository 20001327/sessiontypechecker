-module(client).
-export([start/0, init/0]).
start() -> register(client,spawn(client, init,[])).
-spec init()->'#seller!title<String>.seller?price<Int>.@(seller!ok.seller?pay<Int>.seller!card<String>.&(seller?date<String>.End,seller?ko.End),seller!ko.End)'.
init() ->
  MyLimit = 50,
  seller!{client,title,"Novecento"},
  receive
    {seller,price,Price} ->
    case Price=<MyLimit of
      true ->
          seller!{client,ok},
          receive
            {seller,pay,Price} ->
              seller!{client,card,"0000000000000000"},
              receive
                {seller,date,Date} ->
                  ok;
                {seller,ko} ->
                  ko
            end
          end;
      false ->
          seller!{client,ko},
          'End'
    end
end.
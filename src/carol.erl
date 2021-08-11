-module(carol).
-export([start/0,init/0]).
start()->
    register(?MODULE, spawn(?MODULE, init, [])).


init()->
    receive
        {bob,start_delegation,{Name,ReturnPid,MyQuote}} when MyQuote < 100 ->
          unregister(?MODULE),
          register(Name,self()),
          seller!{Name,ok},
          alice!{Name,ok},
          seller!{Name,address, "Address"},
          receive
            {seller, date, Date}->
              io:format("carol delegating: received Date ~n"),
              unregister(Name),
              register(?MODULE, self()),
              ReturnPid!{?MODULE,end_delegation, ok}
          end;
          {bob,start_delegation,{Name,ReturnPid,MyQuote}} when MyQuote >= 100 ->
            unregister(?MODULE),
            register(Name,self()),
            alice!{Name,quit},
            seller!{Name,quit},
            unregister(Name),
            register(?MODULE, self()),
            ReturnPid!{?MODULE,end_delegation, quit}
end,
unregister(?MODULE),
exit(ok).
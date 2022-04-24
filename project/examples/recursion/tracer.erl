-module(tracer).
-author("Lorenzo").

%% API
-export([start/0, tracer/2, print_trace/4, print_trace/5]).
tracer(S, UserList) ->
  NewList = receive
    {seq_trace, Label, TraceInfo} ->
      print_trace(S, UserList, Label, TraceInfo, false);
    {seq_trace, Label, TraceInfo, Ts} ->
      print_trace(S, UserList, Label, TraceInfo, Ts);
    _Other -> UserList
  end,
  tracer(S, NewList).

print_trace(S, UserList, Label, TraceInfo, false) ->
  print_trace(S, UserList,Label, TraceInfo).

print_trace(S, UserList,_Label, {print, _Serial, _From, _To, _Info}) ->
  io:format(S, "~n"),
  UserList;

print_trace(S, UserList,Label, {'receive', _Serial, From, To, Message}) ->
  NewList = checkList(Message,UserList, To),
  Print = getPrint(Message,UserList, From),
  case Print of
    true ->
      Sender=lists:keyfind(From, 2, UserList),
      Recipient=lists:keyfind(To, 2, UserList),
      io:format("~p: Received ~p from ~p ~n", [Recipient,Message, Sender]),
      io:format(S, "~p: Received ~p from ~p ~n", [Recipient,Message, Sender]);
    false -> ok
  end,
  NewList;

print_trace(S, UserList, Label, {send, _Serial, From, To, Message}) ->
  NewList = checkList(Message,UserList, From),
  Print = getPrint(Message,UserList,From),
  case Print of
    true ->
      Sender=lists:keyfind(From, 2, UserList),
      Recipient=lists:keyfind(To, 2, UserList),
      io:format("~p: Sent ~p to ~p ~n", [Sender, Message, Recipient]),
      io:format(S, "~p: Sent ~p to ~p ~n", [Sender, Message, Recipient]);
    _ ->
      unit
  end,
  UserList.



start() ->
  {ok, S} = file:open("trace.txt", [write]),
  Pid = spawn(?MODULE, tracer, [S,[]]),
  seq_trace:set_system_tracer(Pid),% set Pid as the system tracer
  seq_trace:set_token(send,true),
  seq_trace:set_token('receive',true).


getPrint(Message, UserList, Pid) ->
  Call = if
    is_tuple(Message) ->  element(1, Message);
    true -> 'stop'
  end,
  Ret = if
    is_atom(Call) ->  lists:member({Call,Pid}, UserList);
    (Call) ->  lists:member({Call,Pid}, UserList);
    true -> false
  end,
  Ret.

checkList(Message, UserList, Pid) ->
    NewList = if
    is_tuple(Message) ->
        case Message of
             {spawn_request,_A,_B,_C,{Attore,init,0}, [],spawn_reply,[]} -> [{Attore,Pid} | UserList];
            _ -> UserList
        end;
        true -> UserList
    end,
    NewList.
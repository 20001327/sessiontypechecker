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

print_trace(S, UserList,_Label, {'receive', _Serial, From, To, Message}) ->
  NewList = checkList(Message,UserList, To),
  Print = getPrint(Message,UserList, From),
  L = case Print of
    true ->
      {Sender,SenderPid}=lists:keyfind(From, 2, UserList),
      {Recipient,RecipientPid}=lists:keyfind(To, 2, UserList),
      Ls = case Message of
         {_Sndr, start_delegation, Name, Pid} ->
            Tmp = setelem({Recipient,RecipientPid}, NewList, {unreg,Pid}),
            setelem({Sender,SenderPid}, Tmp, {Name,RecipientPid});
         _ -> NewList
      end,
      io:format("~p: Received ~p from ~p ~n", [{Recipient,RecipientPid},Message, Sender]),
      io:format(S, "~p: Received ~p from ~p ~n", [{Recipient,RecipientPid},Message, Sender]),
      Ls;
    false -> NewList
  end,
  L;

print_trace(S, UserList, _Label, {send, _Serial, From, To, Message}) ->
  Print = getPrint(Message,UserList,From),
  L = case Print of
    true ->
      {Sender,SenderPid}=lists:keyfind(From, 2, UserList),
      {Recipient,RecipientPid}=lists:keyfind(To, 2, UserList),
      Ls = case Message of
         {Snd, end_delegation} ->
            Tmp = setelem({Sender,SenderPid},UserList,{Sender,RecipientPid}),
            Tmp2 = setelem({unreg,RecipientPid}, Tmp, {Snd,SenderPid}),
            Tmp2;
         _ -> UserList
      end,
      SndT=lists:keyfind(From, 2, Ls),
      RcvT=lists:keyfind(To, 2, Ls),
      io:format("~p: Sent ~p to ~p ~n", [SndT, Message, RcvT]),
      io:format(S, "~p: Sent ~p to ~p ~n", [SndT, Message, RcvT]),
      Ls;
    _ ->
      UserList
  end,
  L.



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
  Lbl = if
      is_tuple(Message) ->  element(2, Message);
      true -> 'stop'
  end,
  Ret = case Lbl of
    end_delegation -> true;
    _ -> if
            is_atom(Call) -> lists:member({Call,Pid}, UserList);
            (Call) ->  lists:member({Call,Pid}, UserList);
            true -> false
         end
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

setelem(_,[],_)->[];
setelem(Old, [Old|Rest], New) -> [New|Rest];
setelem(Old, [H|Rest], New) -> [H|setelem(Old,Rest,New)].

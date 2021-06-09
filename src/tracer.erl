%%%-------------------------------------------------------------------
%%% @author Lorenzo
%%% @copyright (C) 2021, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 07. giu 2021 10:31
%%%-------------------------------------------------------------------
-module(tracer).
-author("Lorenzo").

%% API
-export([start/0, tracer/1, print_trace/3, print_trace/4]).


tracer(S) ->
  receive
    {seq_trace, Label, TraceInfo} ->
      print_trace(S, Label, TraceInfo, false);
    {seq_trace, Label, TraceInfo, Ts} ->
      print_trace(S, Label, TraceInfo, Ts);
    _Other -> ignore
  end,
  tracer(S).

print_trace(S, Label, TraceInfo, false) ->
  print_trace(S,Label, TraceInfo).

print_trace(S,_Label, {print, _Serial, _From, _To, _Info}) ->
  io:format(S, "~n");
print_trace(S,Label, {'receive', _Serial, _From, _To, Message}) ->
  Call = getCall(Message),
  case Call of
    '$gen_cast' ->
      Input = [element(2, Message)],
      {_FromName,ToName} = Label,
      io:format(S, "~p: Received ~p~n", [ToName,Input]);
    _ ->
      unit
  end;
print_trace(S, Label, {send, _Serial, _From, _To, Message}) ->
  Call = getCall(Message),
  case Call of
    '$gen_cast' ->
      {FromName,_ToName} = Label,
      io:format(S, "~p: Sent ~p~n", [FromName, element(2, Message)]);
    _ ->
      unit
  end.



start() ->
  {ok, S} = file:open("trace.txt", [write]),
  Pid = spawn(?MODULE, tracer, [S]),
  seq_trace:set_system_tracer(Pid),% set Pid as the system tracer
  seq_trace:set_token(send,true),
  seq_trace:set_token('receive',true).


getCall(Message) ->
  Call = if
    is_tuple(Message) ->  element(1, Message);
    true -> 'stop'
  end,
  Call.
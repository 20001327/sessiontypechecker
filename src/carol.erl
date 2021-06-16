%%%-------------------------------------------------------------------
%%% @author Lorenzo
%%% @copyright (C) 2021, <COMPANY>
%%% @doc
%%% @end
%%%-------------------------------------------------------------------
-module(carol).

-behaviour(gen_server).

-export([start_link/0, prova_delegation/0]).
-export([init/1, handle_call/3, handle_cast/2, handle_info/2, terminate/2,
  code_change/3]).

-define(SERVER, ?MODULE).

-record(carol_state, {}).

%%%===================================================================
%%% Spawning and gen_server implementation
%%%===================================================================

start_link() ->
  gen_server:start_link({local, ?SERVER}, ?MODULE, [], []).

init([]) ->
  {ok, #carol_state{}}.

handle_call(_Request, _From, State = #carol_state{}) ->
  {reply, ok, State}.

handle_cast(_Request, State = #carol_state{}) ->
  io:format("Carol: received message ~p~n",[_Request]),
  {noreply, State}.

handle_info(_Info, State = #carol_state{}) ->
  {noreply, State}.

terminate(_Reason, _State = #carol_state{}) ->
  ok.

code_change(_OldVsn, State = #carol_state{}, _Extra) ->
  {ok, State}.

prova_delegation() ->
  gen_server:cast(?MODULE,prova).

%%%===================================================================
%%% Internal functions
%%%===================================================================

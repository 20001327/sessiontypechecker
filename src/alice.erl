%%%-------------------------------------------------------------------
%%% @author Lorenzo
%%% @copyright (C) 2021, <COMPANY>
%%% @doc
%%% @end
%%%-------------------------------------------------------------------
-module(alice).

-behaviour(gen_server).

-export([start_link/0]).
-export([init/1, handle_call/3, handle_cast/2, handle_info/2, terminate/2,
  code_change/3]).
-export([send_title/1, send_quote/1, send_ok/0, send_quit/0]).

-define(SERVER, ?MODULE).

-record(alice_state, {quote}).

%%%===================================================================
%%% Spawning and gen_server implementation
%%%===================================================================

start_link() ->
  gen_server:start_link({local, ?SERVER}, ?MODULE, [], []).

init([]) ->
  {ok, #alice_state{}}.

handle_call(_Req, _From, State = #alice_state{}) ->
  {reply, ok, State}.


handle_cast({quote,Quote}, State = #alice_state{quote = undefined}) ->
  io:format("ALICE STATE:  ~p~n", [State]),
  io:format("ALICE: quote receive from seller ~p~n", [Quote]),
  bob:send_quote(Quote / 2),
  {noreply, #alice_state{quote = Quote}};
handle_cast(ok, #alice_state{quote=_Quote}) ->
  io:format("alice: received ok ~n"),
  {noreply, #alice_state{}};
handle_cast(quit, #alice_state{quote=_Quote}) ->
  io:format("alice: received quit ~n"),
  exit(normal).

handle_info(_Info, State = #alice_state{}) ->
  {noreply, State}.

terminate(_Reason, _State = #alice_state{}) ->
  ok.

code_change(_OldVsn, State = #alice_state{}, _Extra) ->
  {ok, State}.

send_title(Title) ->
  seller:send_title(Title).

send_quote(Quote) ->
  gen_server:cast(?SERVER, {quote,Quote}).

send_quit() ->
  gen_server:cast(?SERVER, quit).

send_ok() ->
  gen_server:cast(?SERVER, ok).

%%%===================================================================
%%% Internal functions
%%%===================================================================

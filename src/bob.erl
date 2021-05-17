%%%-------------------------------------------------------------------
%%% @author Lorenzo
%%% @copyright (C) 2021, <COMPANY>
%%% @doc
%%% @end
%%%-------------------------------------------------------------------
-module(bob).

-behaviour(gen_server).

-export([start_link/0]).
-export([init/1, handle_call/3, handle_cast/2, handle_info/2, terminate/2,
  code_change/3]).
-export([send_quote/1]).

-define(ADDRESS, "Passo del fossato di San Barnaba").
-define(SERVER, ?MODULE).

-record(bob_state, {quote, myquote}).

%%%===================================================================
%%% Spawning and gen_server implementation
%%%===================================================================

start_link() ->
  gen_server:start_link({local, ?SERVER}, ?MODULE, [], []).

init([]) ->
  {ok, #bob_state{}}.

handle_call(_Request, _From, State = #bob_state{}) ->
  {reply, ok, State}.

handle_cast(Quote, #bob_state{quote=undefined}) ->
  io:format("BOB: receive quote from seller ~p~n", [Quote]),
  {noreply, #bob_state{quote = Quote}};
handle_cast(MyQuote, State = #bob_state{quote = Quote}) ->
  io:format("BOB: receive quote from alice ~p~n", [MyQuote]),
  Res = if Quote - MyQuote < 100 ->
    seller:send_ok(),
    Date = seller:send_address(?ADDRESS),
    io:format("BOB: receive date ~p~n", [Date]),
    {noreply,State};
    true -> {noreply,State}
  end,
  Res.

handle_info(_Info, State = #bob_state{}) ->
  {noreply, State}.

terminate(_Reason, _State = #bob_state{}) ->
  ok.

code_change(_OldVsn, State = #bob_state{}, _Extra) ->
  {ok, State}.

send_quote(Quote) ->
  gen_server:cast(?SERVER, Quote).
%%%===================================================================
%%% Internal functions
%%%===================================================================

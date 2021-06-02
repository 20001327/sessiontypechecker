%%%-------------------------------------------------------------------
%%% @author Lorenzo
%%% @copyright (C) 2021, <COMPANY>
%%% @doc
%%% @end
%%%-------------------------------------------------------------------
-module(bob).
-include_lib("eunit/include/eunit.hrl").
-include_lib("records.hrl").

-behaviour(gen_server).

-export([start_link/0]).
-export([init/1, handle_cast/2, handle_info/2, terminate/2,
  code_change/3]).
-export([send_quote/1, send_time/1, send_contribute/1, send_quit/0]).

-define(ADDRESS, "Passo del fossato di San Barnaba").
-define(SERVER, ?MODULE).


%%%===================================================================
%%% Spawning and gen_server implementation
%%%===================================================================

start_link() ->
  gen_server:start_link({local, ?SERVER}, ?MODULE, [], []).

init([]) ->
  {ok, #bob_state{}}.

do_interaction(State, Input) ->
  Res = case Input of
    {quote, Num} ->
      MyQuote = State#bob_state.myquote,
      Quote = Num,
      do_interaction(inner,Quote,MyQuote);
    {myquote, Num} ->
      Quote = State#bob_state.quote,
      MyQuote = Num,
      do_interaction(inner,Quote,MyQuote)
        end,
  Res.

do_interaction(inner,Quote,MyQuote) ->
  Res = if (Quote =/= undefined) and (MyQuote =/= undefined) ->
    if Quote - MyQuote < 100 ->
      seller:send_ok(),
      seller:send_address(?ADDRESS),
      #bob_state{quote = Quote, myquote = MyQuote, buy = true};
      true ->
        seller:send_quit(),
        alice:send_quit(),
        #bob_state{quote = Quote, myquote = MyQuote, buy = false}
    end;
          true ->
            #bob_state{quote = Quote, myquote = MyQuote}
        end,
  Res.

handle_cast(Input = {quote, Quote}, State) ->
  io:format("BOB: receive quote from seller ~p~n", [Quote]),
  NewState = do_interaction(State, Input),
  {noreply, NewState};
handle_cast(Input = {myquote, MyQuote}, State) ->
  io:format("BOB: receive quote from alice ~p~n", [MyQuote]),
  NewState = do_interaction(State, Input),
  {noreply, NewState};
handle_cast({time, _Time}, _State = #bob_state{quote = _Quote, myquote = _MyQuote, buy = true}) ->
  io:format("BOB: receive time from seller ~p~n", [_Time]),
  alice:send_ok(),
  {noreply, #bob_state{}};
handle_cast(quit, #bob_state{quote = _, myquote = _, buy = false}) ->
  io:format("BOB: receive quit , ending ... ~n"),
  {stop, normal, #bob_state{}}.

handle_info(_Info, State = #bob_state{}) ->
  {noreply, State}.

terminate(_Reason, _State = #bob_state{}) ->
  ok.

code_change(_OldVsn, State = #bob_state{}, _Extra) ->
  {ok, State}.

send_quote(Quote) ->
  gen_server:cast(?SERVER, {quote, Quote}).

send_quit() ->
  gen_server:cast(?SERVER, quit).

send_contribute(Quote) ->
  gen_server:cast(?SERVER, {myquote, Quote}).

send_time(Time) ->
  gen_server:cast(?SERVER, {time, Time}).
%%%===================================================================
%%% TESTS
%%%===================================================================

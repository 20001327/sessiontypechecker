%%%-------------------------------------------------------------------
%%% @author Lorenzo
%%% @copyright (C) 2021, <COMPANY>
%%% @doc
%%% @end
%%%-------------------------------------------------------------------
-module(seller).

-behaviour(gen_server).

-export([start_link/0]).
-export([init/1, handle_call/3, handle_cast/2, handle_info/2, terminate/2,
  code_change/3]).
-export([send_address/1, send_ok/0, send_title/1, send_quit/0]).

-define(SERVER, ?MODULE).
-define(LIBRARY, [{"Torah", 27}, {"Bibbia", 400}, {"Corano", 90}]).

-record(seller_state, {title, quote, status}).

%%%===================================================================
%%% Spawning and gen_server implementation
%%%===================================================================

start_link() ->
  gen_server:start_link({local, ?SERVER}, ?MODULE, [], []).

init([]) ->
  {ok, #seller_state{}}.
handle_call(_Arg0, _Arg1, _Arg2) ->
  erlang:error(not_implemented).

handle_cast({title, Title}, #seller_state{title = undefined}) ->
  io:format("Title:  ~p~n", [Title]),
  Resp = case lists:keysearch(Title, 1, ?LIBRARY) of
           false -> exit(undef);
           {value, {_, Quote}} ->
               io:format("BOOK FOUND, it cost: ~p~n", [Quote]),
               bob:send_quote(Quote),
             alice:send_quote(Quote),
             {noreply, #seller_state{title = Title, quote = Quote}}
         end,
  Resp;
handle_cast(ok, #seller_state{title = Title, quote = Quote}) ->
  io:format("seller: received ok ~n"),
  {noreply, #seller_state{title = Title, quote = Quote, status = ok}};
handle_cast(quit, _State = #seller_state{title = _Title, quote = _Quote}) ->
  io:format("seller: received Quit ~n"),
  exit(normal);
handle_cast({address, Address}, _State = #seller_state{title = _Title, quote = _Quote, status = ok}) ->
  io:format("SELLER: received address ~p~n", [Address]),
  bob:send_time(erlang:localtime()),
  {noreply, #seller_state{}}.


handle_info(Info, State = #seller_state{}) ->
  io:format("SELLER: received ~p~n", Info),
  {noreply, State}.

terminate(_Reason, _State = #seller_state{}) ->
  ok.

code_change(_OldVsn, State = #seller_state{}, _Extra) ->
  {ok, State}.

send_title(Title) ->
  gen_server:cast(?SERVER, {title, Title}).

send_address(Address) ->
  gen_server:cast(?SERVER, {address, Address}).

send_ok() ->
  gen_server:cast(?SERVER, ok).

send_quit() ->
  gen_server:cast(?SERVER, quit).

%%%===================================================================
%%% Internal functions
%%%===================================================================



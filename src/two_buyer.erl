%% A module implementing a supervisor usually has a name ending with `_sup`.
-module(two_buyer).

-behaviour(supervisor).
-include_lib("eunit/include/eunit.hrl").
-include_lib("records.hrl").

%% API exports
-export([start_link/0, send_message/4]).

%% Behaviour exports
-export([init/1]).



start_link() ->
  %% If needed, we can pass an argument to the init callback function.
  Args = [],
  supervisor:start_link({local, ?MODULE}, ?MODULE, Args),
  two_buyer:send_message(alice, seller, send_title, ["Torah"]).


%% The init callback function is called by the 'supervisor' module.
init(_Args) ->
  %% Configuration options common to all children.
  %% If a child process crashes, restart only that one (one_for_one).
  %% If there is more than 1 crash ('intensity') in
  %% 5 seconds ('period'), the entire supervisor crashes
  %% with all its children.
  SupFlags = #{strategy => one_for_all,
    intensity => 1,
    period => 5,
    auto_shutdown => any_significant},


  Seller = #{id => seller, restart => transient,
    start => {seller, start_link, []}, significant => true},
  Buyer1 = #{id => alice, restart => transient,
    start => {alice, start_link, []}},
  Buyer2 = #{id => bob, restart => transient,
    start => {bob, start_link, []}},
%%  Buyer3 = #{id => buyer_2,
%%    start => {buyer_2, start_link, []}},

  ChannelA = [Seller, Buyer1, Buyer2],
%%  ChannelB = [Buyer3],

  %% Return the supervisor flags and the child specifications
  %% to the 'supervisor' module.
  {ok, {SupFlags, ChannelA}}.


send_message(From, To, Function, Args) ->
  seq_trace:set_token(label, {From, To}),
  apply(To, Function, Args).

two_buyer_test() ->
  tracer:start(),
  two_buyer:start_link(),
  {ok,File1} = file:read_file("../correctTraces/1.txt"),
  {ok,File2} = file:read_file("../correctTraces/2.txt"),
  {ok,CurrentTrace} = file:read_file("trace.txt"),
  CurrentArray = binary:split(CurrentTrace, [<<"\n">>], [global]),
  ok = checkTrace(CurrentArray, [File1, File2]).


checkTrace(CurrentArray, [H | Tail]) ->
  case checkFile(CurrentArray, H) of
    true -> ok;
      _ -> checkTrace(CurrentArray,Tail)
  end;
checkTrace(_CurrentArray,[])-> false.


checkFile(CurrentArray, CurrentFile) ->
  TestArray = binary:split(CurrentFile, [<<"\n">>], [global]),
  checkLines(CurrentArray,TestArray).

checkLines([X|Rest], [X|Tail]) ->
  checkLines(Rest,Tail);
checkLines([_X|_Rest], [_]) ->
  false;
checkLines([], []) ->
  true.
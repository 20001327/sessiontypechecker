%% A module implementing a supervisor usually has a name ending with `_sup`.
-module(two_buyer).

-behaviour(supervisor).
-include_lib("eunit/include/eunit.hrl").
-include_lib("records.hrl").

%% API exports
-export([start_link/0, send_message/4, check/0]).

%% Behaviour exports
-export([init/1]).



start_link() ->
  %% If needed, we can pass an argument to the init callback function.
  Args = [],
  supervisor:start_link({local, ?MODULE}, ?MODULE, Args),
  bob:start_delegation(carol),
  two_buyer:send_message(alice, bob, prova_delegation, [])
%%two_buyer:send_message(alice, seller, send_title, ["Torah"])
.


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
  Buyer3 = #{id => carol, restart => transient,
    start => {carol, start_link, []}},

  Children = [Seller, Buyer1, Buyer2, Buyer3],
%%  ChannelB = [Buyer3],

  %% Return the supervisor flags and the child specifications
  %% to the 'supervisor' module.
  {ok, {SupFlags, Children}}.


send_message(From, To, Function, Args) ->
  seq_trace:set_token(label, {From, To}),
  Recipient = get_delegate(To),
  apply(Recipient, Function, Args).


get_delegate(To) ->
  State = sys:get_state(To),
  StateName = element(1, State),
  Delegate = if StateName == bob_state -> State#bob_state.delegate;
               true -> To
             end,
  io:format("Stato Trovato: ~p~n",[State]),
  Delegate.


top_setup() ->
  tracer:start(),
  two_buyer:start_link().

test_two_buyer() ->
  two_buyer:check().

t_test_() ->
  {setup,
    fun top_setup/0,
    [fun test_two_buyer/0]}.

check() ->
  {ok, File1} = file:read_file("../correctTraces/1.txt"),
  {ok, File3} = file:read_file("../correctTraces/3.txt"),
  {ok, File2} = file:read_file("../correctTraces/2.txt"),
  {ok, File4} = file:read_file("../correctTraces/4.txt"),
  Array1 = string:tokens(erlang:binary_to_list(File1), "\r\n"),
  Array2 = string:tokens(erlang:binary_to_list(File2), "\r\n"),
  Array3 = string:tokens(erlang:binary_to_list(File3), "\r\n"),
  Array4 = string:tokens(erlang:binary_to_list(File4), "\r\n"),
  {ok, CurrentTrace} = file:read_file("trace.txt"),
  CurrentArray = string:tokens(erlang:binary_to_list(CurrentTrace), "\n"),
  true = checkTrace(CurrentArray, [Array1, Array2, Array3, Array4]).

checkTrace(CurrentArray, [H | Tail]) ->
  Res = case H of
          CurrentArray ->
            true;
          _ ->
            checkTrace(CurrentArray, Tail)
        end,
  Res;
checkTrace(_CurrentArray, []) ->
  false.

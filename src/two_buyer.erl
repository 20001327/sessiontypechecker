%% A module implementing a supervisor usually has a name ending with `_sup`.
-module(two_buyer).

-behaviour(supervisor).

%% API exports
-export([start_link/0]).

%% Behaviour exports
-export([init/1]).
-export([end_communication/0]).

start_link() ->
  %% If needed, we can pass an argument to the init callback function.
  Args = [],
  supervisor:start_link({local, ?MODULE}, ?MODULE, Args).

%% The init callback function is called by the 'supervisor' module.
init(_Args) ->
  %% Configuration options common to all children.
  %% If a child process crashes, restart only that one (one_for_one).
  %% If there is more than 1 crash ('intensity') in
  %% 5 seconds ('period'), the entire supervisor crashes
  %% with all its children.
  SupFlags = #{strategy => one_for_one,
    intensity => 1,
    period => 5},


  Seller = #{id => seller,
    start => {seller, start_link, []}},
  Buyer1 = #{id => alice,
    start => {alice, start_link, []}},
  Buyer2 = #{id => bob,
    start => {bob, start_link, []}},
%%  Buyer3 = #{id => buyer_2,
%%    start => {buyer_2, start_link, []}},

  ChannelA = [Seller,Buyer1,Buyer2],
%%  ChannelB = [Buyer3],

  %% Return the supervisor flags and the child specifications
  %% to the 'supervisor' module.
  {ok, {SupFlags, ChannelA}}.

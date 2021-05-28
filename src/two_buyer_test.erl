%%%-------------------------------------------------------------------
%%% @author Lorenzo
%%% @copyright (C) 2021, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 29. mag 2021 00:14
%%%-------------------------------------------------------------------
-module(two_buyer_test).
-author("Lorenzo").

-include_lib("eunit/include/eunit.hrl").

simple_test() ->
  two_buyer:start_link().

-module(three_buyer).

-export([start_protocol/0]).

start_protocol()->
    seller:start(),
    bob:start(),
    alice:start().
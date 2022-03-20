-module(main).

-export([start_protocol/0]).

start_protocol()->
    start_actor(adder),
    start_actor(client).

start_actor(Actor) ->
  Res = whereis(Actor),
  case Res of
    undefined ->
      Actor:start();
    _ ->
      ok
  end.
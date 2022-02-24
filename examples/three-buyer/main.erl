-module(main).

-export([start_protocol/0]).

start_protocol()->
    start_actor(seller),
    start_actor(carol),
    start_actor(bob),
    start_actor(alice).

start_actor(Actor) ->
  Res = whereis(Actor),
  case Res of
    undefined ->
      Actor:start();
    _ ->
      ok
  end.
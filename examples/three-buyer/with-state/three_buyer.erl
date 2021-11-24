%% A module implementing a supervisor usually has a name ending with `_sup`.
-module(three_buyer).

-include_lib("records.hrl").
%% API exports
-export([send_message/3, start_protocol/0]).

start_protocol()->
    alice:start(),
    bob:start(),
    seller:start(),
    carol:start(),
    alice!start_protocol.


send_message(From, To, Message) ->
  seq_trace:set_token(label, {From, To}),
  %% determinano se esiste un delegato
  Recipient = if Message == end_delegation -> To;
  true-> get_delegate(To)
  end,
  %% manda il messaggio a chi lo deve effettivamente ricevere
  Recipient ! #message{from = From, to = Recipient, message = Message}.


get_delegate(To) ->
  State = get_state(To),
  StateName = State#buyer_actor.delegate,
  Delegate = if StateName == undefined -> To;
               true ->
                 StateName
             end,
  Delegate.

get_state(To) ->
  To ! #message{from=self(),to=To,message=get_state},
  State = receive
            Stato->Stato
           end,
  State.

%%%-------------------------------------------------------------------
%%% @author Lorenzo
%%% @copyright (C) 2021, <COMPANY>
%%% @doc
%%% @end
%%%-------------------------------------------------------------------
-module(seller).
-include_lib("eunit/include/eunit.hrl").
-include_lib("records.hrl").
-export([start/0, loop/1]).

-define(SERVER, ?MODULE).
-define(LIBRARY, [{"Torah", 27}, {"Bibbia", 400}, {"Corano", 201}]).

%%%===================================================================
%%% Spawning and gen_server implementation
%%%===================================================================

start()->
    register(?MODULE, spawn(?MODULE, loop, [#buyer_actor{}])).


loop(State)->
    NewState = receive
        {message,From,_To,get_state} ->
            From ! State,
            State;
        {message,_From,_To,{title, Title}} ->
         St = if State#buyer_actor.title == undefined ->
                  io:format("Title:  ~p~n", [Title]),
                  Resp = case lists:keysearch(Title, 1, ?LIBRARY) of
                           false -> exit(undef);
                           {value, {_, Quote}} ->
                             io:format("BOOK FOUND, it cost: ~p~n", [Quote]),
                             three_buyer:send_message(seller, bob, {quote,Quote}),
                             three_buyer:send_message(seller, alice, {quote,Quote}),
                             State#buyer_actor{title = Title, quote = Quote}
                         end,
                    Resp;
              true->State
             end,
             St;
            {message,_From,_To,okay} ->
             St = if State#buyer_actor.title =/= undefined  ->
              io:format("seller: received ok ~n"),
              State#buyer_actor{buy = true};
             true -> State
             end,
             St;
             {message,_From,_To,quit} ->
             St = if State#buyer_actor.title =/= undefined andalso State#buyer_actor.quote =/= undefined  ->
               three_buyer:send_message(seller,bob,quit),
               three_buyer:send_message(seller,alice,quit),
               #buyer_actor{};
             true -> State
             end,
             St;
             {message,_From,_To,{address, Address}} ->
             St = if State#buyer_actor.title =/= undefined andalso
             State#buyer_actor.quote =/= undefined andalso  State#buyer_actor.buy == true  ->
               io:format(" -- SELLER: received address ~p ~n", [Address]),
               three_buyer:send_message(seller,bob,{time,{{2021,6,9},{11,2,15}}}),
               #buyer_actor{};
             true -> State
             end,
             St;
        _Message ->
            io:format("Seller received: ~p~n",[_Message]),
            State
    end,
    loop(NewState).


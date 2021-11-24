%%
%%%%  test
%%top_setup() ->
%%  tracer:start(),
%%  two_buyer:start_link().
%%
%%test_two_buyer() ->
%%  two_buyer:check().
%%
%%t_test_() ->
%%  {setup,
%%    fun top_setup/0,
%%    [fun test_two_buyer/0]}.
%%
%%check() ->
%%  {ok, File1} = file:read_file("../correctTraces/1.txt"),
%%  {ok, File3} = file:read_file("../correctTraces/3.txt"),
%%  {ok, File2} = file:read_file("../correctTraces/2.txt"),
%%  {ok, File4} = file:read_file("../correctTraces/4.txt"),
%%  Array1 = string:tokens(erlang:binary_to_list(File1), "\r\n"),
%%  Array2 = string:tokens(erlang:binary_to_list(File2), "\r\n"),
%%  Array3 = string:tokens(erlang:binary_to_list(File3), "\r\n"),
%%  Array4 = string:tokens(erlang:binary_to_list(File4), "\r\n"),
%%  {ok, CurrentTrace} = file:read_file("trace.txt"),
%%  CurrentArray = string:tokens(erlang:binary_to_list(CurrentTrace), "\n"),
%%  true = checkTrace(CurrentArray, [Array1, Array2, Array3, Array4]).
%%
%%checkTrace(CurrentArray, [H | Tail]) ->
%%  Res = case H of
%%          CurrentArray ->
%%            true;
%%          _ ->
%%            checkTrace(CurrentArray, Tail)
%%        end,
%%  Res;
%%checkTrace(_CurrentArray, []) ->
%%  false.

## Building

Just run

	$ ant build

to build a working jar file in the `jar` directory. then execute by simple java command

    $ java -jar type-checker.jar <source-directory>

where <source-directory> have to be replaced with the directory cointaing erlang code.

In spec folder you can find input files for erlang and instructions for developing
## Cleaning

Run

	$ ant clean

to clean up the project tree.
If you encounter some problems on Cygwin environment, try to add the `-v` flag.

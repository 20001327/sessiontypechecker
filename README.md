# Session type checker

the aim of the project is typechecking of erlang processes with their type that are annotated for each
process.
 
### bin
in bin folder you can find the jar of the typechecker, you can run in the following way:
    $ java -jar threeBuyer.jar <source-directory>
where <source-directory> have to be replaced with the directory cointaing erlang code. 
In the bin folder are available some examples. for example from the bin directory you can run :
    $ java -jar threeBuyer.jar examples/seller-bank
to run the seller-bank protocol typechecking.


you can also test the available examples with docker running
   $ docker run eis513/session-type-checker:v1 <example>
replacing <example> with one of the following:
 - seller-bank
 - three-buyer
 - recursion

### project 
In project folder you can find sources and instructions to develop

# JRAG
![img.png](img.png)

# Structure of packages
- print: contains the code for the pretty print of the code, session types and global types
- erlangtyping: contains code to derive the type of erlang processes
- subtyping: contains the code for subtyping the derived code. Here we understand if the derived code contains all the session types in the type we are checking (be it projected from the global type or annotated in the code)
- projection: contains the code for projection from the global type to the session types
- validation: contains the code to verify the good form of External and Internal Choice
- utils / nameAnalisys: code to create the symbol table
- utils / equals.jrag: equals utility for typechecking

### TypeChecking.jadd
code that derives and starts checking with the annotated/projected type

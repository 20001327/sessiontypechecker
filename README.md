# Session type checker

The aim of the project is to typecheck a **multyparty session** written in Erlang 
to ensure that it conforms to the **global type** that specifies its expected protocol.

You can find examples of multiparty sessions in `project/examples/`.

In addition to the source files of the project, available in the folder `project`, we provide 
-  an already compiled version the project (in the `bin` folder) and
-  a docker of the generated tool that you can test with the command:

        `$ docker run eis513/session-type-checker:v1 <example>`

    replacing <_example_> with one of the following:
    - seller-bank
    - three-buyer
    - recursion

The examples are described in the readme of the `project` folder.

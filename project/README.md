
# Building
Just run

	$ ant build

to build a working jar file in the `jar` directory, then execute by simple java command

    $ java -jar type-checker.jar <source-directory>

where <source-directory> have to be replaced with the directory cointaing erlang code.
In spec folder you can find input files for erlang and instructions for developing
# Cleaning
Run

	$ ant clean

to clean up the project tree.
If you encounter some problems on Cygwin environment, try to add the `-v` flag.

# Examples

In the `examples` folder you can find three example:
  
- `seller-bank`: a typical example of delegation involving three participants:Client,Seller,and Bank.
               In the protocol, the client and seller engage in a session in which they agree on 
               the terms of a purchase. If the client decide to purchase, the seller delegates 
               the processing of the client’s credit card to the bank.
- `three-buye`r: a system involving Alice, Bob and Carol cooperating to buy a book from a Seller. 
               In the protocol, alice and seller engage in a session in which they agree on
               the terms of a purchase. Alice tells Bob how much she can contribute. 
               If the price is within Bob’s budget,Bob notifies both Seller and Alice he accepts, 
               then sends his address to Seller and Seller answers with the delivery date 
               If the price exceeds Bob’s  budget, Bob delegates to Carol the
               remaining interactions with Alice and Seller. If Carol’s contribution is within her budget, 
               she accepts the quote, notifies Alice and Seller, continues the rest of the protocol with
               Seller and Alice as if she were Bob and then ends delegation, giving back control to Bob.
               Otherwise, she notifies Alice and Seller to quit the protocol and then ends delegation, giving back control to Bob.
- `recursion`:    a simple example of a recursive protocol, in which an actor(client) ask to
               another actor to do the sum of two numbers for 10 times.

A folder `global` contains some examples of global types.
	
The folders in `examples` contain:
	
- a file `.erl`	for each participant of the multiparty session
- a file `global` contaning the global type for the multiparty session
- a file `main.erl` that can be used to execute the protocol in the Erlang interpreter
- a file `tracer.erl` that traces the execution of the sent and received messages (called in `main.erl`)

The last two files are ignored by the type-ckecer.
They can be used to run the protocol in the Erlang shell, compiling all the `.erl` files and evaluating `main:start_protocol()`	
	
	
The project files are also available from the zipped directory `project_.zip`

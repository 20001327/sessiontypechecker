import java.io.*;


import miniErlang.*;


public class Printer {
	public static void main(String[] args) {
		new Printer().run("./src/ast/alice.ast");
	}		

	public void run(String... args) {
		// Make sure there are arguments
		if (args.length == 0) {
			System.err.println("error (PrettyPrint) : No arguments given");
			System.exit(1);
		}
		
		// check that the file exists
		File file = new File(args[0]);
	    if(!file.exists()) {
	    	System.err.println("error (PrettyPrint) : file does not exist");
	    	System.exit(2);
	    }
	    System.out.println("file : " + args[0]);
	    		
		try {
			
			// scan, parse and build ast
			ErlangParser parser = new ErlangParser();
			Reader reader = new FileReader(args[0]);
			ErlangScanner scanner = new ErlangScanner(new BufferedReader(reader));
			Program p = (Program)parser.parse(scanner);
			reader.close();
			PrettyPrinter printer = p.print();
			try (PrintWriter out = new PrintWriter("prettyPrint.txt")) {
				out.println(printer.getString());
			}

		} catch (IOException e) {
			System.err.println("error (PrettyPrint) : " + e.getMessage());
			e.printStackTrace();
		} catch (beaver.Parser.Exception e) {
			System.err.println("error (PrettyPrint) : " + e.getMessage());
			e.printStackTrace();
		} 
	}

}

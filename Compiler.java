import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;


import miniErlang.*;


public class Compiler {
	public static void main(String[] args) {
		new Compiler().run("./src/ast/alice.ast");
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
			
			runPreErrorCheck(p);
	
/*			Collection c = p.errors();
			if (c.size() > 0) {
				System.out.println("Errors: ");
				for (Object o : c) {
					System.out.println("- " + o.toString());
				}
			} */
		} catch (IOException e) {
			System.err.println("error (PrettyPrint) : " + e.getMessage());
			e.printStackTrace();
		} catch (beaver.Parser.Exception e) {
			System.err.println("error (PrettyPrint) : " + e.getMessage());
			e.printStackTrace();
		} 
	}

	public void runPreErrorCheck(Program p) {
	}
}

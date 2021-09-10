import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


import beaver.Parser;
import miniErlang.*;
import miniErlang.Module;


public class TypeCheck {
	public static void main(String[] args) {
		new TypeCheck().run("src/ast");
	}

	public void run(String... args) {
		// Make sure there are arguments
		if (args.length == 0) {
			System.err.println("error (PrettyPrint) : No arguments given");
			System.exit(1);
		}

		// check that the file exists
		File file = new File(args[0]);
	    if(!file.isDirectory()) {
	    	System.err.println("error (PrettyPrint) : not a directory");
	    	System.exit(2);
	    }
	    System.out.println("file : " + args[0]);
		Path path = Paths.get(args[0]);
		System.out.println("directory : " + path.toAbsolutePath());

		try {
			Program p = new Program();
			try (Stream<Path> paths = Files.walk(path)) {
				paths.filter(Files::isRegularFile)
						.forEach(f->{
							try {
								System.out.println("scan : " + f.getFileName());
								ErlangParser parser = new ErlangParser();
								Reader reader = new FileReader(f.toFile());
								ErlangScanner scanner = new ErlangScanner(new BufferedReader(reader));
								Program pr_part = (Program)parser.parse(scanner);
								for (Module m : pr_part.getModuless()){
									p.addModules(m);
								}
								reader.close();
							} catch (IOException | Parser.Exception e) {
								e.printStackTrace();
							}
						});
			}
			// scan, parse and build ast

			PrettyPrinter printer = p.print();
			try (PrintWriter out = new PrintWriter("prettyPrint.txt")) {
				out.println(printer.getString());
			}

			//p.checkType();

		} catch (Exception e) {
			System.err.println("error (PrettyPrint) : " + e.getMessage());
			e.printStackTrace();
		}
	}

}

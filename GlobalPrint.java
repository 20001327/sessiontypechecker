import miniErlang.*;

import java.io.*;

public class GlobalPrint {

    public static void main(String[] args) {
        new GlobalPrint().run(args[0]);
    }

    public void run(String... args) {
        // Make sure there are arguments
        if (args.length == 0) {
            System.err.println("error (PrettyPrint) : No arguments given");
            System.exit(1);
        }

        // check that the file exists
        File file = new File(args[0]);
        System.out.println("file : " + args[0]);

        try {
            ErlangParser parser = new ErlangParser();
            Reader reader = new FileReader(file);
            ErlangScanner scanner = new ErlangScanner(new BufferedReader(reader));
            GProg g = (GProg) parser.parse(scanner);
            reader.close();

            PrettyPrinter printer = g.getGlobal().stampante();
            g.getGlobal().stampa();
            System.out.println(printer.getString());
            System.out.println(String.join(",",g.getActors()));

            for (String s : g.getActors()){
                if(g.project(s)!=null) {
                    Session session = g.project(s);
                    printer.reset();
                    FunctionType type2 = new FunctionType(s,new List<>(),session);
                    System.out.println(type2.stampa().getString());
                }
            }


        } catch (Exception e) {
            System.err.println("error (PrettyPrint) : " + e.getMessage());
            e.printStackTrace();
        }
    }

}



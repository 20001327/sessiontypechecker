package upo;

import beaver.Parser;
import miniErlang.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class GlobalTypeChecker {

    public static void main(String[] args) {
        new GlobalTypeChecker().run(args[0]);
    }

    public void run(String... args) {
        // Make sure there are arguments
        if (args.length != 1) {
            System.err.println("1 arguments required: path of the folder with sources and global types");
            System.exit(1);
        }
        // check that the file exists and is a directory
        File fileGlobal = new File(args[0]+"/global");
        File file = new File(args[0]);
        if (!file.isDirectory()) {
            Path path = Paths.get(args[0]);
            System.out.println("directory : " + path.toAbsolutePath());
            System.err.println("error (PrettyPrint) : not a directory");
            System.exit(2);
        }
        System.out.println("file : " + args[0]);
        Path pathast = Paths.get(args[0]+"/ast/");

        try {
            Program p = new Program();
            try (Stream<Path> paths = Files.walk(pathast)) {
                paths.filter(Files::isRegularFile)
                        .forEach(f -> {
                            try {
                                System.out.println("scan : " + f.getFileName());
                                ErlangParser parser = new ErlangParser();
                                Reader reader = new FileReader(f.toFile());
                                ErlangScanner scanner = new ErlangScanner(new BufferedReader(reader));
                                Program pr_part = (Program) parser.parse(scanner);
                                for (Module m : pr_part.getModuless()) {
                                    p.addModules(m);
                                }
                                reader.close();
                            } catch (IOException | Parser.Exception e) {
                                e.printStackTrace();
                            }
                        });
            }

            ErlangParser parser = new ErlangParser();
            Reader reader = new FileReader(fileGlobal);
            ErlangScanner scanner = new ErlangScanner(new BufferedReader(reader));
            GProg g = (GProg) parser.parse(scanner);
            reader.close();

            PrettyPrinter printer = g.getGlobal().stampante();
            g.getGlobal().stampa();
            System.out.println(printer.getString());
            System.out.println(String.join(",", g.getActors()));

            for (String s : g.getActors()) {
                if (g.project(s) != null) {
                    Session session = g.project(s);
                    printer.reset();
                    FunctionType type = new FunctionType("init", new List<>(), session);
                    System.out.println(type.stampa().getString());
                    p.checkType(s,type);
                }
            }


        } catch (Exception e) {
            System.err.println("error (PrettyPrint) : " + e.getMessage());
            e.printStackTrace();
        }

    }

}



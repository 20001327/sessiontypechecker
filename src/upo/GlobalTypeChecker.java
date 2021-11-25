package upo;

import beaver.Parser;
import miniErlang.*;

import java.io.*;
import java.lang.Process;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class GlobalTypeChecker {

    public static void main(String[] args) throws IOException {
        new GlobalTypeChecker().run(args[0]);
    }

    public void run(String... args) throws IOException {
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
        Path pathast = Paths.get(args[0] + "ast/");
        File astDir = new File(args[0] + "ast");

        if (!astDir.exists()){
            Files.createDirectories(pathast);
        }

        try {

            ErlangParser parser = new ErlangParser();
            Reader reader = new FileReader(fileGlobal);
            ErlangScanner scanner = new ErlangScanner(new BufferedReader(reader));
            GProg g = (GProg) parser.parse(scanner);
            reader.close();

            PrettyPrinter printer = g.getGlobal().stampante();
            g.getGlobal().stampa();
            System.out.println(printer.getString());

            System.out.println("compiling erlang files ");
            Process process = Runtime.getRuntime().exec("erl -noshell " +
                    "-eval \"make:all().\" " +
                    "-eval 'init:stop().'", null, file);
            process.waitFor(5, TimeUnit.SECONDS);

            for (String s : g.getActors()) {
                System.out.println("getting " + s + " ast file");
                Process p = Runtime.getRuntime().exec("erl -noshell " +
                        "-eval \"forms:read_to_binary(" + s + ",'ast/" + s + ".ast').\" " +
                        "-eval 'init:stop().'", null, file);
                p.waitFor(3, TimeUnit.SECONDS);
                p.destroy();
            }

            Program p = new Program();
            try (Stream<Path> paths = Files.walk(pathast)) {
                paths.filter(Files::isRegularFile)
                        .forEach(f -> {
                            try {
                                System.out.println("scan : " + f.getFileName());
                                Reader readerloc = new FileReader(f.toFile());
                                ErlangScanner scannerloc = new ErlangScanner(new BufferedReader(readerloc));
                                Program pr_part = (Program) parser.parse(scannerloc);
                                for (Module m : pr_part.getModuless()) {
                                    p.addModules(m);
                                }
                                readerloc.close();
                            } catch (IOException | Parser.Exception e) {
                                e.printStackTrace();
                            }
                        });
            }

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



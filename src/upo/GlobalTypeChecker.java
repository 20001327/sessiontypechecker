package upo;

import beaver.Parser;
import miniErlang.*;

import java.io.*;
import java.lang.Process;
import java.net.URL;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class GlobalTypeChecker {

    private static final int DEFAULT_BUFFER_SIZE = 1024;

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
        File fileGlobal = new File(args[0] + "/global");
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

        if (!astDir.exists()) {
            Files.createDirectories(pathast);
        }

        System.out.println("copy lib file");
        InputStream filetemp = this.getClass().getClassLoader().getResourceAsStream("forms.beam");
        assert filetemp != null;
        copyInputStreamToFile(filetemp, new File(args[0] + "forms.beam"));

        try {

            ErlangParser parser = new ErlangParser();
            GProg g = null;
            if (fileGlobal.exists()) {
                Reader reader = new FileReader(fileGlobal);
                ErlangScanner scanner = new ErlangScanner(new BufferedReader(reader));
                g = (GProg) parser.parse(scanner);
                reader.close();
                PrettyPrinter printer = g.getGlobal().stampante();
                g.getGlobal().stampa();
                System.out.println(printer.getString());
            }

            System.out.println("compiling erlang files ");
            Process process = Runtime.getRuntime().exec("erl -noshell " +
                    "-eval \"make:all().\" " +
                    "-eval 'init:stop().'", null, file);
            process.waitFor(5, TimeUnit.SECONDS);
            process.destroy();

            if(g!=null) {
                for (String s : g.getActors()) {
                    System.out.println("getting " + s + " ast file");
                    Process p = Runtime.getRuntime().exec("erl -noshell " +
                            "-eval \"forms:read_to_binary(" + s + ",'ast/" + s + ".ast').\" " +
                            "-eval 'init:stop().'", null, file);
                    p.waitFor(3, TimeUnit.SECONDS);
                    p.destroy();
                }
            }else{
                try (Stream<Path> paths = Files.walk(Paths.get(args[0]))) {
                    paths.filter(Files::isRegularFile)
                            .forEach(f -> {
                                try {
                                    String[] fname = f.getFileName().toString().split("\\.");
                                    if (fname.length==2 && !fname[0].startsWith("main") && fname[1].equals("erl")) {
                                        String s = fname[0];
                                        System.out.println("getting " + s + " ast file");
                                        Process p = Runtime.getRuntime().exec("erl -noshell " +
                                                "-eval \"forms:read_to_binary(" + s + ",'ast/" + s + ".ast').\" " +
                                                "-eval 'init:stop().'", null, file);
                                        p.waitFor(3, TimeUnit.SECONDS);
                                        p.destroy();
                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            });
                }
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

            if(g!=null) {
                for (String s : g.getActors()) {
                    if (g.project(s) != null) {
                        Session session = g.project(s);
                        FunctionType type = new FunctionType("init", new List<>(), session);
                        System.out.println(type.stampa().getString());
                        p.checkType(s, type);
                    }
                }
            }else{
                p.checkType();
            }
        } catch (Exception e) {
            System.err.println("error (PrettyPrint) : " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {

        // append = false
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }

    }

}



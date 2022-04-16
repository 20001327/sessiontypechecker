package upo;

import beaver.Parser;
import miniErlang.*;

import java.io.*;
import java.lang.Process;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class GlobalTypeChecker {

    private static final int DEFAULT_BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        new GlobalTypeChecker().run(args);
    }

    public void run(String... args) throws IOException {
        // check that the file exists and is a directory
        doTypeChecking(args.length == 0? null: args[0]);

    }

    protected static void doTypeChecking(String pathTotype) throws IOException {
        String basepath = pathTotype;
        if (basepath == null){
            System.out.println("It seems you have not specified a valid path, available examples are :");
            System.out.println("  - recursion");
            System.out.println("  - seller-bank");
            System.out.println("  - three-buyer");
            BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Insert the example to typecheck: ");
            String fi = c.readLine();
            basepath = "examples" + File.separator + fi;
        }

        File file = new File(basepath);
        File fileGlobal = new File(basepath + File.separator + "global");

        if (!file.isDirectory()) {
            file = new File(basepath);
            Path path = Paths.get(basepath);
            System.out.println("directory : " + path.toAbsolutePath());
            System.err.println("error (PrettyPrint) : not a directory");
            System.exit(2);
        }
        Path pathast = Paths.get(basepath + File.separator + "form" + File.separator);
        File astDir = new File(basepath + File.separator + "form");

        if (!astDir.exists()) {
            Files.createDirectories(pathast);
        }

        InputStream filetemp = GlobalTypeChecker.class.getClassLoader().getResourceAsStream("forms.beam");
        assert filetemp != null;
        copyInputStreamToFile(filetemp, new File(basepath + File.separator + "forms.beam"));
        try {
            ErlangParser parser = new ErlangParser();
            GProg g = null;
            if (fileGlobal.exists()) {
                System.out.println("Global type: ");
                Reader reader = new FileReader(fileGlobal);
                ErlangScanner scanner = new ErlangScanner(new BufferedReader(reader));
                g = (GProg) parser.parse(scanner);
                reader.close();
                PrettyPrinter printer = g.getGlobal().stampante();
                g.getGlobal().stampa();
                System.out.println(printer.getString());
            }

            Process process = Runtime.getRuntime().exec("erl -noshell " +
                    "-eval \"make:all().\" " +
                    "-eval 'init:stop().'", null, file);
            process.waitFor(3, TimeUnit.SECONDS);
            process.destroy();
            if(g!=null) {
                for (String s : g.getActors()) {
                    File temp = new File(basepath + File.separator + s + ".erl");
                    if (temp.exists()) {
                        Process p = Runtime.getRuntime().exec("erl -noshell " +
                                "-eval \"forms:read_to_binary(" + s + ",'form/" + s + ".form').\" " +
                                "-eval 'init:stop().'", null, file);
                        p.waitFor(3, TimeUnit.SECONDS);
                        p.destroy();
                    }
                }
            }else{
                try (Stream<Path> paths = Files.walk(Paths.get(basepath))) {
                    File finalFile = file;
                    paths.filter(Files::isRegularFile)
                            .forEach(f -> {
                                try {
                                    String[] fname = f.getFileName().toString().split("\\.");
                                    if (fname.length==2 && !fname[0].startsWith("main") && fname[1].equals("erl")) {
                                        String s = fname[0];
                                        Process p = Runtime.getRuntime().exec("erl -noshell " +
                                                "-eval \"forms:read_to_binary(" + s + ",'form/" + s + ".form').\" " +
                                                "-eval 'init:stop().'", null, finalFile);
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
                                Reader readerloc = new FileReader(f.toFile());
                                ErlangScanner scannerloc = new ErlangScanner(new BufferedReader(readerloc));
                                Program pr_part = (Program) parser.parse(scannerloc);
                                for (miniErlang.Module m : pr_part.getModuless()) {
                                    p.addModules(m);
                                }
                                readerloc.close();
                            } catch (IOException | Parser.Exception e) {
                                e.printStackTrace();
                            }
                        });
            }

            boolean verified = true;
            if(g!=null) {
                for (String s : g.getActors()) {
                    if (g.project(s) != null) {
                        Session session = g.project(s);
                        FunType type = new FunType("init", new List<>(), session);
                        verified = verified && p.checkType(s, type);
                    }
                }
            }else{
                verified = p.checkType();
            }


            if(verified){
                System.out.println("the protocol follows the global type " );
            }else{
                System.out.println("some error has occoured, it seems the protocol doesn't follow the global type" );
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



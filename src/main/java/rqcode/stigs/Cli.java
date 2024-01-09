package rqcode.stigs;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Cli {

    private static void help() {
        System.out.println("Arguments: \n"
                + " no args  - help information\n"
                + " --help - help information\n"
                + " stig_id - checking the STIG by id\n"
                + " stig_id --enforce - enforcing the STIG by id\n"
                + "Example: V_220956\n"
                + "Note: You need administrative rights to run this class.\n\n ");
    }

    private static STIG locate_stig(String stig_id) throws Exception {
        File givenFile = new File((Cli.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath());
        Set<String> classNames = new HashSet<>();
        Class clazz;

        try (JarFile jarFile = new JarFile(givenFile)) {
            Enumeration<JarEntry> e = jarFile.entries();
            while (e.hasMoreElements()) {
                JarEntry jarEntry = e.nextElement();
                if (jarEntry.getName().endsWith(".class")) {
                    String fileName = jarEntry.getName();
                    String className = fileName
                            .replace("/", ".")
                            .replace(".class", "");

                    if (className.contains(stig_id)) {
                        classNames.add(className);
                    }
                }
            }
            if (classNames.isEmpty())
                throw new ClassNotFoundException("Could not locate STIG by id: " + stig_id + " in the current jar");
            if (classNames.size()>1) throw new Exception("Located more than one STIG by id: " + stig_id + " in the current jar.\n"
            +"Try adding a more precise name. For example: win10_3."+ stig_id);
        }
        try (URLClassLoader cl = URLClassLoader.newInstance(
                new URL[] { new URL("jar:file:" + givenFile + "!/") })) {  
                clazz = cl.loadClass(classNames.iterator().next()); // Load the class by its name
            }
        
        return STIG.class.cast(clazz);
    }

    public static void main1(String[] args) {
        if (args.length == 0) {
            help();
            System.exit(0);
        }
        if (args[0].equals("--help")) {
            help();
            System.exit(0);
        }

        String stig_to_locate = args[0];

    }

    public static void main(String[] args) {

        STIG stig;
        try {
            stig = locate_stig("V_220956");
            System.out.println(stig);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

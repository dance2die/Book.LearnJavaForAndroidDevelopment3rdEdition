package io;

import java.io.File;
import java.io.IOException;

public class IOMain {
    public static void main(String[] args){
//        testListingDrives();
        testPathNameInfo();
    }

    private static void testPathNameInfo() {
        try {
            File file = new File("C:\\misc\\Sources\\Repos\\Java\\Book.LearnJavaForAndroidDevelopment3rdEdition\\src\\io\\IOMain.java\"");
            System.out.println("Absolute path = " + file.getAbsolutePath());
            System.out.println("Canonical path = " + file.getCanonicalPath());
            System.out.println("Name = " + file.getName());
            System.out.println("Parent = " + file.getParent());
            System.out.println("Path = " + file.getPath());
            System.out.println("Is absolute = " + file.isAbsolute());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testListingDrives() {
        File[] roots = File.listRoots();
        for (File root: roots)
            System.out.println(root);
    }
}

package com.yosep.zip;

// Zip4j 2.4.0 dependencies
//import net.lingala.zip4j.ZipFile;

// Zip4j 1.3.1 dependencies
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started...");

        String path = "/Users/ykim/workspace/zip/files/";
        String outputFile = path + "output1.3.1.zip";
        String inputFile1 = path + "input1.txt";

        // Create zip file using Zip4j 2.4.0
//        ZipFile output = new ZipFile(outputFile);
//        output.addFile(new File(inputFile1));

        // Create zip file using Zip4j 1.3.1
        ZipFile output = new ZipFile(outputFile);
        output.addFile(new File(inputFile1),
                new ZipParameters());

        // Verifying if output zip is healthy

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(outputFile));

        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            System.out.println(zipEntry.getName() + " = " + zipEntry.getSize());
        }

        System.out.println("Completed...");
    }
}

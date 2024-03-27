package org.mogul.section4.throughput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ThroughputHttpServer {
    private static final String INPUT_FILE = "resources/throughput/war_and_peace.txt";

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
    }
}

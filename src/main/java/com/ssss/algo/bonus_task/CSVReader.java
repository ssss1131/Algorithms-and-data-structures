package main.java.com.ssss.algo.bonus_task;

import com.sun.tools.javac.Main;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {

    public static List<Edge> readEdgesFromCSV(String file) throws IOException {
        List<Edge> edges = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream(file))
        ))) {
            String line;
            boolean skipHeader = true;

            while ((line = br.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] columns = line.split(",");

                String from = columns[2];
                String to = columns[4];
                edges.add(new Edge(from, to));

            }
        }

        return edges;
    }

    public record Edge(String from, String to) {
    }
}


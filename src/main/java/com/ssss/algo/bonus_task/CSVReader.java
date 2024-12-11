package main.java.com.ssss.algo.bonus_task;

import com.sun.tools.javac.Main;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                LocalDateTime timestamp = LocalDateTime.parse(columns[0], DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
                edges.add(new Edge(from, to, timestamp));
            }
        }

        return edges;
    }

    public record Edge(String from, String to, LocalDateTime timestamp) {
    }
}


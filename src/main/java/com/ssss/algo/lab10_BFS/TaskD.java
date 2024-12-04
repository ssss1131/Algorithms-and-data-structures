package main.java.com.ssss.algo.lab10_BFS;
import java.io.*;
import java.util.*;

public class TaskD {

    static List<List<Integer>> adj = new ArrayList<>();
    static boolean[] isRed;
    static int[] distances;

    public static void init(int size) {
        isRed = new boolean[size + 1];
        distances = new int[size + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        for (int i = 0; i <= size; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int queryCount = Integer.parseInt(st.nextToken());

        init(vertices);

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int neighbour = Integer.parseInt(st.nextToken());
            if (vertex == neighbour) continue;
            adj.get(vertex).add(neighbour);
            adj.get(neighbour).add(vertex);
        }

        Queue<Integer> redQueue = new LinkedList<>();

        // Обработка запросов
        for (int i = 0; i < queryCount; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int vertex = Integer.parseInt(st.nextToken());

            if (command == 1) {

                if (!isRed[vertex]) {
                    isRed[vertex] = true;
                    distances[vertex] = 0;
                    redQueue.add(vertex);
                    bfsUpdateDistances(redQueue);
                }
            } else {
                if (distances[vertex] == Integer.MAX_VALUE) {
                    bw.write("-1\n");
                } else {
                    bw.write(distances[vertex] + "\n");
                }
            }
        }
        bw.flush();
    }

    private static void bfsUpdateDistances(Queue<Integer> redQueue) {
        while (!redQueue.isEmpty()) {
            int current = redQueue.poll();

            for (int neighbour : adj.get(current)) {
                if (distances[current] + 1 < distances[neighbour]) {
                    distances[neighbour] = distances[current] + 1;
                    redQueue.add(neighbour);
                }
            }
        }
    }
}

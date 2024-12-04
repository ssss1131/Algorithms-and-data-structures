package main.java.com.ssss.algo.lab11_Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskD {
    static class Edge {
        long weight;
        int from;
        int to;

        public Edge(long weight, int from, int to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Edge{" +
                   "weight=" + weight +
                   ", from=" + from +
                   ", to=" + to +
                   '}';
        }
    }

    static class Graph {
        List<Edge> edges = new ArrayList<>();
        int size;
        int[] predecessor;

        public Graph(int size) {
            this.size = size;
            predecessor = new int[size];
            for (int i = 0; i < size; i++) {
                predecessor[i] = i;
            }
        }


        void addEdge(int from, int to, long w) {
            Edge edge = new Edge(w, from, to);
            edges.add(edge);
        }

        int oldestPredecessor(int i) {
            int pred = predecessor[i];
            while (predecessor[pred] != pred) {
                pred = predecessor[pred];
            }
            return pred;
        }

        long kruskal(){
            long cost = 0;
            edges.sort(Comparator.comparingLong(e -> e.weight));
            long w;
            int v1;
            int v2;
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                w = edge.weight;
                v1 = edge.from;
                v2 = edge.to;
                if(oldestPredecessor(v1) != oldestPredecessor(v2)){
                    predecessor[oldestPredecessor(v2)] = oldestPredecessor(v1);
                    cost +=w;
                }
            }
            return cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Graph graph = new Graph(size);
        for (int i = 0; i < size; i++) {
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                graph.addEdge(i, j, array[j]);
            }
        }
        System.out.println(graph.kruskal());
    }


}

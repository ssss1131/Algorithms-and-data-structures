package main.java.com.ssss.algo.lab11_Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskC {

    static class Edge {
        long weight;
        int from;
        int to;

        public Edge(long weight, int from, int to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

        public Edge(long weight) {
            this.weight = weight;
        }
    }

    static class Graph {

        private List<Edge> edges;
        private int size;
        private int[] predecessor;
        int big;
        int small;

        public Graph(int size, int big, int small) {
            this.size = size;
            this.big = big;
            this.small = small;

            edges = new ArrayList<>();
            predecessor = new int[size];
            for (int i = 0; i < size; i++) {
                predecessor[i] = i;
            }
        }

        public void mergeSort(List<Edge> edges, int beg, int end) {
            if (end > beg) {
                int mid = beg + (end - beg) / 2;
                mergeSort(edges, beg, mid);
                mergeSort(edges, mid + 1, end);

                merge(edges, beg, mid, end);
            }
        }

        private void merge(List<Edge> edges, int beg, int mid, int end) {
            Edge[] left = new Edge[mid - beg + 2];
            Edge[] right = new Edge[end - mid + 1];
            left[mid - beg + 1] = new Edge(Integer.MAX_VALUE);
            right[end - mid] = new Edge(Integer.MAX_VALUE);
            for (int i = 0; i < left.length - 1; i++) {
                left[i] = edges.get(beg + i);
            }

            for (int i = 0; i < right.length - 1; i++) {
                right[i] = edges.get(mid + i + 1);
            }

            int i = 0;
            int j = 0;
            int k = beg;
            while (k <= end) {
                if (left[i].weight >= right[j].weight) {
                    edges.set(k++, right[j++]);
                } else {
                    edges.set(k++, left[i++]);
                }
            }
        }

        void addEdge(int from, int to, long length, String type) {
            switch (type) {
                case "both":
                    edges.add(new Edge(length * big, from, to));
                    edges.add(new Edge(length * small, from, to));
                    break;
                case "big":
                    edges.add(new Edge(length * big, from, to));
                    break;
                case "small":
                    edges.add(new Edge(length * small, from, to));
                    break;
            }

        }

        int oldestPredecessor(int i) {
            int pred = predecessor[i];
            while (predecessor[pred] != pred) {
                pred = predecessor[pred];
            }
            return pred;
        }

        long kruskal() {
            long cost = 0;
            mergeSort(edges, 0, edges.size() - 1);

            long w;
            int v1;
            int v2;
            for (Edge edge : edges) {
                v1 = edge.from;
                v2 = edge.to;
                w = edge.weight;
                int oldestV1 = oldestPredecessor(v1);
                int oldestV2 = oldestPredecessor(v2);
                if (oldestV1 != oldestV2) {
                    predecessor[oldestV2] = oldestV1;
                    cost += w;
                }
            }
            return cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int big = Integer.parseInt(st.nextToken());
        int small = Integer.parseInt(st.nextToken());
        Graph graph = new Graph(vertices + 1, big, small);
        String type;
        int from;
        int to;
        int length;
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            type = st.nextToken();
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            graph.addEdge(from, to, length, type);
        }
        System.out.println(graph.kruskal());
    }

}

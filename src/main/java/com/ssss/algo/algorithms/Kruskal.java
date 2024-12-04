package main.java.com.ssss.algo.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {

    static class Edge {
        int weight;
        int from;
        int to;

        public Edge(int weight, int from, int to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

        public Edge(int weight) {
            this.weight = weight;
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


        void addEdge(int from, int to, int w) {
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

        int kruskal() {
            int cost = 0;
            mergeSort(edges, 0, edges.size() - 1);

            Edge v;
            int from;
            int to;
            for (int i = 0; i < edges.size(); i++) {
                v = edges.get(i);
                from = v.from;
                to = v.to;
                int oldestFrom = oldestPredecessor(from);
                int oldestTo = oldestPredecessor(to);
                if (oldestFrom != oldestTo) {
                    predecessor[oldestTo] = oldestFrom;
                    cost += v.weight;
                }
            }
            return cost;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 5, 7);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 5, 6);
        graph.addEdge(1, 5, 13);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 7);

        System.out.println(graph.kruskal());
    }

}

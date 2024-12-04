package main.java.com.ssss.algo.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {

    static class MinHeap {
        private List<int[]> content; // Каждый элемент: [вершина, вес, предок]
        private int heapSize;

        public MinHeap(List<int[]> arr) {
            this.content = new ArrayList<>(arr);
            this.heapSize = arr.size();
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public void print() {
            for (int[] entry : content) {
                System.out.println(entry[0] + ":(" + entry[1] + ";" + entry[2] + ")");
            }
            System.out.println();
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int left(int i) {
            return 2 * i + 1;
        }

        private int right(int i) {
            return 2 * i + 2;
        }

        private void minHeapify(int i) {
            int smallest = i;
            int l = left(i);
            int r = right(i);

            if (l < heapSize && content.get(l)[1] < content.get(smallest)[1]) {
                smallest = l;
            }
            if (r < heapSize && content.get(r)[1] < content.get(smallest)[1]) {
                smallest = r;
            }

            if (smallest != i) {
                Collections.swap(content, i, smallest);
                minHeapify(smallest);
            }
        }

        public void buildMinHeap() {
            for (int i = (heapSize - 2) / 2; i >= 0; i--) {
                minHeapify(i);
            }
        }

        public int[] extractMin() {
            int[] min = content.get(0);
            Collections.swap(content, 0, heapSize - 1);
            heapSize--;
            minHeapify(0);
            return min;
        }

        public void decreaseKey(int vertex, int newKey, int pred) {
            int index = -1;
            for (int i = 0; i < heapSize; i++) {
                if (content.get(i)[0] == vertex) {
                    index = i;
                    break;
                }
            }
            if (index != -1 && newKey < content.get(index)[1]) {
                content.get(index)[1] = newKey;
                content.get(index)[2] = pred;
                while (index > 0 && content.get(parent(index))[1] > content.get(index)[1]) {
                    Collections.swap(content, parent(index), index);
                    index = parent(index);
                }
            }
        }
    }

    static class Graph {
        private List<List<int[]>> adj; // Для каждой вершины список соседей: [сосед, вес]
        private List<int[]> vertices; // Список вершин: [индекс, вес, предок]
        private boolean[] visited;

        public Graph(int size) {
            adj = new ArrayList<>();
            vertices = new ArrayList<>();
            visited = new boolean[size];
            for (int i = 0; i < size; i++) {
                adj.add(new ArrayList<>());
                vertices.add(new int[]{i, Integer.MAX_VALUE, -1});
            }
        }

        public void addEdge(int v1, int v2, int weight) {
            adj.get(v1).add(new int[]{v2, weight});
            adj.get(v2).add(new int[]{v1, weight});
        }

        public void print() {
            for (int i = 0; i < adj.size(); i++) {
                System.out.print(i + ":\t");
                for (int[] neighbor : adj.get(i)) {
                    System.out.print("(" + neighbor[0] + ";" + neighbor[1] + ")\t");
                }
                System.out.println();
            }
            System.out.println();
        }

        public int dijkstra(int root, int dest) {
            MinHeap minHeap = new MinHeap(vertices);
            minHeap.decreaseKey(root, 0, root);
//            minHeap.buildMinHeap();

            while (!minHeap.isEmpty()) {
                int[] extracted = minHeap.extractMin();
                visited[extracted[0]] = true;
                int initialCost = extracted[1];

                for (int[] neighbor : adj.get(extracted[0])) {
                    if (!visited[neighbor[0]]) {
                        minHeap.decreaseKey(neighbor[0], neighbor[1] + initialCost, extracted[0]);
                    }
                }

                if (extracted[0] == dest) {
                    return extracted[1];
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 5, 3);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 4, 2);
        g.addEdge(5, 2, 5);
        g.addEdge(5, 4, 5);
        g.addEdge(2, 3, 1);
        g.addEdge(4, 3, 2);

        System.out.println("Dijkstra: " + g.dijkstra(0, 3));
    }
}




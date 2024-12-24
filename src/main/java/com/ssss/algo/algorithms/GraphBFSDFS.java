package main.java.com.ssss.algo.algorithms;
import java.util.*;

public class GraphBFSDFS {
    private List<List<Integer>> adj; // Список смежности
    private int size; // Количество вершин
    private int[] color; // Цвета вершин (0 - белый, 1 - серый, 2 - чёрный)
    private int[] discovery; // Время обнаружения вершины
    private int[] finish; // Время завершения обработки вершины
    private int[] predecessor; // Предыдущая вершина
    private int dfsTime; // Общее время для отслеживания шагов DFS

    public GraphBFSDFS(int size) {
        this.size = size;
        adj = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
        color = new int[size];
        discovery = new int[size];
        finish = new int[size];
        predecessor = new int[size];
    }

    public void addEdge(int v, int u) {
        adj.get(v).add(u);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    private void dfsVisit(int i) {
        dfsTime++;
        discovery[i] = dfsTime;
        color[i] = 1;

        for (int neighbor : adj.get(i)) {
            if (color[neighbor] == 0) {
                predecessor[neighbor] = i;
                dfsVisit(neighbor);
            }
        }

        dfsTime++;
        finish[i] = dfsTime;
        color[i] = 2;
    }



    public int[] dfs() {

        Arrays.fill(color, 0);
        Arrays.fill(discovery, Integer.MAX_VALUE);
        Arrays.fill(finish, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        dfsTime = 0;

        for (int i = 0; i < size; i++) {
            if (color[i] == 0) {
                dfsVisit(i);
            }
        }

        return finish;
    }

    public int[] bfs(int start) {
        int[] color = new int[size];
        int[] discovery = new int[size];
        int[] predecessor = new int[size];

        Arrays.fill(discovery, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);

        Queue<Integer> queue = new LinkedList<>();
        color[start] = 1;
        discovery[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbor : adj.get(curr)) {
                if (color[neighbor] == 0) {
                    color[neighbor] = 1;
                    discovery[neighbor] = discovery[curr] + 1;
                    predecessor[neighbor] = curr;
                    queue.add(neighbor);
                }
            }
            color[curr] = 2;
        }

        return discovery;
    }
}

class Main {
    public static void main(String[] args) {
//        GraphBFSDFS g = new GraphBFSDFS(8);

//        g.addEdge(0, 1);
//        g.addEdge(0, 4);
//        g.addEdge(1, 2);
//        g.addEdge(1, 4);
//        g.addEdge(2, 3);
//        g.addEdge(3, 1);
//        g.addEdge(4, 3);
//        g.addEdge(5, 6);
//        g.addEdge(5, 7);
//        g.addEdge(6, 0);
//        g.addEdge(6, 4);
//        g.addEdge(7, 6);
//        g.addEdge(7, 5);

//        int[] bfs = g.bfs(0);
//        for (int i = 0; i < bfs.length; i++) {
//            System.out.println(i + " " + bfs[i]);
//        }


        GraphBFSDFS g = new GraphBFSDFS(7);
        g.addEdge(4,2);
        g.addEdge(4,3);
        g.addEdge(2,3);
        g.addEdge(1,5);
        g.addEdge(6,2);
        g.addEdge(6,4);

        int[] dfs = g.dfs();
        for (int df : dfs) {
            System.out.print(df + " ");
        }
    }
}

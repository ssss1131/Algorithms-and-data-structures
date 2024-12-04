package main.java.com.ssss.algo.lab10_BFS;

import java.util.*;

public class TaskJ {

    // BFS для обработки графа
    private static int bfs(List<List<Integer>> adjList, int start, int n, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int[] children = new int[n];
        Map<Integer, Integer> parents = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parents.put(i, -1);
        }

        int cnt = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            for (int neighbor : adjList.get(current)) {
                if (parents.get(neighbor) == -1) {
                    queue.add(neighbor);
                    parents.put(neighbor, current);
                    children[current]++;
                }
            }

            if (parents.get(current) == -1 || children[current] > children[parents.get(current)]) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Количество вершин
        int m = scanner.nextInt(); // Количество рёбер

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Считывание рёбер
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1; // Преобразуем к 0-индексации
            int y = scanner.nextInt() - 1;
            adjList.get(x).add(y);
        }

        int cnt = 0;
        boolean[] visited = new boolean[n];

        // Запуск BFS для всех непосещённых узлов
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt += bfs(adjList, i, n, visited);
            }
        }

        System.out.println(cnt);
    }
}

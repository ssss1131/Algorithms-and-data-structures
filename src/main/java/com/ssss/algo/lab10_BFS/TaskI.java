package main.java.com.ssss.algo.lab10_BFS;
import java.util.*;

public class TaskI {

    // Метод для проверки наличия цикла
    private static boolean detectCycle(int current, List<List<Integer>> adjList, boolean[] visited, boolean[] recursionStack) {
        visited[current] = true;
        recursionStack[current] = true;

        for (int neighbor : adjList.get(current)) {
            if (!visited[neighbor]) {
                if (detectCycle(neighbor, adjList, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[neighbor]) {
                return true; // Цикл найден
            }
        }

        recursionStack[current] = false;
        return false;
    }

    private static boolean isThereCycle(int n, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[n];
        boolean[] recursionStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (detectCycle(i, adjList, visited, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS для топологической сортировки
    private static void dfs(int at, boolean[] visited, List<Integer> visitedNodes, List<List<Integer>> adjList) {
        visited[at] = true;

        for (int neighbor : adjList.get(at)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, visitedNodes, adjList);
            }
        }

        visitedNodes.add(at);
    }

    // Топологическая сортировка
    private static void topSort(List<List<Integer>> adjList) {
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        int[] ordering = new int[n];
        int index = n - 1;

        for (int at = 0; at < n; at++) {
            if (!visited[at]) {
                List<Integer> visitedNodes = new ArrayList<>();
                dfs(at, visited, visitedNodes, adjList);
                for (int node : visitedNodes) {
                    ordering[index--] = node;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print((ordering[i] + 1) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Количество вершин
        int m = scanner.nextInt(); // Количество рёбер

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adjList.get(x - 1).add(y - 1);
        }

        if (isThereCycle(n, adjList)) {
            System.out.println("Impossible");
            return;
        }

        System.out.println("Possible");
        topSort(adjList);
    }
}


package main.java.com.ssss.algo.lab10_BFS;
import java.util.*;

public class TaskG {

    // Метод для проверки наличия цикла с использованием DFS
    private static boolean detectCycle(int current, List<List<Integer>> adjList, boolean[] visited, boolean[] recursionStack) {
        visited[current] = true;
        recursionStack[current] = true;

        for (int neighbor : adjList.get(current)) {
            if (!visited[neighbor]) {
                if (detectCycle(neighbor, adjList, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[neighbor]) {
                return true; // Найден цикл
            }
        }

        recursionStack[current] = false;
        return false;
    }

    // Проверка, есть ли цикл в графе
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

    // Метод для удаления ребра и проверки ацикличности
    private static boolean removeEdgeAndCheck(int n, List<List<Integer>> adjList, List<int[]> edges) {
        if (!isThereCycle(n, adjList)) {
            return true; // Если уже ацикличный граф
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            // Удаляем ребро
            adjList.get(from).remove((Integer) to);

            // Проверяем, стал ли граф ацикличным
            if (!isThereCycle(n, adjList)) {
                return true;
            }

            // Восстанавливаем ребро
            adjList.get(from).add(to);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Количество вершин
        int m = scanner.nextInt(); // Количество рёбер

        List<List<Integer>> adjList = new ArrayList<>();
        List<int[]> edges = new ArrayList<>();

        // Инициализация списка смежности
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Считывание рёбер
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1; // Преобразуем в 0-индексацию
            int y = scanner.nextInt() - 1;
            adjList.get(x).add(y);
            edges.add(new int[]{x, y});
        }

        // Проверяем возможность удаления одного ребра для ацикличности
        if (removeEdgeAndCheck(n, adjList, edges)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}



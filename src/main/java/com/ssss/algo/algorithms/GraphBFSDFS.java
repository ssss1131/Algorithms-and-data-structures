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

    // Конструктор графа
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

    // Метод для добавления ребра
    public void addEdge(int v, int u) {
        adj.get(v).add(u);
    }

    // Печать графа (списка смежности)
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Вспомогательный метод DFS для обработки одной вершины
    private void dfsVisit(int i) {
        dfsTime++;
        discovery[i] = dfsTime; // Сохраняем время обнаружения
        color[i] = 1; // Серый цвет (в процессе обработки)

        for (int neighbor : adj.get(i)) {
            if (color[neighbor] == 0) { // Если сосед ещё не посещён
                predecessor[neighbor] = i; // Записываем предка
                dfsVisit(neighbor); // Рекурсивно обрабатываем соседа
            }
        }

        dfsTime++;
        finish[i] = dfsTime; // Сохраняем время завершения обработки
        color[i] = 2; // Чёрный цвет (обработано)
    }

    // Метод для выполнения DFS
    public int[] dfs() {
        // Инициализация
        Arrays.fill(color, 0); // Все вершины белые
        Arrays.fill(discovery, Integer.MAX_VALUE); // Изначально все вершины не обнаружены
        Arrays.fill(finish, Integer.MAX_VALUE); // Время завершения обработки неизвестно
        Arrays.fill(predecessor, -1); // Предков нет
        dfsTime = 0;

        // Запуск DFS для каждой непосещённой вершины
        for (int i = 0; i < size; i++) {
            if (color[i] == 0) { // Если вершина белая
                dfsVisit(i);
            }
        }

        return predecessor; // Возвращаем массив времени завершения обработки
    }

    // Метод для выполнения BFS
    public int[] bfs(int start) {
        int[] color = new int[size]; // Цвета вершин
        int[] discovery = new int[size]; // Расстояние от начальной вершины
        int[] predecessor = new int[size]; // Предыдущая вершина в пути

        Arrays.fill(discovery, Integer.MAX_VALUE); // Изначально все расстояния максимальные
        Arrays.fill(predecessor, -1); // Предков нет

        Queue<Integer> queue = new LinkedList<>();
        color[start] = 1; // Серый цвет (в процессе обработки)
        discovery[start] = 0; // Расстояние до самой себя — 0
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbor : adj.get(curr)) {
                if (color[neighbor] == 0) { // Если сосед ещё не посещён
                    color[neighbor] = 1; // Серый цвет
                    discovery[neighbor] = discovery[curr] + 1; // Считаем расстояние
                    predecessor[neighbor] = curr; // Запоминаем предка
                    queue.add(neighbor);
                }
            }
            color[curr] = 2; // Чёрный цвет (обработано)
        }

        return discovery; // Возвращаем массив расстояний
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

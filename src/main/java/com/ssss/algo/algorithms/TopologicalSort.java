package main.java.com.ssss.algo.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopologicalSort {

    public static int[] topologicalSort(List<List<Integer>> graph, int size) {
        int[] ordering = new int[size];
        boolean[] visited = new boolean[size];

        int i = size - 1;
        for (int at = 0; at < size; at++) {
            if (!visited[at]) {
                i = dfs(i, at, graph, ordering, visited);
            }
        }
        return ordering;
    }

    private static int dfs(int i, int at, List<List<Integer>> graph, int[] ordering, boolean[] visited) {
        visited[at] = true;
        for (Integer to : graph.get(i)) {
            if (!visited[to]) {
                i = dfs(i, to, graph, ordering, visited);
            }
        }
        ordering[i] = at;
        return i - 1;
    }


    public static void main(String[] args) {
        int size = 7;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(5);
        graph.get(1).add(3);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(3).add(4);
        graph.get(5).add(4);

        System.out.println(Arrays.toString(topologicalSort(graph, size)));
    }


}

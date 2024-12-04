package main.java.com.ssss.algo.dataStructeres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *      Короч основная суть структуры в том что он может находит количество и элементы таких сабграфов которые соединяют несколько элементов.
 *      Еще можно циклы убрать с помощью него так как в цикле предки двух элементов одинаковые и алгоритм не соединит их
 *      допустим если components = 1 это означает что все элементы графа соединены друг с другом
 *      если components = 2 то значит там два сабграфа которые не соединяются друг с другом, типа так выглядит
 *      1 - 2 - 3
 *      |
 *      4   5 - 6
 *      тут 2 сабграфа это : s1 = {1,2,3,4} s2 = {5,6}
 *      ---
 *      Суть структуры:
 *      <p>
 *          DSU помогает эффективно отслеживать компоненты связности в графе.
 *          Она позволяет определить, принадлежат ли две вершины одному компоненту (подграфу) или нет.
 *          DSU используется в таких алгоритмах, как Крускал, для проверки циклов или для построения минимального остовного дерева (MST).
 *      Хранение данных:
 *      <p>
 *          Массив parents используется для хранения информации о том, кто является "родителем" вершины.
 *          Если элемент является корнем, его значение в parents отрицательное, и его модуль (|parents[v]|) равен размеру подграфа
 *          (рангу дерева).
 *      Объединение (unify):
 *      <p>
 *          При объединении меньшего подграфа с большим рангом мы делаем меньшее дерево "детьми" большего.
 *          Это помогает минимизировать высоту дерева и ускорить операции поиска.
 *      Метод find:
 *      <p>
 *          Операция find использует технику сжатия путей (path compression), чтобы ускорить последующие вызовы.
 *          Она обновляет путь от текущей вершины к корню, указывая всех промежуточных "родителей" на сам корень.
 *      Преимущество DSU:
 *      <p>
 *      Благодаря техникам "сжатие путей" и "объединение по рангу", операции выполняются очень быстро,
 *      приближаясь к амортизированному времени O(α(n)), где α(n) — обратная функция Акермана, которая растет крайне медленно.
 * </p>
 **/

public class DisjointSetsUnion {

    static void addUndirectedEdge(Map<Integer, List<Integer>> graph, int v1, int v2) {
        graph.putIfAbsent(v1, new ArrayList<>());
        graph.putIfAbsent(v2, new ArrayList<>());
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    static class DisjointSet {
        int[] parents;
        int components;

        public DisjointSet(int size) {
            parents = new int[size];
            for (int i = 0; i < size; i++) {
                parents[i] = -1;
            }
            components = size;
        }

        int countConnectedComponents(Map<Integer, List<Integer>> graph) {
            for (int i = 0; i < parents.length; i++) {
                List<Integer> edges = graph.get(i);
                if (edges != null) {
                    for (Integer edge : edges) {
                        unify(i, edge);
                    }
                }
            }
            return components;
        }

        private void unify(int v1, int v2) {
            int edgeV1 = find(v1);
            int edgeV2 = find(v2);
            int rankV1 = parents[edgeV1];
            int rankV2 = parents[edgeV2];

            if (edgeV2 == edgeV1) {
                return;
            }

            if (rankV1 < rankV2) {
                parents[edgeV1] += rankV2;// Увеличиваем размер дерева V1
                parents[edgeV2] = edgeV1; // Делаем корень V2 указывать на V1
            } else {
                parents[edgeV2] += rankV1;
                parents[edgeV1] = edgeV2;
            }

            components--;
        }

        private int find(int v) {
            if (parents[v] < 0) {
                return v;
            }
            return parents[v] = find(parents[v]);
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        DisjointSetsUnion.addUndirectedEdge(graph, 0, 1);
        DisjointSetsUnion.addUndirectedEdge(graph, 1, 2);
        DisjointSetsUnion.addUndirectedEdge(graph, 3, 4);
        DisjointSetsUnion.addUndirectedEdge(graph, 4, 5);
        DisjointSetsUnion.addUndirectedEdge(graph, 6, 7);

        DisjointSet disjointSet = new DisjointSet(8);
        System.out.println(disjointSet.countConnectedComponents(graph));
    }


}

package main.java.com.ssss.algo.lab11_Kruskal;

import java.io.*;
import java.util.*;

public class TaskE {

//    static void addUndirectedEdge(Map<Integer, List<Integer>> graph, int v1, int v2) {
//        graph.putIfAbsent(v1, new ArrayList<>());
//        graph.putIfAbsent(v2, new ArrayList<>());
//        graph.get(v1).add(v2);
//        graph.get(v2).add(v1);
//    }
//
//    static class DisjointSet {
//        private int[] parents;
//        private int components;
//
//        public DisjointSet(int size) {
//            parents = new int[size];
//            for (int i = 0; i < size; i++) {
//                parents[i] = -1;
//            }
//            components = size;
//        }
//
//        int countConnectedComponents(Map<Integer, List<Integer>> graph, int size) {
//            parents = new int[size];
//            components = size;
//            for (int i = 0; i < parents.length; i++) {
//                parents[i] = -1;
//            }
//
//            for (int i = 0; i < parents.length; i++) {
//                List<Integer> edges = graph.get(i);
//                if (edges != null) {
//                    for (Integer edge : edges) {
//                        unify(i, edge);
//                    }
//                }
//            }
//            return components;
//        }
//
//        private void unify(int v1, int v2) {
//            int edgeV1 = find(v1);
//            int edgeV2 = find(v2);
//            int rankV1 = parents[edgeV1];
//            int rankV2 = parents[edgeV2];
//
//            if (edgeV2 == edgeV1) {
//                return;
//            }
//
//            if (rankV1 < rankV2) {
//                parents[edgeV1] += rankV2;// Увеличиваем размер дерева V1
//                parents[edgeV2] = edgeV1; // Делаем корень V2 указывать на V1
//            } else {
//                parents[edgeV2] += rankV1;
//                parents[edgeV1] = edgeV2;
//            }
//
//            components--;
//        }
//
//        private int find(int v) {
//            if (parents[v] < 0) {
//                return v;
//            }
//            return parents[v] = find(parents[v]);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int vertices = Integer.parseInt(st.nextToken());
//        int edges = Integer.parseInt(st.nextToken());
//        Map<Integer, List<Integer>> graph = new HashMap<>();
//        for (int i = 0; i < edges; i++) {
//            st = new StringTokenizer(br.readLine());
//            int v1 = Integer.parseInt(st.nextToken()) - 1;
//            int v2 = Integer.parseInt(st.nextToken()) - 1;
//            addUndirectedEdge(graph, v1, v2);
//        }
//        DisjointSet disjointSet = new DisjointSet(vertices);
//        for (int i = vertices - 1; i > 0; i--) {
//            List<Integer> neighbors = graph.getOrDefault(i, new ArrayList<>());
//            for (int neighbor : neighbors) {
//                graph.get(neighbor).remove((Integer) i);
//            }
//            graph.remove(i);
//            bw.write(disjointSet.countConnectedComponents(graph, i) + "\n");
//        }
//        bw.flush();
//    }

}

//#include <iostream>
//#include <algorithm>
//#include <vector>
//
//using namespace std;
//
//const int MAX_VERTICES = 200005;
//
//int dsuParent[MAX_VERTICES], dsuRank[MAX_VERTICES];
//vector<int> adjacencyList[MAX_VERTICES];
//vector<int> connectedComponents;
//
//void initializeDSU() {
//    for (int i = 0; i < MAX_VERTICES; i++) {
//        dsuParent[i] = i;
//        dsuRank[i] = 1;
//    }
//}
//
//int findRoot(int vertex) {
//    return (dsuParent[vertex] == vertex) ? vertex : (dsuParent[vertex] = findRoot(dsuParent[vertex]));
//}
//
//bool uniteSets(int vertexA, int vertexB) {
//    int rootA = findRoot(vertexA);
//    int rootB = findRoot(vertexB);
//
//    if (rootA == rootB)
//        return false;
//
//    if (dsuRank[rootA] < dsuRank[rootB]) {
//        dsuParent[rootA] = rootB;
//    } else if (dsuRank[rootB] < dsuRank[rootA]) {
//        dsuParent[rootB] = rootA;
//    } else {
//        dsuParent[rootA] = rootB;
//        dsuRank[rootB]++;
//    }
//
//    return true;
//}
//
//int main() {
//    int vertexCount, edgeCount;
//    int componentCount = 0;
//
//    initializeDSU();
//
//    cin >> vertexCount >> edgeCount;
//    for (int i = 0; i < edgeCount; i++) {
//        int vertexU, vertexV;
//        cin >> vertexU >> vertexV;
//        adjacencyList[vertexU].push_back(vertexV);
//        adjacencyList[vertexV].push_back(vertexU);
//    }
//
//    for (int currentVertex = vertexCount; currentVertex >= 1; currentVertex--) {
//        componentCount++;
//        for (int neighbor : adjacencyList[currentVertex]) {
//            if (currentVertex < neighbor && findRoot(currentVertex) != findRoot(neighbor)) {
//                componentCount--;
//                uniteSets(currentVertex, neighbor);
//            }
//        }
//        connectedComponents.push_back(componentCount);
//    }
//    reverse(connectedComponents.begin(), connectedComponents.end());
//    for (int i = 1; i < connectedComponents.size(); i++) {
//        cout << connectedComponents[i] << endl;
//    }
//
//    cout << 0 << endl;
//
//    return 0;
//}

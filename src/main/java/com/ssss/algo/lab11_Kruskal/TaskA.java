package main.java.com.ssss.algo.lab11_Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class TaskA {

    static class Edge {
        long weight;
        int from;
        int to;

        public Edge(long weight, int from, int to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
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


        void addEdge(int from, int to, long w) {
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

        long kruskal(){
            long cost = 0;
            edges.sort(Comparator.comparingLong(e -> e.weight));
            long w;
            int v1;
            int v2;
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                w = edge.weight;
                v1 = edge.from;
                v2 = edge.to;
                if(oldestPredecessor(v1) != oldestPredecessor(v2)){
                    predecessor[oldestPredecessor(v2)] = oldestPredecessor(v1);
                    cost +=w;
                }
            }
            return cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        Graph graph = new Graph(vertices + 1);
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long weight = Integer.parseInt(st.nextToken());
            for (int j = from; j <= to; j++) {
                for (int k = j + 1; k <= to; k++) {
                    graph.addEdge(j, k, weight);
                }
            }
        }
        System.out.println(graph.kruskal());


    }

}


//<------------ WITHOUT Time-limit exceeded -------------------->

//#include <bits/stdc++.h>
//
//using namespace std;
//
//class UnionFind {
//private:
//    vector<int> parent, leftmost, rightmost;
//
//public:
//    UnionFind(int n) {
//        parent.resize(n);
//        leftmost.resize(n);
//        rightmost.resize(n);
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//            leftmost[i] = i;
//            rightmost[i] = i;
//        }
//    }
//
//    int find(int i) {
//        if (i == parent[i]) {
//            return i;
//        }
//        return parent[i] = find(parent[i]);
//    }
//
//    void unionSets(int a, int b) {
//        a = find(a);
//        b = find(b);
//
//        if (a == b) {
//            return;
//        }
//
//        parent[a] = b;
//        leftmost[b] = min(leftmost[a], leftmost[b]);
//        rightmost[b] = max(rightmost[a], rightmost[b]);
//    }
//
//    int getLeftmost(int i) {
//        return leftmost[find(i)];
//    }
//
//    int getRightmost(int i) {
//        return rightmost[find(i)];
//    }
//};
//
//class Solution {
//private:
//    int n, m;
//    vector<pair<int, pair<int, int>>> edges;
//
//public:
//    Solution(int nodes, int edgesCount) : n(nodes), m(edgesCount) {}
//
//    void addEdge(int l, int r, int cost) {
//        edges.push_back({cost, {l - 1, r - 1}});
//    }
//
//    long long computeMinimumCost() {
//        sort(edges.begin(), edges.end());
//        UnionFind uf(n);
//
//        long long totalCost = 0;
//        int components = 0;
//
//        for (const auto& edge : edges) {
//            if (components >= n - 1) {
//                break;
//            }
//
//            int left = edge.second.first;
//            int right = edge.second.second;
//            int cost = edge.first;
//
//            int representative = uf.find(left);
//
//            if (uf.getLeftmost(representative) <= left && right <= uf.getRightmost(representative)) {
//                continue;
//            } else if (uf.getLeftmost(representative) <= right && right <= uf.getRightmost(representative)) {
//                right = uf.getLeftmost(representative);
//            } else if (uf.getLeftmost(representative) <= left && left <= uf.getRightmost(representative)) {
//                left = uf.getRightmost(representative);
//            }
//
//            for (int j = left; j <= right; j++) {
//                if (uf.find(representative) != uf.find(j)) {
//                    uf.unionSets(representative, j);
//                    components++;
//                    totalCost += cost;
//                }
//            }
//        }
//
//        return totalCost;
//    }
//};
//
//int main() {
//    int n, m;
//    cin >> n >> m;
//
//    Solution solution(n, m);
//
//    for (int i = 0; i < m; i++) {
//        int l, r, c;
//        cin >> l >> r >> c;
//        solution.addEdge(l, r, c);
//    }
//
//    cout << solution.computeMinimumCost() << endl;
//
//    return 0;
//}

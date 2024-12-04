package main.java.com.ssss.algo.lab10_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            adj.add(new ArrayList<>());
        }
        StringTokenizer st;

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= size; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(bfs(adj, start, end, size));
    }

    private static int bfs(List<List<Integer>> adj, int start, int end, int size) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] discovery = new int[size + 1];
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            if(poll == end){
                return discovery[end];
            }
            for (Integer i : adj.get(poll)) {
                if(!visited.contains(i)){
                    queue.add(i);
                    visited.add(i);
                    discovery[i] = discovery[poll] + 1;
                }
            }
        }
        return -1;
    }

}

package main.java.com.ssss.algo.lab10_BFS;

import java.io.*;
import java.util.*;

public class TaskE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                if (array[j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < query; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            int third = Integer.parseInt(st.nextToken()) - 1;

            boolean isConnected = bfs(adj, first, second) &&
                                  bfs(adj, first, third) &&
                                  bfs(adj, second, third);

            bw.write(isConnected ? "YES\n" : "NO\n");
        }
        bw.flush();

    }

    private static boolean bfs(List<List<Integer>> adj, int first, int second) {
        for (Integer i : adj.get(first)) {
            if(i == second){
                return true;
            }
        }
        return false;
    }

}

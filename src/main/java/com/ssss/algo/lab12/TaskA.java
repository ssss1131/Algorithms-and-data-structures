package main.java.com.ssss.algo.lab12;

import java.io.*;

public class TaskA {

    static class FloydWarshall {
        int[][] matrix;
        int n;

        public FloydWarshall(int[][] matrix) {
            this.matrix = matrix;
            this.n = matrix.length;
        }

        public int solve(boolean[] added) {
            int longestShortestPath = 0;

            for (int k = 0; k < n; k++) {
                if (!added[k]) continue;
                for (int i = 0; i < n; i++) {
                    if (!added[i]) continue;
                    for (int j = 0; j < n; j++) {
                        if (!added[j]) continue;
                        if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                            matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (!added[i]) continue;
                for (int j = 0; j < n; j++) {
                    if (!added[j]) continue;
                    if (i != j && matrix[i][j] != Integer.MAX_VALUE) {
                        longestShortestPath = Math.max(longestShortestPath, matrix[i][j]);
                    }
                }
            }

            return longestShortestPath;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] addingOrder = br.readLine().split(" ");
        FloydWarshall fw = new FloydWarshall(matrix);

        boolean[] added = new boolean[size];

        for (int i = 0; i < added.length; i++) {
            int vertex = Integer.parseInt(addingOrder[i]) - 1;
            added[vertex] = true;
            bw.write(fw.solve(added) + "\n");
        }

        bw.flush();
    }
}


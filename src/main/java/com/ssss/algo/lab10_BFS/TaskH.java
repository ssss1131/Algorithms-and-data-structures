package main.java.com.ssss.algo.lab10_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskH {

    private static final List<int[]> directions = List.of(new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0});

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        int islands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(matrix[i][j] == 1){
                    bfs(matrix, i, j, row, column);
                    islands++;
                }
            }
        }

        System.out.println(islands);

    }

    private static void bfs(int[][] matrix, int row, int column, int maxRow, int maxColumn) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row, column});
        matrix[row][column] = 0;
        while (!queue.isEmpty()){
            Integer[] coordinates = queue.poll();
            for (int[] direction : directions) {
                int newRow = coordinates[0] + direction[0];
                int newColumn = coordinates[1] + direction[1];
                if((newRow >=0 && newRow< maxRow) && (newColumn >=0 && newColumn < maxColumn) && matrix[newRow][newColumn] == 1){
                    queue.add(new Integer[]{newRow, newColumn});
                    matrix[newRow][newColumn] = 0;
                }
            }
        }

    }


}

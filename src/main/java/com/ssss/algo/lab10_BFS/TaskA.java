package main.java.com.ssss.algo.lab10_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskA {

    static int[][] matrix;
    static int rowSize;
    static int columnSize;
    static int countOfMushrooms;
    static Queue<List<Integer>> queueOfMarios = new LinkedList<>();
    static final List<List<Integer>> directions = List.of(List.of(0, 1), List.of(0, -1), List.of(1, 0), List.of(-1, 0));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        columnSize = Integer.parseInt(st.nextToken());
        matrix = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < columnSize; j++) {
                int elm = Integer.parseInt(st.nextToken());
                matrix[i][j] = elm;
                if (elm == 2) {
                    queueOfMarios.add(List.of(i, j));
                } else if(elm == 1){
                    countOfMushrooms ++ ;
                }
            }
        }
        int res = bfs();
        if(countOfMushrooms == 0){
            System.out.println(res);
        } else {
            System.out.println(-1);
        }
    }

    static int bfs() {
        int result = 0;
        boolean killed = false;

        while (!queueOfMarios.isEmpty()) {
            int size = queueOfMarios.size();

            for (int i = 0; i < size; i++) {
                List<Integer> coordinatesOfMarios = queueOfMarios.poll();

                for (List<Integer> direction : directions) {
                    List<Integer> shifted = shiftCoordinate(coordinatesOfMarios, direction);
                    Integer row = shifted.get(0);
                    Integer column = shifted.get(1);

                    if (validCoordinates(row, column) && matrix[row][column] == 1) {
                        matrix[row][column] = 2;
                        queueOfMarios.add(shifted);
                        countOfMushrooms --;
                        killed = true;
                    }
                }
            }

            if (killed) {
                result++;
                killed = false;
            }
        }

        return result;
    }


    static List<Integer> shiftCoordinate(List<Integer> from, List<Integer> shift) {
        return List.of(from.get(0) + shift.get(0), from.get(1) + shift.get(1));
    }

    static boolean validCoordinates(int row, int column){
        return row >= 0 && column >= 0 && row < rowSize && column < columnSize;
    }

}

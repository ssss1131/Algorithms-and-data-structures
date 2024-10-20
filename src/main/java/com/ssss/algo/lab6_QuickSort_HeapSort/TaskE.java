package main.java.com.ssss.algo.lab6_QuickSort_HeapSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class TaskE {

    public static void quickSort(int[][] matrix, int beg, int end, int yIndex){
        if(end>beg){
            int p = partition(matrix, beg, end, yIndex);
            quickSort(matrix, beg, p -1, yIndex);
            quickSort(matrix, p + 1, end, yIndex);
        }

    }

    private static int partition(int[][] matrix, int beg, int end, int yIndex) {
        int pivot = beg + new Random().nextInt(end - beg + 1);
        swap(matrix, pivot, end, yIndex);
        int cur = beg;
        for (int i = beg; i < end; i++) {
            if(matrix[i][yIndex] >= matrix[end][yIndex]){
                swap(matrix, cur, i, yIndex);
                cur++;
            }
        }
        swap(matrix, end, cur, yIndex);
        return cur;
    }

    private static void swap(int[][] matrix, int cur, int end, int yIndex) {
        int temp = matrix[cur][yIndex];
        matrix[cur][yIndex] = matrix[end][yIndex];
        matrix[end][yIndex] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeX = Integer.parseInt(st.nextToken());
        int sizeY = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sizeY; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < sizeY; i++) {
            quickSort(matrix, 0, sizeX - 1, i);
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}

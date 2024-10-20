package main.java.com.ssss.algo.lab3_BinarySearch;
//
//import java.util.Optional;
//import java.util.Scanner;
//
//public class TaskA {
//
//    private static int row;
//    private static int column;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int sizeOfSearchingElm = scanner.nextInt();
//        int[] searchingElmnts = new int[sizeOfSearchingElm];
//        for (int i = 0; i < sizeOfSearchingElm; i++) {
//            searchingElmnts[i] = scanner.nextInt();
//        }
//        row = scanner.nextInt();
//        column = scanner.nextInt();
//        int[] matrix = new int[row*column];
//        int size = row * column;
//
//        for (int i = 0; i < row; i++) {
//            if (i % 2 == 0) {
//                for (int j = 0; j < column; j++) {
//                    matrix[i * column + j] = scanner.nextInt();
//                }
//            } else {
//                for (int j = 0; j < column; j++) {
//                    matrix[i * column + (column - 1 - j)] = scanner.nextInt();
//                }
//            }
//        }
//        for (int searchingElmnt : searchingElmnts) {
//            Optional<int[]> ints = binarySearch(searchingElmnt,size, matrix);
//            if (ints.isPresent()) {
//                for (int anInt : ints.get()) {
//                    System.out.print(anInt + " ");
//                }
//                System.out.println();
//            } else {
//                System.out.println("-1");
//            }
//        }
//    }
//
//    //search for ascending list
//    public static Optional<int[]> binarySearch(int searchingElm, int size, int[] matrix){
//        int leftPointer = 0;
//        int rightPointer = size - 1;
//        while(leftPointer<=rightPointer){
//            int m = (leftPointer + (rightPointer - leftPointer)/2);
//            if(matrix[m] == searchingElm){
//                int rowOfElm = m / column;
//                int columnOfElm;
//                if (rowOfElm % 2 == 0) {
//                    columnOfElm = m % column;
//                } else {
//                    columnOfElm = (column - 1) - (m % column);
//                }
//                int[] res = {rowOfElm, columnOfElm};
//                return Optional.of(res);
//            }
//            if(searchingElm < matrix[m]){
//                leftPointer = m + 1;
//            } else{
//                rightPointer = m-1;
//            }
//        }
//        return Optional.empty();
//
//    }
//}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class TaskA {

    private static int row;
    private static int column;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int sizeOfSearchingElm = Integer.parseInt(reader.readLine());
        String[] searchingElmntsInput = reader.readLine().split(" ");
        int[] searchingElmnts = new int[sizeOfSearchingElm];
        for (int i = 0; i < sizeOfSearchingElm; i++) {
            searchingElmnts[i] = Integer.parseInt(searchingElmntsInput[i]);
        }

        String[] matrixDimensions = reader.readLine().split(" ");
        row = Integer.parseInt(matrixDimensions[0]);
        column = Integer.parseInt(matrixDimensions[1]);
        int[] matrix = new int[row * column];
        int size = row * column;

        int index = 0;
        for (int i = 0; i < row; i++) {
            String[] line = reader.readLine().split(" ");
            if (i % 2 == 0) {
                for (int j = 0; j < column; j++) {
                    matrix[index++] = Integer.parseInt(line[j]);
                }
            } else {
                for (int j = 0; j < column; j++) {
                    matrix[index++] = Integer.parseInt(line[column - 1 - j]);
                }
            }
        }

        for (int searchingElmnt : searchingElmnts) {
            int[] result = binarySearch(searchingElmnt, size, matrix);
            if (result[0] != -1) {
                writer.write(result[0] + " " + result[1] + "\n");
            } else {
                writer.write("-1\n");
            }
        }

        writer.flush();
    }

    public static int[] binarySearch(int searchingElm, int size, int[] matrix) {
        int leftPointer = 0;
        int rightPointer = size - 1;

        while (leftPointer <= rightPointer) {
            int m = (leftPointer + (rightPointer - leftPointer) / 2);

            if (matrix[m] == searchingElm) {
                int rowOfElm = m / column;
                int columnOfElm;

                if (rowOfElm % 2 == 0) {
                    columnOfElm = m % column;
                } else {
                    columnOfElm = (column - 1) - (m % column);
                }

                return new int[]{rowOfElm, columnOfElm};
            }

            if (searchingElm > matrix[m]) {
                rightPointer = m - 1;
            } else {
                leftPointer = m + 1;
            }
        }

        return new int[]{-1};
    }
}


package main.java.com.ssss.algo.lab3_BinarySearch;

import java.io.*;
import java.util.Arrays;

public class TaskI {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(bufferedReader.readLine());
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int searchingElm = Integer.parseInt(bufferedReader.readLine());
        bufferedWriter.write( binarySearch(searchingElm, array) ? "Yes" : "No");
        bufferedWriter.flush();

    }

    public static boolean binarySearch(int searchingElm, int[] matrix){
        int leftPointer = 0;
        int rightPointer = matrix.length - 1;
        while(leftPointer<=rightPointer){
            int m = (leftPointer + (rightPointer - leftPointer)/2);
            if(matrix[m] == searchingElm){
                return true;
            }
            if(searchingElm > matrix[m]){
                leftPointer = m + 1;
            } else{
                rightPointer = m-1;
            }
        }
        return false;

    }
}

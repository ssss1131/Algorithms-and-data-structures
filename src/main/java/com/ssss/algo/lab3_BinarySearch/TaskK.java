package main.java.com.ssss.algo.lab3_BinarySearch;

import java.io.*;
import java.util.Arrays;

public class TaskK {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int biggerThan = array[1];
        int[] elements = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] prefixSums = new int[elements.length + 1];
        for (int i = 1; i <= elements.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + elements[i - 1];
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < prefixSums.length; i++) {
            int result = binarySearch(biggerThan, prefixSums, i);
            if (result != -1) {
                answer = Math.min(answer, result);
            } else {
                break;
            }
        }
        System.out.println(answer);


    }

    public static int binarySearch(int searchingElm, int[] matrix, int indexOfLeft) {
        int leftPointer = 0;
        int rightPointer = matrix.length - 1;
        int answer = -1;
        while (leftPointer <= rightPointer) {
            int m = (leftPointer + (rightPointer - leftPointer) / 2);
            int sum = matrix[m] - matrix[indexOfLeft];
            if (sum >= searchingElm) {
                answer = m - indexOfLeft;
                rightPointer = m - 1;
            } else {
                leftPointer = m + 1;
            }

        }
        return answer;
    }

}

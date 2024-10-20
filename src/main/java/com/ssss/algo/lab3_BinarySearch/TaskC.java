package main.java.com.ssss.algo.lab3_BinarySearch;

import java.io.*;
import java.util.Arrays;

public class TaskC {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] some = reader.readLine().split(" ");
        int sizeOfSearchingElm = Integer.parseInt(some[0]);
        int queryQuantity = Integer.parseInt(some[1]);
        String[] searchingElmntsInput = reader.readLine().split(" ");
        int[] searchingElmnts = new int[sizeOfSearchingElm];
        for (int i = 0; i < sizeOfSearchingElm; i++) {
            searchingElmnts[i] = Integer.parseInt(searchingElmntsInput[i]);
        }
        int[] sortedArray = quickSort(searchingElmnts);
        int[] result = new int[queryQuantity];

        for (int i = 0; i < queryQuantity; i++) {
            int[] query = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int suu = find(query, sortedArray);
            result[i] = suu;
        }
        for (int i : result) {
            writer.write(i + "\n");
        }
        writer.flush();

    }

    public static int find(int[] query, int[] searchingElmnts) {
        int min = Math.min(query[0], query[2]);
        int max = Math.max(query[1], query[3]);
        int minIndex = findBinaryIndexOfFirstElmBigger(searchingElmnts, min);
        int maxIndex = findBinaryIndexOfLastElmSmaller(searchingElmnts, max);
        int answer = maxIndex - minIndex + 1;
        if (query[1] > query[2] && !(query[0] > query[3])) {
            return answer;
        } else if (query[0] > query[3]) {
            return answer - excludeElementsThatBetween(query[3] + 1, query[0] - 1, searchingElmnts);
        } else {
            return answer - excludeElementsThatBetween(query[1] + 1, query[2] - 1, searchingElmnts);
        }

    }

//    public static int binarySearch(int[] matrix, int min, int max) {
//        int leftPointer = 0;
//        int rightPointer = matrix.length - 1;
//        int result = 0;
//
//        while (leftPointer <= rightPointer) {
//            int m = (leftPointer + (rightPointer - leftPointer) / 2);
//            if (max < matrix[m]) {
//                rightPointer = m - 1;
//            } else if (min > matrix[m]) {
//                leftPointer = m + 1;
//            } else {
//
//            }
//        }
//
//        return result;
//    }

    public static int findBinaryIndexOfFirstElmBigger(int[] matrix, int min) {
        int leftPointer = 0;
        int rightPointer = matrix.length - 1;
        int result = matrix.length;
        while (leftPointer <= rightPointer) {
            int m = (leftPointer + (rightPointer - leftPointer) / 2);
            if (matrix[m] >= min) {
                rightPointer = m - 1;
                result = m;
            } else {
                leftPointer = m + 1;
            }
        }
        return result;
    }


    public static int findBinaryIndexOfLastElmSmaller(int[] matrix, int max) {
        int leftPointer = 0;
        int rightPointer = matrix.length - 1;
        int result = -1;
        while (leftPointer <= rightPointer) {
            int m = (leftPointer + (rightPointer - leftPointer) / 2);
            if (matrix[m] <= max) {
                leftPointer = m + 1;
                result = m;
            } else {
                rightPointer = m - 1;
            }
        }
        return result;
    }

    public static int excludeElementsThatBetween(int from, int to, int[] sortedArray) {
        if(from != to){
            int fromIndex = findBinaryIndexOfFirstElmBigger(sortedArray, from);
            int toIndex = findBinaryIndexOfLastElmSmaller(sortedArray, to);
            if (fromIndex <= toIndex) {
                return toIndex - fromIndex + 1;
            }
        }
        return 0;
    }

    public static int[] quickSort(int[] array) {
        int size = array.length;
        if (size < 2) {
            return array;
        }
        int pivot = array[size / 2];
        int[] bigger = Arrays.stream(array).filter(x -> x > pivot).toArray();
        int[] smaller = Arrays.stream(array).filter(x -> x < pivot).toArray();
        return concat(quickSort(smaller), quickSort(bigger), pivot);

    }

    private static int[] concat(int[] smaller, int[] bigger, int pivot) {
        int[] result = new int[smaller.length + bigger.length + 1];
        System.arraycopy(smaller, 0, result, 0, smaller.length);
        result[smaller.length] = pivot;
        System.arraycopy(bigger, 0, result, smaller.length + 1, bigger.length);
        return result;
    }

}

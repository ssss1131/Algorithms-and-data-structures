package main.java.com.ssss.algo.algorithms;

import java.util.List;

public class binarySearch {
    //search for ascending array
    public static boolean binarySearch(int searchingElm, int size, int[] elements) {
        int leftPointer = 0;
        int rightPointer = size - 1;
        while (leftPointer <= rightPointer) {
            int m = leftPointer + (rightPointer - leftPointer) / 2;
            if (elements[m] == searchingElm) {
                return true;
            }
            if (searchingElm > elements[m]) {
                leftPointer = m + 1;
            } else {
                rightPointer = m - 1;
            }
        }
        return false;
    }

    //search for ascending list
    public static boolean binarySearch(int searchingElm, List<Integer> matrix) {
        int leftPointer = 0;
        int rightPointer = matrix.size() - 1;
        while (leftPointer <= rightPointer) {
            int m = leftPointer + (rightPointer - leftPointer) / 2;
            if (matrix.get(m) == searchingElm) {
                return true;
            }
            if (searchingElm > matrix.get(m)) {
                leftPointer = m + 1;
            } else {
                rightPointer = m - 1;
            }
        }
        return false;

    }
}

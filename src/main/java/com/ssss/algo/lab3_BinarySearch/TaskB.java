package main.java.com.ssss.algo.lab3_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int blocks = Integer.parseInt(st.nextToken());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long left = Integer.MIN_VALUE;
        long right = 0;
        for (int i = 0; i < size; i++) {
            left = Math.max(array[i], left);
            right += array[i];
        }
        long answer = binarySearch(array, left, right, blocks);
        System.out.println(answer);

    }

    public static long binarySearch(int[] array, long leftPointer, long rightPointer, int blocks) {
        long answer = rightPointer;
        while (rightPointer >= leftPointer) {
            long mid = leftPointer + (rightPointer - leftPointer) / 2;

            if (possibleToDivide(array, mid, blocks)) {
                rightPointer = mid - 1;
                answer = mid;
            } else {
                leftPointer = mid + 1;
            }
        }
        return answer;
    }

    private static boolean possibleToDivide(int[] array, long mid, int blocks) {
        long currentSum = 0;
        int currentBlocks = 1;
        for (int ghoul : array) {
            if (currentSum + ghoul > mid) {
                currentSum = ghoul;
                currentBlocks++;
            } else {
                currentSum += ghoul;
            }
            if (currentBlocks > blocks) {
                return false;
            }
        }
        return true;
    }


}

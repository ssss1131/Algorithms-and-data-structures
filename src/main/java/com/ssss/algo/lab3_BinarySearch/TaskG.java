package main.java.com.ssss.algo.lab3_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskG {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(st.nextToken());
        long hours = Long.parseLong(st.nextToken());
        int[] bags = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(bags).max().getAsInt();
        int min = binarySearch(max, hours, bags);
        System.out.println(min);

    }

    public static int binarySearch(int max, long hours, int[] matrix) {
        int leftPointer = 1;
        int rightPointer = max;
        int answer = max;
        while (leftPointer <= rightPointer) {
            int m = (leftPointer + (rightPointer - leftPointer) / 2);
            if (sum(m, matrix, hours)) {
                answer = Math.min(answer, m);
                rightPointer = m - 1;
            } else {
                leftPointer = m + 1;
            }
        }
        return answer;
    }

    public static boolean sum(int middle, int[] matrix, long hours) {
        long sum = 0;
        for (int i : matrix) {
            sum += (i + middle - 1)/middle;
            if (sum > hours) {
                return false;
            }
        }
        return true;
    }

}

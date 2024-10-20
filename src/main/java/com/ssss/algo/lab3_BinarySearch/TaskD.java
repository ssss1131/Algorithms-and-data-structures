package main.java.com.ssss.algo.lab3_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskD {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(arr);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int[] cord = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();


            if (cord[0] > cord[2]) {
                int temp = cord[0];
                cord[0] = cord[2];
                cord[2] = temp;
                temp = cord[1];
                cord[1] = cord[3];
                cord[3] = temp;
            }


            if (cord[1] >= cord[2]) {
                if (cord[0] <= cord[2]) {
                    answer.append(getAnswer(arr, cord[0], Math.max(cord[1], cord[3])) + "\n");
                } else {
                    answer.append(getAnswer(arr, cord[2], Math.max(cord[1], cord[3])) + "\n");
                }
            } else {
                answer.append(getAnswer(arr, cord[0], cord[1]) + getAnswer(arr, cord[2], cord[3])+ "\n");
            }
        }
        System.out.println(answer);
    }


    public static int upperBound(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }


    public static int lowerBound(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


    public static int getAnswer(int[] arr, int l, int r) {
        return upperBound(arr, r) - lowerBound(arr, l) + 1;
    }
}

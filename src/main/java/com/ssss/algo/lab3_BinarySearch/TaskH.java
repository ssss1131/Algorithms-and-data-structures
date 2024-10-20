package main.java.com.ssss.algo.lab3_BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class TaskH {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(st.nextToken());
        int mistakes = Integer.parseInt(st.nextToken());
        int[] sum = new int[size + 1];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= size; i++) {
            int input = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + input;
        }
        int[] result = new int[mistakes];
        for (int i = 0; i < mistakes; i++) {
            int mistake = Integer.parseInt(bufferedReader.readLine());
            int answer = binarySearch(mistake, sum);
            result[i] = answer;
        }
        for (int i : result) {
            bufferedWriter.write(i + "\n");
        }
        bufferedWriter.flush();
    }

    public static int binarySearch(int searchingElm, int[] matrix) {
        int leftPointer = 0;
        int rightPointer = matrix.length - 1;
        int answer = Integer.MAX_VALUE;
        while (leftPointer <= rightPointer) {
            int m = (leftPointer + (rightPointer - leftPointer) / 2);
            if (matrix[m] >= searchingElm) {
                answer = Math.min(answer, m);
                rightPointer = m - 1;
            } else {
                leftPointer = m + 1;
            }
        }
        return answer;
    }
}

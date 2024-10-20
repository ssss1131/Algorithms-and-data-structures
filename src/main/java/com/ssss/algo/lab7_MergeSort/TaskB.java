package main.java.com.ssss.algo.lab7_MergeSort;

import java.io.*;
import java.util.Arrays;

public class TaskB {

    static void findWithTwoPointers(int[] sortedArr1, int[] sortedArr2, BufferedWriter bw) throws IOException {
        int i = 0;
        int j = 0;
        while (i < sortedArr1.length && j < sortedArr2.length) {
            if (sortedArr1[i] <= sortedArr2[j]) {
                bw.write(sortedArr1[i] + " ");
                i++;
            } else {
                bw.write(sortedArr2[j] + " ");
                j++;
            }
        }
        while (i < sortedArr1.length) {
            bw.write(sortedArr1[i] + " ");
            i++;
        }
        while (j < sortedArr2.length) {
            bw.write(sortedArr2[j] + " ");
            j++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        int[] sorterArr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.readLine();
        int[] sorterArr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        findWithTwoPointers(sorterArr1, sorterArr2, bw);
        bw.flush();

    }

}

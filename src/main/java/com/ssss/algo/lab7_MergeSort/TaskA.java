package main.java.com.ssss.algo.lab7_MergeSort;

import java.io.*;
import java.util.Arrays;

public class TaskA {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void merge(String[] arr, int beg, int mid, int end) throws IOException {
        String[] left = new String[mid - beg + 2];
        String[] right = new String[end - mid + 1];
        left[mid - beg + 1] = "z".repeat(51);
        right[end - mid] = "z".repeat(51);

        for (int i = 0; i < mid - beg + 1; i++) {
            left[i] = arr[beg + i];
        }
        for (int i = 0; i < end - mid; i++) {
            right[i] = arr[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = beg;
        while (k <= end) {
            if (compare(left[i], right[j])) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

    }

    private static boolean compare(String maybeBigger, String s1) {
        return maybeBigger.length() <= s1.length();
    }

    static void mergeSort(String[] arr, int beg, int end) throws IOException {
        if (end > beg) {
            int mid = beg + (end - beg) / 2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String[] split = br.readLine().split(" ");
            mergeSort(split, 0, split.length - 1);
            Arrays.stream(split).forEach(s -> {
                try {
                    bw.write(s + " ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bw.write("\n");
        }
        bw.flush();
    }


}

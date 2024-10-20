package main.java.com.ssss.algo.lab7_MergeSort;

import java.io.*;
import java.util.StringTokenizer;

public class TaskE {
    static class Row {
        int[] row;
        int sum;

        public Row(int[] row, int sum) {
            this.row = row;
            this.sum = sum;
        }
    }


    static void mergeSort(Row[] arr, int beg, int end) throws IOException {
        if (end > beg) {
            int mid = beg + (end - beg) / 2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid + 1, end);

            merge(arr, beg, mid, end);
        }
    }

    private static void merge(Row[] arr, int beg, int mid, int end) throws IOException {
        Row[] left = new Row[mid - beg + 2];
        Row[] right = new Row[end - mid + 1];
        left[mid - beg + 1] = new Row(new int[]{1}, Integer.MIN_VALUE);
        right[end - mid] = new Row(new int[]{1}, Integer.MIN_VALUE);

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
        left = null;
        right = null;
    }

    private static boolean compare(Row maybeBigger, Row row1) {
        if (maybeBigger.sum == row1.sum) {
            int i = 0;
            int j = 0;
            while (i < maybeBigger.row.length && j < row1.row.length) {
                if (maybeBigger.row[i] == row1.row[j]) {
                    i++;
                    j++;
                    continue;
                }
                return maybeBigger.row[i] < row1.row[i];
            }
        }
        return maybeBigger.sum > row1.sum;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        Row[] rows = new Row[row];
        for (int i = 0; i < row; i++) {
            String[] s = br.readLine().split(" ");
            int sum = 0;
            int[] currentRow = new int[col];
            for (int j = 0; j < col; j++) {
                int value = Integer.parseInt(s[j]);
                currentRow[j] = value;
                sum += value;
            }
            rows[i] = new Row(currentRow, sum);
        }
        mergeSort(rows, 0, row - 1);
        for (Row row1 : rows) {
            for (int i = 0; i < row1.row.length; i++) {
                bw.write(row1.row[i] + " ");
            }
            bw.write("\n");
        }
        bw.flush();

    }

}

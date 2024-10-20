package main.java.com.ssss.algo.lab7_MergeSort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskC {
    static void merge(int[] arr, int beg, int mid, int end) {
        int[] left = new int[mid - beg + 2];//сюда добавим миддл элемент еще помимо бесконечности
        int[] right = new int[end - mid + 1];
        left[mid - beg + 1] = Integer.MAX_VALUE;
        right[end - mid] = Integer.MAX_VALUE;

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
            if (left[i] >= right[j]) {
                arr[k] = right[j];
                j++;
            } else {
                arr[k] = left[i];
                i++;
            }
            k++;
        }
        left = null;
        right = null;
    }

    static void mergeSort(int[] arr, int beg, int end) {
        if (end > beg) {
            int mid = beg + (end - beg) / 2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
        }
    }


    static void findWithTwoPointers(int[] sortedArr1, int[] sortedArr2, BufferedWriter bw) throws IOException {
        int i = 0;
        int j = 0;
        while (i < sortedArr1.length && j < sortedArr2.length) {
            if (sortedArr1[i] == sortedArr2[j]) {
                bw.write(sortedArr1[i] + " ");
                i++;
                j++;
            }else if(sortedArr1[i] > sortedArr2[j]){
                j++;
            }else{
                i++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeArr1 = Integer.parseInt(st.nextToken());
        int sizeArr2 = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[0];
        if(sizeArr1 > 0){
            arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] arr2 = new int[0];
        if(sizeArr2 > 0){
            arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        mergeSort(arr1, 0, sizeArr1 - 1);
        mergeSort(arr2, 0, sizeArr2 - 1);
        findWithTwoPointers(arr1, arr2, bw);
        bw.flush();

    }

}

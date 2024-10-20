package main.java.com.ssss.algo.lab6_QuickSort_HeapSort;

import java.io.*;
import java.util.Arrays;

public class TaskD {

    static class Heap {
        String[] arr;
        int heapSize;
        int arrSize;

        public Heap(String[] arr, int arrSize) {
            this.arr = arr;
            this.heapSize = arrSize;
            this.arrSize = arrSize;
        }

        public int parent(int i) {
            return (i - 1) / 2;
        }

        public int left(int i) {
            return i * 2 + 1;
        }

        public int right(int i) {
            return i * 2 + 2;
        }

        public void minHeapify(int i) {
            int smallest = i;
            int left = left(i);
            int right = right(i);
            if (left < heapSize && wasBefore(arr[smallest], arr[left])) {
                smallest = left;
            }
            if (right < heapSize && wasBefore(arr[smallest], arr[right])) {
                smallest = right;
            }

            if (smallest != i) {
                swap(arr, smallest, i);
                minHeapify(smallest);
            }
        }

        public void buildMinHeap() {
            for (int i = arrSize / 2 - 1; i >= 0; i--) {
                minHeapify(i);
            }
        }

        public boolean wasBefore(String date, String maybeBeforeDate) {
            int[] date1Int = Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();
            int[] date2Int = Arrays.stream(maybeBeforeDate.split("-")).mapToInt(Integer::parseInt).toArray();

            if (date1Int[2] != date2Int[2]) {
                return date1Int[2] < date2Int[2];
            } else if (date1Int[1] != date2Int[1]) {
                return date1Int[1] < date2Int[1];
            } else {
                return date1Int[0] < date2Int[0];
            }
        }


        private static void swap(String[] array, int i, int end) {
            String temp = array[i];
            array[i] = array[end];
            array[end] = temp;
        }

        public void heapSort() {
            buildMinHeap();
            swap(arr, 0, heapSize - 1);
            heapSize--;

            while (heapSize > 0) {
                minHeapify(0);
                swap(arr, 0, heapSize - 1);
                heapSize--;
            }
        }

        public void print(BufferedWriter bw) throws IOException {
            for (String i : arr) {
                bw.write(i + "\n");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = br.readLine();
        }

        Heap heap = new Heap(arr, size);

        heap.heapSort();
        heap.print(bw);
        bw.flush();
    }

}

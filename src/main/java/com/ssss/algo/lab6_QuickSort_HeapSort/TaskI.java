package main.java.com.ssss.algo.lab6_QuickSort_HeapSort;

import java.io.*;

public class TaskI {
    static class Heap {
        char[] arr;
        int arrSize;
        int heapSize;

        public Heap(char[] arr, int arrSize) {
            this.arr = arr;
            this.arrSize = arrSize;
            this.heapSize = arrSize;
        }

        int parent(int i) {
            return (i - 1) / 2;
        }

        int left(int i) {
            return i * 2 + 1;
        }

        int right(int i) {
            return i * 2 + 2;
        }

        void minHeapify(int i) {
            int smallest = i;
            int left = left(i);
            int right = right(i);

            if (left < heapSize && arr[smallest] < arr[left]) {
                smallest = left;
            }
            if (right < heapSize && arr[smallest] < arr[right]) {
                smallest = right;
            }

            if (smallest != i) {
                swap(smallest, i);
                minHeapify(smallest);
            }
        }

        void buildMinHeap() {
            for (int i = arrSize/ 2 - 1; i >= 0; i--) {
                minHeapify(i);
            }
        }

        void heapSort(){
            buildMinHeap();
            swap(0, heapSize - 1);
            heapSize--;
            while (heapSize>0){
                minHeapify(0);
                swap(0, heapSize - 1);
                heapSize--;
            }

        }

        private void swap(int smallest, int i) {
            char temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] array = br.readLine().toCharArray();
        Heap heap = new Heap(array, array.length);
        heap.heapSort();
        for (char c : array) {
            bw.write(c);
        }
        bw.flush();
    }


}

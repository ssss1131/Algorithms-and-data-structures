package main.java.com.ssss.algo.lab5_Heap_PQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskA {
    static class Heap {
        long[] array;
        int array_size;
        int heap_size;

        public Heap(long[] array, int array_size) {
            this.array = array;
            this.array_size = array_size;
            this.heap_size = array_size;
        }

        public void print() {
            for (long i : array) {
                System.out.print(i + " ");
            }
        }

        int parent(int i) {
            return (i - 1) / 2;
        }

        int left(int i) {
            return (i * 2 + 1);
        }

        int right(int i) {
            return (i * 2 + 2);
        }

        void minHeapify(int i) {
            int smallest = i;
            int left = left(i);
            int right = right(i);
            if (left < heap_size && array[smallest] > array[left]) {
                smallest = left;
            }
            if (right < heap_size && array[smallest] > array[right]) {
                smallest = right;
            }
            if (smallest != i) {
                swap(array, i, smallest);
                minHeapify(smallest);
            }
        }

        public void swap(long[] array, int i, int j) {
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public void buildMinHeap() {
            for (int i = heap_size / 2 - 1; i >= 0; i--) {
                minHeapify(i);
            }
        }

        public long minCost() {
            long total = 0;
            buildMinHeap();
            long first;
            long second;
            while (heap_size > 1) {
                first = array[0];
                swap(array, 0, heap_size - 1);
                heap_size--;
                minHeapify(0);

                second = array[0];
                swap(array, 0, heap_size - 1);
                heap_size--;
                minHeapify(0);
                long cost = first + second;
                total += cost;
                array[heap_size] = cost;
                heap_size++;
                minHeapify(0);

            }
            return total;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        long[] array = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Heap heap = new Heap(array, size);
        System.out.println(heap.minCost());
    }


}

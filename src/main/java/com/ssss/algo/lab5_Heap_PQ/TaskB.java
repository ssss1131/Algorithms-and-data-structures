package main.java.com.ssss.algo.lab5_Heap_PQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskB {
    static class Heap {
        int[] array;
        int array_size;
        int heap_size;

        public Heap(int[] array, int array_size) {
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

        void maxHeapify(int i) {
            int largest = i;
            int left = left(i);
            int right = right(i);
            if (left < heap_size && array[largest] < array[left]) {
                largest = left;
            }
            if (right < heap_size && array[largest] < array[right]) {
                largest = right;
            }
            if (largest != i) {
                swap(array, i, largest);
                maxHeapify(largest);
            }
        }

        public void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public void buildMaxHeap() {
            for (int i = heap_size / 2 - 1; i >= 0; i--) {
                maxHeapify(i);
            }
        }

        public int rocks() {
            buildMaxHeap();
            int first;
            int second;
            while (heap_size > 1) {
                first = array[0];
                swap(array, 0, heap_size - 1);
                heap_size--;
                maxHeapify(0);

                second = array[0];
                int cost = first - second;
                if(cost != 0){
                    array[heap_size] = cost;
                    heap_size++;
                }
                swap(array, 0, heap_size - 1);
                heap_size--;
                maxHeapify(0);

            }
            return heap_size == 1 ? array[0] : 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Heap heap = new Heap(array, size);
        System.out.println(heap.rocks());
    }



}

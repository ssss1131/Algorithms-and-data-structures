package main.java.com.ssss.algo.algorithms;

public class HeapSort {
    static class Heap{
        int[] array;
        int arraySize;
        int heapSize;

        public Heap(int[] array, int arraySize) {
            this.array = array;
            this.arraySize = arraySize;
            this.heapSize = arraySize;
        }

        public void print() {
            for (int i : array) {
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
            if (left < heapSize && array[smallest] > array[left]) {
                smallest = left;
            }
            if (right < heapSize && array[smallest] > array[right]) {
                smallest = right;
            }
            if (smallest != i) {
                swap(array, i, smallest);
                minHeapify(smallest);
            }
        }

        public void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public void buildMinHeap() {
            for (int i = heapSize / 2 - 1; i > 0; i--) {
                minHeapify(i);
            }
        }

        public void heapSortDesc() {
            buildMinHeap();
            swap(array, 0, heapSize - 1);
            heapSize--;

            while (heapSize > 0) {
                minHeapify(0);
                swap(array, 0, heapSize - 1);
                heapSize--;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 23, 15, 213, 12, 512, 3, 125, 132, 423, 56, 326, 234, 1};
        Heap heap = new Heap(array, array.length);
        heap.heapSortDesc();
        heap.print();
    }

}

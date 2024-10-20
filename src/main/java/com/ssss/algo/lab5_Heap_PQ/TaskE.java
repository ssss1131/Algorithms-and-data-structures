package main.java.com.ssss.algo.lab5_Heap_PQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskE {
    static class PriorityQueue {
        int[] arr;
        int heapSize;
        int maxHeapSize;

        public PriorityQueue(int k) {
            this.arr = new int[k];
            heapSize = 0;
            maxHeapSize = k;
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

            if (left < heapSize && arr[smallest] > arr[left]) {
                smallest = left;
            }
            if (right < heapSize && arr[smallest] > arr[right]) {
                smallest = right;
            }

            if (smallest != i) {
                swap(smallest, i);
                minHeapify(smallest);
            }
        }

        public int heapMinimum() {
            return arr[0];
        }

        public void minHeapInsert(int key) {
            if (heapSize < maxHeapSize) {
                arr[heapSize] = Integer.MIN_VALUE;
                heapIncreaseKey(key, heapSize);
                heapSize++;
            } else {
                if (key > heapMinimum()) {
                    arr[0] = key;
                    minHeapify(0);
                }
            }
        }

        public long printKMaxBoxes() {
            long total = 0;
            for (int i = 0; i < heapSize; i++) {
                total += arr[i];
            }
            return total;
        }

        private void heapIncreaseKey(int key, int i) {
            arr[i] = key;
            while (i > 0 && arr[i] < arr[parent(i)]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        private void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue priorityQueue = new PriorityQueue(k);

        while (size-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("print")) {
                sb.append(priorityQueue.printKMaxBoxes()).append("\n");
            } else {
                priorityQueue.minHeapInsert(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);
    }
}


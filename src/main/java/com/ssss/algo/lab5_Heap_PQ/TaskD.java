package main.java.com.ssss.algo.lab5_Heap_PQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TaskD {
    static class PriorityQueue {
        List<Integer> list ;
        int heap_size;

        public PriorityQueue(int list_size, List<Integer> list) {
            this.list = list;
            heap_size = list_size;
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

            if (left < heap_size && list.get(smallest) > list.get(left)) {
                smallest = left;
            }
            if (right < heap_size && list.get(smallest) > list.get(right)) {
                smallest = right;
            }

            if (smallest != i) {
                swap(list, smallest, i);
                minHeapify(smallest);
            }
        }

        public void buildMinHeap() {
            for (int i = heap_size / 2 - 1; i >= 0; i--) {
                minHeapify(i);
            }
        }

        public int heapMinimum(){
            return list.get(0);
        }

        public int heapExtractMin(){
            int min = heapMinimum();
            list.set(0, list.get(heap_size - 1));
            heap_size--;
            minHeapify(0);
            return min;
        }

        public void minHeapInsert(int key){
            heap_size++;
            list.add(Integer.MIN_VALUE);
            heapIncreaseKey(key, heap_size - 1);
        }

        public int density(int m) {
            int total = -1;
            buildMinHeap();
            if (heapMinimum() >= m) {
                return 0;
            }
            int firstMin = Integer.MIN_VALUE;
            int secondMin;
            while (heap_size > 1 &&  firstMin < m) {
                firstMin = heapExtractMin();
                secondMin = heapExtractMin();
                int newDensity = firstMin + 2 * secondMin;
                minHeapInsert(newDensity);
                total++;
            }
            return heapMinimum() >= m ? total : -1;
        }


        private void heapIncreaseKey(int key, int i) {
            list.set(i, key);
            while(i > 0 && list.get(i) < list.get(parent(i))){
                swap(list, i, parent(i));
                i = parent(i);
            }
        }

        private void swap(List<Integer> list, int largest, int i) {
            int temp = list.get(largest);
            list.set(largest, list.get(i));
            list.set(i, temp);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int density = Integer.parseInt(st.nextToken());
        List<Integer> collect = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        PriorityQueue priorityQueue = new PriorityQueue(size, collect);
        System.out.println(priorityQueue.density(density));
    }

}

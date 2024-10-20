package main.java.com.ssss.algo.lab5_Heap_PQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.stream.Collectors.*;

public class TaskC {
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

        public void maxHeapify(int i) {
            int largest = i;
            int left = left(i);
            int right = right(i);

            if (left < heap_size && list.get(largest) < list.get(left)) {
                largest = left;
            }
            if (right < heap_size && list.get(largest) < list.get(right)) {
                largest = right;
            }

            if (largest != i) {
                swap(list, largest, i);
                maxHeapify(largest);
            }
        }

        public void buildMaxHeap() {
            for (int i = heap_size / 2 - 1; i >= 0; i--) {
                maxHeapify(i);
            }
        }

        public int heapMaximum(){
            return list.get(0);
        }

        public int heapExtractMax(){
            int max = heapMaximum();
            list.set(0, list.get(heap_size - 1));
            heap_size--;
            maxHeapify(0);
            return max;
        }

        public void maxHeapInsert(int key){
            heap_size++;
            list.add(Integer.MIN_VALUE);
            heapIncreaseKey(key, heap_size - 1);
        }

        private void heapIncreaseKey(int key, int i) {
            list.set(i, key);
            while(i > 0 && list.get(i) > list.get(parent(i))){
                swap(list, i, parent(i));
                i = parent(i);
            }
        }

        public long findMaxCost(int i){
            long total = 0;
            buildMaxHeap();
            while (i>0){
                int max = heapExtractMax();
                total += max;
                maxHeapInsert(max - 1);
                i--;
            }
            return total;
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
        int buyers =Integer.parseInt(st.nextToken());
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(toList());
        PriorityQueue priorityQueue = new PriorityQueue(size, list);
        System.out.println(priorityQueue.findMaxCost(buyers));
    }
}

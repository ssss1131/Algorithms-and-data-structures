package main.java.com.ssss.algo.dataStructeres;

import java.util.List;

public class PriorityQueue {
    List<Integer> list ;
    int heapSize;

    public PriorityQueue(int list_size, List<Integer> list) {
        this.list = list;
        heapSize = list_size;
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

        if (left < heapSize && list.get(largest) < list.get(left)) {
            largest = left;
        }
        if (right < heapSize && list.get(largest) < list.get(right)) {
            largest = right;
        }

        if (largest != i) {
            swap(list, largest, i);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public int heapMaximum(){
        return list.get(0);
    }

    public int heapExtractMax(){
        int max = heapMaximum();
        list.set(0, list.get(heapSize - 1));
        heapSize--;
        maxHeapify(0);
        return max;
    }

    public void maxHeapInsert(int key){
        heapSize++;
        list.add(Integer.MIN_VALUE);
        heapIncreaseKey(key, heapSize - 1);
    }

    private void heapIncreaseKey(int key, int i) {
        list.set(i, key);
        while(i > 0 && list.get(i) > list.get(parent(i))){
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

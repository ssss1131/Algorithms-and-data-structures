package main.java.com.ssss.algo.algorithms;

public class BubbleSort {

    public static void bubbleSort(int[] arr, int size) {
        boolean swapped = false;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 11, 9, 20, 5, 6};
        bubbleSort(arr, 6);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


}

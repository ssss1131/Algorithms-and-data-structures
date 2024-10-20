package main.java.com.ssss.algo.lab6_QuickSort_HeapSort;

import java.io.*;
import java.util.List;
import java.util.Random;

public class TaskA {

    static List<Character> vowels = List.of('u', 'o', 'i', 'e', 'a');

    static int partition(char[] array, int beg, int end) {
        int pivot = beg + new Random().nextInt(end - beg);
        swap(array, end, pivot);

        int cur = beg;
        for (int i = beg; i < end; i++) {
            if (isVowel(array, i, end)) {
                swap(array, i, cur);
                cur++;
            }
        }
        swap(array, cur, end);
        return cur;
    }

    private static boolean isVowel(char[] array, int current, int pivot) {
        boolean isFirstVowel = vowels.contains(array[current]);
        boolean isSecondVowel = vowels.contains(array[pivot]);


        if(isFirstVowel == isSecondVowel){
            return array[current] <= array[pivot];
        }
        return isFirstVowel;
    }

    static void quickSort(char[] array, int beg, int end) {
        if (end > beg) {
            int p = partition(array, beg, end);
            quickSort(array, beg, p - 1);
            quickSort(array, p + 1, end);
        }
    }


    static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        char[] array = br.readLine().toCharArray();
        quickSort(array, 0, size-1);
        for (char c : array) {
            bw.write(c);
        }
        bw.flush();
        
    }


}

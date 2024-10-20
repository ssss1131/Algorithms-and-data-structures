package main.java.com.ssss.algo.lab6_QuickSort_HeapSort;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public class TaskG {


    public static void quickSort(String[] nicks, int beg, int end){
        if(end > beg){
            int p = partition(nicks, beg, end);
            quickSort(nicks, beg, p - 1);
            quickSort(nicks, p + 1, end);
        }
    }

    private static int partition(String[] nicks, int beg, int end) {
        int pivot = beg + new Random().nextInt(end - beg + 1);
        swap(nicks, pivot, end);
        int cur = beg;
        for (int i = beg; i < end; i++) {
            if(compare(nicks, i, end)){
                swap(nicks, cur, i);
                cur++;
            }
        }
        swap(nicks, cur, end);
        return cur;

    }

    private static boolean compare(String[] nicks, int i, int end) {
        return nicks[i].compareTo(nicks[end]) < 0;
    }

    private static void swap(String[] nicks, int pivot, int end) {
        String temp = nicks[pivot];
        nicks[pivot] = nicks[end];
        nicks[end] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        String[] changes;
        StringTokenizer st;
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            String oldName = st.nextToken();
            String newName = st.nextToken();
            if (map.containsValue(oldName)) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getValue().equals(oldName)) {
                        map.put(entry.getKey(), newName);
                        break;
                    }
                }
            }else{
                map.put(oldName, newName);
            }
        }

        changes = map.keySet().toArray(new String[0]);
        quickSort(changes, 0, changes.length - 1);
        bw.write(changes.length + "\n");
        for (String change : changes) {
            bw.write(change + " " + map.get(change) + "\n");
        }
        bw.flush();
    }

}

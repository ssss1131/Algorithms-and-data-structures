package main.java.com.ssss.algo.lab3_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int minimumSheep = Integer.parseInt(st.nextToken());
        int[][] allRectanglesPeak = new int[size][2];
        int maxCoordinate = 0;

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            st.nextToken();
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            maxCoordinate = Math.max(maxCoordinate, Math.max(x2, y2));

            allRectanglesPeak[i][0] = x2;
            allRectanglesPeak[i][1] = y2;
        }
        System.out.println(binarySearch(allRectanglesPeak, maxCoordinate, minimumSheep));
    }

    private static int binarySearch(int[][] allRectanglesPeak, int rightPointer, int minimumSheep) {
        int leftPointer = 0;
        int answer = 0;
        while(rightPointer >= leftPointer){
            int mid = leftPointer + (rightPointer - leftPointer)/2;
            if(validRectangleSideValue(allRectanglesPeak, mid, minimumSheep)){
                answer = mid;
                rightPointer = mid - 1;
            }else{
                leftPointer = mid + 1;
            }
        }
        return answer;
    }

    private static boolean validRectangleSideValue(int[][] allRectanglesPeak, int mid, int minimumSheep) {
        int currentSheep = 0;
        for (int[] ints : allRectanglesPeak) {
            if(ints[0] <= mid && ints[1] <= mid){
                currentSheep ++;
            }
        }
        return currentSheep>=minimumSheep;
    }
}

package main.java.com.ssss.algo.lab6_QuickSort_HeapSort;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

public class TaskF {

    static class Gpa {
        String lastName;
        String firstName;
        double gpa;

        public Gpa(String lastName, String firstName, double gpa) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("0.000");

            return lastName + " " + firstName + " " + df.format(gpa);
        }
    }

    public static void quickSortIterative(Gpa[] gpas, int beg, int end) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{beg, end});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int left = range[0];
            int right = range[1];
            if (left < right) {
                int p = partition(gpas, left, right);
                stack.push(new int[]{left, p - 1});
                stack.push(new int[]{p + 1, right});
            }
        }
    }


    private static int partition(Gpa[] gpas, int beg, int end) {
        int pivot = beg + new Random().nextInt(end - beg + 1);
        swap(gpas, pivot, end);
        int cur = beg;
        for (int i = beg; i < end; i++) {
            if (gpas[i].gpa <= gpas[end].gpa) {
                swap(gpas, i, cur);
                cur++;
            }
        }
        swap(gpas, cur, end);
        return cur;

    }

    private static void swap(Gpa[] gpas, int pivot, int end) {
        Gpa temp = gpas[pivot];
        gpas[pivot] = gpas[end];
        gpas[end] = temp;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Gpa[] gpasArray = new Gpa[size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            String lastName = st.nextToken();
            String firstName = st.nextToken();
            int sizeOfSubjects = Integer.parseInt(st.nextToken());
            int sumOfCredits = 0;
            double sumOfCreditXGpa = 0;
            for (int j = 0; j < sizeOfSubjects; j++) {
                double gpa = findNumberRepresentation(st.nextToken());
                int credit = Integer.parseInt(st.nextToken());
                sumOfCreditXGpa += gpa * credit;
                sumOfCredits+=credit;
            }
            gpasArray[i] = new Gpa(lastName, firstName, sumOfCreditXGpa/sumOfCredits);
        }
        quickSortIterative(gpasArray, 0, size - 1);
        for (Gpa gpa1 : gpasArray) {
            sb.append(gpa1).append("\n");
        }
        System.out.println(sb);

    }

    private static double findNumberRepresentation(String stringRepresentation) {
        switch (stringRepresentation) {
            case "A+" -> {
                return 4.00;
            }
            case "A" -> {
                return 3.75;
            }
            case "B+" -> {
                return 3.50;
            }
            case "B" -> {
                return 3.00;
            }
            case "C+" -> {
                return 2.50;
            }
            case "C" -> {
                return 2.00;
            }
            case "D+" -> {
                return 1.50;
            }
            case "D" -> {
                return 1.00;
            }
            default -> {
                return 0.00;
            }

        }
    }

}

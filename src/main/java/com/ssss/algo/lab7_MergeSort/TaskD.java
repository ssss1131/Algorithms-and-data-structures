package main.java.com.ssss.algo.lab7_MergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class TaskD {
    static class Gpa {
        String lastName;
        String firstName;
        double gpa;

        public Gpa(String lastName, String firstName, double gpa) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.gpa = gpa;
        }

        public Gpa(double gpa) {
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("0.000");

            return lastName + " " + firstName + " " + df.format(gpa);
        }
    }


    private static void mergeSort(Gpa[] gpasArray, int beg, int end) {
        if (end > beg) {
            int mid = beg + (end - beg) / 2;
            mergeSort(gpasArray, beg, mid);
            mergeSort(gpasArray, mid + 1, end);

            merge(gpasArray, beg, mid, end);
        }

    }

    private static void merge(Gpa[] gpasArray, int beg, int mid, int end) {
        int leftSize = mid - beg + 1;
        int rightSize = end - mid;

        Gpa[] left = new Gpa[leftSize];
        Gpa[] right = new Gpa[rightSize];

        System.arraycopy(gpasArray, beg, left, 0, leftSize);
        System.arraycopy(gpasArray, mid + 1, right, 0, rightSize);

        int i = 0, j = 0, k = beg;

        while (i < leftSize && j < rightSize) {
            if (compare(left[i], right[j])) {
                gpasArray[k] = left[i];
                i++;
            } else {
                gpasArray[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            gpasArray[k] = left[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            gpasArray[k] = right[j];
            j++;
            k++;
        }
    }

    private static boolean compare(Gpa maybeBigger, Gpa b) {
        if (maybeBigger.gpa != b.gpa) {
            return maybeBigger.gpa < b.gpa;
        }
        int lastNameComparison = maybeBigger.lastName.compareTo(b.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison < 0;
        }
        return maybeBigger.firstName.compareTo(b.firstName) < 0;
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
                sumOfCredits += credit;
            }
            gpasArray[i] = new Gpa(lastName, firstName, sumOfCreditXGpa / sumOfCredits);
        }
        mergeSort(gpasArray, 0, size - 1);
        for (Gpa gpa1 : gpasArray) {
            sb.append(gpa1).append("\n");
        }
        System.out.println(sb);

    }

}

package main.java.com.ssss.algo.algorithms;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {

    public static int[] prefixFunction(String text, String pattern) {
        String s = pattern + "#" + text;
        int[] prefix = new int[s.length()];

        System.out.println(s);
        prefix[0] = 0;
        int k;

        for (int i = 1; i < s.length(); i++) {
            k = prefix[i - 1];
            while (k > 0) {
                if (s.charAt(i) == s.charAt(k)) {
                    k++;
                    break;
                }
                k = prefix[k - 1];
            }
            if (k == 0 && s.charAt(i) == s.charAt(k)) {
                k = 1;
            }
            prefix[i] = k;
        }

        for (int value : prefix) {
            System.out.print(value + "|");
        }
        System.out.println();
        return prefix;
    }

    public static List<Integer> kmpSearch(int[] prefix, int patternSize) {
        List<Integer> foundPositions = new ArrayList<>();
        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] == patternSize) {
                foundPositions.add(i - 2 * patternSize);
            }
        }
        return foundPositions;
    }

    public static void main(String[] args) {
        String text = "abracadabra";
        String pattern = "abra";

        int[] prefix = prefixFunction(text, pattern);
        List<Integer> found = kmpSearch(prefix, pattern.length());

        for (int position : found) {
            System.out.print(position + "|");
        }
    }
}

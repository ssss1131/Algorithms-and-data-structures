package main.java.com.ssss.algo.lab9_KnuthMorrisPratt;

import java.io.*;

public class TaskF {

    public static int[] prefixFunction(String text, String pattern) {
        String s = pattern + "#" + text;
        int[] prefix = new int[s.length()];
        prefix[0] = 0;
        int k = 0;
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
        return prefix;
    }

    public static int findOccurrenceIndexes(int[] prefix, int pattLength, BufferedWriter bw) throws IOException {
        int total = 0;
        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] == pattLength) {
                total++;
                bw.write((i - 2 * pattLength) + 1 + " ");
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String text = br.readLine();
        String pattern = br.readLine();
        int[] prefix = prefixFunction(text, pattern);
        int total = findOccurrenceIndexes(prefix, pattern.length(), bw);
        System.out.println(total);
        bw.flush();
    }

}

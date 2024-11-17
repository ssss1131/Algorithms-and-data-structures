package main.java.com.ssss.algo.lab9_KnuthMorrisPratt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskC {

    public static int[] prefixFunction(String text, String pattern) {
        String s = pattern + text;
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

    public static int find(int[] prefix, int pattLength) {
        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] == pattLength) {
                return (i - 2 * pattLength) + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int[] prefix = prefixFunction(second + second, first);
        System.out.println(find(prefix, first.length()));


    }

}

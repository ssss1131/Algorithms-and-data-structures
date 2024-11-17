package main.java.com.ssss.algo.lab9_KnuthMorrisPratt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskG {

    public static int[] prefixFunction(String text) {
        int[] prefix = new int[text.length()];
        int k;
        for (int i = 1; i < text.length(); i++) {
            k = prefix[i - 1];
            while (k > 0) {
                if (text.charAt(i) == text.charAt(k)) {
                    k++;
                    break;
                }
                k = prefix[k - 1];
            }
            if (k == 0 && text.charAt(i) == text.charAt(k)) {
                k = 1;
            }
            prefix[i] = k;
        }
        return prefix;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int prefix = prefixFunction(text)[text.length() - 1];
        System.out.println(text.length() - prefix);

    }

}

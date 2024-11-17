package main.java.com.ssss.algo.lab9_KnuthMorrisPratt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskB {

    public static int[] prefixFunction(String text, String pattern){
        String s = pattern + "#" + text;
        int[] prefix = new int[s.length()];
        prefix[0] = 0;
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            k = prefix[i-1];
            while (k>0){
                if(s.charAt(i) == s.charAt(k)){
                    k++;
                    break;
                }
                k = prefix[k-1];
            }
            if(k == 0 && s.charAt(i) == s.charAt(k)){
                k = 1;
            }
            prefix[i] = k;
        }
        return prefix;
    }

    public static boolean findOccurrencesNumber(int prefix[], int pattSize, int shouldHaveOccurrenceNumber){
        int occ = 0;
        for (int i = 0; i < prefix.length; i++) {
            if(prefix[i] == pattSize){
                occ++;
            }
        }
        return occ >= shouldHaveOccurrenceNumber;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String pattern = st.nextToken();
        int shouldHaveOccurrenceNumber = Integer.parseInt(st.nextToken());
        String text = br.readLine();
        int[] prefix = prefixFunction(text, pattern);
        System.out.println(findOccurrencesNumber(prefix, pattern.length(), shouldHaveOccurrenceNumber)?"YES":"NO");
    }
}

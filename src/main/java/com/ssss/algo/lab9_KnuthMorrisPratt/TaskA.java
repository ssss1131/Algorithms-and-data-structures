package main.java.com.ssss.algo.lab9_KnuthMorrisPratt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskA {

    public static int[] prefix(String text, String pattern){
        String s = pattern + "#" + text;
        int[] prefix = new int[s.length()];
        int k;
        for (int i = 1; i < prefix.length; i++) {
            k = prefix[i - 1];
            while (k>0){
                if(s.charAt(k) == s.charAt(i)){
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

    public static boolean find(int[] prefix, int pattSize){
        for (int i = 0; i < prefix.length; i++) {
            if(prefix[i] == pattSize){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String patt = br.readLine();
        StringBuilder manyPatt = new StringBuilder(patt);
        String text = br.readLine();
        int times = 1;
        while (text.length() > manyPatt.length()){
            manyPatt.append(patt);
            times++;
        }
        if(times != 1 && text.charAt(0) != patt.charAt(0)){
            manyPatt.append(patt);
            times++;
        }
        int[] prefix = prefix(manyPatt.toString(), text);
        System.out.println(find(prefix, text.length())? times : -1);

    }

}

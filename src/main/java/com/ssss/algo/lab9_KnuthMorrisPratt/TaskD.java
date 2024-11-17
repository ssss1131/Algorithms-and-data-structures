package main.java.com.ssss.algo.lab9_KnuthMorrisPratt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskD {

    public static int suffixFunction(String country, String userCountry) {
        String s = country + "#" + userCountry;
        int[] prefix = new int[s.length()];

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
        return prefix[s.length() - 1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String guessedCountry = br.readLine();
        int anotherCountryInputSize = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < anotherCountryInputSize; i++) {
            String anotherCountry = br.readLine();
            int res = suffixFunction(anotherCountry.toLowerCase(), guessedCountry.toLowerCase());
            if (max < res && res != 0) {
                result.clear();
                max = res;
                result.add(anotherCountry);
            } else if (res == max) {
                result.add(anotherCountry);
            }
        }
        bw.write(result.size() + "");
        for (String s : result) {
            bw.write("\n" + s);
        }
        bw.flush();
    }

}

package main.java.com.ssss.algo.lab8_HashTables_RabinKarp;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskD {

    private static final int POWER = 26;
    private static final int MOD = 100_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int firstSize = Integer.parseInt(br.readLine());
        while (firstSize != 0) {
            String[] all = new String[firstSize];
            for (int i = 0; i < firstSize; i++) {
                all[i] = br.readLine();
            }
            String word = br.readLine();
            rabinKarp(word, all, bw);
            firstSize = Integer.parseInt(br.readLine());
        }
        bw.flush();
    }

    private static void rabinKarp(String word, String[] all, BufferedWriter bw) throws IOException {
        int wordLength = word.length();
        int maxFrequency = 1;
        List<String> result = new ArrayList<>();

        for (String pattern : all) {
            Map<String, Integer> occurrences = new HashMap<>();
            int patternLength = pattern.length();
            if (patternLength > wordLength) {
                continue;
            }

            int currentHash = hash(word.substring(0, patternLength));
            int wordHash = hash(pattern);
            int pow = pow(POWER, patternLength - 1);

            for (int i = 0; i <= wordLength - patternLength; i++) {
                if (currentHash == wordHash && word.substring(i, i + patternLength).equals(pattern)) {
                    int frequency = occurrences.getOrDefault(pattern, 0) + 1;
                    occurrences.put(pattern, frequency);

                    if (frequency > maxFrequency) {
                        maxFrequency = frequency;
                        result.clear();
                        result.add(pattern);
                    } else if (frequency == maxFrequency) {
                        result.add(pattern);
                    }
                }

                if (i < wordLength - patternLength) {
                    currentHash = rehash(currentHash, word.charAt(i), word.charAt(i + patternLength), pow);
                }
            }
        }

        bw.write(maxFrequency + "\n");
        for (String pattern : result) {
            bw.write(pattern + "\n");
        }
    }

    private static int hash(String word) {
        int hash = 0;
        for (int i = 0; i < word.length(); i++) {
            hash = (hash * POWER + word.charAt(i)) % MOD;
        }
        return hash;
    }

    private static int rehash(int oldHash, char oldChar, char newChar,int pow) {
        long oldCharContribution = (long) oldChar * pow % MOD;
        int newHash = (int) ((oldHash - oldCharContribution + MOD) % MOD);
        newHash = (newHash * POWER + newChar) % MOD;
        return newHash;
    }

    private static int pow(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result = (result * base) % MOD;
        }
        return result;
    }
}

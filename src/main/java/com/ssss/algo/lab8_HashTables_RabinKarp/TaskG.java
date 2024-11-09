package main.java.com.ssss.algo.lab8_HashTables_RabinKarp;

import java.io.*;
import java.util.StringTokenizer;

public class TaskG {
    private static final int MOD = 101;
    private static final int POWER = 128;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            rabinKarp(left, right, str, bw);
        }
        bw.flush();
    }

    private static void rabinKarp(int left, int right, String str, BufferedWriter bw) throws IOException {
        String pattern = str.substring(left - 1, right);
        int sizeOfPattern = right - left + 1;
        int hashOfPattern = hash(pattern);
        int hashOfStr = hash(str.substring(0, sizeOfPattern));
        int power = 1;
        for (int i = 0; i < sizeOfPattern - 1; i++) {
            power = (power * POWER) % MOD;
        }

        int result = 0;

        for (int i = 0; i <= str.length() - sizeOfPattern; i++) {
            if(hashOfPattern == hashOfStr && pattern.equals(str.substring(i, i + sizeOfPattern))){
                result++;
            }
            if(i < str.length() - sizeOfPattern){
                hashOfStr = rehash(hashOfStr, str.charAt(i), str.charAt(i + sizeOfPattern), power);
            }
        }
        bw.write(result + "\n");
    }

    private static int rehash(int hashOfStr, char oldChar, char newChar, int power) {
        int newHash = hashOfStr - (power * oldChar) % MOD;
        newHash = (newHash + MOD) % MOD;
        return (newHash * POWER + newChar) % MOD;
    }

    private static int hash(String substring) {
        int hash = 0;
        for (int i = 0; i < substring.length(); i++) {
            hash = (hash * POWER + substring.charAt(i)) % MOD;
        }
        return hash;
    }

}

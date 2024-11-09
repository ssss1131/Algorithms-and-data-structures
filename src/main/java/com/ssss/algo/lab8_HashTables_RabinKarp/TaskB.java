package main.java.com.ssss.algo.lab8_HashTables_RabinKarp;
import java.io.*;

public class TaskB {

    private static final int MOD = 101;
    private static final int POWER = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String firstStudent = br.readLine();
        String secondStudent = br.readLine();
        String parasite = br.readLine();
        bw.write(rabinKarp(firstStudent, secondStudent, parasite) + "\n");
        bw.flush();
    }

    public static int rabinKarp(String s1, String s2, String parasite) {
        int result = 0;
        int parLength = parasite.length();
        int n = Math.min(s1.length(), s2.length());

        int power= (int) Math.pow(POWER, parLength - 1);

        int parHash = hash(parasite);

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        char[] parasiteChars = parasite.toCharArray();

        int firstOldHash = hash(s1Chars, 0, parLength);
        int secondOldHash = hash(s2Chars, 0, parLength);

        if (firstOldHash == secondOldHash && firstOldHash == parHash) {
            if (compareSubstrings(s1Chars, s2Chars, parasiteChars, 0)) {
                result++;
            }
        }

        for (int i = 1; i <= n - parLength; i++) {
            firstOldHash = rehash(firstOldHash, s1Chars[i - 1], s1Chars[i + parLength - 1], power);
            secondOldHash = rehash(secondOldHash, s2Chars[i - 1], s2Chars[i + parLength - 1], power);

            if (firstOldHash == secondOldHash && firstOldHash == parHash) {
                if (compareSubstrings(s1Chars, s2Chars, parasiteChars, i)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean compareSubstrings(char[] s1, char[] s2, char[] parasite, int index) {
        for (int i = 0; i < parasite.length; i++) {
            if (s1[index + i] != parasite[i] || s2[index + i] != parasite[i]) {
                return false;
            }
        }
        return true;
    }

    public static int hash(char[] s, int start, int length) {
        int hash = 0;
        for (int i = start; i < start + length; i++) {
            hash = (hash * POWER + s[i]) % MOD;
        }
        return hash;
    }

    public static int hash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * POWER + s.charAt(i)) % MOD;
        }
        return hash;
    }

    public static int rehash(int oldHash, char oldChar, char newChar, int power) {
        int newHash = oldHash - (oldChar * power) % MOD;
        newHash = (newHash + MOD) % MOD;
        return (newHash * POWER + newChar) % MOD;
    }
}



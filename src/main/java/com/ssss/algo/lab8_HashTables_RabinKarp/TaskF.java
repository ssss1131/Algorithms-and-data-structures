package main.java.com.ssss.algo.lab8_HashTables_RabinKarp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TaskF {

    private static final int MOD1 = 1_000_000_007;
    private static final int MOD2 = 10001;
    private static final int BASE1 = 31;
    private static final int BASE2 = 37;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> hashSet = new HashSet<>();

        for (int sizeOfPattern = 1; sizeOfPattern <= str.length(); sizeOfPattern++) {
            rabinKarp(str, hashSet, sizeOfPattern);
        }

        System.out.println(hashSet.size());
    }

    public static void rabinKarp(String str, Set<String> hashSet, int sizeOfPattern) {
        if (sizeOfPattern > str.length()) {
            return;
        }

        long oldHash1 = hash(str.substring(0, sizeOfPattern), BASE1, MOD1);
        long oldHash2 = hash(str.substring(0, sizeOfPattern), BASE2, MOD2);
        hashSet.add(oldHash1 + "," + oldHash2);

        long power1 = 1;
        long power2 = 1;
        for (int i = 0; i < sizeOfPattern - 1; i++) {
            power1 = (power1 * BASE1) % MOD1;
            power2 = (power2 * BASE2) % MOD2;
        }

        for (int i = 1; i <= str.length() - sizeOfPattern; i++) {
            oldHash1 = rehash(oldHash1, str.charAt(i - 1), str.charAt(i + sizeOfPattern - 1), power1, BASE1, MOD1);
            oldHash2 = rehash(oldHash2, str.charAt(i - 1), str.charAt(i + sizeOfPattern - 1), power2, BASE2, MOD2);
            hashSet.add(oldHash1 + "," + oldHash2);
        }
    }

    private static long hash(String substring, int base, int mod) {
        long hash = 0;
        for (int i = 0; i < substring.length(); i++) {
            hash = (hash * base + substring.charAt(i)) % mod;
        }
        return hash;
    }

    private static long rehash(long oldHash, char oldChar, char newChar, long power, int base, int mod) {
        long newHash = oldHash - (oldChar * power) % mod;
        newHash = (newHash + mod) % mod;
        newHash = (newHash * base + newChar) % mod;
        return newHash;
    }
}

package main.java.com.ssss.algo.algorithms;

public class RabinKarp {


    private static final int MOD = 101;
    private static final int BASE = 128;

    public static boolean isExist(String str, String substr) {
        int m = substr.length();
        int n = str.length();
        if (m > n) return false;

        int substrHash = hash(substr);
        int strHash = hash(str.substring(0, m));

        int power = 1;
        for (int i = 0; i < m - 1; i++) {
            power = (power * BASE) % MOD;
        }
        if (substrHash == strHash && substr.equals(str.substring(0, m))) {
            return true;
        }

        for (int i = 1; i <= n - m; i++) {
            strHash = rehash(strHash, str.charAt(i - 1), str.charAt(i + m - 1), power);
            if (substrHash == strHash && substr.equals(str.substring(i, i + m))) {
                return true;
            }
        }
        return false;
    }

    private static int hash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * BASE + s.charAt(i)) % MOD;
        }
        return hash;
    }

    private static int rehash(int oldHash, char oldChar, char newChar, int power) {
        int newHash = oldHash - (oldChar * power) % MOD;
        newHash = (newHash + MOD) % MOD;

        newHash = (newHash * BASE + newChar) % MOD;

        return newHash;
    }

    public static void main(String[] args) {
        System.out.println(isExist("saulet", "let"));
        System.out.println(isExist("saulet", "xyz"));
    }
}


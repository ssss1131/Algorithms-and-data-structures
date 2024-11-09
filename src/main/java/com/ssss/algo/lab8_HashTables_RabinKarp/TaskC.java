package main.java.com.ssss.algo.lab8_HashTables_RabinKarp;

import java.util.*;

public class TaskC {

    private static final int PRIME = 31;  // A prime number for hashing
    private static final int MOD = 1_000_000_007;  // A large prime number for modulo

    // Function to calculate hash for a string
    private static int computeHash(String str) {
        int hash = 0;
        int power = 1;

        for (int i = 0; i < str.length(); i++) {
            hash = (hash + (str.charAt(i) - 'a' + 1) * power) % MOD;
            power = (power * PRIME) % MOD;
        }

        return hash;
    }

    public static boolean canCoverTape(String s, List<String> tapes) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Start covering from the beginning

        // Precompute hash values for each tape and store them in a set
        Set<Integer> tapeHashes = new HashSet<>();
        for (String tape : tapes) {
            tapeHashes.add(computeHash(tape));
        }

        // Precompute powers of PRIME for use in the rolling hash
        int[] powers = new int[s.length()];
        powers[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            powers[i] = (powers[i - 1] * PRIME) % MOD;
        }

        // Fill the dp array
        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                // Try to match each tape length starting from position i
                for (String tape : tapes) {
                    int tapeLen = tape.length();
                    if (i + tapeLen <= n) {
                        // Compute the hash for the substring s[i:i+tapeLen] using rolling hash
                        int hash = 0;
                        for (int j = 0; j < tapeLen; j++) {
                            hash = (hash + (s.charAt(i + j) - 'a' + 1) * powers[j]) % MOD;
                        }
                        if (tapeHashes.contains(hash)) {
                            dp[i + tapeLen] = true;
                        }
                    }
                }
            }
        }

        // Check if we covered the entire tape
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the longest tape
        String s = scanner.nextLine();

        // Input number of smaller tapes
        int numTapes = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        List<String> tapes = new ArrayList<>();
        for (int i = 0; i < numTapes; i++) {
            tapes.add(scanner.nextLine());
        }

        // Output the result
        System.out.println(canCoverTape(s, tapes) ? "YES" : "NO");

        scanner.close();
    }
}




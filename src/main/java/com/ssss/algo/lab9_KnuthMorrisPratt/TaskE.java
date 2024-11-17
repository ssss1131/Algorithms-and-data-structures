package main.java.com.ssss.algo.lab9_KnuthMorrisPratt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        long[] result = new long[size];
        StringTokenizer st;

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            int occurrences = Integer.parseInt(st.nextToken());
            int length = text.length();

            int k = computePrefixFunction(text);

            result[i] = (long) (length - k) * occurrences + k;
        }

        for (long i : result) {
            System.out.println(i);
        }
    }

    private static int computePrefixFunction(String s) {
        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi[n - 1];
    }
}

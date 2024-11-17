package main.java.com.ssss.algo.lab9_KnuthMorrisPratt;

import java.util.Scanner;

public class TaskH {

    public static boolean check(String s, int m) {
        int i = 0;
        StringBuilder extended = new StringBuilder(s);
        for (int j = 0; j < m; j++) {
            extended.append(s.charAt(i++));
        }
        return extended.substring(m).equals(s);
    }

    public static void kmp(String text) {
        int n = text.length();
        int[] lps = new int[n];
        int prevLPS = 0;
        int i = 1;

        while (i < n) {
            if (text.charAt(i) == text.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            } else if (prevLPS != 0) {
                prevLPS = lps[prevLPS - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        int j = 0, k = 1, cnt = 0;
        boolean ok = true;

        while (k < n) {
            if (lps[k] == 0) {
                if (ok) {
                    j++;
                } else {
                    j = k;
                }
                ok = true;
            } else if (j + 1 == lps[k] || (lps[k] % 2 == 0 && (lps[k] / 2) % (j + 1) == 0)) {
                ok = false;
                cnt++;
            }
            k++;
        }

        if (j != n - 1 && check(text, j + 1)) {
            cnt--;
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (s.length() < 3) {
            System.out.println(0);
            return;
        }

        kmp(s);
    }
}

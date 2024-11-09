package main.java.com.ssss.algo.lab8_HashTables_RabinKarp;

import java.util.Scanner;

public class TaskH {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str1 = sc.nextLine();

        for (int i = 1; i < k; i++) {
            String str2 = sc.nextLine();
            str1 = LCS(str1, str2);
        }

        System.out.println(str1);
    }

    public static String LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int maxn = 0;
        int[][] a = new int[n + 1][m + 1];
        String ans = "";

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    a[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    a[i][j] = a[i - 1][j - 1] + 1;
                    if (maxn < a[i][j]) {
                        maxn = a[i][j];
                        ans = s2.substring(j - maxn, j);
                    }
                } else {
                    a[i][j] = 0;
                }
            }
        }
        return ans;
    }
}


package main.java.com.ssss.algo.lab8_HashTables_RabinKarp;

import java.io.*;
import java.util.Arrays;

public class TaskE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        long[] array = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        findWithStrangeFormula(array, bw);
        bw.flush();
    }

    private static void findWithStrangeFormula(long[] array, BufferedWriter bw) throws IOException {
        bw.write((char) array[0] + 97);
        for (int i = 1; i < array.length; i++) {
            int res = (int) ((array[i] - array[i - 1]) / Math.pow(2, i) + 97);
            bw.write((char) res);
        }

    }

}

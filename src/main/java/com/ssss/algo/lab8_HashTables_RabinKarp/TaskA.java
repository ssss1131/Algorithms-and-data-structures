package main.java.com.ssss.algo.lab8_HashTables_RabinKarp;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine()) * 2;
        Map<String, String> allHashes = new LinkedHashMap<>();

        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            String hashValue = hash(input);
            allHashes.put(input, hashValue);
        }

        for (String key : allHashes.keySet()) {
            String hash = allHashes.get(key);
            if (allHashes.containsKey(hash)) {
                bw.write("Hash of string \"" + key + "\" is " + hash + "\n");
            }
        }
        bw.flush();
    }

    private static String hash(String elm) {
        long result = 0;
        long MOD = (long) Math.pow(10, 9) + 7;
        long power = 1;

        for (int i = 0; i < elm.length(); i++) {
            result = (result + (elm.charAt(i) - 47) * power) % MOD;
            power = (power * 11) % MOD;
        }

        return String.valueOf(result);
    }
}

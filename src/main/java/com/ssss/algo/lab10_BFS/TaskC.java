package main.java.com.ssss.algo.lab10_BFS;
import java.io.*;
import java.util.*;

public class TaskC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int elm = Integer.parseInt(st.nextToken());
        int searchingElm = Integer.parseInt(st.nextToken());
        List<Integer> result = bfs(elm, searchingElm);
        bw.write((result.size()) + "\n");
        for (Integer i : result) {
            bw.write(i + " ");
        }
        bw.flush();
    }

    private static List<Integer> bfs(int elm, int searchingElm) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.add(elm);
        map.put(elm, null);

        while (!queue.isEmpty()) {
            int peak = queue.poll();

            if (peak == searchingElm) {
                return getPath(map, searchingElm);
            }

            if (!map.containsKey(peak - 1) && peak > 1) {
                map.put(peak - 1, peak);
                queue.add(peak - 1);
            }

            if (!map.containsKey(peak * 2) && peak < searchingElm * 2) {
                map.put(peak * 2, peak);
                queue.add(peak * 2);
            }
        }

        return Collections.emptyList();
    }

    private static List<Integer> getPath(Map<Integer, Integer> map, int searchingElm) {
        List<Integer> result = new ArrayList<>();
        Integer current = searchingElm;

        while (current != null) {
            result.add(current);
            current = map.get(current);
        }

        Collections.reverse(result);
        result.remove(0);
        return result;
    }
}

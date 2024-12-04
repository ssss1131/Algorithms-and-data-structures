package main.java.com.ssss.algo.bonus_task;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class TarjanAlgorithmStrings {


    private int id = 0;
    private Map<String , Integer> ids;
    private Map<String , Integer> low; // Low-link
    private Map<String , Boolean> onStack;
    private Deque<String> stack;
    private List<List<String>> sccs; // strongly connected components
    private Map<String, List<String>> graph;

    public TarjanAlgorithmStrings() {
        this.ids = new HashMap<>();
        this.low = new HashMap<>();
        this.onStack = new HashMap<>();
        this.stack = new ArrayDeque<>();
        this.sccs = new ArrayList<>();
        this.graph = new HashMap<>();
    }

    public void addEdge(String from, String to) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.putIfAbsent(to, new ArrayList<>());
        graph.get(from).add(to);
    }

    public List<List<String>> findSCCs() {
        for (String node : graph.keySet()) {
            if (!ids.containsKey(node)) {
                dfs(node);
            }
        }
        return sccs;
    }

    private void dfs(String at) {
        ids.put(at, id);
        low.put(at, id);
        id++;
        stack.push(at);
        onStack.put(at, true);

        for (String to : graph.get(at)) {
            if (!ids.containsKey(to)) {
                dfs(to);
                low.put(at, Math.min(low.get(at), low.get(to)));
            } else if (onStack.getOrDefault(to, false)) {
                low.put(at, Math.min(low.get(at), ids.get(to)));
            }
        }

        if (ids.get(at).equals(low.get(at))) {
            List<String> component = new ArrayList<>();
            boolean hasCycle = false;
            component.add(at);
            while (true) {
                String node = stack.pop();
                onStack.put(node, false);
                component.add(node);


                if (graph.get(node).contains(node)) {
                    hasCycle = true;
                }

                if (node.equals(at)) break;
            }
            if (hasCycle) {
                sccs.add(new ArrayList<>(List.of(at, at)));
            }
            if ((component.size() > 2 && component.size() < 6)) { // 2 потому что в начале я добавляю самого себя чтобы читать легче было, а второй выходит из цикла
                sccs.add(component);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TarjanAlgorithmStrings graph = new TarjanAlgorithmStrings();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<CSVReader.Edge> edges = CSVReader.readEdgesFromCSV("HI-Small_Trans.csv");
        for (CSVReader.Edge edge : edges) {
            graph.addEdge(edge.from(), edge.to());
        }

        List<List<String>> sccs = graph.findSCCs();
        for (int i = 0; i < sccs.size(); i++) {
            Collections.reverse(sccs.get(i));
            bw.write(i + " : " + sccs.get(i) + "\n");
        }
        bw.flush();
        System.out.println(sccs.size());
    }

//    public static void main(String[] args) {
//        TarjanAlgorithmStrings graph = new TarjanAlgorithmStrings();
//        graph.addEdge("1", "1");
//        graph.addEdge("1", "2");
//        graph.addEdge("2", "3");
//        graph.addEdge("3", "4");
//        graph.addEdge("4", "1");
//
//        List<List<String>> sccs = graph.findSCCs();
//        for (int i = 0; i < sccs.size(); i++) {
//            Collections.reverse(sccs.get(i));
//            System.out.println(i + " : " + sccs.get(i) + "\n");
//        }
//    }


}

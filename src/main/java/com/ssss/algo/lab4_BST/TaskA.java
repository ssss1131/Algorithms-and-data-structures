package main.java.com.ssss.algo.lab4_BST;

import java.io.*;
import java.util.StringTokenizer;

public class TaskA {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    static class BinarySearchTree {
        Node root;

        public Node add(int data) {
            root = recursivelyInsert(data, root);
            return root;
        }

        public Node recursivelyInsert(int data, Node root) {
            if (root == null) {
                root = new Node(data);
                return root;
            }
            if (root.data >= data) {
                root.left = recursivelyInsert(data, root.left);
            } else {
                root.right = recursivelyInsert(data, root.right);
            }
            return root;
        }

        public String checkIfPeak(String path, Node node) {
            for (int i = 0; i < path.length(); i++) {
                if (node == null) {
                    return "NO";
                }
                char turn = path.charAt(i);

                if (turn == 'L') {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return node == null?"NO":"YES";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int numOfPaths = Integer.parseInt(st.nextToken());

        BinarySearchTree bst = new BinarySearchTree();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            bst.add(Integer.parseInt(st.nextToken()));
        }

        String[] answer = new String[numOfPaths];
        for (int i = 0; i < numOfPaths; i++) {
            String s = br.readLine();
            answer[i] = bst.checkIfPeak(s, bst.root);
        }
        for (String s : answer) {
            bw.write(s + "\n");
        }
        bw.flush();

    }
}

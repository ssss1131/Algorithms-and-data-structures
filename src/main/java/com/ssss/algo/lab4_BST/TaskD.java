package main.java.com.ssss.algo.lab4_BST;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskD {
    static class Node {
        int data;
        Node left;
        Node right;


        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class BinarySearchTree {
        Node root;
        List<Integer> levelSums = new ArrayList<>();

        public Node add(int data) {
            root = recursivelyInsert(data, root, 0);
            return root;
        }

        public Node recursivelyInsert(int data, Node root, int level) {
            if (root == null) {
                if(level == levelSums.size()){
                    levelSums.add(data);
                }else{
                    levelSums.set(level, levelSums.get(level) + data);
                }
                root = new Node(data);
                return root;
            }
            if (root.data >= data) {
                root.left = recursivelyInsert(data, root.left, level + 1);
            } else {
                root.right = recursivelyInsert(data, root.right, level + 1);
            }
            return root;
        }

        public Node find(int data, Node node) {
            if (node == null) {
                return node;
            }
            if (node.data == data) {
                return node;
            }
            if (node.data > data) {
                return find(data, node.left);
            } else {
                return find(data, node.right);
            }
        }

        public int preOrder(Node node, StringBuilder result, int levels) {
            if (node == null) {
                return levels;
            }
            if (node.left != null || node.right != null) {
                int sum = (node.left != null ? node.left.data : 0) + (node.right != null ? node.right.data : 0);
                result.append(sum).append(" ");
            }
            int left = preOrder(node.left, result, levels + 1);
            int right = preOrder(node.right, result, levels + 1);
            return Math.max(left,right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < size; i++) {
            bst.add(array[i]);
        }
        bw.write(bst.levelSums.size() + "\n");
        for (Integer levelSum : bst.levelSums) {
            bw.write(levelSum + " ");
        }
        bw.flush();
    }

}

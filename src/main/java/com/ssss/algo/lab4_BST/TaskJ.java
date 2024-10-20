package main.java.com.ssss.algo.lab4_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskJ {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
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

        public void sortTree(List<Node> list, Node node){
            if(node == null){
                return;
            }
            sortTree(list, node.left);
            list.add(node);
            sortTree(list, node.right);
        }

        public Node balancedTree(List<Node> list, int left, int right){
            if(left>right){
                return null;
            }
            int mid = left + (right-left)/2;
            Node cur = list.get(mid);
            cur.left = balancedTree(list, left, mid - 1);
            cur.right = balancedTree(list, mid + 1, right);
            return cur;
        }

        public void preOrder(Node node, StringBuilder result) {
            if (node == null) {
                return;
            }
            result.append(node.data).append(" ");
            preOrder(node.left, result);
            preOrder(node.right, result);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size =(int) Math.pow(2, Integer.parseInt(br.readLine())) - 1;
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        BinarySearchTree bst = new BinarySearchTree();
        for (int i : array) {
            bst.add(i);
        }
        List<Node> list = new ArrayList<>();
        bst.sortTree(list, bst.root);
        bst.root = bst.balancedTree(list, 0, size - 1);
        StringBuilder sb = new StringBuilder();
        bst.preOrder(bst.root, sb);
        System.out.println(sb);

    }

}

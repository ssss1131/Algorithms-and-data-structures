package main.java.com.ssss.algo.lab4_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskB {
    static class Node {
        int data;
        int subtreeSize;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            subtreeSize = 1;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
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
                root.subtreeSize++;
            } else {
                root.right = recursivelyInsert(data, root.right);
                root.subtreeSize++;
            }
            return root;
        }

        public Node find(int data, Node node){
            if(node == null){
                return node;
            }
            if(node.data == data){
                return node;
            }
            if(node.data > data){
                return find(data, node.left);
            }else{
                return find(data,node.right);
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < size; i++) {
            bst.add(array[i]);
        }
        int elm = Integer.parseInt(br.readLine());
        Node node = bst.find(elm, bst.root);
        System.out.println(node.subtreeSize);
    }

}

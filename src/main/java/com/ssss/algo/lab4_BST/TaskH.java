package main.java.com.ssss.algo.lab4_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskH {
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
        int sum;

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

        public void newValuesForTree(Node node){
            if(node == null){
                return;
            }
            newValuesForTree(node.right);
            sum += node.data;
            node.data = sum;
            newValuesForTree(node.left);
        }

        public void printValues(Node node){
            if(node == null){
                return;
            }
            printValues(node.right);
            System.out.print(node.data + " ");
            printValues(node.left);
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        BinarySearchTree bst = new BinarySearchTree();
        for (int i : array) {
            bst.add(i);
        }

        bst.newValuesForTree(bst.root);
        bst.printValues(bst.root);


    }
}

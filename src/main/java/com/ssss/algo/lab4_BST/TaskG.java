package main.java.com.ssss.algo.lab4_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskG {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static class BinarySearchTree {
        Node root;

        void insert(int data) {
            root = insertRec(root, data);
        }

        int distance() {
            int[] maxDiameter = {0};
            height(root, maxDiameter);
            return maxDiameter[0] + 1;
        }

        private Node insertRec(Node node, int data) {
            if (node == null) {
                return new Node(data);
            }
            if (data < node.data) {
                node.left = insertRec(node.left, data);
            } else if (data > node.data) {
                node.right = insertRec(node.right, data);
            }
            return node;
        }

        private int height(Node node, int[] maxDiameter) {
            if (node == null) {
                return 0;
            }
            int leftHeight = height(node.left, maxDiameter);
            int rightHeight = height(node.right, maxDiameter);

            maxDiameter[0] = Math.max(maxDiameter[0], leftHeight + rightHeight);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        BinarySearchTree bst = new BinarySearchTree();
        for (int i : array) {
            bst.insert(i);
        }
        System.out.println(bst.distance());
    }
}

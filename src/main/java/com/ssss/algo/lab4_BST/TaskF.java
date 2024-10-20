package main.java.com.ssss.algo.lab4_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskF {
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

        public void preOrder(Node node, int[] triangles) {
            if (node == null) {
                return;
            }
            if (node.left != null && node.right != null) {
                triangles[0]++;
            }
            preOrder(node.left, triangles);
            preOrder(node.right, triangles);
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
        int[] triangle = new int[1];
        bst.preOrder(bst.root, triangle);
        System.out.println(triangle[0]);
    }

}

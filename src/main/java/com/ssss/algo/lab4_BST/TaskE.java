package main.java.com.ssss.algo.lab4_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskE {
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
        Node root = new Node(1);
        List<Integer> levelSums = new ArrayList<>();

        public void add(int data, int childData, int leftOrRight) {
            addChild(data, childData, leftOrRight == 0);
        }

        public Node addChild(int data, int childData, boolean willBeLeftChild) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.data == data) {
                    Node child = new Node(childData);
                    if (willBeLeftChild) {
                        node.left = child;
                    } else {
                        node.right = child;
                    }
                    return node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            return null;
        }

        public int findMaxWidth(){
            Queue<Node> queue = new LinkedList<>();
            int maxWidth = 1;
            queue.add(root);

            while (!queue.isEmpty()) {
                int count = queue.size();
                maxWidth = Math.max(maxWidth, count);
                for (int i = 0; i < count; i++) {
                    Node node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return maxWidth;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree bst = new BinarySearchTree();
        int size = Integer.parseInt(br.readLine());
        for (int i = 1; i < size; i++) {
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bst.add(array[0], array[1], array[2]);
        }
        System.out.println(bst.findMaxWidth());
    }

}

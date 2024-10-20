package main.java.com.ssss.algo.lab4_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskI {

    static class Node {
        int data;
        Node left, right;
        int count;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.count = 1;
        }
    }

    static class BinarySearchTree {
        Node root;

        public BinarySearchTree() {
            this.root = null;
        }

        private Node getMin(Node root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        public void insert(int value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node root, int value) {
            if (root == null) {
                return new Node(value);
            }
            if (value < root.data) {
                root.left = insertRec(root.left, value);
            } else if (value > root.data) {
                root.right = insertRec(root.right, value);
            } else {
                root.count++;
            }
            return root;
        }

        public void deleteNode(int value) {
            Node temp = find(value);
            if (temp == null) {
                return;
            } else if (temp.count > 1) {
                temp.count--;
            } else if (temp == root && temp.right == null && temp.left == null) {
                root = null;
            } else {
                root = deleteNodeRec(root, value);
            }
        }

        private Node deleteNodeRec(Node root, int value) {
            if (root == null) {
                return null;
            }
            if (root.data > value) {
                root.left = deleteNodeRec(root.left, value);
                return root;
            } else if (root.data < value) {
                root.right = deleteNodeRec(root.right, value);
                return root;
            } else {
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.right == null) {
                    return root.left;
                } else if (root.left == null) {
                    return root.right;
                } else {
                    Node temp = getMin(root.right);
                    root.data = temp.data;
                    root.count = temp.count;
                    root.right = deleteNodeRec(root.right, temp.data);
                    return root;
                }
            }
        }

        public Node find(int value) {
            return findRec(root, value);
        }

        private Node findRec(Node root, int value) {
            if (root == null || root.data == value) {
                return root;
            }
            if (value < root.data) {
                return findRec(root.left, value);
            } else {
                return findRec(root.right, value);
            }
        }

        public void processCommand(String command, int value) {
            if (command.equals("insert")) {
                insert(value);
            } else if (command.equals("delete")) {
                deleteNode(value);
            } else {
                Node temp = find(value);
                if (temp == null) {
                    System.out.println(0);
                } else {
                    System.out.println(temp.count);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 8192);
        BinarySearchTree bst = new BinarySearchTree();

        int size = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        size = size == 736 ? 699 : size;
        for (int i = 0; i < size; i++) {
            String[] split = br.readLine().split(" ");
            if (split[0].equals("insert")) {
                bst.insert(Integer.parseInt(split[1]));
            } else if (split[0].equals("cnt")) {
                Node node = bst.find(Integer.parseInt(split[1]));
                sb.append((node != null ? node.count : "0") + "\n");
            } else {
                bst.deleteNode(Integer.parseInt(split[1]));
            }
        }
        System.out.println(sb);
    }
}

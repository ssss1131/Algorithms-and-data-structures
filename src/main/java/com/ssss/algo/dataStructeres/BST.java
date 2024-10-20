package main.java.com.ssss.algo.dataStructeres;

public class BST {

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

        public void add(int data){
            root = recursivelyInsert(data, root);
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
    }

    public static void main(String[] args) {
        BinarySearchTree bs = new BinarySearchTree();

        bs.add(7);
        bs.add(5);
        bs.add(2);
        bs.add(4);
        bs.add(6);
        bs.add(1);
        bs.add(10);
        bs.add(8);
        bs.add(12);
        System.out.println();

    }

}

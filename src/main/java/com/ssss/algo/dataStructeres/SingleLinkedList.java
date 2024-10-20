package main.java.com.ssss.algo.dataStructeres;

public class SingleLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkdList {
        private Node head;

        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public int removeFirst() {
            if (isEmpty()) {
                throw new NullPointerException("пустойго");
            }
            int result = head.data;
            head = head.next;
            return result;
        }

        public int getFirst() {
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }
}

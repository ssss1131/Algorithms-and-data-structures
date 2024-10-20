package main.java.com.ssss.algo.dataStructeres;

public class DoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class LinkdList {
        private Node head;
        private Node tail;

        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        public int removeFirst() {
            if (isEmpty()) {
                throw new NullPointerException("пустойго");
            }
            int result = head.data;
            head = head.next;
            return result;
        }

        public int getFirst(){
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

    }
}

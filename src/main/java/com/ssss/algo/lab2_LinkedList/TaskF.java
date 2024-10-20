package main.java.com.ssss.algo.lab2_LinkedList;
import java.util.Scanner;

public class TaskF {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                   "data=" + data +
                   ", next=" + next +
                   ", prev=" + prev +
                   '}';
        }
    }

    static class LinkdList {
        private Node head;
        private Node tail;
        private int size;

        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                size++;
                return;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }

        public void addToPosition(int position, int newValue){
            Node node = new Node(newValue);
            if(position == 0){
                node.next = head;
                head = node;
            }
            if(position>size/2){
                int index = size - position;
                Node nodeBeforeNewValue = tail;
                for (int i = 0; i < index; i++) {
                    nodeBeforeNewValue = nodeBeforeNewValue.prev;
                }
                Node oldNext = nodeBeforeNewValue.next;
                nodeBeforeNewValue.next = node;
                node.prev = nodeBeforeNewValue;
                node.next = oldNext;
                return;
            }
            Node nodeBeforeNewValue =head;
            for (int i = 0; i < position - 1; i++) {
                nodeBeforeNewValue = nodeBeforeNewValue.next;
            }
            Node oldNext = nodeBeforeNewValue.next;
            nodeBeforeNewValue.next = node;
            node.prev = nodeBeforeNewValue;
            node.next = oldNext;
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

        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            Node current = head;
            while (current != null){
                stringBuilder.append(current.data + " ");
                current = current.next;
            }
            return stringBuilder.toString().trim();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        LinkdList linkdList = new LinkdList();
        for (int i = 0; i < size; i++) {
            linkdList.add(scanner.nextInt());
        }
        int elm = scanner.nextInt();
        int position = scanner.nextInt();
        linkdList.addToPosition(position, elm);
        System.out.println(linkdList);
    }
}

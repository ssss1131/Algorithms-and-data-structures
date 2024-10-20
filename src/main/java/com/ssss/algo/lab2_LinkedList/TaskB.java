package main.java.com.ssss.algo.lab2_LinkedList;

import java.util.Scanner;

public class TaskB {
    static class Node {
        String data;
        Node next;
        Node prev;

        public Node(String  data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class LinkdList {
        private Node head;
        private Node tail;

        public void add(String  data) {
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

        public String  removeFirst() {
            if (isEmpty()) {
                throw new NullPointerException("пустойго");
            }
            String  result = head.data;
            head = head.next;
            return result;
        }

        public String  getFirst(){
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }
        public String getAll(){
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
        int shift = scanner.nextInt();
        LinkdList linkdList = new LinkdList();
        LinkdList linkdListShifted = new LinkdList();
        for (int i = 0; i < shift; i++) {
            linkdListShifted.add(scanner.next());
        }
        for (int i = 0; i < size - shift; i++) {
            linkdList.add(scanner.next());
        }
        System.out.println(linkdList.getAll() + " " + linkdListShifted.getAll());
    }
}

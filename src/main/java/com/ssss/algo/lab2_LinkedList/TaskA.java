package main.java.com.ssss.algo.lab2_LinkedList;

import java.util.Scanner;

public class TaskA {

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        LinkdList userInput = new LinkdList();
        for (int i = 0; i < quantity; i++) {
            userInput.add(scanner.nextInt());
        }
        int closestTo = scanner.nextInt();
        int result = 0;
        int difference = Integer.MAX_VALUE;
        int currentIndex = 0;
        while (!userInput.isEmpty()) {
            int currentInt = userInput.getFirst();
            int newDiff = Math.abs(closestTo - currentInt);
            if (newDiff < difference) {
                result = currentIndex;
                difference = newDiff;
            }
            currentIndex++;
            userInput.removeFirst();
        }
        System.out.println(result);

    }
}

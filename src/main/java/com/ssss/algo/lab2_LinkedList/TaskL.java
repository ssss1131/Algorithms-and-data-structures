package main.java.com.ssss.algo.lab2_LinkedList;

import java.util.Scanner;

public class TaskL {
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

        public int findMaxSum() {
            int max = Integer.MIN_VALUE;
            int maxNow = 0;
            Node currentNode = head;

            while (currentNode != null) {
                maxNow += currentNode.data;
                if (maxNow > max) {
                    max = maxNow;
                }
                if (maxNow < 0) {
                    maxNow = 0;
                }
                currentNode = currentNode.next;
            }
            return max;
        }


        public boolean isEmpty() {
            return head == null;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        LinkdList linkdList = new LinkdList();
        for (int i = 0; i < size; i++) {
            linkdList.add(scanner.nextInt());
        }
        System.out.println(linkdList.findMaxSum());



    }

}

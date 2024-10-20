package main.java.com.ssss.algo.dataStructeres;

import java.util.NoSuchElementException;

public class LinkedListByTeacher {
    class Node {
        Node next;
        Node prev;
        String key;

        Node(String key) {
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    class LinkedList {
        Node head;
        Node tail;

        LinkedList() {
            head = null;
            tail = null;
        }

        void tailPush(String x) {
            Node newNode = new Node(x);
            if (head == null && tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        String headPop() {
            if (head != null) {
                String word = head.key;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.prev = null;
                }
                return word;
            } else {
                throw new NoSuchElementException("List is empty!");
            }
        }

        void print() {
            if (head == null) {
                System.out.println("This list is empty");
            } else {
                Node current = head;
                while (current != null) {
                    System.out.print(current.key + " ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }
}

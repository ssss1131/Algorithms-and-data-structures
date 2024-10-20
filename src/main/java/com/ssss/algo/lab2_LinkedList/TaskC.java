package main.java.com.ssss.algo.lab2_LinkedList;

import java.util.Scanner;

public class TaskC {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int  data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class LinkdList {
        private Node head;
        private Node tail;

        public void add(int  data) {
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

        public void removeAllSecond() {
            if (head == tail) {
                throw new NullPointerException("пустойго");
            }
            Node current = head;
            while (current.next != null && current.next.next !=null){
                Node secondValue = current.next.next;
                current.next = secondValue;
                current = secondValue;
            }
            if(current.next!=null){
                current.next = null;
            }
        }

        public int  getFirst(){
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }
        @Override
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
        linkdList.removeAllSecond();
        System.out.println(linkdList);


    }
}

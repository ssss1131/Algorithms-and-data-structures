package main.java.com.ssss.algo.lab2_LinkedList;

import java.util.Scanner;

public class TaskE {
    static class Node {
        String  data;
        Node next;
        Node prev;

        public Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class LinkdList {
        private Node head;
        private Node tail;
        private int size;

        public void add(String  data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                size++;
                return;
            }
            if(!tail.data.equals(data)){
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                size++;
            }
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

        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            Node current = tail;
            while (current != null){
                stringBuilder.append(current.data);
                if(current.prev !=null){
                    stringBuilder.append("\n");
                }
                current = current.prev;
            }
            return stringBuilder.toString().trim();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        LinkdList linkdList = new LinkdList();
        for (int i = 0; i < size; i++) {
            linkdList.add(scanner.next());
        }
        System.out.println(
                "All in all: "  + linkdList.size +
                "\nStudents:\n" + linkdList
        );
    }
}

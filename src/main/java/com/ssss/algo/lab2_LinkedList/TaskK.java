package main.java.com.ssss.algo.lab2_LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskK {
    static class Node {
        String data;
        Node next;
        int count = 1;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static class LinkdList {
        private Node head;

        public String add(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return head.data;
            }
            Node trash = new Node("suu", head);
            String result = "-1";
            boolean isNew  = true;
            while(trash.next != null){
                if(trash.next.data.equals(data)){
                    trash.next.count++;
                    isNew  = false;
                }else if (result.equals("-1") && trash.next.count == 1) {
                    result = trash.next.data;
                }
                trash = trash.next;
            }
            if(isNew){
                trash.next = newNode;
                if(result.equals("-1")){
                    result = newNode.data;
                }
            }
            return result;

        }

        public String removeFirst() {
            if (isEmpty()) {
                throw new NullPointerException("пустойго");
            }
            String result = head.data;
            head = head.next;
            return result;
        }

        public String getFirst() {
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public String print() {
            Node node = head;
            while (node.next != null) {
                if (node.count == 1) {
                    return node.data;
                }
                node = node.next;
            }
            return "-1";
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int all = scanner.nextInt();
        List<String> result = new ArrayList<>();
        while (all != 0) {
            int size = scanner.nextInt();
            LinkdList linkdList = new LinkdList();
            for (int i = 0; i < size; i++) {
                result.add(linkdList.add(scanner.next()));
            }
            all--;
            result.add("\n");
        }
        System.out.println(String.join(" ", result));
    }

}

package main.java.com.ssss.algo.lab2_LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskI {

    private static final String ERROR = "error";
    private static final String OK = "ok";

    static class Node {
        String data;
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

        public String addBack(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return OK;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            return OK;
        }

        public String addFront(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return OK;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return OK;
        }

        public String eraseFront() {
            if (isEmpty()) {
                return ERROR;
            }
            String result = head.data;
            head = head.next;
            if(head!=null){
                head.prev = null;
            } else{
                tail = null;
            }
            return result;
        }

        public String eraseBack() {
            if (isEmpty()) {
                return ERROR;
            }
            String result = tail.data;
            tail = tail.prev;
            if(tail!=null){
                tail.prev = null;
            } else {
                head = null;
            }
            return result;
        }

        public String front() {
            if (isEmpty()) {
                return ERROR;
            }
            return head.data;
        }

        public String back() {
            if (isEmpty()) {
                return ERROR;
            }
            return tail.data;
        }

        public String clear() {
            head = null;
            return OK;
        }

        public boolean isEmpty() {
            return head == null || tail == null;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Node current = tail;
            while (current != null) {
                stringBuilder.append(current.data);
                if (current.prev != null) {
                    stringBuilder.append("\n");
                }
                current = current.prev;
            }
            return stringBuilder.toString().trim();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkdList linkdList = new LinkdList();
        List<String> result = new ArrayList<>();
        while (true) {
            String[] inputtedString = scanner.nextLine().split(" ");
            String command = inputtedString[0];
            if (inputtedString.length == 2) {
                String book = inputtedString[1];
                if (command.equals("add_front")) {
                    result.add(linkdList.addFront(book));
                } else if (command.equals("add_back")) {
                    result.add(linkdList.addBack(book));
                }
            } else {
                if (command.equals("erase_front")) {
                    result.add(linkdList.eraseFront());
                } else if (command.equals("erase_back")) {
                    result.add(linkdList.eraseBack());
                } else if (command.equals("front")) {
                    result.add(linkdList.front());
                } else if (command.equals("back")) {
                    result.add(linkdList.back());
                } else if (command.equals("clear")) {
                    result.add(linkdList.clear());
                } else {
                    break;
                }
            }
        }
        if(result.size() !=0){
            System.out.println(String.join("\n", result));
        }
        System.out.println("goodbye");
    }
}

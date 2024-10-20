package main.java.com.ssss.algo.lab2_LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskD {

    static class Node {
        int data;
        int count;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            count++;
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
            Node node = indexOf(data);
            if(node!=null){
                node.count++;
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

        public Node indexOf(int data){
            Node current = head;
            while (current!=null){
                if(current.data == data){
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        public List<Integer> findModeData(){
            Node current = head;
            List<Integer> result = new ArrayList<>();
            int count = Integer.MIN_VALUE;
            while (current!=null){
                if(current.count > count){
                    count = current.count;
                    result.clear();
                    result.add(current.data);
                } else if(current.count == count){
                    result.add(current.data);
                }
                current = current.next;
            }
            return result;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        LinkdList linkdList = new LinkdList();
        for (int i = 0; i < size; i++) {
            linkdList.add(scanner.nextInt());
        }
        System.out.println(quickSort(linkdList.findModeData()));
    }

    public static String quickSort(List<Integer> list){
        int size = list.size();
        if(size < 2){
            if(size!=0){
                return String.valueOf(list.get(0));
            }
            return "";
        }
        List<Integer> bigger = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();
        int pivot = list.get(size/2);
        for (Integer i : list) {
            if(i>pivot){
                bigger.add(i);
            }
            else if(i == pivot){
                continue;
            }
            else{
               smaller.add(i);
            }
        }
        return (quickSort(bigger) + " " + pivot + " " +  quickSort(smaller)).trim();
    }
}

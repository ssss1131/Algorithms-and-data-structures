package main.java.com.ssss.algo.lab2_LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskH {

    public static void main(String[] args) throws IOException {

        class Node {
            int val;
            Node next;

            Node(int x, Node next) {
                this.val = x;
                this.next = next;
            }

            Node(int x) {
                this(x, null);
            }

            Node(Node next) {
                this(0, next);
            }

            Node() {
                this(0, null);
            }
        }

        class Solution {

            Node insert(Node head, Node node, int pos) {
                Node trash = new Node(0, head);
                Node currentNode = trash;
                for (int i = 0; i < pos; i++) {
                    currentNode = currentNode.next;
                }
                Node nextFromCurrent = currentNode.next;
                currentNode.next = node;
                node.next = nextFromCurrent;
                return trash.next;

            }

            Node remove(Node head, int pos) {
                if (pos == 0) {
                    return head.next;
                }
                Node trash = new Node(0, head);
                Node currentNode = trash;
                for (int i = 0; i < pos; i++) {
                    currentNode = currentNode.next;
                }
                currentNode.next = currentNode.next.next;
                return trash.next;
            }


            String print(Node head) {
                Node node = head;
                StringBuilder stringBuilder = new StringBuilder();
                while (node.next != null) {
                    stringBuilder.append(node.val + " ");
                    node = node.next;
                }
                stringBuilder.append(node.val);
                return String.valueOf(stringBuilder);
            }

            Node replace(Node head, int pos1, int pos2) {
                if (pos1 == pos2) {
                    return head;
                }
                Node removedNode = getNodeAtPosition(head, pos1);
                head = remove(head, pos1);
                head = insert(head, removedNode, pos2);
                return head;
            }

            Node getNodeAtPosition(Node head, int pos) {
                Node currentNode = head;
                for (int i = 0; i < pos; i++) {
                    currentNode = currentNode.next;
                }
                return new Node(currentNode.val);
            }


            Node reverse(Node head) {
                Node prev = null;
                Node current = head;
                Node next;
                while (current != null) {
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }
                return prev;
            }

            Node cyclic_left(Node head, int x) {
                if (x == 0) {
                    return head;
                }
                Node currentNode = head;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = head;
                Node trash = head;
                for (int i = 0; i < x - 1; i++) {
                    trash = trash.next;
                }
                Node newHead = trash.next;
                trash.next = null;
                return newHead;
            }

            Node cyclic_right(Node head, int x) {
                if (x == 0) {
                    return head;
                }
                Node currentNode = head;
                int length = 0;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                    length++;
                }
                currentNode.next = head;
                currentNode = head;
                for (int i = 0; i < length - x; i++) {
                    currentNode = currentNode.next;
                }
                Node newHead = currentNode.next;
                currentNode.next = null;
                return newHead;

            }
        }

        Node head = null;
        Solution solution = new Solution();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        List<String> result = new ArrayList<>();
        while (true) {
            tk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tk.nextToken());
            if (x == 0) {
                break;
            } else if (x == 1) {
                int val = Integer.parseInt(tk.nextToken());
                int pos = Integer.parseInt(tk.nextToken());
                head = solution.insert(head, new Node(val), pos);
            } else if (x == 2) {
                int pos = Integer.parseInt(tk.nextToken());
                head = solution.remove(head, pos);
            } else if (x == 3) {
                String print = solution.print(head);
                result.add(print);
            } else if (x == 4) {
                int pos1 = Integer.parseInt(tk.nextToken());
                int pos2 = Integer.parseInt(tk.nextToken());
                head = solution.replace(head, pos1, pos2);
            } else if (x == 5) {
                head = solution.reverse(head);
            } else if (x == 6) {
                int y = Integer.parseInt(tk.nextToken());
                head = solution.cyclic_left(head, y);
            } else if (x == 7) {
                int y = Integer.parseInt(tk.nextToken());
                head = solution.cyclic_right(head, y);
            }
        }
        System.out.println(String.join("\n", result));
    }

}

package main.java.com.ssss.algo.dataStructeres;

public class HashTable {
    static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public String getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    static class List {
        private Node head;

        public List() {
            head = null;
        }

        public void clear(Node node) {
            if (node != null) {
                if (node.getNext() != null) {
                    clear(node.getNext());
                }
                node = null;
            }
        }

        public void insert(String s) {
            Node newNode = new Node(s);
            if (head == null) {
                head = newNode;
            } else {
                Node next = head;
                head = newNode;
                newNode.next = next;
            }
        }

        public void print() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.getData() + "<=>");
                curr = curr.getNext();
            }
            System.out.println();
        }

        public Node search(String s) {
            if (head != null) {
                Node curr = head;
                while (curr != null) {
                    if (curr.getData().equals(s)) {
                        return curr;
                    }
                    curr = curr.getNext();
                }
            }
            return null;
        }
    }

    static class HashTables {
        private List[] content;
        private  int m;
        private static final int BASE = 128;

        public HashTables(int size) {
            content = new List[size];
            for (int i = 0; i < size; i++) {
                content[i] = new List();
            }
            m = size;
        }

        private int hash(String s) {
            int hash = 0;
            for (int i = 0; i < s.length(); i++) {
                hash = (hash * BASE + s.charAt(i)) % m;
            }
            return hash;
        }

        public void insert(String s) {
            content[hash(s)].insert(s);
        }

        public void print() {
            for (int i = 0; i < m; i++) {
                content[i].print();
            }
        }

        public Node search(String s) {
            int probe = hash(s);
            return content[probe].search(s);
        }
    }

    public static void main(String[] args) {
        HashTables h = new HashTables(15);

        h.insert("ha");
        h.insert("he");
        h.insert("ho");
        h.insert("hu");
        h.insert("ha");

        h.print();

        Node result = h.search("he");
        System.out.println(result != null ? result.getData() : "Not found");

    }

}

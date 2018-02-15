import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
    public Node first;
    private Node last;
    private int N;
    private class Node {
        Item item;
        Node next;
    }
    public void add(Item string) {
        Node newNode = new Node();
        newNode.item = string;
        if (first == null){
            first = newNode;
        }
        if (last == null) last = first;
        else {
            last.next = newNode;
            last = newNode;
        }
        N++;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void deleteLast(){ // Exercise1319_DeleteLastNode
        if (isEmpty()) return;
        Node current = first;
        while (current != null && current.next != null) {
            if (current.next.next == null) {
                current.next = null;
                last = null;
                current.next.item = null; // loitering avoiding
            } else current = current.next;
        }
    }
    public void delete(int k) { // Exercise1320_DeleteKthNode
        if (isEmpty()) return;
        Node current = first;
        int count = 1;
        if (k == 1) {
            current.item = null; // loitering avoiding
            first = current.next;
        }
        while (current != null) {
            if (count == k - 1) {
                if (current.equals(last)) {
                    current = null;
                } else if(current.next.equals(last)){
                    current.next.item = null; // loitering avoiding
                    current.next = null;
                    last = null;
                } else {
                    if (current.next.next != null) {
                        current.next.item = null; // loitering avoiding
                        current.next = current.next.next;
                        break;
                    } else {
                        current.next.item = null; // loitering avoiding
                        current.next = null;
                        break;
                    }
                }
            } else current = current.next;
            count++;
        }
    }
    public boolean find(String key){
        if (isEmpty()) return false;
        Node current = first;
        while (current != null) {
            if (current.item == key) {
                return true;
            } else current = current.next;
        }
        return false;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){}
    }
}

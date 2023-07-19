package homework3;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private class Node {
        private int value;
        private Node next;
        private Node prev;
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            head.prev = node;
            node.next = head;
        } else {
            tail = node;
        }
        head = node;
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (tail != null) {
            tail.next = node;
            node.prev = tail;
        } else {head = node;}
        tail = node;
    }

    public void delFirst() {
        if (head != null && head.next != null) {
            head = head.next;
            head.prev = null;
        } else {
            head = null;
            tail = null;
        }
    }

    public void delLast() {
        if (tail != null && tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
    }

    public boolean contains(int value) {
        if (head == null) return false;
        Node current = head;
        do {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        } while (current != null);
        return false;
    }

    public void sort() {
        Node current;
        if (head != null) {
            current = head;
        } else return;

        while (current.next != null) {
            if (current.value > current.next.value) {
                int temp = current.value;
                current.value = current.next.value;
                current.next.value = temp;
            }
            current = current.next;
        }
    }

    public void revert() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        temp = head;
        head = tail;
        tail = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}

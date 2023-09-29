package dsa.datastructure.list;

public class DoublyLinkedList {

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public DoublyLinkedList(int value) {
        DoublyLinkedNode node = new DoublyLinkedNode(value);
        head = node;
        tail = node;
    }

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(1);
        dList.add(2);
        dList.add(3);
        System.out.println("size= " +dList.size());
        dList.remove(3);
        dList.remove(3);
        dList.remove(1);
        System.out.println("size= " +dList.size());
    }

    public boolean add(int value) {
        DoublyLinkedNode node = new DoublyLinkedNode(value);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        return true;
    }

    public boolean remove(int value) {
        if(head == null) return false;
        if(head.value == value) {
            head.next.previous = null;
            head = head.next;
            return true;
        }
        if(tail.value == value) {
            tail.previous.next = null;
            tail = tail.previous;
            return true;
        }
        DoublyLinkedNode currentNode = head.next;
        while(currentNode.next != null) {
            if(currentNode.value == value) {
                currentNode.previous.next = currentNode.next;
                currentNode.next.previous = currentNode.previous;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /*
    Removes head node and returns the value.
    Used for Queue implementation.
     */
    public int poll() {
        DoublyLinkedNode currentHead = head;
        if(currentHead == null) return Integer.MIN_VALUE;
        head = currentHead.next;
        if(head == null) {
            tail = null;
        } else {
            head.previous = null;
        }
        return currentHead.value;
    }

    public int peek() {
        if(head == null) return Integer.MIN_VALUE;
        return head.value;
    }

    public int size() {
        int count = 0;
        DoublyLinkedNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

package dsa.datastructure.queue;

import dsa.datastructure.list.DoublyLinkedList;

public class LinkedListQueue {

    DoublyLinkedList list = new DoublyLinkedList();

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("peek = " +queue.peek());
        queue.poll();
        System.out.println("peek = " +queue.peek());
        queue.add(4);
        queue.poll();
        queue.poll();
        System.out.println("peek = " +queue.peek());
    }

    public boolean add(int value) {
        return list.add(value);
    }

    public int poll() {
        return list.poll();
    }

    public int peek() {
        return list.peek();
    }
}

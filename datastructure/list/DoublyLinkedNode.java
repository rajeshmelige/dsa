package dsa.datastructure.list;

public class DoublyLinkedNode {

    public Integer value;
    public DoublyLinkedNode next;
    public DoublyLinkedNode previous;

    public DoublyLinkedNode(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public DoublyLinkedNode(int value, DoublyLinkedNode previous, DoublyLinkedNode next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
}

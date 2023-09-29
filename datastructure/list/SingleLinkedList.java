package dsa.datastructure.list;

public class SingleLinkedList {

    SingleLinkedNode head;

    public SingleLinkedList(int value) {
        head = new SingleLinkedNode(value);
    }

    public SingleLinkedList() {
        head = null;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //singleLinkedList.head.next = new SingleLinkedNode(2);
        //singleLinkedList.head.next.next = new SingleLinkedNode(3);

        System.out.println(singleLinkedList.add(4));
        //System.out.println(singleLinkedList.add(5));

        System.out.println(singleLinkedList.size());
        System.out.println(singleLinkedList.remove(4));
        System.out.println(singleLinkedList.size());
        System.out.println(singleLinkedList.remove(2));
    }

    public boolean add(int value) {
        if(head == null) {
            head = new SingleLinkedNode(value);
            return true;
        }
        SingleLinkedNode newNode = new SingleLinkedNode(value);
        SingleLinkedNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return true;
    }

    public boolean remove(int value) {
        if(head == null) return false;
        if(head.value == value) {
            head = head.next;
            return true;
        }
        SingleLinkedNode prev = head;
        SingleLinkedNode current = head;
        while(current != null) {
            if(current.value == value) {
                prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public int size() {
        int count = 0;
        SingleLinkedNode current = head;
        if(head == null) return 0;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

}

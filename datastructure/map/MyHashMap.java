package dsa.datastructure.map;

import java.util.Objects;

public class MyHashMap<K,V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity;
    private float loadFactor;
    private int size;
    private Node<K,V>[] table;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, LOAD_FACTOR);
    }

    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    static class Node<K,V> {
        int hash;
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value) {
            this.hash = Objects.hashCode(key);
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,'a');
        map.put(2,'b');
        map.put(3,'c');
        map.put(1,'d');
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        System.out.println(map.size());

    }

    public V put(K key, V value) {
        int index = Objects.hashCode(key) % capacity;
        Node<K,V> newNode = new Node<>(key,value);
        if(table == null)
            table = new Node[DEFAULT_CAPACITY];
        if(table[index] == null) {
            table[index] = newNode;
            size++;
            return value;
        } else {
            Node<K,V> head = table[index];
            while(head != null) {
                if(head.key == key) {
                    head.value = value;
                    return value;
                }
                head = head.next;
            }
            head.next = newNode;
            size++;
            return value;
        }
    }

    public Object get(Object key) {
        int index = Objects.hashCode(key);
        if(table[index] != null) {
            Node<K,V> head = table[index];
            while(head != null) {
                if(head.key.equals(key))
                    return head.value;
                head = head.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }
}

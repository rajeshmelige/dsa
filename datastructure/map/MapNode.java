package dsa.datastructure.map;

public class MapNode {

    int hash;
    Object key;
    Object value;
    MapNode next;

    public MapNode(Object key, Object value) {
        this.hash = key.hashCode();
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

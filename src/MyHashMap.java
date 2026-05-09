import java.util.Arrays;

public class MyHashMap<K, V> {
    private static class Node<K, V>{
        final K key;
        V value;
        private Node<K, V> next;
        Node(K key, V value,Node<K, V> next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }

    private Node<K,V>[] table;
    private int size=0;
    static int defaultsize = 16;

    public MyHashMap() {
        this.table = new Node[defaultsize];
        this.size = 0;
    }

    public void put(K key, V value){

        int index = calculateIndex(key);
        Node<K,V> current = table[index];
        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        if (table.length==size){
            grow();
            index = calculateIndex(key);
        }

        Node<K, V> newNode = new Node(key, value, table[index]);
        table[index] = newNode;
        size++;
    }

    public void grow() {
        int index;
        Node<K, V>[] newtable=new Node[table.length*2];
        for (Node s : table){
            if (s!=null){
            index=calculateIndex((K) s.key);
            newtable[index]=s;
            }
        }
        this.table=Arrays.copyOf(newtable,table.length*2);
    }

    public void remove(K key) {
        int index = calculateIndex(key);
        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear(){
        Node<K, V>[] newtable=new Node[size];
        table=newtable;
        size=0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = calculateIndex(key);
        Node<K, V> current = table[index];

        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                return current.value;
            }
            current = current.next;
        }
        System.out.println("Impossible to find key : "+key);
        return null;
    }

    private int calculateIndex(K key) {
        if (key == null) {
            return 0;
        }
        if (size<=defaultsize){
            return Math.abs(key.hashCode()) % defaultsize;
        }
        return Math.abs(key.hashCode()) % table.length;
    }
}
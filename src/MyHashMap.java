
public class MyHashMap {
    private static class Node{
        final Object key;
        Object value;
        Node next;
        Node(Object key, Object value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }
    private int size=0;
    private Node head;
    public void put(Object key, Object value){
        Node current = head;
        while (current!=null){
            if (current.key.equals(key)){
                current.value=value;
                return;
            }
            else {
                current=current.next;
            }
        }
        head=new Node(key,value,head);
        size++;
    }
    public void remove(Object key){
        Node current = head;
        Node n=head.next;
        if (head.key.equals(key)){
            head=n;
            size--;
            return;
        }
        else {
            while (n!=null){
                if (n.key.equals(key)){
                    current.next=n.next;
                    size--;
                    return;
                }
                else {
                    current=current.next;
                    n=current.next;
                }
            }
        }
        System.out.println("Impossible to find key : "+key);
    }

    public void clear(){
        head=null;
        size=0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key){
        Node current=head;
        while (current!=null){
            if (current.key.equals(key)){
                return current.value;
            }
            current=current.next;
        }
        System.out.println("Impossible to find key : "+key);
        return null;
    }
}


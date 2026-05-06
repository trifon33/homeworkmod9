public class MyStack {
    private static class Node{
        Object object;
        Node prev;
        Node next;
        Node(Object object,Node prev, Node next){
            this.object=object;
            this.prev=prev;
            this.next=next;
        }
    }
    private int size=0;
    private Node first;
    private Node last;
    public void push(Object object){
        Node node = new Node(object,last,null);
        Node l = last;
        this.last = node;
        node.prev = l;
        this.size++;

    }
    public Object peek(){
        return last.object;
    }
    public Object pop(){
        Node x = last;
        Node p = x.prev;
        Node n = x.next;
        if (p!=null){
            if (n==null){
                p.next = null;
            }
            else p.next = n;
            last=p;
        }
        return x.object;
    }
    public void clear() {
        for (Node x = first; x != null; ) {
            Node n = x.next;
            x.object = null;
            x.next = null;
            x.prev = null;
            x = n;
        }
        first = last = null;
        size = 0;
    }
    public void remove(int index){
        Node x = find(index);
        Node p = x.prev;
        Node n = x.next;
        if (p!=null){
            if (n==null){
                p.next = null;
            }
            else p.next = n;
        }
        if (n!=null){
            if (p==null){
                n.prev = null;
            }
            else n.prev = p;
        }

        x.prev=null;
        x.next=null;
        x.object=null;
        size--;
    }
    private Node find(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + "\n" + "Index out of range");
        }

        Node x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--) x = x.prev;
        }
        return x;
    }
    public int size() {
        return size;
    }
    public Object get(int index){
        return find(index).object;
    }
}

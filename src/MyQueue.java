public class MyQueue {
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
    public void add(Object object){
        Node node = new Node(object,last,null);
        Node l = last;
        this.last = node;
        node.prev = l;
        this.size++;
        if (first==null){
            first=node;
        }

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
    public Object peek(){
        return first.object;
    }
    public Object poll(){
        Node x = first;
        Node p = x.prev;
        Node n = x.next;
        if (n!=null){
            if (p==null){
                n.prev = null;
            }
            else n.prev = p;
            first=n;
        }
        size--;
        return x.object;
    }

    public int size() {
        return size;
    }

}

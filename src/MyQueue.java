public class MyQueue<T> {
    private static class Node<T> {
        T object;
        Node<T> prev;
        Node<T> next;

        Node(T object, Node<T> prev, Node<T> next) {
            this.object = object;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public void add(T object) {
        Node<T> l = last;
        Node<T> node = new Node<>(object, l, null);
        this.last = node;
        if (first == null) {
            first = node;
        } else {
            l.next = node;
        }
        this.size++;
    }

    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> n = x.next;
            x.object = null;
            x.next = null;
            x.prev = null;
            x = n;
        }
        first = last = null;
        size = 0;
    }

    public T peek() {
        return (first != null) ? first.object : null;
    }

    public T poll() {
        if (first == null) return null;
        Node<T> x = first;
        T obj = x.object;
        Node<T> n = x.next;

        first = n;
        if (n == null) {
            last = null;
        } else {
            n.prev = null;
        }

        size--;
        return obj;
    }

    public int size() {
        return size;
    }
}
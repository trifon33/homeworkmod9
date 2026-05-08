public class MyStack<T> {
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

    public void push(T object) {
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

    public T peek() {
        return (last != null) ? last.object : null;
    }

    public T pop() {
        if (last == null) return null;
        Node<T> x = last;
        T obj = x.object;
        Node<T> p = x.prev;

        last = p;
        if (p == null) {
            first = null;
        } else {
            p.next = null;
        }

        size--;
        return obj;
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

    public void remove(int index) {
        Node<T> x = find(index);
        Node<T> p = x.prev;
        Node<T> n = x.next;

        if (p != null) p.next = n;
        else first = n;

        if (n != null) n.prev = p;
        else last = p;

        size--;
    }

    private Node<T> find(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> x = first;
        for (int i = 0; i < index; i++) x = x.next;
        return x;
    }

    public int size() {
        return size;
    }
}
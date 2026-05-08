public class MyLinkedList<T> {
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
        if (l == null) {
            this.first = node;
        } else {
            l.next = node;
        }
        this.last = node;
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

    public void remove(int index) {
        Node<T> x = find(index);
        Node<T> p = x.prev;
        Node<T> n = x.next;

        if (p != null) {
            p.next = n;
        } else {
            first = n;
        }

        if (n != null) {
            n.prev = p;
        } else {
            last = p;
        }

        x.object = null;
        x.prev = null;
        x.next = null;
        size--;
    }

    public Node<T> find(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> x;
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

    public T get(int index) {
        return find(index).object;
    }
}
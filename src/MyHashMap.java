//*public class MyHashMap {
//    private static class Node {
//        Object key;
//        Object value;
//        Node next;
//
//        Node(Object key, Object value, Node next) {
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//    }
//
//    private Node head; // Початок нашого єдиного ланцюжка
//    private int size = 0;
//
//    // put(Object key, Object value) - додає або оновлює пару
//    public void put(Object key, Object value) {
//        Node current = head;
//        // Шукаємо, чи є вже такий ключ у списку
//        while (current != null) {
//            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
//                current.value = value; // Оновлюємо значення, якщо ключ знайдено
//                return;
//            }
//            current = current.next;
//        }
//
//        // Якщо ключа немає, створюємо нову ноду і ставимо її в початок
//        head = new Node(key, value, head);
//        size++;
//    }
//
//    // get(Object key) - повертає значення за ключем
//    public Object get(Object key) {
//        Node current = head;
//        while (current != null) {
//            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
//                return current.value;
//            }
//            current = current.next;
//        }
//        return null;
//    }
//
//    // remove(Object key) - видаляє вузол за ключем
//    public void remove(Object key) {
//        Node current = head;
//        Node prev = null;
//
//        while (current != null) {
//            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
//                if (prev == null) {
//                    head = current.next; // Видаляємо перший елемент
//                } else {
//                    prev.next = current.next; // Видаляємо елемент з середини/кінця
//                }
//                size--;
//                return;
//            }
//            prev = current;
//            current = current.next;
//        }
//    }
//
//    // clear() - повне очищення
//    public void clear() {
//        head = null;
//        size = 0;
//    }
//
//    // size() - кількість елементів
//    public int size() {
//        return size;
//    }
//}



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


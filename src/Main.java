public class Main {
    public static void main(String[] args) {

        System.out.println("=== Тест MyArrayList ===");
        MyArrayList arrayList = new MyArrayList();
        arrayList.add("Java");
        arrayList.add("Kotlin");
        arrayList.add("Swift");
        System.out.println("Розмір: " + arrayList.size());
        System.out.println("Елемент[1]: " + arrayList.get(1));
        arrayList.remove(1);
        System.out.println("Після видалення[1], новий елемент[1]: " + arrayList.get(1));
        arrayList.clear();
        System.out.println("Розмір після clear: " + arrayList.size());
        System.out.println();


        System.out.println("=== Тест MyLinkedList ===");
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add("First");
        linkedList.add("Second");
        System.out.println("Елемент[0]: " + linkedList.get(0));
        linkedList.remove(0);
        System.out.println("Розмір після видалення: " + linkedList.size());
        System.out.println();


        System.out.println("=== Тест MyQueue ===");
        MyQueue queue = new MyQueue();
        queue.add("Patient 1");
        queue.add("Patient 2");
        System.out.println("Розмір: " + queue.size());
        System.out.println("Peek (дивимось першого): " + queue.peek());
        System.out.println("Poll (забираємо першого): " + queue.poll());
        System.out.println("Розмір після poll: " + queue.size());
        System.out.println();


        System.out.println("=== Тест MyStack ===");
        MyStack stack = new MyStack();
        stack.push("Base Layer");
        stack.push("Top Layer");
        System.out.println("Peek (верхній): " + stack.peek());
        System.out.println("Pop (видаляємо верхній): " + stack.pop());
        System.out.println("Новий Peek: " + stack.peek());
        System.out.println();

        System.out.println("=== Тест MyHashMap ===");
        MyHashMap map = new MyHashMap();
        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
        map.put("Key1", "UpdatedValue1");

        System.out.println("Розмір: " + map.size());
        System.out.println("Key1: " + map.get("Key1"));
        map.remove("Key2");
        System.out.println("Після видалення Key2, get: " + map.get("Key2"));
    }
}
import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] array;
    private int size;
    private final int defaultSize = 10;

    public MyArrayList() {
        this.array = new Object[defaultSize];
        this.size = 0;
    }

    public void add(T object) {
        if (size == array.length) {
            grow();
        }
        this.array[size] = object;
        this.size++;
    }

    public void grow() {
        array = Arrays.copyOf(array, array.length + 1);
    }

    public void decrease() {
        array = Arrays.copyOf(array, array.length - 1);
    }

    public void remove(int index) {
        checkIndex(index);
        if (size - 1 - index > 0) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        this.size--;
        decrease();
    }

    public void clear() {
        array = new Object[defaultSize];
        size = 0;
    }

    public void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + "\n" + "Index out of range");
        }
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }
}
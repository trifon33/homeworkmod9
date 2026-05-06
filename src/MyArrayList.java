import java.util.Arrays;

public class MyArrayList {
    private Object[] array;
    private int size;
    private final int defaultSize = 10;

    public MyArrayList(){
        this.array=new Object[defaultSize];
        this.size=0;
    }
    public void add(Object object){
        if (size==defaultSize){
            grow();
        }
        this.array[size]=object;
        this.size++;
    }
    public void grow(){
        array= Arrays.copyOf(array,array.length+1);
    }
    public void decrease(){
        array= Arrays.copyOf(array,array.length-1);
    }
    public void remove(int index){
        checkIndex(index);
        if (size-1-index>0){
            System.arraycopy(array,index+1, array, index ,size-1-index );
        }
        decrease();
    }
    public void clear(){
        array=new Object[defaultSize];
        size=0;
    }
    public void checkIndex(int index){
        if (index<0||index>size-1){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + "\n" + "Index out of range");
        }
    }
    public int size(){
        return this.size;
    }
    public Object get(int index){
        return array[index];
    }
}

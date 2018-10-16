package TA.DataStructs;

public class DynamicArray<T> {
    private T[] array;
    private int size;

    public DynamicArray(){
        this(5);
        size = 0;
    }

    public DynamicArray(int size) {
        array = (T[]) new Object[size];
        size = 0;
    }

    public void add(T data){
        if(size < array.length){
            array[size] = data;
        }else {
            T[] tmp = (T[]) new  Object[(int)(array.length*1.5)];

            for (int i = 0; i < array.length; i++){
                tmp[i] = array[i];
            }

            array = tmp;

            array[size] = data;
        }
        ++size;
    }

    public void remove(int index){
        if(index >= 0 && index < size){
            for(int i = index; i < array.length-1;i++){
                array[i] = array[i+1];
            }
            --size;
        }
    }

    public T get(int index) {
        return array[index];
    }

    public void add(int index, T value) {
        if (index < array.length)
            array[index] = value;
    }

    public int size() {
        return array.length;
    }

    public void incSize(int size){
            T[] newArray = (T[]) new Object[size];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
    }

    public void move(int begin, int end){
        for(int j = 1; j <= array.length/2; j++)
        for(int i = end; i > begin; i--){
            array[i] = array[i-1];
        }
    }
}

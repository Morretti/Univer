package TA.DataStructs;

public class QueueArray<T> {
    private DynamicArray<T> dynArr;

    public QueueArray(){
        dynArr = new DynamicArray<>();
    }

    public QueueArray(T data){
        dynArr = new DynamicArray<>();
        dynArr.add(data);
    }

    public void enqueue(T data){
        dynArr.add(data);
    }

    public T dequeue(){
        T tmp = dynArr.get(0);
        dynArr.remove(0);
        return tmp;
    }

    public boolean isEmpty(){
        return dynArr.size() == 0;
    }
}

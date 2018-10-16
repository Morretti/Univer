package TA.DataStructs;

public class Stack<T> {
    private MyLinkedList<T> list;
    private T data;

    public Stack(){
        list = new MyLinkedList<>();
    }

    public Stack(T data){
        list.addFront(data);
    }

    public void push(T data){
        list.addFront(data);
    }

    public T pop(){
        if(list.size() > 0) {
            T tmp = list.get(0);
            list.remove(0);
            return tmp;
        }
        return null;
    }

    public T top(){
        return list.get(0);
    }
}

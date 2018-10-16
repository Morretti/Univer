package TA.DataStructs;

public class Queue<T> {
    private DynamicArray<T> dynArr;
    private int start;
    private int finish;

    public Queue(){
        dynArr = new DynamicArray<>();
    }

    public Queue(T data){
        dynArr = new DynamicArray<>();
        dynArr.add(data);
    }

    public void enqueue(T data){
        dynArr.add(finish,data);
        ++finish;

        if(finish == start) {
            dynArr.incSize(dynArr.size() * 2);
            dynArr.move(start,dynArr.size()-1);
            start = start+dynArr.size()/2;

            for(int i = finish; i < start; i++)
                dynArr.add(i,null);
        }

        if(finish >= dynArr.size())
            finish = 0;
    }

    public T dequeue(){
        T tmp = dynArr.get(start);

        dynArr.add(start++,null);

        if(start >= dynArr.size())
            start = 0;

        return tmp;
    }

    public boolean isEmpty(){
        return dynArr.size() == 0;
    }

    public void print(){
        for(int i = 0; i < dynArr.size(); i++){
            System.out.println(dynArr.get(i));
        }
    }
}

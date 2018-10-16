package TA.DataStructs;

public class MyLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public MyLinkedList(T data){
        head = new Node(data);
        tail = head;
        ++size;
    }

    public void addFront(T data){
        Node tmp = new Node(data);
        tmp.next = head;
        head = tmp;
        ++size;
        if(size == 1)
            tail = head;
    }

    public void addBack(T data){
        if(head == null){
            head = new Node(data);
        }else {
            tail.next = new Node(data);
            tail = tail.next;
            tail.next = null;
            ++size;
        }
    }

    public T get(int index){
        if(head != null) {

            if(index == 0)
                return head.data;

            Node tmp = head;

            for (int i = 0; i <= index; i++) {
                tmp = tmp.next;
            }

            if(tmp != null)
                return tmp.data;
        }
        return null;
    }

    public int size(){
        return this.size;
    }

    public void print(){
        Node tmp = head;
        while (tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public void remove(int index){
        if(head == null)
            return;

        if(index == 0){
            head = head.next;
        }else if(index > 0){

            Node beforeDeleting = head;

            for (int i = 0; i < index; i++) {
                beforeDeleting = beforeDeleting.next;
            }

            beforeDeleting = beforeDeleting.next.next;
        }
    }
}

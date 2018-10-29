package TA.DataStructs;

public class BinaryHeapTree<T extends Comparable<T>> {
    //TODO Изменить значение приориитета

    private Node root;
    private int size;

    private class Node{
        T value;
        Node left;
        Node right;
        Node parent;

        public Node(T value){
            this.value = value;
        }
    }

//    public void add(T priority, Node root, int depth){
//        if(this.depth < )
//        if(this.root == null) {
//            this.root = new Node(priority);
//            return;
//        }
//
//        Node tmp = root;
//        if(tmp.left == null) {
//            tmp.left = new Node(priority);
//            return;
//        } else if(tmp.right == null) {
//            tmp.right = new Node(priority);
//            return;
//        }
//
//        add(priority,root.left);
//        add(priority,root.right);
//
//    }

    public void add(T value){
        if(this.root == null) {
            this.root = new Node(value);
            ++size;
            return;
        }

        QueueArray<Node> queue = new QueueArray<>();

        Node tmp = this.root;

        while (tmp.left != null && tmp.right != null){
            queue.enqueue(tmp.left);
            queue.enqueue(tmp.right);
            tmp = queue.dequeue();
        }

        if(tmp.left == null)
            tmp.left = new Node(value);
        else if(tmp.right == null)
            tmp.right = new Node(value);
        ++size;

        heapify();
//        for (int i = 0; i < size; i++){
//            tmp = this.root;
//
//            while (tmp != null){
//                queue.enqueue(tmp.left);
//                queue.enqueue(tmp.right);
//
//                if(tmp.left != null){
//                    if(tmp.left.priority.compareTo(tmp.priority) > 0){
//                        T data = tmp.priority;
//                        tmp.priority = tmp.left.priority;
//                        tmp.left.priority = data;
//                    }
//                }
//
//                if(tmp.right != null){
//                    if(tmp.right.priority.compareTo(tmp.priority) > 0){
//                        T data = tmp.priority;
//                        tmp.priority = tmp.right.priority;
//                        tmp.right.priority = data;
//                    }
//                }
//
//                tmp = queue.dequeue();
//            }
//        }
    }

    public void breadth() {
        QueueArray<Node> queue = new QueueArray<>();
        Node tmp = this.root;

        while (tmp != null){
            System.out.print(tmp.value + " ");
            queue.enqueue(tmp.left);
            queue.enqueue(tmp.right);
            tmp = queue.dequeue();
        }

        System.out.println();
    }

    private void heapify(){
        for (int i = 0; i < size; i++){
            Node tmp = this.root;
            QueueArray<Node> queue = new QueueArray<>();
            while (tmp != null){
                queue.enqueue(tmp.left);
                queue.enqueue(tmp.right);

                if(tmp.left != null){
                    if(tmp.left.value.compareTo(tmp.value) > 0){
                        T data = tmp.value;
                        tmp.value = tmp.left.value;
                        tmp.left.value = data;
                    }
                }

                if(tmp.right != null){
                    if(tmp.right.value.compareTo(tmp.value) > 0){
                        T data = tmp.value;
                        tmp.value = tmp.right.value;
                        tmp.right.value = data;
                    }
                }

                tmp = queue.dequeue();
            }
        }
    }

    public T getMax(){
        return this.root.value;
    }

    public void deletMax() {
        if((root.left == null) && (root.right == null)) {
            root = null;
            return;
        }

        QueueArray<Node> queue = new QueueArray<>();
        Node tmp = this.root;
        Node previousTmp = null;

        while (tmp != null) {

            if (tmp.left != null)
                tmp.left.parent = tmp;
            if (tmp.right != null)
                tmp.right.parent = tmp;

            queue.enqueue(tmp.left);
            queue.enqueue(tmp.right);
            previousTmp = tmp;
            tmp = queue.dequeue();
        }

        if(previousTmp.parent != null) {
            if (previousTmp.parent.left == previousTmp)
                previousTmp.parent.left = null;
            if (previousTmp.parent.right == previousTmp)
                previousTmp.parent.right = null;
        }

        this.root.value = previousTmp.value;

        heapify();
    }

    public void increaseKey(T first, T priority){
        QueueArray<Node> queue = new QueueArray<>();
        Node tmp = this.root;

        while (tmp != null){
            if(tmp.value == first)
                break;

            queue.enqueue(tmp.left);
            queue.enqueue(tmp.right);
            tmp = queue.dequeue();
        }

        if (tmp == null)
            return;

        tmp.value = priority;

        heapify();
    }

    public void piramideSort(T[] array){
        for (int i = array.length-1; i >=0; i--){
            array[i] = getMax();
            deletMax();
        }
    }
}

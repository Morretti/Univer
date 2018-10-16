package TA.DataStructs;

/*
 Вывод на экран
*/

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree<T extends Comparable> {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T data) {
        root = new Node(data);
    }

    public Node getRoot() {
        return root;
    }

    public void add(T data) {
        addToTree(data, root);
    }

    private void addToTree(T data, Node root) {
        if (this.root == null) {
            this.root = new Node(data);
            return;
        }

        if (data.compareTo(root.data) < 0) {
            if (root.left != null)
                addToTree(data, root.left);
            else
                root.left = new Node(data);
        }

        if (data.compareTo(root.data) > 0)
            if (root.right != null)
                addToTree(data, root.right);
            else
                root.right = new Node(data);
    }

    public Node search(T data) {
        return searchInTree(data, root);
    }

    private Node searchInTree(T data, Node root) {
        if (root == null)
            return null;

        if (root.data.equals(data))
            return root;

        Node tmp = null;
        if (data.compareTo(root.data) > 0)
            tmp = searchInTree(data, root.right);
        else if (data.compareTo(root.data) < 0)
            tmp = searchInTree(data, root.left);

        return tmp;
    }

    public void breadth() {
        if (root != null) {
            QueueArray<Node> queue = new QueueArray<>();
            queue.enqueue(root);

            Node tmp = queue.dequeue();

            while (tmp != null) {
                if (tmp.left != null)
                    queue.enqueue(tmp.left);

                if (tmp.right != null)
                    queue.enqueue(tmp.right);

                System.out.println(tmp.data);

                tmp = queue.dequeue();
            }
        }
    }

    public void preOrder() {
        preOrderTree(root);
    }

    private void preOrderTree(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTree(root.left);
        preOrderTree(root.right);
    }

    public void inOrder() {
        inOrderTree(root);
    }

    private void inOrderTree(Node root) {
        if (root == null)
            return;
        inOrderTree(root.left);
        System.out.println(root.data);
        inOrderTree(root.right);
    }

    public void postOrder() {
        postOrderTree(root);
    }

    private void postOrderTree(Node root) {
        if (root == null)
            return;
        postOrderTree(root.left);
        postOrderTree(root.right);
        System.out.println(root.data);
    }

    public int getHeight() {
        return getTreeHeight(root)-1;
    }

    private int getTreeHeight(Node root) {
        if (root != null)
            return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
        else
            return 0;
    }

    public void delete(T data) {

        Node deleting = search(data);

        if (root == deleting){
            deleteRoot();
            return;
        }

        Node deletingParent = searchParent(root, deleting);

        if (deleting.left != null) {
            Node newRoot = deleting.left;

            while (newRoot.right != null) {
                newRoot = newRoot.right;
            }

            Node newRootParent = searchParent(root, newRoot);
            newRoot.right = deleting.right;

            if (newRoot != deleting.left)
                newRoot.left = deleting.left;
            else deleting.left = null;

            if (deletingParent.right == deleting)
                deletingParent.right = newRoot;
            else if (deletingParent.left == deleting)
                deletingParent.left = newRoot;

            if (newRootParent.right == newRoot)
                newRootParent.right = null;
            else if (newRootParent.left == newRoot)
                newRootParent.left = null;

        } else if (deleting.right != null) {
            Node newRoot = deleting.right;

            while (newRoot.left != null) {
                newRoot = newRoot.left;
            }

            Node newRootParent = searchParent(root, newRoot);

            newRoot.left = deleting.left;

            if (newRoot != deleting.right)
                newRoot.right = deleting.right;
            else deleting.right = null;

            if (deletingParent.right == deleting)
                deletingParent.right = newRoot;
            else if (deletingParent.left == deleting)
                deletingParent.left = newRoot;

            if (newRootParent.right == newRoot)
                newRootParent = null;
            else if (newRootParent.left == newRoot)
                newRootParent = null;
        }else {
            if(deletingParent.right == deleting)
                deletingParent.right = null;
            else if(deletingParent.left == deleting)
                deletingParent.left = null;
        }
    }

    private Node searchParent(Node root, Node node) {
        Node result = null;

        if (root == node)
            return null;

        if (root.right != null)
            if (root.right == node)
                return root;

        if (root.left != null)
            if (root.left == node)
                return root;

                else if (node.data.compareTo(root.data) < 0)
                    result = searchParent(root.left, node);
                else if (node.data.compareTo(root.data) > 0)
                    result = searchParent(root.right, node);

        return result;
    }

    private void deleteRoot() {
        Node newRoot;
        if (root.left != null) {
            newRoot = root.left;

            while (newRoot.right != null)
                newRoot = newRoot.right;

            Node newRootParent = searchParent(root, newRoot);

            if (newRootParent.right == newRoot)
                newRootParent.right = null;
            else if (newRootParent.left == newRoot)
                newRootParent.left = null;

            newRoot.left = root.left;
            newRoot.right = root.right;

            root = newRoot;
        } else if (root.right != null) {
            newRoot = root.right;

            while (newRoot.left != null)
                newRoot = newRoot.left;

            Node newRootParent = searchParent(root,newRoot);

            if(newRootParent.right == newRoot)
                newRootParent.right = null;
            else if(newRootParent.left == newRoot)
                newRootParent.left = null;

            newRoot.left = root.left;
            newRoot.right = root.right;

            root = newRoot;
        }
    }

//    public void print(){
//        int height = getHeight()+1;
//        int symbolsCount = 1;
//        int numOfElements = 1;
//        int elements = numOfElements(root);
//
//        LinkedList<StringBuilder> linkedList = new LinkedList<>();
//        StringBuilder stringBuilder = new StringBuilder();
//        QueueArray<Node> queue = new QueueArray<>();
//
//        while (numOfElements <= elements){
//            if(numOfElements == elements){
//                stringBuilder.append('\n');
//                linkedList.add(stringBuilder);
//                break;
//            }
//
//            int addedSymbols = 0;
//
//            queue.enqueue(root);
//
//            Node tmp = queue.dequeue();
//
//            while (tmp != null) {
//                if (tmp.left != null) {
//                    queue.enqueue(tmp.left);
//                    ++numOfElements;
//                }
//
//                if (tmp.right != null) {
//                    queue.enqueue(tmp.right);
//                    ++numOfElements;
//                }
//
//                    stringBuilder.append(tmp.data + "\t");
//                    ++addedSymbols;
//
//                if(addedSymbols >= symbolsCount) {
//
////                    for(int i = 0; i < height; i++){
////                        stringBuilder.insert(0,'\t');
////                    }
////
////                    --height;
//
//                    stringBuilder.append('\n');
//                    linkedList.add(stringBuilder);
//                    stringBuilder = new StringBuilder();
//                    addedSymbols = 0;
//                    symbolsCount *= 2;
//                }
//
//                tmp = queue.dequeue();
//            }
//        }
//
//        for(StringBuilder el : linkedList){
//            System.out.print(el);
//        }
//    }

    public void print(){
        int height = getHeight();

        ArrayList<ArrayList<T>> arrayLists = new ArrayList<>(height+1);

        int index = 0;

        for(int i = 0; i < height+1; i++){
            arrayLists.add(new ArrayList<T>());
        }

        toArray(root,0,arrayLists);

//        for(int i = 0; i < arrayLists.size(); i++){
//            for(int j = 0; j < arrayLists.get(i).size(); j++){
//                System.out.print(arrayLists.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }

        /**************************/

        int tabs = height*2;
        int interval = height*2;

        LinkedList<StringBuilder> linkedList = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < arrayLists.size(); i++){

            for(int k = tabs; k > 0; k--){
                stringBuilder.insert(0,'\t');
            }

            for(int j = 0; j < arrayLists.get(i).size(); j++){

                T tmp = arrayLists.get(i).get(j);

                //TODO добавил interval != 0
                if(tmp == null) {
                    if(interval != 0)
                        stringBuilder.append('\t');
                } else stringBuilder.append(tmp);

                if(i > 0)
                    for(int k = interval+1; k > 0; k--){
                        stringBuilder.append('\t');
                    }
            }

            linkedList.add(stringBuilder);
            stringBuilder = new StringBuilder();
            tabs = (int) (Math.ceil(tabs/2));
            interval = (int) (Math.ceil(interval/2));
//            tabs /= 2;
        }

        for(StringBuilder el : linkedList){
            System.out.println(el);
        }
    }

    private void toArray(Node root, int index, ArrayList<ArrayList<T>> arrayList){
        if(root == null) {
            return;
        }

//        if(root.left == null && root.right == null){
//            arrayList.get(index).add(root.data);
//
//            //TODO добавил
//            if((arrayList.size()-1) >= (index+1)) {
//                arrayList.get(index + 1).add(null);
//                arrayList.get(index + 1).add(null);
//            }
//
//            return;
//        }

        if(!arrayList.get(index).contains(root.data))
            arrayList.get(index).add(root.data);


        if(root.left == null) {
            if((arrayList.size()-1) >= (index+1)) {
                arrayList.get(index + 1).add(null);

                if(root.right != null) {
                    arrayList.get(index + 1).add(root.right.data);
                }
            }

            if((arrayList.size()-1) >= (index+2)) {
                arrayList.get(index + 2).add(null);
                arrayList.get(index + 2).add(null);
                arrayList.get(index + 2).add(null); /*Возможно надо удалить*/
            }
        }

        if(root.right == null) {
            if((arrayList.size()-1) >= (index+1)) {
                if(root.left != null) {
                    arrayList.get(index + 1).add(root.left.data);
                }

                arrayList.get(index + 1).add(null);
            }

//            if((arrayList.size()-1) >= (index+2)) {
//                arrayList.get(index + 2).add(null);
//                arrayList.get(index + 2).add(null);
//                arrayList.get(index + 2).add(null); /*Возможно надо удалить*/
//            }
        }

        toArray(root.left,index+1,arrayList);
        toArray(root.right,index+1,arrayList);
    }

    public int numOfElements(Node root){
        if(root == null)
            return 0;

        return 1+numOfElements(root.left)+numOfElements(root.right);
    }

    private class Node {
        T data;
        Node right;
        Node left;

        public Node(T data) {
            this.data = data;
        }
    }
}

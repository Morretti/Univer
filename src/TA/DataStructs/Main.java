package TA.DataStructs;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(20);
        binaryTree.add(10);
        binaryTree.add(30);
        binaryTree.add(5);
        binaryTree.add(15);
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(14);
        binaryTree.add(16);
        binaryTree.add(25);
        binaryTree.add(35);
        binaryTree.add(23);
        binaryTree.add(26);
        binaryTree.add(34);
        binaryTree.add(36);

        binaryTree.print();

        binaryTree.add(17);
        binaryTree.add(7);

        Thread.currentThread().sleep(100);

        System.out.println();
        binaryTree.print();
    }
}

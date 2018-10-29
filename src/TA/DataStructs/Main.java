package TA.DataStructs;

import javax.swing.plaf.basic.BasicHTML;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static int steps = 0;
    public static void main(String[] args) {
//        int[] ints = {6, 9, 1, 7, 5, 3, 2, 8, 4, 10};
//        int[] ints = new int[10];
//
//
//        int tmp;
//        int current = 0;
//        for (int i = 0; i < ints.length; i++){
//            tmp = 1 + (int) (Math.random()*10);
//            for (int j = 0; j <= current; j++){
//                if (ints[j] == tmp) {
//                    tmp = 1 + (int) (Math.random()*10);
//                    j = 0;
//                }
//            }
//            ints[i] = tmp;
//            ++current;
//        }
//
//        System.out.println("До");
//        System.out.println(Arrays.toString(ints));
//        build(ints);
//        System.out.println("После." + " Шаги: " + steps);
//        System.out.println(Arrays.toString(ints));



        BinaryHeapTree<Integer> binaryHeapTree = new BinaryHeapTree<>();

        Integer[] integers = {6, 9, 1, 7, 5, 3, 2, 8, 4, 10};

        for (Integer integer : integers){
            binaryHeapTree.add(integer);
        }

        System.out.println(Arrays.toString(integers));
        binaryHeapTree.piramideSort(integers);
        System.out.println(Arrays.toString(integers));

    }

    static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int l = 2*rootIndex + 1;
        int r = 2*rootIndex + 2;

        if (l < heapSize && arr[l] > arr[largest])
            largest = l;

        if (r < heapSize && arr[r] > arr[largest])
            largest = r;

        if (largest != rootIndex) {
            int swap = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = swap;

            heapify(arr, heapSize, largest);
        }
    }

    static void build(int[]arr){
        for(int i = (arr.length-1)/2; i >= 0;i--){
            ++steps;
            heapify(arr,arr.length,i);
        }
    }
}

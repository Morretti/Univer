package Sorts;

import java.io.*;

public class Sorts {

    public static void setData(int [] array, String filename) throws IOException{
        DataOutputStream dst = new DataOutputStream(new FileOutputStream(filename));
        for (int i = 0; i < array.length; i++){
            dst.writeInt(array[i]);
        }
    }

    public static void getData(int [] array, String filename) throws IOException{
        DataInputStream src = new DataInputStream(new FileInputStream(filename));

        for(int i = 0; i < array.length; i++){
            array[i] = src.readInt();
        }
    }

    public static void stoogeSort(int [] array){
        stooge(array, 0, array.length-1);
    }

    public static int quickSort(int [] array){
        quick(array,0,array.length-1);
        return numOfAction;
    }

    public static void shakerSort(int[] array) {
        int begin = 0;
        int end = array.length - 1;

        while (begin < end) {
            for (int index = begin; index < end; index++) {
                if (array[index] > array[index + 1]) {
                    int tmp = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = tmp;
                }
            }

            for (int index = end; index > begin; index--) {
                if (array[index] < array[index - 1]) {
                    int tmp = array[index];
                    array[index] = array[index - 1];
                    array[index - 1] = tmp;
                }
            }

            ++begin;
            --end;
        }
    }

    private static void stooge(int[] array, int begin, int end) {
        if (array[end] < array[begin]) {
            int tmp = array[end];
            array[end] = array[begin];
            array[begin] = tmp;
        }

        if ((end - begin + 1) >= 3) {
            stooge(array, begin, end - (end - begin + 1) / 3);
            stooge(array, begin + (end - begin + 1) / 3, end);
            stooge(array, begin, end - (end - begin + 1) / 3);
        }else return;
    }

    private static void quick(int [] array, int begin, int end){
        if(begin >= end)
            return;

        int pivot = array[end];
        int wall = begin;

        for (int currentIndex = wall; currentIndex <= end; currentIndex++){
            ++numOfAction;
            if(array[currentIndex] <= pivot){
                if(wall < currentIndex) {
                    int tmp = array[currentIndex];
                    array[currentIndex] = array[wall];
                    array[wall] = tmp;
                }
                if (wall < end)
                    wall++;
            }
        }

        int tmp = array[end];
        array[end] = array[wall];
        array[wall] = tmp;
        ++numOfAction;

        quick(array,begin,wall-1);
        quick(array,wall,end);
    }

}

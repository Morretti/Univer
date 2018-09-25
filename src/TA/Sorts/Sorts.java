package TA.Sorts;

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

    public static void quickSort(int [] array){
        quickWithRandomPivot(array,0,array.length-1);
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

    public static void pancakeSort(int[] array){pancake(array,array.length);}

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

        quick(array,begin,wall-1);
        quick(array,wall,end);
    }

    private static void quickWithRandomPivot(int [] array, int begin, int end){
        if(begin >= end)
            return;

        int pivotIndex = (int)(Math.random()*(array.length-1));
        int pivot = array[pivotIndex];
        //TODO Удалить sout
        System.out.println("Опорная точка " + pivotIndex);
        int wall = begin;

        for (int currentIndex = wall; currentIndex <= end; currentIndex++){
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

        quick(array,begin,wall-1);
        quick(array,wall,end);
    }

    private static void pancake(int[] array, int end){
        if (end < 2)
            return;

        int maxValue = array[0];
        int maxValueIndex = 0;

        for (int i = 0; i < end; i++) {
            if(maxValue < array[i]) {
                maxValue = array[i];
                maxValueIndex = i;
            }
        }

        for(int begin = 0, lastIndex = maxValueIndex; begin < lastIndex;++begin,--lastIndex){
            int tmp = array[begin];
            array[begin] = array[lastIndex];
            array[lastIndex] = tmp;
        }

        for(int begin = 0, lastIndex = end-1; begin < lastIndex;++begin,--lastIndex){
            int tmp = array[begin];
            array[begin] = array[lastIndex];
            array[lastIndex] = tmp;
        }

        pancake(array,--end);
    }
}

package TA.Sorts;
import java.io.IOException;
import java.util.Arrays;

import static TA.Sorts.Sorts.*;
public class Main {
    public static void main(String[] args) throws IOException {
        int[] array = new int[250_000_000];

        for(int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * array.length);
//        System.out.println(Arrays.toString(array));
        long begin = System.currentTimeMillis();
        quickSort(array);
        long end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(array));
        System.out.println((end - begin) + " ms");
    }
}

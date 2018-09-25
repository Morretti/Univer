package TA.Sorts;
import java.io.IOException;

import static TA.Sorts.Sorts.*;
public class Main {
    public static void main(String[] args) throws IOException {
        int[] array = new int[1000];
        getData(array,"data random.int");

        long begin = System.currentTimeMillis();
        quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - begin) + " ms");
    }
}

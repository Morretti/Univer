package TA.Hash;

import java.util.Arrays;
import java.util.Random;

public class TaskWithNumbers {
    public static void main(String[] args) {
        Random random = new Random();

        IntegerPlug[] ints = new IntegerPlug[10];

        for(int i = 0; i < ints.length; i++)
            ints[i] = new IntegerPlug(0);

        int tmp;
        int current = 0;

        for (int i = 0; i < ints.length; i++){
            tmp = random.nextInt(999)+1;
            for (int j = 0; j < current; j++){
                if (ints[j].getValue() == tmp) {
                    tmp = random.nextInt(999) + 1;
                    j = 0;
                }
            }
            ints[i].setValue(tmp);
            ++current;
        }

        System.out.println(Arrays.toString(ints));
        System.out.println();


        HashTable<IntegerPlug, Object> hashTable = new HashTable<>(10);

        for (IntegerPlug integerPlug : ints){
            hashTable.put(integerPlug,null);
        }

        hashTable.print();
    }
}

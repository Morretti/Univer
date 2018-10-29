package TA.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TaskWithNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        IntegerPlug[] ints = new IntegerPlug[10];

        HashTable_1<IntegerPlug> hashTable = new HashTable_1<>(10);
        HashTable_1<IntegerPlug> hashTable1 = new HashTable_1<>(11);
        HashTable_1<IntegerPlug> hashTable2 = new HashTable_1<>(16);
        HashTable_1<IntegerPlug> hashTable3 = new HashTable_1<>(17);
        HashTable_1<IntegerPlug> hashTable4 = new HashTable_1<>(32);
        HashTable_1<IntegerPlug> hashTable5 = new HashTable_1<>(64);
        HashTable_1<IntegerPlug> hashTable6 = new HashTable_1<>(67);


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


//        for(int i = 0; i < hashes.length; i++){
//            hashes[i] = new IntegerPlug(ints[i].hashCode());
//        }

//        int count = 0;
//        ArrayList<Integer> collisions = new ArrayList<>();


//        for (int i = 0; i < ints.length; i++){
//            if(hashes[i] != null) {
//                int hash = hashes[i].getValue();
//                for (int j = i + 1; j < ints.length; j++) {
//                    if (hash == hashes[j].getValue() && !collisions.contains(hash)) {
//                        ++count;
//                    }
//                }
//                collisions.add(hash);
//            }
//        }



        for (IntegerPlug integerPlug : ints){
            hashTable.put(integerPlug);
        }


        hashTable.print();
        System.out.println("Количество коллизий: " + hashTable.collions());


        for (IntegerPlug integerPlug : ints){
            hashTable1.put(integerPlug);
        }

        System.out.println();
        hashTable1.print();
        System.out.println("Количество коллизий: " + hashTable1.collions());

        for (IntegerPlug integerPlug : ints){
            hashTable2.put(integerPlug);
        }

        System.out.println();
        hashTable2.print();
        System.out.println("Количество коллизий: " + hashTable2.collions());

        for (IntegerPlug integerPlug : ints){
            hashTable3.put(integerPlug);
        }

        System.out.println();
        hashTable3.print();
        System.out.println("Количество коллизий: " + hashTable3.collions());

        for (IntegerPlug integerPlug : ints){
            hashTable4.put(integerPlug);
        }

        System.out.println();
        hashTable4.print();
        System.out.println("Количество коллизий: " + hashTable4.collions());

        for (IntegerPlug integerPlug : ints){
            hashTable5.put(integerPlug);
        }

        System.out.println();
        hashTable5.print();
        System.out.println("Количество коллизий: " + hashTable5.collions());

        for (IntegerPlug integerPlug : ints){
            hashTable6.put(integerPlug);
        }

        System.out.println();
        hashTable6.print();
        System.out.println("Количество коллизий: " + hashTable6.collions());


//        System.out.println("Количество коллизий в 1 таблице: " + hashTable.collions());
//        System.out.println("Количество коллизий в 2 таблице: " + hashTable1.collions());
//        System.out.println("Количество коллизий в 3 таблице: " + hashTable2.collions());
//        System.out.println("Количество коллизий в 4 таблице: " + hashTable3.collions());
//        System.out.println("Количество коллизий в 5 таблице: " + hashTable4.collions());
//        System.out.println("Количество коллизий в 6 таблице: " + hashTable5.collions());
//        System.out.println("Количество коллизий в 7 таблице: " + hashTable6.collions());

//
//        System.out.println(Arrays.toString(ints));
//        System.out.println();
//
//
//
//        for (int i = 0; i < ints.length; i++){
//            array[i] = ints[i].hashCode();
//        }
//
//        int count = 0;
//        ArrayList<Integer> collisions = new ArrayList<>();
//
//        System.out.println(Arrays.toString(array));
//
//        for (int i = 0; i < ints.length; i++){
//            int hash = array[i];
//            for (int j = i+1; j < ints.length;j++){
//                if(hash == array[j] && !collisions.contains(hash)) {
//                    ++count;
//                }
//            }
//            collisions.add(hash);
//        }
//
//        System.out.println("Количество коллизий: "+count);
    }
}

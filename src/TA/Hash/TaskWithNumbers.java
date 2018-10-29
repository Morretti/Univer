package TA.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TaskWithNumbers {
    public static void main(String[] args) {
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
            tmp = 1 + (int) (Math.random()*1000);
            for (int j = 0; j < current; j++){
                if (ints[j].getValue() == tmp) {
                    tmp = 1 + (int) (Math.random()*1000);
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


        System.out.println("Метод умножения");

        for (IntegerPlug integerPlug : ints){
            hashTable.put(integerPlug);
        }
        System.out.println("Количество коллизий при размере " + hashTable.size() + ": " + hashTable.collions());


        for (IntegerPlug integerPlug : ints){
            hashTable1.put(integerPlug);
        }

        System.out.println("Количество коллизий при размере " + hashTable1.size() + ": " + hashTable1.collions());

        for (IntegerPlug integerPlug : ints){
            hashTable2.put(integerPlug);
        }

        System.out.println("Количество коллизий при размере " + hashTable2.size() + ": " + hashTable2.collions());

        for (IntegerPlug integerPlug : ints){
            hashTable3.put(integerPlug);
        }

        System.out.println("Количество коллизий при размере " + hashTable3.size() + ": " + hashTable3.collions());

        for (IntegerPlug integerPlug : ints){
            hashTable4.put(integerPlug);
        }

        System.out.println("Количество коллизий при размере " + hashTable4.size() + ": " + hashTable4.collions());

        for (IntegerPlug integerPlug : ints){
            hashTable5.put(integerPlug);
        }

        System.out.println("Количество коллизий при размере " + hashTable5.size() + ": " + hashTable5.collions());

        for (IntegerPlug integerPlug : ints){
            hashTable6.put(integerPlug);
        }

        System.out.println("Количество коллизий при размере " + hashTable6.size() + ": " + hashTable6.collions());





        HashTable<IntegerPlug,Object> hashT1 = new HashTable<>(10);
        HashTable<IntegerPlug,Object> hashT2 = new HashTable<>(11);
        HashTable<IntegerPlug,Object> hashT3 = new HashTable<>(16);
        HashTable<IntegerPlug,Object> hashT4 = new HashTable<>(17);
        HashTable<IntegerPlug,Object> hashT5 = new HashTable<>(32);
        HashTable<IntegerPlug,Object> hashT6 = new HashTable<>(37);
        HashTable<IntegerPlug,Object> hashT7 = new HashTable<>(64);
        HashTable<IntegerPlug,Object> hashT8 = new HashTable<>(67);

        for (IntegerPlug integerPlug : ints){
            hashT1.put(integerPlug,null);
        }

        for (IntegerPlug integerPlug : ints){
            hashT2.put(integerPlug,null);
        }

        for (IntegerPlug integerPlug : ints){
            hashT3.put(integerPlug,null);
        }

        for (IntegerPlug integerPlug : ints){
            hashT4.put(integerPlug,null);
        }

        for (IntegerPlug integerPlug : ints){
            hashT5.put(integerPlug,null);
        }

        for (IntegerPlug integerPlug : ints){
            hashT6.put(integerPlug,null);
        }

        for (IntegerPlug integerPlug : ints){
            hashT7.put(integerPlug,null);
        }

        System.out.println();
        System.out.println("Метод деления");
        System.out.println("Количество коллизий при размере " + hashT1.size() + ": " + hashT1.collions());
        System.out.println("Количество коллизий при размере " + hashT2.size() + ": " + hashT2.collions());
        System.out.println("Количество коллизий при размере " + hashT3.size() + ": " + hashT3.collions());
        System.out.println("Количество коллизий при размере " + hashT4.size() + ": " + hashT4.collions());
        System.out.println("Количество коллизий при размере " + hashT5.size() + ": " + hashT5.collions());
        System.out.println("Количество коллизий при размере " + hashT6.size() + ": " + hashT6.collions());
        System.out.println("Количество коллизий при размере " + hashT7.size() + ": " + hashT7.collions());
        System.out.println("Количество коллизий при размере " + hashT8.size() + ": " + hashT8.collions());

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

package TA.Hash;

public class HashTableArray<K, V> {
    private Node[] table;
    private int k;
    private int taken;

    public HashTableArray(){
        table = new Node[16];
        k = 31;
    }

    public HashTableArray(int length){
        table = new Node[length];
        k = 31;

        while (true){
            if(length % k != 0)
                break;
            else ++k;
        }
    }

    private class Node<K, V>{
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value){
        if (taken == table.length)
            moveTable(table);

        int index = key.hashCode() % table.length;

        if(table[index] == null) {
            table[index] = new Node(key, value);
            ++taken;
        }
        else {
//            for(int i = index+1; i < table.length; i++){
//                if (table[i] == null) {
//                    table[i] = new Node(key, value);
//                    return;
//                }
//
//                if(table[i].key.hashCode() == key.hashCode())
//                    if(table[i].key.equals(key))
//                        table[i].value = value;
//            }

            //ДИЧЬ
            if(key.hashCode() == table[index].key.hashCode())
                if(key.equals(table[index].key)) {
                    table[index].value = value;
                    return;
                }

            index = index + secondHash(key) % table.length;

            while (true){

                if (table[index] == null) {
                    table[index] = new Node(key, value);
                    ++taken;
                    return;
                }else {
                    if(key.hashCode() == table[index].key.hashCode())
                        if(key.equals(table[index].key)) {
                            table[index].value = value;
                            return;
                        }
                }

                index = index + secondHash(key) % table.length;
            }

        }
    }

    private void moveTable(Node[] table) {
        HashTableArray<K,V> hashTableArray = new HashTableArray<K,V>(table.length*2);

        for(int i = 0; i < table.length; i++){
            hashTableArray.put((K)table[i].key,(V)table[i].value);
        }

        table = hashTableArray.table;
    }

    public V get(K key){
        int i = key.hashCode() % table.length;

        while (true) {
            if (key.hashCode() == table[i].key.hashCode())
                if (key.equals(table[i].key))
                    return (V) table[i].value;

            i = i + secondHash(key) % table.length;
        }
    }

    public void remove(K key){
        int i = key.hashCode() % table.length;

        while (true) {
            if (key.hashCode() == table[i].key.hashCode())
                if (key.equals(table[i].key)) {
                    table[i] = null;
                    --taken;
                    return;
                }

            i = i + secondHash(key) % table.length;
        }
    }

    public void print(){
        for (int i = 0; i < table.length; i++){
            if(table[i] != null){
                System.out.println("["+i+"] "+table[i].key +" - "+table[i].value);
            }
        }
    }

    private int secondHash(K key){
        return (int)(key.hashCode()*1.5);
    }
}

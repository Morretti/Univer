package TA.Hash;

public class HashTable_1<K> {
    private Node[] table;

    public HashTable_1() {
        table = new Node[16];
    }

    public HashTable_1(int length) {
        table = new Node[length];
    }

    public void put(IntegerPlug value) {

        //TODO Сделать
        int hash = hash(value.getValue());

        int index = hash % table.length;

        Node tmp = table[index];

        //Поиск дубликата
        while (tmp != null) {

            if (tmp.value == null) {
                tmp = tmp.next;
                continue;
            }

            if (tmp.value.hashCode() != value.hashCode())
                tmp = tmp.next;
            else {
                if (tmp.value.equals(value)) {
                    tmp.value = value;
                    return;
                }else
                    tmp = tmp.next;
            }
        }

        Node entry = new Node(value,hash);

        if (index == 0 && table[index] != null) {
            if (table[index].value == null) {
                entry.next = table[index].next;
                table[index].next = entry;
            }
        } else {
            entry.next = table[index];
            table[index] = entry;
        }
    }

    public IntegerPlug get(K key) {
        if (key == null) {
            Node tmp = table[0];

            while (tmp != null) {
                if (tmp.value == null)
                    return (IntegerPlug) tmp.value;
                tmp = tmp.next;
            }
        }

        int index = key.hashCode() % table.length;

        Node tmp = table[index];

        while (tmp != null) {
            if (tmp.value.hashCode() != key.hashCode())
                tmp = tmp.next;
            else {
                if (tmp.value.equals(key))
                    return (IntegerPlug) tmp.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        if (key == null) {
            Node tmp = table[0];

            if (tmp != null)
                if (tmp.value == null)
                    table[0] = tmp.next;

            while (tmp.next != null) {
                if (tmp.next.value == null)
                    tmp.next = tmp.next.next;

                tmp = tmp.next;
            }
            return;
        }

        int index = key.hashCode() % table.length;

        Node tmp = table[index];

        //Если удаляем первый элемент в цепи
        if (tmp != null) {
            if (tmp.value != null)
                if (tmp.value.hashCode() == key.hashCode()) {
                    if (tmp.value.equals(key)) {
                        table[index] = tmp.next;
                        return;
                    }
                }

            while (tmp.next != null) {
                if (tmp.next.value.hashCode() != key.hashCode())
                    tmp = tmp.next;
                else {
                    if (tmp.next.value.equals(key)) {
                        tmp.next = tmp.next.next;
                    }
                }
            }
        }
    }

    public void print() {
        int i = 0;

        for (Node node : table) {
            if (node == null) {
                continue;
            }
//                System.out.print("table["+(i++)+"] = null");
            else System.out.print("table[" + (i++) + "] = ");
            while (node != null) {
                System.out.print("Key: " + node.value + "\tHash: "+ node.hash +" | ");
                node = node.next;
            }
            System.out.println();
        }
    }

    private class Node<V> {
        int hash;
        V value;
        Node next;

        public Node(V value, int hash) {
            this.value = value;
            this.hash = hash;
        }
    }

    public int collions(){
        int count = 0;
        for(int i = 0; i < table.length; i++){
            Node tmp = table[i];
            while (tmp != null){
                if(tmp.next != null){
                    ++count;
                }
                tmp = tmp.next;
            }
        }
        return count;
    }

    private int hash(int value){
        double A=0.618033;
        int n = table.length;
        int k = value;
        double drob = (k*A) - ((int) (k*A));
        int result = (int)(n*drob);

        return result;
    }

    public int size(){
        return table.length;
    }
}

package TA.Hash;

public class HashTable<K, V> {
    private Node[] table;

    public HashTable(){
        table = new Node[16];
    }

    private class Node<K, V>{
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public void put(K key, V value){
        int index = key.hashCode() % table.length;

        Node tmp = table[index];

        //Поиск дубликата
        while (tmp != null){
            if(tmp.key.hashCode() != key.hashCode())
                tmp = tmp.next;
            else {
                if(tmp.key.equals(key)) {
                    tmp.value = value;
                    return;
                }
            }
        }

        Node entry = new Node(key,value);
        entry.next = table[index];
        table[index] = entry;

    }

    public V get(K key){
        int index = key.hashCode() % table.length;

        Node tmp = table[index];

        while (tmp != null){
            if(tmp.key.hashCode() != key.hashCode())
                tmp = tmp.next;
            else {
                if(tmp.key.equals(key))
                    return (V) tmp.value;
            }
        }

        return null;
    }

    public void remove(K key){
        int index = key.hashCode() % table.length;

        Node tmp = table[index];

        //Если удаляем первый элемент в цепи
        if(tmp.key.hashCode() == key.hashCode()){
            if(tmp.key.equals(key)) {
                table[index] = tmp.next;
                return;
            }
        }

        while (tmp.next != null){
            if(tmp.next.key.hashCode() != key.hashCode())
                tmp = tmp.next;
            else {
                if(tmp.next.key.equals(key)){
                    tmp.next = tmp.next.next;
                }
            }
        }
    }

    public void print(){
        int i = 0;

        for(Node node : table){
            if(node == null)
                System.out.print("table["+(i++)+"] = null");
            else System.out.print("table["+(i++)+"] = ");
            while (node != null){
                System.out.print(node.key+" - "+node.value+" ");
                node = node.next;
            }
            System.out.println();
        }
    }
}

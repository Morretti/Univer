package TA.Hash;

public class HashTable<K, V> {
    private Node[] table;

    public HashTable() {
        table = new Node[16];
    }

    public HashTable(int length) {
        table = new Node[length];
    }

    public void put(K key, V value) {
        if (key == null) {
            putNullKey(value);
            return;
        }

        int index = key.hashCode() % table.length;

        Node tmp = table[index];

        //Поиск дубликата
        while (tmp != null) {

            if (tmp.key == null) {
                tmp = tmp.next;
                continue;
            }

            if (tmp.key.hashCode() != key.hashCode())
                tmp = tmp.next;
            else {
                if (tmp.key.equals(key)) {
                    tmp.value = value;
                    return;
                }
            }
        }

        Node entry = new Node(key, value);

        if (index == 0 && table[index] != null) {
            if (table[index].key == null) {
                entry.next = table[index].next;
                table[index].next = entry;
            }
        } else {
            entry.next = table[index];
            table[index] = entry;
        }
    }

    private void putNullKey(V value) {
        Node tmp = table[0];

        while (tmp != null) {
            if (tmp.key == null) {
                tmp.value = value;
                return;
            }
            tmp = tmp.next;
        }

        tmp = new Node(null, value);
        tmp.next = table[0];
        table[0] = tmp;
    }

    public V get(K key) {
        if (key == null) {
            Node tmp = table[0];

            while (tmp != null) {
                if (tmp.key == null)
                    return (V) tmp.value;
                tmp = tmp.next;
            }
        }

        int index = key.hashCode() % table.length;

        Node tmp = table[index];

        while (tmp != null) {
            if (tmp.key.hashCode() != key.hashCode())
                tmp = tmp.next;
            else {
                if (tmp.key.equals(key))
                    return (V) tmp.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        if (key == null) {
            Node tmp = table[0];

            if (tmp != null)
                if (tmp.key == null)
                    table[0] = tmp.next;

            while (tmp.next != null) {
                if (tmp.next.key == null)
                    tmp.next = tmp.next.next;

                tmp = tmp.next;
            }
            return;
        }

        int index = key.hashCode() % table.length;

        Node tmp = table[index];

        //Если удаляем первый элемент в цепи
        if (tmp != null) {
            if (tmp.key != null)
                if (tmp.key.hashCode() == key.hashCode()) {
                    if (tmp.key.equals(key)) {
                        table[index] = tmp.next;
                        return;
                    }
                }

            while (tmp.next != null) {
                if (tmp.next.key.hashCode() != key.hashCode())
                    tmp = tmp.next;
                else {
                    if (tmp.next.key.equals(key)) {
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
            }
//                System.out.print("table["+(i++)+"] = null");
            else System.out.print("table[" + (i++) + "] = ");
            while (node != null) {
                System.out.print(node.key + " - " + node.value + " ");
                node = node.next;
            }
            System.out.println();
        }
    }

    private class Node<K, V> {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

package lesson8;

import java.util.ArrayList;
import java.util.List;

public class ChanHashTable<K,V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    private final List<HashTableImpl.Item<K, V>>[] data;//Создаем массив связных списков
    private int size;

    @SuppressWarnings("unchecked")
    public ChanHashTable(int maxSize) {
        this.data = new ArrayList[maxSize * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        if (data[index] != null) {//Если в ячейке
            for (int i = 0; i < data[index].size(); i++) {
                if(data[index].get(i).getKey().equals(key)) {
                    data[index].get(i).setValue(value);
                    return true;
                }
            }
            data[index].add(new HashTableImpl.Item<>(key, value));
            return true;

        }

        data[index] = new ArrayList<>();
        data[index].add(new HashTableImpl.Item<>(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int[] index = indexOf(key);
        return index[0] != -1 ? data[index[0]].get(index[1]).getValue() : null;
    }

    private int[] indexOf(K key) {

        int index = hashFunc(key);
        if(data[index] == null) return new int[]{-1,-1};

        for (int i = 0; i < data[index].size(); i++) {
            if(data[index].get(i).getKey().equals(key)) {

                return new int[]{index,i};
            }
        }

        return new int[]{-1,-1};
    }

    @Override
    public V remove(K key) {
        int[] index = indexOf(key);
        if (index[0] == -1) {
            return null;
        }

        HashTableImpl.Item<K, V> item = data[index[0]].get(index[1]);
        data[index[0]].remove(index[1]);
        size--;
        return item.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [", i);
            if (data[i]!=null)
            System.out.print(data[i]+ " ");
            else System.out.print("NULL]");

            System.out.println();
        }
        System.out.println("----------");
    }


}

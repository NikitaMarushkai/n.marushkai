package ru.kpfu.itis.group408.marushkai.map;

import java.util.*;

/**
 * Created by unlim_000 on 28.03.2015.
 */
public class HashMap<K, V> implements Map<K, V> {

    private class KVP<K, V> implements Entry<K, V>{
        K key;
        V value;

        public KVP(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }

    private LinkedList<KVP> table[];
    private int size = 0;

    public HashMap(int size){
        table = new LinkedList[size];
        for (int i = 0; i < table.length; i++){
            table[i] = new LinkedList<>();
        }
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
    public boolean containsKey(Object key) {
        boolean is = false;
        outer:for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table[i].size(); j++){
                if (table[i].get(j).key == (K) key || table[i].get(j).key.equals((K) key)){
                    is = true;
                    break outer;
                } else
                    is = false;
            }
        }
        return is;
    }

    @Override

    public boolean containsValue(Object value) {
        boolean is = false;
        outer:for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table[i].size(); j++){
                if (table[i].get(j).value == (V) value || table[i].get(j).value.equals((V) value)){
                    is = true;
                    break outer;
                } else
                    is = false;
            }
        }
        return is;
    }

    private int getIndex(Object key){
        return key.hashCode() % this.table.length;
    }

    @Override
    public V get(Object key) {
        V value = null;
        int index = this.getIndex(key);
        for (int i = 0; i < table[index].size(); i++){
            if (table[index].get(i).key == key || table[index].get(i).key.equals(key)){
                value =(V) table[index].get(i).value;
            }
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        table[getIndex(key)].add(new KVP(key, value));
        size++;
        return value;
    }

    @Override
    public V remove(Object key) {
        int index = this.getIndex(key);
        V value = null;
        for (int i = 0; i < table[index].size(); i++){
            if (table[index].get(i).key == key || table[index].get(i).key.equals(key)){
                value = (V) table[index].get(i).value;
                table[index].remove(i);
            }
        }
        size--;
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach((k, v) -> this.put(k, v));
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++){
            table[i].clear();
        }
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keyset = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].size(); j++) {
                keyset.add((K) table[i].get(j).key);
            }
        }
        return keyset;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new LinkedList<>();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].size(); j++) {
                values.add((V) table[i].get(j).value);
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        for (int i = 0; i < table.length; i++){
            table[i].forEach((el) -> entrySet.add(new KVP<>((K) el.getKey(), (V) el.getValue())));
        }
        return entrySet;
    }

}

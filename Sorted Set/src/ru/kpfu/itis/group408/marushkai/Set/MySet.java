package ru.kpfu.itis.group408.marushkai.Set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by unlim_000 on 28.03.2015.
 */
public class MySet<T extends Comparable> implements SortedSet<T> {

    private LinkedList<T> setList = new LinkedList<>();
    private static int i = 0;

    @Override
    public void add(T element) {
        int ins = 0;
        for (int i = 0; i < setList.size(); i++){
            if (setList.get(i).equals(element))
                ins++;
        }
        if (ins == 0) {
            setList.add(element);
            Object[] service = new Object[setList.size()];
            for (int i = 0; i < service.length; i++){
                service[i] = setList.get(i);
            }
            Arrays.sort(service);
            for (int i = 0; i < service.length; i++){
                setList.set(i, (T) service[i]);
            }
        }
    }

    @Override
    public void clear() {
        setList.clear();
    }

    @Override
    public boolean contains(Object o) {
        return (setList.contains(o));
    }

    @Override
    public boolean isEmpty() {
        return setList.isEmpty();
    }

    @Override
    public void remove(Object o) {
        setList.remove(o);
    }

    @Override
    public int size() {
        return setList.size();
    }

    @Override
    public Object[] toArray() {
        return setList.toArray();
    }

    public class MyIterator<T> implements Iterator<T>{
        @Override
        public boolean hasNext() {
            try {
                if (setList.get(i) == null) {
                    return false;
                } else return true;
            } catch (IndexOutOfBoundsException e){
                return false;
            }
        }

        @Override
        public T next() {
            T th;
            if (hasNext()){
                th = (T) setList.get(i);
                i++;
                return th;
            } else
                return null;
        }
    }
    @Override
    public MyIterator<T> iterator() {
        return new MyIterator();
    }
}

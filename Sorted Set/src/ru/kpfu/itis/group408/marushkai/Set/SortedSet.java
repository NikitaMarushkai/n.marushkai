package ru.kpfu.itis.group408.marushkai.Set;

/**
 * Created by unlim_000 on 01.04.2015.
 */
public interface SortedSet<T> extends Iterable<T>{
    void add(T element);
    void clear();
    boolean contains(Object o);
    boolean isEmpty();
    void remove(Object o);
    int size();
    Object[] toArray();

}

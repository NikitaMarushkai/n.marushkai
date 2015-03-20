package ru.kpfu.itis.group408.marushkai.stack;

/**
 * Created by unlim_000 on 20.03.2015.
 */
public interface SuperStack<T> {
    T pop() throws Exception;

    T peek() throws Exception;

    void push (T t);

    int size();

    boolean isEmpty();

}

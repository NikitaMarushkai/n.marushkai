package ru.kpfu.itis.group408.marushkai.queue;

/**
 * Created by Никита on 21.03.2015.
 */
public interface Queue<T> {
    void offer(T t) throws Exception;
    T peek() throws Exception;
    T poll() throws Exception;
    boolean isEmpty();
    int size();
    int maxSize();
}

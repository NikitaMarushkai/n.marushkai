package ru.kpfu.itis.group408.marushkai.queue;

/**
 * Created by Никита on 21.03.2015.
 */
public class ArrayQueue<T> implements Queue<T> {
    private final int SIZE = 20;
    private Object[] queue = new Object[SIZE];
    private int startIndex  = 0, endIndex = 0, queueLength = 0;

    public void offer(T t) throws Exception{
        queue[endIndex] = t;
        endIndex++;
        queueLength++;
        if (endIndex == SIZE){
            endIndex = 0;
        }
        if (queueLength >= SIZE){
            throw new Exception("queue overflow");
        }
    }

    public T peek() throws Exception{
        if (!isEmpty()) {
            return (T) queue[startIndex];
        } else throw new Exception("Queue is empty");
    }

    public T poll() throws Exception{
        if (!isEmpty()) {
            T element = (T) queue[startIndex];
            startIndex++;
            queueLength--;
            if (startIndex == SIZE){
                startIndex = 0;
            }
            return element;
        } else throw new Exception("Queue is empty");
    }

    public boolean isEmpty(){
        return queueLength == 0;
    }

    public int size(){
        return queueLength;
    }

    public int maxSize(){
        return SIZE;
    }
}

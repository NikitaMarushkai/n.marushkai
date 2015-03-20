package ru.kpfu.itis.group408.marushkai.stack;

import java.util.Iterator;

/**
 * Created by unlim_000 on 20.03.2015.
 */
public class ArrayStack<T> implements SuperStack<T> {
    private final int STACK_SIZE = 20;
    private Object[] stack = new Object[STACK_SIZE];
    private int size = 0;

    public T pop() throws Exception{
        if (!isEmpty()){
            size--;
            T last = (T) stack[this.size];
            stack[this.size] = null;
            return last;
        } else{
            throw new Exception("Popping is unavaliable for empty stack");
        }
    }

    public T peek() throws Exception{
        if (!isEmpty()){
            return (T) stack[this.size-1];
        } else{
            throw new Exception("Nothing to peek");
        }
    }

    public void push(T t){
        stack[size] = t;
        size++;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return stack[0] == null;
    }

    public MyIterator iterator(){
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T>{
        private int i = 0;

        public boolean hasNext(){
            if (isEmpty()){
                return false;
            } else if ((i < STACK_SIZE) && (stack[i]!= null)){
                i++;
                return true;
            } else return false;
        }
        public T next(){
            if (!isEmpty())
                return (T) stack[i];
            else
                return null;
        }
    }
}
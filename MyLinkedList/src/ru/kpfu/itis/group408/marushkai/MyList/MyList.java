package ru.kpfu.itis.group408.marushkai.MyList;
import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * Created by unlim_000 on 16.03.2015.
 */
public class MyList<T> {
    private Element first = null;
    private Element last = null;

    public class MyIterator implements Iterator<T> {
        private Element node = new Element(null, first);
        private Element previous = null;

        public T value() {
            if (node == null) {
                throw new NoSuchElementException();
            }
            return node.value;
        }

        public T next() {
            if (node == null || node.next == null) {
                throw new NoSuchElementException();
            }
            previous = node;
            node = node.next;
            return node.value;
        }

        public boolean hasNext() {
            return node != null && node.next != null;
        }
    }

    public MyIterator iterator(){
        return new MyIterator();
    }

    public void add(T value) {

        if (first == null) {
            first = new Element(value);
            last = first;
            return;
        }

        Element newLast = new Element(value);

        last.setNext(newLast);
        last = newLast;

    }

    public void add(int index, T value) {

        Element elem;
        if (index == 0) {
            elem = first;
        } else {
            elem = getElement(index - 1);
        }

        Element predNext = elem.getNext();
        Element newNext = new Element(value, predNext);

        elem.setNext(newNext);

        if (elem == last) {
            last = newNext;
        }

    }

    public void clear() {

        first = null;
        last = null;

    }

    public boolean contains(T value) {
        Element el = first;
        while (el != null) {
            if (value == null || el.value == null) {

                if (value == el.value) {
                    return true;
                }
            } else if (value.equals(el.value)) {
                return true;
            }
            el = el.next;
        }
        return false;
    }

    public int size() {
        int size = 0;
        if (first == null) {
            return 0;
        }
        for (Element iter = first; iter != null; iter = iter.getNext(), size++);
        return size;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public int IndexOf(T value) {
        Element el = first;
        int k = -1;
        while (el != null) {
            k++;
            if (value == null || el.value == null) {
                if (el.value == value) {
                    return k;
                }
            } else if (value.equals(el.value)) {
                return k;
            }
            el = el.next;
        }
        return k;
    }

    public int lastIndexOf(T value) {
        Element el = first;
        int k = -1;
        int n = -1;
        while (el != null) {
            k++;
            if (value == null || el.value == null) {
                if (el.value == value) {
                    n = k;
                }
            } else if (value.equals(el.value)) {
                n = k;
            }
            el = el.next;
        }
        return n;
    }

    public T set(int index, T element) {
        Element el = getElement(index - 1);
        T t = el.value;
        el.value = element;
        return t;
    }

    public void remove(int index) {

        if (first == null) {
            throw new IndexOutOfBoundsException(
                    "Unable to delete element from empty list");
        }

        if (index == 0) {

            first = first.getNext();

            if (first == null) {
                last = null;
            }
            return;

        }

        Element predElement = getElement(index - 1);
        Element elemForDelete = predElement.getNext();

        if (elemForDelete == null) {
            throw new IndexOutOfBoundsException(
                    "Deleting element that doesn't exist");
        }

        predElement.setNext(elemForDelete.getNext());

    }

    public T get(int index) {
        return getElement(index).getObj();
    }

    public T getFirst() {

        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.getObj();
    }

    public T getLast() {

        if (last == null) {
            throw new NoSuchElementException();
        }

        return last.getObj();

    }

    @Override
    public String toString() {

        String result = "[";

        for (Element iter = first; iter != null; iter = iter.getNext()) {

            if (iter != first) {
                result += ", ";
            }

            result += iter.getObj().toString();
        }

        return result + "]";

    }

    private Element getElement(int index) {

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(
                    "Unable to get element by specified index" + index);
        }

        Element elem = first;

        for (int i = 0; i < index; i++, elem = elem.getNext());

        return elem;

    }

    public Object[] toArray() {
        int n = size();
        Object[] array = new Object[n];
        Element el = first;
        for (int i = 0; i < n; i++) {
            array[i] = el.value;
            el = el.next;
        }
        return array;
    }

    private class Element {

        private T value;
        private Element next = null;

        public Element(T value) {
            this.value = value;
        }

        public Element(T value, Element next) {
            this.value = value;
            this.next = next;
        }

        public T getObj() {
            return value;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element getNext() {
            return next;
        }

    }

}

package ru.kpfu.itis.group408.marushkai.ctv;
import java.util.Comparator;

/**
 * Created by unlim_000 on 10.03.2015.
 */
public interface ModelProvider<T> {
    Comparator<T> getComparator();
    T[] getElements(int n);
}

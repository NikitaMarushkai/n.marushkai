package ru.kpfu.itis.group408.marushkai.ctv;

/**
 * Created by unlim_000 on 10.03.2015.
 */
public interface ViewProvider<T> {
    int getColumnCount();
    String getLabel(T obj, int n);
    String[] getHeader();
}

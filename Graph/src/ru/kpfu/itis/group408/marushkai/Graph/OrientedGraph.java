package ru.kpfu.itis.group408.marushkai.Graph;

import java.util.Collection;

/**
 * Created by unlim_000 on 20.04.2015.
 */
public interface OrientedGraph<V> {
    void addVertex (Vertex<V> vertex);
    void link (Vertex<V> from, Vertex<V> to);
    void unlink (Vertex<V> one, Vertex<V> two);
    void remove(Vertex<V> vertex);
    boolean isLinked(Vertex<V> one, Vertex<V> two);
    Collection getLinkedVertex(Vertex<V> vertex);
}

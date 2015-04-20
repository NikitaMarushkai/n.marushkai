package ru.kpfu.itis.group408.marushkai.Graph;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by unlim_000 on 20.04.2015.
 */
public class ListGraph<V> implements OrientedGraph<V> {
    private LinkedList[] listOfLinks;
    private int i = 0;

    public ListGraph(int size){
        System.out.println("Enter the number of vertexes");
        listOfLinks = new LinkedList[size];
        for (int i = 0; i < size; i++){
            listOfLinks[i] = new LinkedList<Vertex>();
        }
    }

    @Override
    public void addVertex(Vertex<V> vertex) {
        listOfLinks[vertex.number].add(vertex);
    }

    @Override
    public void link(Vertex<V> from, Vertex<V> to) {
        listOfLinks[from.number].add(listOfLinks[to.number].get(0));
    }

    @Override
    public void unlink(Vertex<V> one, Vertex<V> two) {
        for (int i = 0; i < listOfLinks[one.number].size(); i++){
            if (listOfLinks[one.number].get(i).equals(two)){
                listOfLinks[one.number].remove(i);
            }
        }
    }

    @Override
    public void remove(Vertex<V> vertex) {
        listOfLinks[vertex.number] = new LinkedList<Vertex>();
    }

    @Override
    public boolean isLinked(Vertex<V> one, Vertex<V> two) {
        return listOfLinks[one.number].contains(two);
    }

    @Override
    public Collection<Vertex<V>> getLinkedVertex(Vertex<V> vertex) {
        return listOfLinks[vertex.number];
    }
}

package ru.kpfu.itis.group408.marushkai.SemesterWork2;

import java.util.Collection;
import java.util.LinkedList;

public class ListGraph<V> implements OrientedGraph<V> {
    private LinkedList[] listOfLinks;
    private int size;
    private int i = 0;

    public ListGraph(int size){
        listOfLinks = new LinkedList[size];
        for (int i = 0; i < size; i++){
            listOfLinks[i] = new LinkedList<Vertex>();
        }
        this.size = size;
    }

    @Override
    public void addVertex(Vertex<V> vertex) {
        vertex.number = i;
        listOfLinks[i].add(vertex);
        i++;
    }


    @Override
    public void link(Vertex<V> from, Vertex<V> to, int distance) {
        Vertex<V> serv = (Vertex) listOfLinks[to.number].get(0);
        listOfLinks[from.number].add(serv.copy());
        Vertex<V> serv1 = (Vertex) listOfLinks[from.number].getLast();
        serv1.distanceTo = distance;
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

    @Override
    public LinkedList<Vertex> getAll(){
        LinkedList vertexes = new LinkedList<>();
        for (int k = 0; k < this.i; k++){
            vertexes.add(listOfLinks[k].get(0));
        }
        return vertexes;
    }

    @Override
    public int getDistance(Vertex<V> from, Vertex<V> to){
        for (int i = 0; i < listOfLinks[from.number].size(); i++){
            Vertex<V> serv = (Vertex) listOfLinks[from.number].get(i);
            if (to.equals(serv)){
                return serv.distanceTo;
            }
        }
        return 0;
    }

    @Override
    public int getSize(){
        return this.size;
    }
}

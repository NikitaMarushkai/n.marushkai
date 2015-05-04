package ru.kpfu.itis.group408.marushkai.SemesterWork2;

public class Vertex<V> {
    private V value;
    private int number;
    private int distanceTo;
    public int mark;

    public int getDistanceTo() {
        return distanceTo;
    }

    public int getNumber() {
        return number;
    }

    public Vertex<V> copy(){
        Vertex<V> newVertex = new Vertex<>(this.getValue());
        newVertex.number = this.number;
        newVertex.distanceTo = this.distanceTo;
        newVertex.mark = this.mark;
        return newVertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;

        Vertex<?> vertex = (Vertex<?>) o;

        if (number != vertex.number) return false;
        return value.equals(vertex.value);

    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + number;
        return result;
    }

    public Vertex(V value){
        this.value = value;
        this.distanceTo = 0;
        this.mark = 0;
    }
    public V getValue(){
        return this.value;
    }
}

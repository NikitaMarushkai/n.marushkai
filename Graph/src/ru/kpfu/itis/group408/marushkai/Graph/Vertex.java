package ru.kpfu.itis.group408.marushkai.Graph;

/**
 * Created by unlim_000 on 20.04.2015.
 */
public class Vertex<V> {
    private V value;
    public int number;

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

    public Vertex(int number, V value){
        this.value = value;
        this.number = number;
    }
    public V getValue(){
        return this.value;
    }
}

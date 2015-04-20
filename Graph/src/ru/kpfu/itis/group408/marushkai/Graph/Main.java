package ru.kpfu.itis.group408.marushkai.Graph;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        OrientedGraph<String> graph = new ListGraph<>(5);
        Vertex<String>[] vertexes = new Vertex[]{
                new Vertex(0, "Nikita"),
                new Vertex(1, "Nastya"),
                new Vertex(2, "Anvar"),
                new Vertex(3, "Natalia"),
                new Vertex(4, "Ilyas")
        };
        graph.addVertex(vertexes[0]);
        graph.addVertex(vertexes[1]);
        graph.addVertex(vertexes[2]);
        graph.addVertex(vertexes[3]);
        graph.addVertex(vertexes[4]);
        graph.link(vertexes[0], vertexes[1]);
        graph.link(vertexes[0], vertexes[2]);
        graph.link(vertexes[0], vertexes[3]);
        LinkedList links = (LinkedList) graph.getLinkedVertex(vertexes[0]);
        for (int i = 0; i < links.size(); i++){
            Vertex a = (Vertex) links.get(i);
            System.out.println(a.getValue());
        }
        System.out.println(graph.isLinked(vertexes[0], vertexes[1]));
        System.out.println(graph.isLinked(vertexes[2], vertexes[3]));
        graph.unlink(vertexes[0], vertexes[1]);
        System.out.println(graph.isLinked(vertexes[0], vertexes[1]));
        graph.link(vertexes[0], vertexes[1]);
        System.out.println(graph.isLinked(vertexes[0], vertexes[1]));
        graph.remove(vertexes[0]);
        System.out.println(graph.isLinked(vertexes[0], vertexes[1]));

    }
}

package ru.kpfu.itis.group408.marushkai.SemesterWork2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    OrientedGraph<String> graph;
    int num = 1;

    private void add(Vertex vertex) throws IOException {
        Scanner sc = new Scanner(System.in);
        graph.addVertex(vertex);
        System.out.println("Количество связей < " + num);
        int links = sc.nextInt(), number, distance, direction;
        if (links >= num)
            throw new IOException("Неприемлемое количество связей");
        num++;
        while (links != 0){
            System.out.println("Номер вершины с которой вы хотите связать данную и расстояние до нее");
            number = sc.nextInt();
            distance = sc.nextInt();
            System.out.println("1 для пути к этой вершине, 2 для пути от нее");
            direction = sc.nextInt();
            switch (direction){
                case 1:
                    graph.link(graph.getAll().get(number), graph.getAll().get(vertex.number), distance);
                    break;
                case 2:
                    graph.link(graph.getAll().get(vertex.number), graph.getAll().get(number), distance);
                    break;
                default:
                    throw new IOException("Неверный ввод, дальнейшая работа программы может быть некорректной");
            }
            links--;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число вершин");
        main.graph = new ListGraph<>(sc.nextInt());
        int size = main.graph.getSize();
        while (size != 0){
            System.out.println("Новая вершина");
            try {
                main.add(new Vertex<>("Vertex"));
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
            size--;
        }
        System.out.println("Номер вершины до которой вы хотите найти путь");
        DejkstraAlgo<String> alg = new DejkstraAlgo<>(sc.nextInt(), main.graph);
        alg.findWay();
    }
}

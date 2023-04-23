package org.example.GraphAdjacencyList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private HashMap<Integer,LinkedList<Integer>> graph = new HashMap();

    private HashMap<Integer,Boolean> visited;

    public void insertVertice(int value){
        LinkedList<Integer> newVertice = new LinkedList<>();
        graph.put(value,newVertice);
    }

    public boolean insertEdge(int firstVertice, int secondVertice){
        if(graph.get(firstVertice).contains(secondVertice)){
            return false;
        }else {
            graph.get(firstVertice).add(secondVertice);
            return true;
        }
    }

    public boolean checkEdge(int firstVertice, int secondVertice){
        LinkedList<Integer> list = graph.get(firstVertice);
        for(int i : list){
            if(i==secondVertice){
                return true;
            }
        }
        return false;
    }

    public int amountOfEdges(int vertice){
        return graph.get(vertice).size();
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.insertVertice(1);
        graph.insertVertice(2);
        graph.insertEdge(2,1);
        System.out.println(graph.checkEdge(2,1));

    }
}

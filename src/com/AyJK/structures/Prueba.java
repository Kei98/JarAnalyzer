package com.AyJK.structures;

/**
 * @author AyJK
 * prueba del grafo
 *
 */

public class Prueba {
	
	@SuppressWarnings({"rawtypes", "unchecked" })
	public static <T> void main(String args[]) {
		Graph graph = new Graph();
		Vertex vertex = new Vertex<String>("hola");
		Vertex vertex0 = new Vertex<String>("adios");
		Vertex vertex00 = new Vertex<String>("mmm...");
		Vertex vertex000 = new Vertex<String>("prueba");
		
		
		graph.insertVertex(vertex, false);
		graph.insertVertex(vertex0, false);
		graph.insertVertex(vertex00, false);
		graph.insertVertex(vertex000, false);
		graph.insertEdge(vertex, vertex0);
		graph.insertEdge(vertex00, vertex);
		graph.insertEdge(vertex, vertex000);
		
		
		
		Graph graph1 = new Graph<>();
		Vertex vertex1 = new Vertex<String>("ola", graph);
		Vertex vertex11 = new Vertex<String>("hora");
		graph1.insertVertex(vertex1, false);
		graph1.insertVertex(vertex11, false);
		graph1.insertEdge(vertex1, vertex11);
		
		
		System.out.println(vertex.getNeighbors());
		System.out.println(" ");
		System.out.println(vertex1.getNeighbors());
		System.out.println(" ");
		System.out.println(vertex1.getChild().getVertex("hola").getNeighbors());
		System.out.println(" ");
		System.out.println(graph.getParent().getNeighbors());
		System.out.println(" ");
		System.out.println(graph.vertexKeys());
		System.out.println(" ");
		System.out.println(graph.getEdge());
		
	}
	
	

}

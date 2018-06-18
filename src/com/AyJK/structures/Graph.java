package com.AyJK.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T extends Comparable<T>> {
	@SuppressWarnings("rawtypes")
	private HashMap<T, Vertex> vertex;
	private HashMap<Integer, Edge> edge;
    
    @SuppressWarnings("rawtypes")
	public Graph() {
    	this.vertex = new HashMap<T, Vertex>();
    	this.edge = new HashMap<Integer, Edge>();
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Graph(ArrayList<Vertex> vertex) {
    	this.vertex = new HashMap<T, Vertex>();
    	this.edge = new HashMap<Integer, Edge>();

    	for(Vertex v : vertex)
    	    {
    		this.vertex.put((T) v.getTag(), v);
    	    }
    }
    
    
    @SuppressWarnings("rawtypes")
	public boolean insertEdge(Vertex v1, Vertex v2) {
    	return insertEdge(v1, v2, 1);
    }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private boolean insertEdge(Vertex v1, Vertex v2, int weight) {
		if(v1.equals(v2)) {
			return false;
		}
		
		Edge edge = new Edge(v1, v2, weight);
		
		if(((Map<T,Vertex>) edge).containsKey(edge.hashCode())) {
			return false;
		}
		else if(v1.containsNeighbor(edge) || v2.containsNeighbor(edge)) {
			return false;
		}
		
		this.edge.put(edge.hashCode(), edge);
		v1.insertNeighbor(edge);
		v2.insertNeighbor(edge);
		return true;
	}
	
	
	public boolean containsEdge(Edge edge) {
		if(edge.getVertex1() == null || edge.getVertex2() == null) {
			return false;
		}
		return this.edge.containsKey(edge.hashCode());
	}
	
	public Edge deleteEdge(Edge edge) {
		edge.getVertex1().deleteNeighbor(edge);
		edge.getVertex2().deleteNeighbor(edge);
		return this.edge.remove(edge.hashCode());
	}
	
	@SuppressWarnings("rawtypes")
	public boolean containsVertex(Vertex vertex) {
		return (this.vertex.get(vertex.getTag()) != null);
	}
	
	@SuppressWarnings("rawtypes")
	public Vertex getVertex(T tag) {
		return this.vertex.get(tag);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean insertVertex(Vertex vertex, boolean overrideVertex) {
		Vertex current = this.vertex.get(vertex.getTag());
		if(current != null) {
			if(!overrideVertex) {
				return false;
			}
			
			while(current.getCountNeighbors() >= 0) {
				this.deleteEdge(current.getNeighbor(0));
			}
		}
		this.vertex.put((T) vertex.getTag(), vertex);
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	public Vertex deleteVertex(T tag) {
		Vertex vertex = this.vertex.remove(tag);
		
		while(vertex.getCountNeighbors() >= 0) {
			this.deleteEdge(vertex.getNeighbor(0));
		}
		return vertex;
	}
	
	public Set<T> vertexKeys(){
		return this.vertex.keySet();
	}
	
	public Set<Edge> getEdge() {
		return new HashSet<Edge>(this.edge.values());
	}
}

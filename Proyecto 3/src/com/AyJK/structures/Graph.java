package com.AyJK.structures;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author AyJK
 *
 * @param <T>
 */

public class Graph<T extends Comparable<T>> {
	
	/**
	 * Atributos de la clase
	 */
	@SuppressWarnings("rawtypes")
	private HashMap<T, Vertex> vertex;
	private HashMap<Integer, Edge> edge;
	@SuppressWarnings("rawtypes")
	private Vertex parent;
	
    /**
     * Constructor de la clase por defecto
     */
    @SuppressWarnings("rawtypes")
	public Graph() {
    	this.vertex = new HashMap<T, Vertex>();
    	this.edge = new HashMap<Integer, Edge>();
    }
    
    /**
     * Constructor de la clase que recibe una lista de vértices
     * 
     * @param vertex
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Graph(ArrayList<Vertex> vertex) {
    	this.vertex = new HashMap<T, Vertex>();
    	this.edge = new HashMap<Integer, Edge>();

    	for(Vertex v : vertex)
    	    {
    		this.vertex.put((T) v.getTag(), v);
    	    }
    }
    
    
    /**
     * Método que retorna el valor de lo que da la función insertEdge
     * 
     * @param v1
     * @param v2
     * @return
     */
    @SuppressWarnings("rawtypes")
	public boolean insertEdge(Vertex v1, Vertex v2) {
    	return insertEdge(v1, v2, 1);
    }

	/**
	 * Este método valida que no exista la arista que se está pretendiendo crear
	 * y si no está creada, se hace la relación entre los vértices
	 * 
	 * @param v1
	 * @param v2
	 * @param weight
	 * @return:
	 * 			true si se crea la arista y false si ya existía
	 */
	@SuppressWarnings({ "rawtypes" })
	private boolean insertEdge(Vertex v1, Vertex v2, int weight) {
		if(v1.equals(v2)) {
			return false;
		}
		
		Edge edge = new Edge(v1, v2, weight);
		
		if((this.edge.containsKey(edge.hashCode()))) {
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
	
	
	/**
	 * Método que retorna si una arista ya está relacionada
	 * 
	 * @param edge
	 * @return:
	 * 			true si las arista existe, false si la arista que se insertó no tiene
	 * 			relación con algún vértice (o bien, no existe)
	 */
	public boolean containsEdge(Edge edge) {
		if(edge.getVertex1() == null || edge.getVertex2() == null) {
			return false;
		}
		return this.edge.containsKey(edge.hashCode());
	}
	
	
	
	/**
	 * Método que elimina la relación (arista) entre dos vértices
	 * 
	 * @param edge
	 * @return
	 */
	public Edge deleteEdge(Edge edge) {
		edge.getVertex1().deleteNeighbor(edge);
		edge.getVertex2().deleteNeighbor(edge);
		return this.edge.remove(edge.hashCode());
	}
	
	/**
	 * Método que retorna si existe el vértice indicado en el grafo
	 * 
	 * @param vertex
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean containsVertex(Vertex vertex) {
		return (this.vertex.get(vertex.getTag()) != null);
	}
	
	/**
	 * Método con el que se obtiene el vértice con cierta etiqueta
	 * 
	 * @param tag
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Vertex getVertex(T tag) {
		return this.vertex.get(tag);
	}
	
	/**
	 * Método que revisa si el vértice no está, crea uno nuevo,
	 * en caso de que esté, se sobreescribe o no se hace nada
	 * 
	 * @param vertex
	 * @param overrideVertex
	 * @return
	 */
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
		
	
	
	/**
	 * Método para conocer las etiquetas del grafo
	 * 
	 * @return:
	 * 			Las etiquetas de los vértices contenidos en el grafo
	 */
	public Set<T> vertexKeys(){
		return this.vertex.keySet();
	}
	
	/**
	 * Método que retorna los valores de las aristas
	 * @return
	 */
	public Set<Edge> getEdge() {
		return new HashSet<Edge>(this.edge.values());
	}

	/**
	 * @return the parent
	 */
	@SuppressWarnings("rawtypes")
	public Vertex getParent() {
		return this.parent.getParent();
	}

	/**
	 * @param parent the parent to set
	 */
	@SuppressWarnings("rawtypes")
	public void setParent(Vertex parent) {
		this.parent = parent.setParent1(parent);
	}
}

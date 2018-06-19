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
     * Constructor de la clase que recibe una lista de v�rtices
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
     * M�todo que retorna el valor de lo que da la funci�n insertEdge
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
	 * Este m�todo valida que no exista la arista que se est� pretendiendo crear
	 * y si no est� creada, se hace la relaci�n entre los v�rtices
	 * 
	 * @param v1
	 * @param v2
	 * @param weight
	 * @return:
	 * 			true si se crea la arista y false si ya exist�a
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
	 * M�todo que retorna si una arista ya est� relacionada
	 * 
	 * @param edge
	 * @return:
	 * 			true si las arista existe, false si la arista que se insert� no tiene
	 * 			relaci�n con alg�n v�rtice (o bien, no existe)
	 */
	public boolean containsEdge(Edge edge) {
		if(edge.getVertex1() == null || edge.getVertex2() == null) {
			return false;
		}
		return this.edge.containsKey(edge.hashCode());
	}
	
	
	
	/**
	 * M�todo que elimina la relaci�n (arista) entre dos v�rtices
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
	 * M�todo que retorna si existe el v�rtice indicado en el grafo
	 * 
	 * @param vertex
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean containsVertex(Vertex vertex) {
		return (this.vertex.get(vertex.getTag()) != null);
	}
	
	/**
	 * M�todo con el que se obtiene el v�rtice con cierta etiqueta
	 * 
	 * @param tag
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Vertex getVertex(T tag) {
		return this.vertex.get(tag);
	}
	
	/**
	 * M�todo que revisa si el v�rtice no est�, crea uno nuevo,
	 * en caso de que est�, se sobreescribe o no se hace nada
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
	 * M�todo para conocer las etiquetas del grafo
	 * 
	 * @return:
	 * 			Las etiquetas de los v�rtices contenidos en el grafo
	 */
	public Set<T> vertexKeys(){
		return this.vertex.keySet();
	}
	
	/**
	 * M�todo que retorna los valores de las aristas
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

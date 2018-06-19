package com.AyJK.structures;

import java.util.ArrayList;

/**
 * 
 * @author AyJK
 *
 * @param <T>
 */

/**
 * @author HP
 *
 * @param <T>
 */
/**
 * @author HP
 *
 * @param <T>
 */
/**
 * @author HP
 *
 * @param <T>
 */
/**
 * @author HP
 *
 * @param <T>
 */
public class Vertex<T extends Comparable<T>> {
	
	/**
	 * Atributos de la clase
	 */
	private ArrayList<Edge> neighborhood;
	@SuppressWarnings("rawtypes")
	private Vertex parent;
	@SuppressWarnings("rawtypes")
	private Graph child;
	private T tag;
	
	
	/**
	 * Constructor que recibe un parámetro por el cual se le conocerá al vértice
	 * @param tag
	 */
	public Vertex(T tag) {
		this.tag = tag;
		this.neighborhood = new ArrayList<Edge>();	
	}
	
		
	/**
	 * Constructor para crear instancias con un hijo definido
	 * 
	 * @param tag
	 * @param child
	 */
	@SuppressWarnings("rawtypes")
	public Vertex(T tag, Graph child) {
		this.tag= tag;
		this.setChild(child);
		this.child.setParent(this);
		this.neighborhood = new ArrayList<Edge>();
	}
	
	
	/**
	 * Método que revisa que si no existe la arista que se le pasa como parámetro
	 * la agrega
	 * 
	 * @param edge
	 */
	public void insertNeighbor(Edge edge) {
		if(!this.neighborhood.contains(edge)) {
			this.neighborhood.add(edge);
		}
	}

	/**
	 * Método que retorna si la arista ya está definida
	 * 
	 * @param edge
	 * @return
	 */
	public boolean containsNeighbor(Edge edge) {
		return this.neighborhood.contains(edge);
	}
	
	/**
	 * Getters y setters
	 */
	
	/**
	 * @param index
	 * @return
	 */
	public Edge getNeighbor(int index) {
		return this.neighborhood.get(index);
	}
	
	public Edge deleteNeighbor(int index) {
		return this.neighborhood.remove(index);
	}
	
	/**
	 * @param edge
	 */
	public void deleteNeighbor(Edge edge) {
		this.neighborhood.remove(edge);
	}
	
	public int getCountNeighbors() {
		return this.neighborhood.size();
	}
	
	public T getTag() {
		return this.tag;
	}
	
	
	
	/**
	 * Método que compara las etiquetas de 2 vértices
	 * 
	 * @param v2
	 * @return:
	 * 			true, si las etiquetas tienen el mismo valor, de lo contrario, false
	 */
	public boolean equals(Object v2) {
		if(!(v2 instanceof Vertex)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Vertex<T> v = (Vertex<T>) v2;
		return this.tag.equals(v.tag);
	}
	
	
	
	/**
	 * Método que devuelve el identificador del vértice como un string
	 * 
	 * @return:
	 * 			String que contiene la etiqueta con la que que se identifica el vértice
	 */
	public String toString() {
		return "Vertex: " + (String) this.tag;
	}
	
	/**
	 * Método que devuelve el valor del vértice
	 * @return
	 */
	public int hashCode() {
		return this.getTag().hashCode();
	}
	
	
	/**
	 * Método que devuelve la lista con los vértices o nodos adyacentes
	 * 
	 * @return:
	 * 			ArrayList con los vértices adyacentes
	 */
	public ArrayList<Edge> getNeighbors(){
		return new ArrayList<Edge>(this.neighborhood);
	}

	/**
	 * Getters y setters 
	 */ 

	@SuppressWarnings("rawtypes")
	public Vertex getParent() {
		return parent;
	}

	/**
	 * @param parent
	 */
	@SuppressWarnings("rawtypes")
	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	
	/**
	 * @param parent
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Vertex setParent1(Vertex parent) {
		this.parent = parent;
		return this.parent;
	}

	@SuppressWarnings("rawtypes")
	public Graph getChild() {
		return child;
	}

	/**
	 * @param child
	 */
	@SuppressWarnings("rawtypes")
	public void setChild(Graph child) {
		this.child = child;
	}
}

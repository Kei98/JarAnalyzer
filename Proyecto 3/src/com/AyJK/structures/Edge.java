package com.AyJK.structures;

/**
 * 
 * @author AyJK
 *
 */

public class Edge implements Comparable<Edge>{
	
	
	/**
	 * Atributos de la clase
	 */
	@SuppressWarnings("rawtypes")
	private Vertex vertex1, vertex2;
	private int weight;
	
	
	/**
	 * Constructor que recibe los v�rtices que se desean relacionar
	 * 
	 * @param v1
	 * @param v2
	 */
	@SuppressWarnings("rawtypes")
	public Edge(Vertex v1, Vertex v2) {
		this(v1, v2, 1);
	}
	
	
	
	/**
	 * Constructor que recibe los v�rtices que se desean relacionar y el peso
	 * que va en la arista 
	 * 
	 * @param v1
	 * @param v2
	 * @param weight
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Edge(Vertex v1, Vertex v2, int weight) {
		if(v1.getTag().compareTo(v2.getTag()) <= 0) {
			this.vertex1 = v1;
			this.vertex2 = v2;
		}else {
			this.vertex1 = v2;
			this.vertex2 = v1;
		}
		this.weight = weight;
	}
	
	/**
	 * M�todo que busca el v�rtice vecino
	 * 
	 * @param current
	 * @return:
	 * 			v�rtice adyacente
	 */
	@SuppressWarnings("rawtypes")
	public Vertex getNeighborOf(Vertex current) {
		if(current.equals(this.vertex1)) {
			return this.vertex2;
		}
		else if(current.equals(this.vertex2)) {
			return this.vertex1;
		}else {
			return null;
		}
		
	}
	/*
	 * Getters y setters
	 */
	
	/**
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Vertex getVertex1() {
		return vertex1;
	}

	/**
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Vertex getVertex2() {
		return vertex2;
	}

	/**
	 * @return
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	/** 
	 * M�todo que devuelve la diferencia de peso 
	 * @param edge2
	 */
	@Override
	public int compareTo(Edge edge2) {
		return (this.weight - edge2.weight);
	}
	


	/**
	 * M�todo que retorna los dos v�rtices que est�n relacionados y el peso entre ellos
	 */
	public String toString() {
		return "({" + this.vertex1 + ", " + this.vertex2 + "}, " + this.weight + ")";
	}
	
	/**
	 * M�todo que retorna el hashcode de la suma de los 2 v�rtices relacionados
	 */
	public int hashCode() {
		return ((String) vertex1.getTag() + vertex2.getTag()).hashCode();
	}
	
	
	
	/**
	 * M�todo que dice si la arista est� correctamente colocada 
	 * 
	 * @param object
	 * @return:
	 * 			true, si la arista dada tiene los v�rtices que deber�a, false de lo contrario
	 */
	public boolean equals(Edge object) {
		if(!(object instanceof Edge)) {
			return false;
		}
		Edge edge2 = (Edge) object;
		
		if(edge2.vertex1.equals(this.vertex1) && edge2.vertex2.equals(this.vertex2)) {
			return true;
		}
		return false;
	}
	
}

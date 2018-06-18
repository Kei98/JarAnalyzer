package com.AyJK.structures;

public class Edge implements Comparable<Edge>{
	@SuppressWarnings("rawtypes")
	private Vertex vertex1, vertex2;
	private int weight;
	
	@SuppressWarnings("rawtypes")
	public Edge(Vertex v1, Vertex v2) {
		this(v1, v2, 1);
	}
	
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
	
	@SuppressWarnings("rawtypes")
	public Vertex getNeighbor(Vertex current) {
		if(current.equals(this.vertex1)) {
			return this.vertex2;
		}
		else if(current.equals(this.vertex2)) {
			return this.vertex1;
		}else {
			return null;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public Vertex getNeighborOf(Vertex current) {
		if(current.equals(this.vertex1)) {
			return this.vertex2;
		} 
		else if(current.equals(this.vertex2)) {
			return this.vertex1;
		}
		else {
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Vertex getVertex1() {
		return vertex1;
	}

	@SuppressWarnings("rawtypes")
	public Vertex getVertex2() {
		return vertex2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge edge2) {
		return (this.weight - edge2.weight);
	}

	public String toString() {
		return "({" + this.vertex1 + ", " + this.vertex2 + "}, " + this.weight + ")";
	}
	
	public int hashCode() {
		return ((String) vertex1.getTag() + vertex2.getTag()).hashCode();
	}
	
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

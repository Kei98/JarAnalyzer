package com.AyJK.structures;

import java.util.ArrayList;

public class Vertex<T extends Comparable<T>> {
	
	private ArrayList<Edge> neighborhood;
	@SuppressWarnings("rawtypes")
	private Graph parent;
	@SuppressWarnings("rawtypes")
	private Graph child;
	private T tag;
	
	public Vertex(T tag) {
		this.tag = tag;
		this.neighborhood = new ArrayList<Edge>();	
	}
	
	@SuppressWarnings("rawtypes")
	public Vertex(T tag, Graph parent) {
		this.tag= tag;
		this.setParent(parent);
		this.setChild(null);
		this.neighborhood = new ArrayList<Edge>();
	}
	
	@SuppressWarnings("rawtypes")
	public Vertex(T tag, Graph parent, Graph child) {
		this.tag= tag;
		this.setParent(parent);
		this.setChild(child);
		this.neighborhood = new ArrayList<Edge>();
	}
	
	
	public void insertNeighbor(Edge edge) {
		if(!this.neighborhood.contains(edge)) {
			this.neighborhood.add(edge);
		}
	}

	public boolean containsNeighbor(Edge edge) {
		return this.neighborhood.contains(edge);
	}
	
	public Edge getNeighbor(int index) {
		return this.neighborhood.get(index);
	}
	
	public Edge deleteNeighbor(int index) {
		return this.neighborhood.remove(index);
	}
	
	public void deleteNeighbor(Edge edge) {
		this.neighborhood.remove(edge);
	}
	
	public int getCountNeighbors() {
		return this.neighborhood.size();
	}
	
	public T getTag() {
		return this.tag;
	}
	
	public boolean equals(Object v2) {
		if(!(v2 instanceof Vertex)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Vertex<T> v = (Vertex<T>) v2;
		return this.tag.equals(v.tag);
	}
	
	public String toString() {
		return "Vértice: " + (String) this.tag;
	}
	
	public int hashCode() {
		return this.getTag().hashCode();
	}
	
	public ArrayList<Edge> getNeighbors(){
		return new ArrayList<Edge>(this.neighborhood);
	}

	@SuppressWarnings("rawtypes")
	public Graph getParent() {
		return parent;
	}

	@SuppressWarnings("rawtypes")
	public void setParent(Graph parent) {
		this.parent = parent;
	}

	@SuppressWarnings("rawtypes")
	public Graph getChild() {
		return child;
	}

	@SuppressWarnings("rawtypes")
	public void setChild(Graph child) {
		this.child = child;
	}
}

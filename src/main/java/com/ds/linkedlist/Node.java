package com.ds.linkedlist;

public class Node {
	private int data;
	private Node next;
	
	public Node() {
		
	}
	
	public Node(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node appendToTail(int data) {
		Node lastNode = this;
		while(lastNode.next != null) {
			lastNode = lastNode.next;
		}
		
		lastNode.next = new Node(data);
		
		return lastNode.next;
	}
	
	public void display() {
		
		Node current = this;
		while(current.next != null) {
			System.out.print(String.format("==> %d ", current.data));
			current = current.next; 
		}
		
	}
}

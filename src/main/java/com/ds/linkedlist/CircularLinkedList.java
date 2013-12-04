package com.ds.linkedlist;

public class CircularLinkedList {
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.appendToTail(2);
		head.appendToTail(3);
		Node tmpNode = head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(6);
		head.appendToTail(7);
		Node lastNode = head.appendToTail(8);
		
		lastNode.setNext(tmpNode);
		
		//head.display();
		
		findBeginning(head);

	}
	
	public static void findBeginning(Node head) {
		Node n1 = head;
		Node n2 = head;
		
		while(n2 != null) {
			
			if(n1.getNext() != null) {
				n1 = n1.getNext();
			}
			
			if(n2.getNext() != null && n2.getNext().getNext() != null) {
				n2 = n2.getNext().getNext();
			}
			
			//NOTE: n1 == n2 can be possible at any node in the circular links, thats is why we need to find beginning of the list from where circular list starts
			if(n1 == n2) {
				System.out.println(String.format(" circular link found, nodes are at : %d ", n1.getData()));
				break; 
			}
		}
		
		if(n1 == null) {
			System.out.println("circular link not found ");
			return;
		}
		
		// to identify the beginning of circular node, head star concept is used, fast guy has a head start of 3, then they will meet b4 n-3
		n1 = head;
		while(n1 != n2) {
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
		
		System.out.println(String.format(" circular link starts from here : %d", n2.getData()));
	}

}

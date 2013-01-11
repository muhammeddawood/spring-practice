package com.dp.composite;

public class Leaf implements IComponent {
	private String name;
	
	public Leaf(String name) {
		this.name = name;
	}

	@Override
	public void print(int depth) {
		String spaces = "";
		for(int i = 0; i < depth; i++) {
			spaces += " ";
		}
		
		System.out.println(String.format("%s</%s>", spaces, name));
	}

}

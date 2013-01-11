package com.dp.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements IComponent {
	private String name;
	private List<IComponent> components = new ArrayList<>();
	
	public Composite(String name) {
		this.name = name;
	}

	@Override
	public void print(int depth) {
		String spaces = "";
		for(int i = 0; i < depth; i++) {
			spaces += " ";
		}
		
		System.out.println(String.format("%s<%s>", spaces, name));
		
		for(IComponent component : components) {
			component.print((depth + 4));
		}
		
		System.out.println(String.format("%s</%s>", spaces, name));
	}
	
	public void addComponent(IComponent component) {
		components.add(component);
	}
	
	public void removeComponent(IComponent component) {
		components.remove(component);
	}
}

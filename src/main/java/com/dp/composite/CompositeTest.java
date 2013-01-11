package com.dp.composite;

public class CompositeTest {

	public static void main(String[] args) {
		Composite html = new Composite("html");
		Composite body = new Composite("body");
		Composite div1 = new Composite("div");
		Leaf h1 = new Leaf("h1");
		Leaf h2 = new Leaf("h2");
		
		html.addComponent(body);
		body.addComponent(div1);
		div1.addComponent(h1);
		div1.addComponent(h2);
		
		html.print(0);
	}
}

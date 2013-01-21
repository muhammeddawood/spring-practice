package com.dp.memento;

import com.dp.memento.Originator.Memento;

// memento pattern is used to restore an object to its previous state
// two objects involved originator and caretaker, originator has an internal state and caretaker 
public class MementoTest {
	public static void main(String[] args) {
		Originator o = new Originator();
		o.set("First");
		Memento m1 = o.saveToMemento();
		o.set("Second");
		Memento m2 = o.saveToMemento();
		o.set("Third");
		Memento m3 = o.saveToMemento();
		
		o.restoreFromMemento(m2);
		
	}
}

package com.dp.adapter;

public class AdapterTest {

	/**
	 * adapter also called wrapper pattern can also be written without interface
	 * converts the interface of a class to another interface which the client expects
	 */
	public static void main(String[] args) {
		LegacyLine legacyLine = new LegacyLine();
		legacyLine.draw(1, 1, 10, 10);

		Line line = new Line();
		line.draw(0, 0, 10, 10);
	}

}

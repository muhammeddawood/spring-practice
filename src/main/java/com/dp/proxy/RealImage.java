package com.dp.proxy;

public class RealImage implements Image {
	private String fileName;
	
	public RealImage(String fileName) {
		this.fileName = fileName;
		loadingImageFile();
	}

	private void loadingImageFile() {
		System.out.println("Loading image : " + fileName);
	}

	@Override
	public void displayImage() {
		System.out.println(" Displaying Image : " + fileName);
	}

}

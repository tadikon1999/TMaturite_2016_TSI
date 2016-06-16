package tests;

import java.awt.image.BufferedImage;


public class NamedBufferedImage {
	
	String name;
	BufferedImage image;
	public NamedBufferedImage(BufferedImage img, String n){
		name= n;
		image= img;
	}
	
	
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	public BufferedImage getImage(){
		return image;
	}
}

package tests;

import java.awt.Color;
import java.awt.Graphics;

public class GraphicObject {
	int x;
	int y;
	int lenght;
	int height;
	Color color;
	
	public GraphicObject(int x,int y,int lenght,int height,Color color){
		this.x=x;this.y=y;this.lenght=lenght;this.height=height;this.color=color;
		
	}
	
	public void paint(Graphics g){
		
	}
	
	public void tick(){
		
	}
}

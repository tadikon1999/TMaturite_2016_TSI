package tests;

import java.awt.Color;
import java.awt.Graphics;

public class PhysicObject {
	int x;
	int y;
	int lenght;
	int height;
	int velY;
	int velX;
	String type = "none";
	
	boolean visible = false;
	boolean gravity = false;
	boolean solid = false;
	
	Color color;
	
	public PhysicObject(int x, int y,boolean solid){
		this.x = x;
		this.y = y;
		this.solid = solid;
	}
	
	public int getX(){
		return x;
		
	}
	public void setX(int x){
		this.x =x;
	}
	
	public int getY(){
		return y;
		
	}
	public void setY(int y){
		this.y =y;
	}
	
	public int getLenght(){
		return lenght;
		
	}
	
	public int getHeight(){
		return height;
		
	}
	
	public Color getColor(){
		return color;
	}


	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	
	public void paint( Graphics g,int mx, int my){
		
	}
}

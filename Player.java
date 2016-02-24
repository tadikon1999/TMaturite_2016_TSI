package tests;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends PhysicObject{
	

	
	boolean stable = false;
		int startX;
		int startY;

	public Player(int x, int y) {
		super(x, y,false);
		// TODO Auto-generated constructor stub
		
		
		lenght = 32;
		height = 32;
		visible = true;
		gravity = true;
		type = "player";
		color = Color.BLUE;
		
	}

	
	
	public boolean getStable() {
		return stable;
	}

	public void setStable(boolean b) {
		stable = b;
	}
	
	public int getStartX() {
		return startX;
	}

	public void setStartX(int x) {
		this.startX = x;
	}
	
	public int getStartY() {
		return startX;
	}

	public void setStartY(int y) {
		this.startY = y;
	}
	@Override
	public void paint(Graphics g,int mx,int my){

		g.setColor(this.getColor());
		g.fillRect(this.getX()+mx, this.getY()+my, this.getLenght(), this.getHeight());
		
	}
	
	

}

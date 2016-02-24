package tests;

import java.awt.Color;
import java.awt.Graphics;

public class End extends PhysicObject{

	public End(int x, int y) {
		super(x, y, false);
		
		height = 20;
		lenght = 20;
		visible = true;
		gravity = true;
		type = "end";
		color = Color.red;
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics g,int mx,int my){

		g.setColor(this.getColor());
		g.fillRect(this.getX()+mx, this.getY()+my, this.getLenght(), this.getHeight());
		
	}

}

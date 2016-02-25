package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Block extends PhysicObject{



	public Block(int x, int y) {
		super(x, y,true);
		// TODO Auto-generated constructor stub
		lenght = 40;
		height = 40;
		visible = true;
		type = "block";
		
		color = Color.darkGray;
	}
	
	public void paint(Graphics g,int mx,int my){

		g.setColor(this.getColor());
		g.fillRect(this.getX()+mx, this.getY()+my, this.getLenght(), this.getHeight());
		
	}
	@Override
	public void tick(ArrayList<PhysicObject> Objects){
		
	}

}

package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Enemy extends PhysicObject{

	public Enemy(int x, int y) {
		super(x, y, false);
		
		height = 40;
		lenght = 30;
		visible = true;
		gravity = true;
		type = "enemy";
		color = Color.green;
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics g,int mx,int my){

		g.setColor(this.getColor());
		g.fillRect(this.getX()+mx, this.getY()+my, this.getLenght(), this.getHeight());
		
	}
	@Override
	public void tick(ArrayList<PhysicObject> Objects){
		
		if(Collides(World.getPlayer(), "enemy",Objects)){
			World.reset();
		}
		
	}
}
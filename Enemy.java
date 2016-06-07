package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends PhysicObject{
	int timer1 = 1;
	public Enemy(int x, int y) {
		super(x, y, false);
		
		height = 40;
		lenght = 30;
		visible = true;
		gravity = true;
		type = "enemy";
		color = Color.green;
		timer1=(int) Math.round(Math.random()*10+1);
		
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void tick(ArrayList<PhysicObject> Objects){
		if(timer1>10){
			timer1=1;
		}
		state = timer1;
		timer1++;
		if(Collides(World.getPlayer(), "enemy",Objects)){
			World.reset();
		}
		
	}
}
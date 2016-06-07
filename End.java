package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class End extends PhysicObject{
	int timer1 = 0;
			
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
	
	
	@Override
	public void tick(ArrayList<PhysicObject> Objects){
			if(timer1==0){
				state=2;
				

			}
			if(timer1==-20){
				
				state=1;
				timer1=20;
			}
		timer1--;
		if(Collides(Main.getWorld().getPlayer(), "end",Objects)){
			Main.getWorld().getPlayer().setVelX(0);
			Main.getWorld().getPlayer().setVelY(0);
			Main.getWorld().setCompletion(true);
			Main.setState("menu");
		}
		
	}

}

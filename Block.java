package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Block extends PhysicObject{



	public Block(int x, int y) {
		super(x, y,true);
		// TODO Auto-generated constructor stub
		lenght = 40;
		height = 40;
		visible = true;
		type = "block";
		int j=(int) (Math.random()*10);
		if(j<1){
			state=3;
		}else if(j<3){
			state=2;
		}else if(j<=10){
			state=1;
		}
		
		
		color = Color.darkGray;
	}
	
	
	@Override
	public void tick(ArrayList<PhysicObject> Objects){
		
	}

}

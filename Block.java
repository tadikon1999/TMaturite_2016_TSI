package tests;

import java.awt.Color;

public class Block extends PhysicObject{



	public Block(int x, int y) {
		super(x, y,true);
		// TODO Auto-generated constructor stub
		lenght = 40;
		height = 40;
		visible = true;
		
		color = Color.darkGray;
	}

}

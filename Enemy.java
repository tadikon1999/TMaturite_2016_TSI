package tests;

import java.awt.Color;

public class Enemy extends PhysicObject{

	public Enemy(int x, int y) {
		super(x, y, false);
		
		height = 40;
		lenght = 30;
		visible = true;
		gravity = true;
		color = Color.green;
		// TODO Auto-generated constructor stub
	}
}
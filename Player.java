package tests;

import java.awt.Color;

public class Player extends PhysicObject{
	

	
	boolean stable = false;

	public Player(int x, int y) {
		super(x, y,false);
		// TODO Auto-generated constructor stub
		lenght = 35;
		height = 35;
		visible = true;
		gravity = true;
		color = Color.BLUE;
		
	}

	
	
	public boolean getStable() {
		return stable;
	}

	public void setStable(boolean b) {
		stable = b;
	}
	
	

}

package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

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
	
	@Override
	public void tick(ArrayList<PhysicObject> Objects){
		//collision et mouvement vertical
				boolean collision = false;
				boolean stable = false;
				//sur une platforme?
				
				stable=IsStableOn(this, "block",Objects);
				
				this.setVelY(this.getVelY()+World.gravity);
				
				
				//max vertical
				if(this.getVelY()>this.getHeight()-1){
					this.setVelY(this.getHeight()-1);
				}else if(this.getVelY()<-(this.getHeight()-1)){
					this.setVelY(-(this.getHeight()-1));
				}
				
				
			
				//saut
				if (World.getBoard().isPressed("vK_Space")&&stable){
					this.setVelY((-13)*World.gravity);
					}		
				
				
				//bas
				if(this.getVelY()>=0){
				do {
					
					collision = false;

				
					collision=CollidesDown(this, "block",Objects);
				
				if (collision == true){
					this.setVelY(this.getVelY()-1);
				}
				
				
				}while(collision == true);}
				
				
				
				if(this.getVelY()<=0){
				//haut
				do{
					collision = false;
				
			
					collision = CollidesUp(this, "block",Objects);
				
				if (collision == true){
					this.setVelY(this.getVelY()+1);
				}
				
				
				//System.out.println(collision);
				}while(collision == true);}
				
				

				//sur une platforme?
				
				//stable=IsStableOn(this, "block",Objects);
				
				
				//saut
					/*if (World.getBoard().isPressed("vK_Space")&&stable){
						this.setVelY((-13)*World.gravity);
						}	*/	
						
					//vel en x et "friction"
					if (World.getBoard().isPressed("vK_D")&&!World.getBoard().isPressed("vK_A")){
						this.setVelX(this.getVelX()+6);
					} else if(World.getBoard().isPressed("vK_A")&&!World.getBoard().isPressed("vK_D")){
						this.setVelX(this.getVelX()-6);
					} else if(stable&&this.getVelX()<0){
						this.setVelX(this.getVelX()+2);
					} else if (stable&&this.getVelX()>0){
						this.setVelX(this.getVelX()-2);
					}
				
				
				//horizontal
				
				//droite
				if(this.getVelX()>=0){
					do {
						
						collision = false;
						
						collision = CollidesRight(this, "block",Objects);
					
					if (collision == true){
						this.setVelX(this.getVelX()-1);
					}
					
					}while(collision == true);}
					
					
					
					if(this.getVelX()<0){
					//gauche 
					do{
						collision = false;
					
					
						collision = CollidesLeft(this, "block",Objects);
					
					if (collision == true){
						this.setVelX(this.getVelX()+1);
					} 
					
					
					//System.out.println(collision);
					}while(collision == true);}
					
					
					
				//max horizontal
				
				if (this.getVelX()<-12){
					this.setVelX(-12);
				}
				if (this.getVelX()>12){
					this.setVelX(12);
				}
				
				
				//mouvement en x et y!
				this.setY(this.getY()+this.getVelY());
				this.setX(this.getX()+this.getVelX());
				
				
	}
	
	

}

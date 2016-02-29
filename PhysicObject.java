package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class PhysicObject {
	int x;
	int y;
	int lenght;
	int height;
	int velY;
	int velX;
	String type = "none";
	
	boolean visible = false;
	boolean gravity = false;
	boolean solid = false;
	
	Color color;
	
	public PhysicObject(int x, int y,boolean solid){
		this.x = x;
		this.y = y;
		this.solid = solid;
	}
	
	public int getX(){
		return x;
		
	}
	public void setX(int x){
		this.x =x;
	}
	
	public int getY(){
		return y;
		
	}
	public void setY(int y){
		this.y =y;
	}
	
	public int getLenght(){
		return lenght;
		
	}
	
	public int getHeight(){
		return height;
		
	}
	
	public Color getColor(){
		return color;
	}


	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	
	//methods to override
	
	public void paint( Graphics g,int mx, int my){
		
	}
	
	public void tick(ArrayList<PhysicObject> list){
		
	}
	
	
	
	
	
	
	//funcs de collisions!
	//haut
	protected boolean CollidesUp(PhysicObject player, String type, ArrayList<PhysicObject> Objects){
		boolean collision = false;
		
		for (int i=0;i<Objects.size();i++){
			if (player.getY()+player.getVelY()>=Objects.get(i).getY()
					&& player.getY()+player.getVelY()<=Objects.get(i).getY()+Objects.get(i).getLenght()
					&& Objects.get(i).getX()-player.getLenght()<=player.getX() 
					&& Objects.get(i).getX()+Objects.get(i).getLenght()>=player.getX()
					&&Objects.get(i).getType()==type){
				collision = true;
				} 
			}
		
		return collision;
		
	}

	//bas
	protected boolean CollidesDown(PhysicObject player, String type, ArrayList<PhysicObject> Objects){
		boolean collision = false;
		
		for (int i=0;i<Objects.size();i++){
			if (player.getY()+player.getVelY()+player.getHeight()>=Objects.get(i).getY()
					&& player.getY()+player.getVelY()+player.getHeight()<=Objects.get(i).getY()+Objects.get(i).getHeight()
					&& Objects.get(i).getX()-player.getLenght()<=player.getX() 
					&& Objects.get(i).getX()+Objects.get(i).getLenght()>=player.getX()
					&& Objects.get(i).getType()==type){
				collision = true;
				} 
			}
		
		return collision;
		
	}

	//droite
	protected boolean CollidesRight(PhysicObject player, String type, ArrayList<PhysicObject> Objects){
		boolean collision = false;
		
		for (int i=0;i<Objects.size();i++){
			if (player.getX()+player.getVelX()+player.getLenght()>=Objects.get(i).getX()
					&& player.getX()+player.getVelX()+player.getLenght()<=Objects.get(i).getX()+Objects.get(i).getLenght()
					&& Objects.get(i).getY()-player.getHeight()<=player.getY() 
					&& Objects.get(i).getY()+Objects.get(i).getHeight()>=player.getY()
					&&Objects.get(i).getType()==type){
				collision = true;
				} 
			}
		
		return collision;
		
	}

	//gauche
	protected boolean CollidesLeft(PhysicObject player, String type, ArrayList<PhysicObject> Objects){
		boolean collision = false;
		
		for (int i=0;i<Objects.size();i++){
			if (player.getX()+player.getVelX()>=Objects.get(i).getX()
					&& player.getX()+player.getVelX()<=Objects.get(i).getX()+Objects.get(i).getLenght()
					&& Objects.get(i).getY()-player.getHeight()<=player.getY() 
					&& Objects.get(i).getY()+Objects.get(i).getHeight()>=player.getY()
					&&Objects.get(i).getType()==type){
				collision = true;
				} 
			}
		
		return collision;
		
	}
	
	//stable?

	
	protected boolean IsStableOn(PhysicObject object, String type, ArrayList<PhysicObject> Objects){
		boolean stable = false;
		if (World.gravity>0){
			for (int i=0;i<Objects.size();i++){
				if (object.getVelY()==0&&object.getY()+(object.getHeight()+1)==Objects.get(i).getY() 
						&& Objects.get(i).getX()-object.getLenght()<=object.getX() 
						&& Objects.get(i).getX()+Objects.get(i).getLenght()>=object.getX()
						&&Objects.get(i).getType()==type){
					stable = true;
					
				}
				
			}
		}
		if (World.gravity<0){
			for (int i=0;i<Objects.size();i++){
				if (object.getVelY()==0&&object.getY()-(Objects.get(i).getHeight()+1)==Objects.get(i).getY() 
						&& Objects.get(i).getX()-object.getLenght()<=object.getX() 
						&& Objects.get(i).getX()+Objects.get(i).getLenght()>=object.getX()
						&&Objects.get(i).getType()==type){
					stable = true;
					
				}
			
			}
		}
		
		return stable;
	}
	

	
	protected boolean Collides(PhysicObject object, String type, ArrayList<PhysicObject> Objects){
		boolean col = false;
		
		for (int i=0;i<Objects.size();i++){
		if (object.getX()+object.getLenght()>=Objects.get(i).getX()
				&& object.getX()<=Objects.get(i).getX()+Objects.get(i).getLenght()
				&& object.getY()+object.getHeight()>=Objects.get(i).getY() 
				&& object.getY()<=Objects.get(i).getY()+Objects.get(i).getHeight()
				&&Objects.get(i).getType()==type){
			col = true;
			}
		}
		return col; 
	}
}

package tests;

import java.awt.Graphics;
import java.util.ArrayList;

public class Sprite extends GraphicObject{
	
	PhysicObject entity;

	public Sprite(PhysicObject e) {
		super(e);
		this.entity=e;
		this.x=entity.getX();
		this.y=entity.getY();
		this.lenght=entity.getLenght();
		this.height=entity.getHeight();
		this.color=entity.getColor();
		this.name=entity.getType();
		
	}
	
	
	public void tick(Panel pan){
		if(entity!=null){
			x=entity.getX();
			y=entity.getY();
			this.lenght=entity.getLenght();
			this.height=entity.getHeight();
			this.color=entity.getColor();
			this.name=entity.getType();
			this.state=entity.getState();
		}
		
	
	}
	public void paint(Graphics g,int mx, int my,ArrayList<NamedBufferedImage> img){

		for(int i=0;i<img.size();i++){

			if( img.get(i).getName().equals((name+state))){
				
				g.setColor(this.getColor());
				//g.fillRect(this.getX()+mx-1, this.getY()+my-1, this.getLenght()+2, this.getHeight()+2);
				g.drawImage(img.get(i).getImage(), x+mx-1, y+my-1,lenght+2,height+2, null);
			}
		}
		
	}


}

package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphicObject {
	int x;
	int y;
	int lenght;
	int height;
	int state = 1;
	Color color;
	String name;
	
	public GraphicObject(int x,int y,int lenght,int height,Color color,String name){
		this.x=x;this.y=y;this.lenght=lenght;this.height=height;this.color=color;this.name=name;
		
	}
	public GraphicObject(PhysicObject e){
	
	}
	
	public void paint(Graphics g,int mx, int my,ArrayList<NamedBufferedImage> img){
		for(int i=0;i<img.size();i++){
		//System.out.println((name+state));
			if( img.get(i).getName().equals((name+state))){
				System.out.println(x+":"+y);
				g.setColor(this.getColor());
				//g.fillRect(this.getX()+mx-1, this.getY()+my-1, this.getLenght()+2, this.getHeight()+2);
				g.drawImage(img.get(i).getImage(), x+mx-1, y+my-1,lenght+2,height+2, null);
			}
		}
		
	}
	
	public void tick(Panel pan){
		
	}
	
	public Color getColor(){
		return color;
	}
}

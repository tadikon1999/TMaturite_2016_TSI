package tests;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Button extends GraphicObject{
	String text;

	public Button(int x, int y, int lenght, int height, Color color,String text,String name) {
		super(x, y, lenght, height, color, name);this.text=text;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g,int mx, int my,ArrayList<NamedBufferedImage> img){
		for(int i=0;i<img.size();i++){
		//System.out.println((name+state));
			if( img.get(i).getName().equals((name+state))){
				
				g.setColor(this.getColor());
				//g.fillRect(this.getX()+mx-1, this.getY()+my-1, this.getLenght()+2, this.getHeight()+2);
				g.drawImage(img.get(i).getImage(), x, y,lenght,height, null);
			}
		}
		
	}
	
	public void tick(Panel pan){
		if(pan.getMouseX()>=x&&pan.getMouseX()<=x+lenght
				&&pan.getMouseY()>=y&&pan.getMouseY()<=y+height){
			state=2;
			if(Main.getBoard().isPressed("bT_1")){
				state=3;
			}
		} else {
			state=1;
		}
		
		
		
		
		if(state==3){
			switch (name){
			case "exit":
				System.exit(0);
				break;
			case "levelone":
				Main.setState("level1");
				break;
			case "leveltwo":
				Main.setState("level2");
				break;
			default :
				break;
			}
		}
	}
}

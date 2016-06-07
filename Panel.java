package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel{
	
	
	
	int x = 0;
	int y = 0;
	double mouseX;
	double mouseY;
	Keyboard keyboard;
	//private BufferedImage image;
	ArrayList<BuffedImage> images = new ArrayList<BuffedImage>();
	
	public Panel(Keyboard k){
		
		keyboard = k;
		File dossierImg = new File(Main.getPath()+"/images");
		String[] listeimages = dossierImg.list();
		for(int i=0;i<listeimages.length;i++){
			System.out.println(listeimages[i]);
			try{
				BufferedImage im= ImageIO.read(new File(Main.getPath()+"/images/"+listeimages[i]));
				
				images.add(i,new BuffedImage(im,listeimages[i].substring(0, listeimages[i].length()-4)));
			}catch(IOException ex){
			
			}
		}
		
		
		
	}
	
	
	
	public void paintComponent(Graphics g){
		this.setLocation(x, y);
		if(this.getMousePosition()!=null){
			mouseX = this.getMousePosition().getX();
			mouseY = this.getMousePosition().getY();
		} else {
			//System.out.println("closed");
		}
		
		
		this.setBackground(Color.white);
		
		g.setColor(Color.white);
		
		while(x+500>Main.getWorld().getPlayer().getX()){
			
			x--;
			
		}
		
		while(x+(this.getWidth()-500)<Main.getWorld().getPlayer().getX()){
			x++;
		}
		
		while(y+300>Main.getWorld().getPlayer().getY()){
			
			y--;
			
		}
		
		while(y+(this.getHeight()-300)<Main.getWorld().getPlayer().getY()){
			y++;
		}
		
		this.setLocation(1, 1);
		this.setLocation(0, 0);
		
		
		

		
		if(Main.getWorld()!=null&&Main.getState().substring(0,4).contains("leve")){
			for(int i=0;i<Main.getWorld().getObjects().size();i++){
				
				Main.getWorld().getObjects().get(i).paint(g, -x, -y,images);
			
			}
		}else if(Main.getState()=="menu"){
			if(keyboard.isPressed("bT_2")){
				System.out.println("PANEL:button 2 is pressed");
			}
		}
		
		
	}
	
	public double getMouseX(){
		return this.mouseX;
	}
	
	public double getMouseY(){
		return this.mouseY;
	}


	
	
	
	


}

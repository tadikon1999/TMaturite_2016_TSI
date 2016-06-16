package tests;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.HierarchyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import com.sun.xml.internal.ws.api.Component;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	
	
	int x = 0;
	int y = 0;
	double mouseX;
	double mouseY;
	Keyboard keyboard;
	//private BufferedImage image;
	ArrayList<NamedBufferedImage> images = new ArrayList<NamedBufferedImage>();

	
	public Panel(Keyboard k){
		this.setDoubleBuffered(true);
		keyboard = k;

		File dossierImg = new File(Main.getPath()+"/images");
		String[] listeimages = dossierImg.list();
		for(int i=0;i<listeimages.length;i++){
			System.out.println(listeimages[i]);
			try{
				BufferedImage im= ImageIO.read(new File(Main.getPath()+"/images/"+listeimages[i]));
				
				images.add(i,new NamedBufferedImage(im,listeimages[i].substring(0, listeimages[i].length()-4)));
			}catch(IOException ex){
			
			}
		}
		
		
		
	}
	
	
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		if(this.getMousePosition()!=null){
			mouseX = this.getMousePosition().getX();
			mouseY = this.getMousePosition().getY();
		} else {
			//System.out.println("closed");
		}

		this.setBackground(Color.white);
		
		g.setColor(Color.white);

		
		
		//move the world
		if(x+500>Main.getWorld().getPlayer().getX()){
			
			x=x-((x+500)-Main.getWorld().getPlayer().getX());
			
		}
		
		if(x+(this.getWidth()-500)<Main.getWorld().getPlayer().getX()){
			x=x+(Main.getWorld().getPlayer().getX()-(x+this.getWidth()-500));
		}
		
		if(y+300>Main.getWorld().getPlayer().getY()){
			
			y=y-((y+300)-Main.getWorld().getPlayer().getY());
			
		}
		
		if(y+(this.getHeight()-300)<Main.getWorld().getPlayer().getY()){
			y=y+(Main.getWorld().getPlayer().getY()-(y+this.getHeight()-300));
		}
		
		if(Main.getWorld()!=null&&Main.getState().substring(0,4).contains("leve")){
			for(int i=0;i<Main.getWorld().getObjects().size();i++){
				
				
				
				
				//paint the objects
				
				Main.getWorld().getObjects().get(i).getSprite().paint(g,-x,-y,images);
				
			
			}
		}else if(Main.getState()=="menu"){
			if(keyboard.isPressed("bT_2")){
				System.out.println("PANEL:button 2 is pressed");
				
				
			}
			for(int i=0;i<Main.getElements().size();i++){
				Main.getElements().get(i).paint(g, 0, 0, images);
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

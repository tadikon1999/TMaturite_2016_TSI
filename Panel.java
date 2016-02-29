package tests;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel{
	
	private Player player = World.player;
	private Block[] walls = World.walls;
	int x = 0;
	int y = 0;
	double mouseX;
	double mouseY;
	
	public Panel(){
		
		
		
	}
	
	public void setPlayer(Player player){
		this.player = player;
	}
	
	public void setBlocks(Block[] walls){
		this.walls=walls;
	}
	
	public void paintComponent(Graphics g){
		this.setLocation(x, y);
		if(this.getMousePosition()!=null){
			mouseX = this.getMousePosition().getX();
			mouseY = this.getMousePosition().getY();
		} else {
			System.out.println("closed");
		}
		
		
		this.setBackground(Color.white);
		g.setColor(Color.white);
		
		while(x+500>player.getX()){
			
			x--;
			
		}
		
		while(x+(this.getWidth()-500)<player.getX()){
			x++;
		}
		
		while(y+300>player.getY()){
			
			y--;
			
		}
		
		while(y+(this.getHeight()-300)<player.getY()){
			y++;
		}
		
		this.setLocation(1, 1);
		this.setLocation(0, 0);
		
		
		
		//this.setLocation(-player.getX()+450, -player.getY()+450);

		for(int i=0;i<World.getObjects().size();i++){
				
			World.getObjects().get(i).paint(g, -x, -y);
			
		}
		/*
		for (int i=0;i < walls.length; i++){
			g.setColor(walls[i].getColor());
			g.fillRect(walls[i].getX(), walls[i].getY(), walls[i].getLenght(), walls[i].getHeight());
		}
		for (int i=0;i < World.enemies.length; i++){
			g.setColor(World.enemies[i].getColor());
			g.fillRect(World.enemies[i].getX(), World.enemies[i].getY(), World.enemies[i].getLenght(), World.enemies[i].getHeight());
		}
		g.setColor(Color.red);
		g.fillRect(World.end.getX(), World.end.getY(), World.end.getLenght(), World.end.getHeight());
	*/}

	
	
	
	


}

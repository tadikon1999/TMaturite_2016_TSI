package tests;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel{
	
	private Player player = World.player;
	private Block[] walls = World.walls;
	
	public Panel(){
		
		
		
	}
	
	public void setPlayer(Player player){
		this.player = player;
	}
	
	public void setBlocks(Block[] walls){
		this.walls=walls;
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);

		//this.setLocation(-player.getX()+450, -player.getY()+450);

		g.clearRect(-1000, -1000, 2000, 2000);
		g.setColor(/*player.getColor()*/Color.blue);
		g.fillRect(player.getX(), player.getY(), player.getLenght(), player.getHeight());
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
	}

	
	
	
	


}

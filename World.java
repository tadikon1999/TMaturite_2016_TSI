package tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Scanner;

public class World {
	
	static boolean completed = false;
	
	static int gravity = 3;
	static int width = 800;
	static Block[] walls;
	static End end = new End(0, 0);
	static Enemy[] enemies;
	static Player player = new Player(0,0);
	private static ArrayList<PhysicObject> Objects = new ArrayList<PhysicObject>();
	private static Keyboard board = new Keyboard();
	private DataReader reader = new DataReader();
	private char[][] box;
	
	
	
	public World(String myFileLocation){
		
		
		
		String s = "error#1:no_file";
		
		
		
		try {
			s = this.reader.readFile(myFileLocation,StandardCharsets.UTF_8);
		} catch (IOException e) {
			
		}
		System.out.println(s);
		int i =1;
		int lenght = 0;
		int height;
		Scanner scanner2 = new Scanner(s);
		
		while (scanner2.hasNextLine()){
			String line = scanner2.nextLine();
			
			lenght = line.length();
			i++;
		}
		height = i;
		
		scanner2.close();
		
		
		Scanner scanner = new Scanner(s);
		
		i=0;
		box = new char[lenght][height];
		
		while (scanner.hasNextLine()&&i<height) {
		  String line = scanner.nextLine();
		  
		  

		  for(int k=0;k<lenght;k++){
			  
				 box[k][i] = line.toCharArray()[k];
				 
		  }
		  i++;
		  // process the line
		}
		scanner.close();
		
		int ene=0;
		int blocks = 0;
		
		for (int j =0;j<lenght;j++){
			for(int m =0;m<height;m++){
				if(box[j][m]=='0'){
					
					
					blocks++;
				}
				if(box[j][m]=='m'){
					
					
					ene++;
				}
				
			}
			
		}
		
		walls = new Block[blocks];
		enemies = new Enemy[ene];
		
		blocks = 0;
		ene = 0;
		
		for (int j =0;j<lenght;j++){
			for(int m =0;m<height;m++){
				if(box[j][m]=='0'){
					
					World.walls[blocks] = new Block(j*40,m*40);
					blocks++;
					Objects.add(new Block(j*40,m*40));
				}
				if(box[j][m]=='m'){
					
					World.enemies[ene] = new Enemy(j*40,m*40);
					ene++;
					Objects.add(new Enemy(j*40,m*40));
				}
				if(box[j][m]=='p'){
					player.setStartX(j*40);
					player.setStartY(m*40);
				}
				if(box[j][m]=='e'){
					end.setX(j*40);
					end.setY(m*40);
					Objects.add(new End(j*40,m*40));
				}
			}
			
		}
		
		player.setX(player.getStartX());
		player.setY(player.getStartY());
		
		Objects.add(player);
	
		

	}
	
	public void iterate(){
		
	/*	
		//collision et mouvement vertical
		boolean collision = false;
		boolean stable = false;
		player.setVelY(player.getVelY()+gravity);
		
		
		//max verticale
		if(player.getVelY()>player.getHeight()-1){
			player.setVelY(player.getHeight()-1);
		}else if(player.getVelY()<-(player.getHeight()-1)){
			player.setVelY(-(player.getHeight()-1));
		}
		
		
		//bas
		if(player.getVelY()>=0){
		do {
			
			collision = false;

		
			collision=CollidesDown(player, "block",Objects);
		
		if (collision == true){
			player.setVelY(player.getVelY()-1);
		}
		
		
		}while(collision == true);}
		
		
		
		if(player.getVelY()<=0){
		//haut
		do{
			collision = false;
		
	
			collision = CollidesUp(player, "block",Objects);
		
		if (collision == true){
			player.setVelY(player.getVelY()+1);
		}
		
		
		//System.out.println(collision);
		}while(collision == true);}
		
		

		//sur une platforme?
		
		stable=IsStableOn(player, "block",Objects);
		
		
		//saut
			if (board.isPressed("vK_Space")&&stable){
					player.setVelY((-13)*gravity);
				}		
				
			//vel en x et "friction"
			if (board.isPressed("vK_D")&&!board.isPressed("vK_A")){
				player.setVelX(player.getVelX()+4);
			} else if(board.isPressed("vK_A")&&!board.isPressed("vK_D")){
				player.setVelX(player.getVelX()-4);
			} else if(stable&&player.getVelX()<0){
				player.setVelX(player.getVelX()+2);
			} else if (stable&&player.getVelX()>0){
				player.setVelX(player.getVelX()-2);
			}
		
		
		//horizontal
		
		//droite
		if(player.getVelX()>=0){
			do {
				
				collision = false;
				
				collision = CollidesRight(player, "block",Objects);
			
			if (collision == true){
				player.setVelX(player.getVelX()-1);
			}
			
			}while(collision == true);}
			
			
			
			if(player.getVelX()<0){
			//gauche 
			do{
				collision = false;
			
			
				collision = CollidesLeft(player, "block",Objects);
			
			if (collision == true){
				player.setVelX(player.getVelX()+1);
			} 
			
			
			//System.out.println(collision);
			}while(collision == true);}
			
			
			
		//max horizontal
		
		if (player.getVelX()<-12){
			player.setVelX(-12);
		}
		if (player.getVelX()>12){
			player.setVelX(12);
		}
		
		if(Collides(player, "enemy",Objects)){
			reset();
		}
		
		//objet fin
		if(Collides(player, "end",Objects)){
			reset();
		}
		
		
		//mouvement en x et y!
		player.setY(player.getY()+player.getVelY());
		player.setX(player.getX()+player.getVelX());*/
		
		for(int i=0;i<Objects.size();i++){
			Objects.get(i).tick(Objects);
		}
		
		
		
		
		
		//reset
		if(board.isPressed("vK_R")){
			reset();
		}
		/*
		if(board.isPressed("vK_W")&&stable){
			gravity = -2;
		} 
		if(board.isPressed("vK_S")&&stable){
			gravity = 2;
		}*/
		
		// TIME MASTER
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	//gets and sets
	public static Player getPlayer(){
		return player;
	}
	
	public Block[] getBlocks(){
		return walls;
	}

	public static Keyboard getBoard() {
		return board;
	}

	public void setBoard(Keyboard board) {
		this.board = board;
	}
	
	
	
	
	
	
	
	
	
	
	//funcs de collisions!
	//haut
	private boolean CollidesUp(PhysicObject player, String type, ArrayList<PhysicObject> Objects){
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
	private boolean CollidesDown(PhysicObject player, String type, ArrayList<PhysicObject> Objects){
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
	private boolean CollidesRight(PhysicObject player, String type, ArrayList<PhysicObject> Objects){
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
	private boolean CollidesLeft(PhysicObject player, String type, ArrayList<PhysicObject> Objects){
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

	
	private boolean IsStableOn(PhysicObject object, String type, ArrayList<PhysicObject> Objects){
		boolean stable = false;
		if (gravity>0){
			for (int i=0;i<Objects.size();i++){
				if (object.getVelY()==0&&object.getY()+(object.getHeight()+1)==Objects.get(i).getY() 
						&& Objects.get(i).getX()-object.getLenght()<=object.getX() 
						&& Objects.get(i).getX()+Objects.get(i).getLenght()>=object.getX()
						&&Objects.get(i).getType()==type){
					stable = true;
				
				}
		
			}
		}
		if (gravity<0){
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
	

	
	private boolean Collides(PhysicObject object, String type, ArrayList<PhysicObject> Objects){
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
	
	
	public static void reset(){
		player.setX(player.startX);
		player.setY(player.startY);
		player.setVelX(0);
		player.setVelY(0);
		gravity = 2;
	}

	
	
	
	public static ArrayList<PhysicObject> getObjects() {
		return Objects;
	}

	public static void setObjects(ArrayList<PhysicObject> objects) {
		Objects = objects;
	}
	
	public static boolean getCompletion(){
		return completed;
	}
	public static void setCompletion(boolean completed){
		World.completed = completed;
		
	}

}

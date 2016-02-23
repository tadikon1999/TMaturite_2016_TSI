package tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.chrono.IsoChronology;
import java.util.Scanner;

public class World {
	
	int gravity = 2;
	static int width = 800;
	static Block[] walls;
	static End end = new End(0, 0);
	static Enemy[] enemies;
	static Player player = new Player(0,0);
	private Keyboard board = new Keyboard();
	private DataReader reader = new DataReader();
	private char[][] box;
	
	
	public World(String myFileLocation){
		
		
		
		String s = "error#1:no_file";
		
		
		
		try {
			s = this.reader.readFile(myFileLocation,StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		int i =0;
		box = new char[20][20];
		Scanner scanner = new Scanner(s);
		while (scanner.hasNextLine()&&i<20) {
		  String line = scanner.nextLine();
		  System.out.println("line: "+i);
		  System.out.println(line);
		  

		  for(int k=0;k<20;k++){
			  System.out.println(k+"  "+i);
				 box[k][i] = line.toCharArray()[k];
				 
		  }
		  i++;
		  // process the line
		}
		scanner.close();
		
		int ene=0;
		int blocks = 0;
		
		for (int j =0;j<20;j++){
			for(int m =0;m<20;m++){
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
		
		for (int j =0;j<20;j++){
			for(int m =0;m<20;m++){
				if(box[j][m]=='0'){
					
					World.walls[blocks] = new Block(j*40,m*40);
					blocks++;
				}
				if(box[j][m]=='m'){
					
					World.enemies[ene] = new Enemy(j*40,m*40);
					ene++;
				}
				if(box[j][m]=='p'){
					player.setX(j*40);
					player.setY(m*40);
				}
				if(box[j][m]=='e'){
					end.setX(j*40);
					end.setY(m*40);
				}
			}
			
		}
	
		

	}
	
	public void iterate(){
		
		
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

		
			collision=CollidesDown(player, walls);
		
		if (collision == true){
			player.setVelY(player.getVelY()-1);
		}
		
		
		}while(collision == true);}
		
		
		
		if(player.getVelY()<=0){
		//haut
		do{
			collision = false;
		
	
			collision = CollidesUp(player, walls);
		
		if (collision == true){
			player.setVelY(player.getVelY()+1);
		}
		
		
		//System.out.println(collision);
		}while(collision == true);}
		
		

		//sur une platforme?
		
		stable=IsStableOn(player, walls);
		
		
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
				
				collision = CollidesRight(player, walls);
			
			if (collision == true){
				player.setVelX(player.getVelX()-1);
			}
			
			}while(collision == true);}
			
			
			
			if(player.getVelX()<0){
			//gauche 
			do{
				collision = false;
			
			
				collision = CollidesLeft(player, walls);
			
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
		
		if(Collides(player, enemies)){
			player.setX(680);
			player.setY(680);
			player.setVelX(0);
			player.setVelY(0);
		}
		
		//objet fin
		if(Collides(player, end)){
			player.setX(200);
			player.setY(680);
			player.setVelX(0);
			player.setVelY(0);
		}
		
		
		//mouvement en x et y!
		player.setY(player.getY()+player.getVelY());
		player.setX(player.getX()+player.getVelX());
		
		
		
		
		
		
		
		//reset
		if(board.isPressed("vK_R")){
			player.setX(680);
			player.setY(680);
			player.setVelX(0);
			player.setVelY(0);
		}
		
		if(board.isPressed("vK_W")){
			gravity = -2;
		} 
		if(board.isPressed("vK_S")){
			gravity = 2;
		}
		
		// TIME MASTER
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	//gets et sets
	public Player getPlayer(){
		return player;
	}
	
	public Block[] getBlocks(){
		return walls;
	}

	public Keyboard getBoard() {
		return board;
	}

	public void setBoard(Keyboard board) {
		this.board = board;
	}
	
	
	
	
	
	
	
	
	
	
	//funcs de collisions!
	//haut
	private boolean CollidesUp(PhysicObject player, PhysicObject[] solids){
		boolean collision = false;
		
		for (int i=0;i<solids.length;i++){
			if (player.getY()+player.getVelY()>=solids[i].getY()
					&& player.getY()+player.getVelY()<=solids[i].getY()+solids[i].getLenght()
					&& solids[i].getX()-player.getLenght()<=player.getX() 
					&& solids[i].getX()+solids[i].getLenght()>=player.getX()){
				collision = true;
				} 
			}
		
		return collision;
		
	}
	private boolean CollidesUp(PhysicObject player, PhysicObject solid){
		boolean collision = false;
		
		
		if (player.getY()+player.getVelY()>=solid.getY()
				&& player.getY()+player.getVelY()<=solid.getY()+solid.getHeight()
				&& solid.getX()-player.getLenght()<=player.getX() 
				&& solid.getX()+solid.getLenght()>=player.getX()){
			collision = true;
			} 
			
		
		return collision;
		
	}
	//bas
	private boolean CollidesDown(PhysicObject player, PhysicObject[] solids){
		boolean collision = false;
		
		for (int i=0;i<solids.length;i++){
			if (player.getY()+player.getVelY()+player.getHeight()>=solids[i].getY()
					&& player.getY()+player.getVelY()+player.getHeight()<=solids[i].getY()+solids[i].getHeight()
					&& solids[i].getX()-player.getLenght()<=player.getX() 
					&& solids[i].getX()+solids[i].getLenght()>=player.getX()){
				collision = true;
				} 
			}
		
		return collision;
		
	}
	private boolean CollidesDown(PhysicObject player, PhysicObject solid){
		boolean collision = false;
		
		
		if (player.getY()+player.getVelY()+player.getHeight()>=solid.getY()
				&& player.getY()+player.getVelY()+player.getHeight()<=solid.getY()+solid.getHeight()
				&& solid.getX()-player.getLenght()<=player.getX() 
				&& solid.getX()+solid.getLenght()>=player.getX()){
			collision = true;
			} 
			
		
		return collision;
		
	}
	//droite
	private boolean CollidesRight(PhysicObject player, PhysicObject[] solids){
		boolean collision = false;
		
		for (int i=0;i<solids.length;i++){
			if (player.getX()+player.getVelX()+player.getLenght()>=solids[i].getX()
					&& player.getX()+player.getVelX()+player.getLenght()<=solids[i].getX()+solids[i].getLenght()
					&& solids[i].getY()-player.getHeight()<=player.getY() 
					&& solids[i].getY()+solids[i].getHeight()>=player.getY()){
				collision = true;
				} 
			}
		
		return collision;
		
	}
	private boolean CollidesRight(PhysicObject player, PhysicObject solid){
		boolean collision = false;
		
		
		if (player.getX()+player.getVelX()+player.getLenght()>=solid.getX()
				&& player.getX()+player.getVelX()+player.getLenght()<=solid.getX()+solid.getLenght()
				&& solid.getY()-player.getHeight()<=player.getY() 
				&& solid.getY()+solid.getLenght()>=player.getY()){
			collision = true;
			} 
			
		
		return collision;
		
	}
	//gauche
	private boolean CollidesLeft(PhysicObject player, PhysicObject[] solids){
		boolean collision = false;
		
		for (int i=0;i<solids.length;i++){
			if (player.getX()+player.getVelX()>=solids[i].getX()
					&& player.getX()+player.getVelX()<=solids[i].getX()+solids[i].getLenght()
					&& solids[i].getY()-player.getHeight()<=player.getY() 
					&& solids[i].getY()+solids[i].getHeight()>=player.getY()){
				collision = true;
				} 
			}
		
		return collision;
		
	}
	private boolean CollidesLeft(PhysicObject player, PhysicObject solid){
		boolean collision = false;
		
		
		if (player.getX()+player.getVelX()>=solid.getX()
				&& player.getX()+player.getVelX()<=solid.getX()+solid.getLenght()
				&& solid.getY()-player.getHeight()<=player.getY() 
				&& solid.getY()+solid.getHeight()>=player.getY()){
			collision = true;
			} 
			
		
		return collision;
		
	}
	//stable?
	private boolean IsStableOn(PhysicObject object, PhysicObject[] ground){
		boolean stable = false;
		if (gravity>0){
			for (int i=0;i<ground.length;i++){
				if (object.getVelY()==0&&object.getY()+(object.getHeight()+1)==ground[i].getY() 
						&& ground[i].getX()-object.getLenght()<=object.getX() 
						&& ground[i].getX()+ground[i].getLenght()>=object.getX()){
					stable = true;
				
				}
		
			}
		}
		if (gravity<0){
			for (int i=0;i<ground.length;i++){
				if (object.getVelY()==0&&object.getY()-(ground[i].getHeight()+1)==ground[i].getY() 
						&& ground[i].getX()-object.getLenght()<=object.getX() 
						&& ground[i].getX()+ground[i].getLenght()>=object.getX()){
					stable = true;
					
				}
			
			}
		}
		return stable;
	}
	private boolean IsStableOn(PhysicObject object, PhysicObject ground){
		boolean stable = false;

		if (object.getVelY()==0&&object.getY()+object.getHeight()+1==ground.getY() 
				&& ground.getX()-object.getLenght()<=object.getX() 
				&& ground.getX()+ground.getLenght()>=object.getX()){
			stable = true;
				
		}
		
		return stable;
	}
	
	private boolean Collides(PhysicObject object, PhysicObject object2){
		boolean col = false;
		
		
		if (object.getX()+object.getLenght()>=object2.getX()
				&& object.getX()<=object2.getX()+object2.getLenght()
				&& object.getY()+object.getHeight()>=object2.getY() 
				&& object.getY()<=object2.getY()+object2.getHeight()){
			col = true;
			}
		return col; 
	}
	
	private boolean Collides(PhysicObject object, PhysicObject[] object2){
		boolean col = false;
		
		for (int i=0;i<object2.length;i++){
		if (object.getX()+object.getLenght()>=object2[i].getX()
				&& object.getX()<=object2[i].getX()+object2[i].getLenght()
				&& object.getY()+object.getHeight()>=object2[i].getY() 
				&& object.getY()<=object2[i].getY()+object2[i].getHeight()){
			col = true;
			}
		}
		return col; 
	}

}

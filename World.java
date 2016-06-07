package tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class World {
	
	static boolean completed = false;
	
	static int gravity = 2;
	static int width = 800;
	
	static End end = new End(0, 0);
	
	static Player player = new Player(0,0);
	private  ArrayList<PhysicObject> Objects = new ArrayList<PhysicObject>();
	private  Keyboard board;
	private DataReader reader = new DataReader();
	private char[][] box;
	

	
	
	
	public World(String myFileLocation, Keyboard board){
		
		this.board = board;
		
		String s = "error#1:no_file";		
		
		
		try {
			s = this.reader.readFile(myFileLocation,StandardCharsets.UTF_8);
		} catch (IOException e) {
			
		}
		//System.out.println(s);
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
		
		
		
		
		blocks = 0;
		ene = 0;
		
		for (int j =0;j<lenght;j++){
			for(int m =0;m<height;m++){
				if(box[j][m]=='0'){
					
					
					blocks++;
					Objects.add(new Block(j*40,m*40));
				}
				if(box[j][m]=='m'){
					
					
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
		/*int j=0;
		for(int n=0;i<Objects.size();i++){
			if(Objects.get(i).getType()=="block"){
				j++;
			}
		}
		System.out.println(j);*/
	
		/*for (int j =0;j<height;j++){
			for(int m =0;m<lenght;m++){
				System.out.print(box[m][j]);
				
			}
			System.out.println();
		}*/

	}
	
	public void iterate(){
		
		
		for(int i=0;i<Objects.size();i++){
			Objects.get(i).tick(Objects);
		}
		
		
		
		
		
		//reset
		if(board.isPressed("vK_R")){
			reset();
		}
		
		/*//grav
		
		if(board.isPressed("vK_W")){
			if (gravity<0){
				gravity = 2;	
			}else if (gravity>0){
				gravity = -2;	
			}	
			
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
	
	//public Block[] getBlocks(){
	//}

	public  Keyboard getBoard() {
		return board;
	}

	public void setBoard(Keyboard b) {
		board = b;
	}
	
	
	
	
	
	
	
	
	
	
	



	
	

	

	
	
	public static void reset(){
		player.setX(player.startX);
		player.setY(player.startY);
		player.setVelX(0);
		player.setVelY(0);
		gravity = 2;
	}

	
	
	
	public  ArrayList<PhysicObject> getObjects() {
		return Objects;
	}

	public  void setObjects(ArrayList<PhysicObject> objects) {
		Objects = objects;
	}
	
	public  boolean getCompletion(){
		return completed;
	}
	public  void setCompletion(boolean completed){
		World.completed = completed;
		
	}

}

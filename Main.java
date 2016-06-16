package tests;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

import sun.audio.*;

//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//JAVAFX???
@SuppressWarnings("unused")
public class Main {
	static String s = "";
	static String state = "menu";
	static World world;
	private static String levelFolder = "lvls";
	static Frame display;
	static ArrayList<GraphicObject> displayedElements = new ArrayList<GraphicObject>();
	private DataReader reader = new DataReader();
	
	
	private static Keyboard Mboard = new Keyboard();
	
	/*String bip = "bip.mp3";
	Media hit = new Media(bip);
	MediaPlayer mediaPlayer = new MediaPlayer(hit);
	mediaPlayer.play();*/


	public static void main(String[] args) throws InterruptedException {
		
		//http://stackoverflow.com/questions/941754/how-to-get-a-path-to-a-resource-in-a-java-jar-file
		s = Main.class.getClassLoader().getResource("").toExternalForm();
		System.out.println(s);
		s=s.substring(6);
		display=new Frame();
		Mboard=display.getListener().getKeyboard();
		SoundPlayer soundPlayer = new SoundPlayer(s);
		displayedElements.add(new Button(200, 200, 100, 60, Color.blue, "no text", "exit"));
		displayedElements.add(new Button(200, 400, 100, 60, Color.blue, "no text", "levelone"));
		displayedElements.add(new Button(200, 600, 100, 60, Color.blue, "no text", "leveltwo"));
		GraphicThread gThread = new GraphicThread(display.getPan());
		gThread.start();

		 while(true){
			 if(state == "menu"){
				 
				// TIME MASTER
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
					for(int i=0;i<displayedElements.size();i++){
						displayedElements.get(i).tick(display.getPan());
					}

				 if(state=="level1"){
					 soundPlayer.playSound("mu1");
				 }
			 }
			 if(state.length()>4){
				 if(state.substring(0,5).contains("level")){
					
					 s=s+levelFolder+"/"+state;
					 System.out.println(s);
					 world=new World(s, Mboard);
					while(world.getCompletion()==false){
						
						//display.getPan().repaint();
						world.iterate();
						// TIME MASTER
						try {
							Thread.sleep(40);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						
						if(Mboard.isPressed("vK_Escape")){
							Main.setState("menu");
							break;
						}
					
					}
					world.setCompletion(false);
					
					
				 }
				 s=s.substring(0, s.length()-11);//11?->a changer
				soundPlayer.StopSound();
			 }
				 
		 }
			 
		 
		 
		
		
		

	}
	
	
	static public String getState(){
		return state;
	}
	static public void setState(String s){
		state = s;
	}
	public static World getWorld(){
		return world;
	}
	public static void setWorld(World w){
		world=w;
	}
	static public String getPath(){
		return s;
	}
	static public void setPath(String path){
		s = path;
	}
	public static Frame getFrame(){
		return display;
	}
	public static ArrayList<GraphicObject> getElements(){
		return displayedElements;
		
	}
	public static Keyboard getBoard(){
		return Mboard;
	}
	
	
}




package tests;

//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//JAVAFX???
public class Main {
	static String s = "";
	static String state = "menu";
	static World world;
	
	
	private static Keyboard Mboard = new Keyboard();
	
	/*String bip = "bip.mp3";
	Media hit = new Media(bip);
	MediaPlayer mediaPlayer = new MediaPlayer(hit);
	mediaPlayer.play();*/


	public static void main(String[] args) {
		
		//http://stackoverflow.com/questions/941754/how-to-get-a-path-to-a-resource-in-a-java-jar-file
		s = Main.class.getClassLoader().getResource("").toExternalForm();
		System.out.println(s);
		Frame display=new Frame();
		Mboard=display.getListener().getKeyboard();
		s=s.substring(6);
		
		
		
		 
		 while(true){
			 if(state == "menu"){
				 
				 if(Mboard.isPressed("vK_1")){
					System.out.println("1hi!"); 
					 state="level1";
				 }
				 if(Mboard.isPressed("vK_2")){
						System.out.println("2hi!"); 
						 state="level2";
					 }
			 }
			 if(state.length()>4){
				 if(state.substring(0,5).contains("level")){
					
					 s=s+"tests/"+state;
					 System.out.println(s);
					 world=new World(s, Mboard);
					while(world.getCompletion()==false){
						
						
						display.getPan().setPlayer(world.getPlayer());
						display.getPan().setBlocks(world.getBlocks());
						display.getPan().repaint();
						world.iterate();
					
					}
					world.setCompletion(false);
					
					
				 }
				 s=s.substring(0, s.length()-12);
				System.out.println("yolo");
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
	
	
}




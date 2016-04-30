package tests;

//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//JAVAFX???
public class Main {
	static String s = "";
	static String state = "menu";
	
	
	private static Keyboard Mboard = new Keyboard();
	
	/*String bip = "bip.mp3";
	Media hit = new Media(bip);
	MediaPlayer mediaPlayer = new MediaPlayer(hit);
	mediaPlayer.play();*/


	public static void main(String[] args) {
		
		//http://stackoverflow.com/questions/941754/how-to-get-a-path-to-a-resource-in-a-java-jar-file
		s = Main.class.getClassLoader().getResource("").toExternalForm();
		Frame display=new Frame();
		Mboard=display.getListener().getKeyboard();
		//s=s.substring(6)+"tests/test";
		
		 
		 
		 while(true){
			 if(state == "menu"){
				 
				 if(Mboard.isPressed("vK_1")){
					System.out.println("hi!"); 
					 state="level1";
				 }
				 if(Mboard.isPressed("vK_2")){
						System.out.println("hi!"); 
						 state="level2";
					 }
			 }
			 if(state.length()>4){
				 if(state.substring(0,5).contains("level")){
					 
					 s=s.substring(6)+"tests/"+state;
					 System.out.println(s);
					 World world= new World(s, Mboard);
					while(world.getCompletion()==false){
						
						
						world.iterate();
						display.getPan().setPlayer(world.getPlayer());
						display.getPan().setBlocks(world.getBlocks());
						display.getPan().repaint();
					
					} 
					
				 }
			 }
				 
		 }
			 
		 
		 
		
		
		

	}
	
	
	static public String getState(){
		return state;
	}
	static public void setState(String states){
		state = states;
	}

}

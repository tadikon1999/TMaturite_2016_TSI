package tests;

public class Main {
	static String s = "";
	static String state = "Menu";


	public static void main(String[] args) {
		
		//http://stackoverflow.com/questions/941754/how-to-get-a-path-to-a-resource-in-a-java-jar-file
		s = Main.class.getClassLoader().getResource("").toExternalForm();
		
		
		s=s.substring(6)+"tests/test";
		System.out.println(s);
		 World world= new World(s);
		 Frame display=new Frame();
		 
		while(world.getCompletion()==false){
			world.setBoard(display.getListener().getKeyboard());
			world.iterate();
			display.getPan().setPlayer(world.getPlayer());
			display.getPan().setBlocks(world.getBlocks());
			display.getPan().repaint();
			
		}
		System.exit(0);
		

	}
	
	
	static public String getState(){
		return state;
	}
	static public void setState(String states){
		state = states;
	}

}

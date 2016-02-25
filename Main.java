package tests;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Main {
	static String s = "";


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s = Main.class.getClassLoader().getResource("").toExternalForm();
		s=s.substring(6)+"tests/test";
		System.out.println(s);
		 World world= new World(s);
		 Frame display=new Frame();
		 
		while(true){
			world.setBoard(display.getListener().getKeyboard());
			world.iterate();
			display.getPan().setPlayer(world.getPlayer());
			display.getPan().setBlocks(world.getBlocks());
			display.getPan().repaint();
			
		}

	}

}

package tests;

public class Main {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 World world= new World("C:/Users/Tadeusz/Desktop/test.txt");
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

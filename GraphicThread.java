package tests;

import javax.swing.RepaintManager;

public class GraphicThread extends Thread{
	Panel panel;
	
	public GraphicThread(Panel pan) {
		panel = pan;
	}

	public void run() {
		while(true){
			panel.repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
    }
	

}

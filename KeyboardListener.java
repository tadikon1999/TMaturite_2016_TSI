package tests;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter{
	
	private Keyboard keyboard = new Keyboard();
		
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()){
		case KeyEvent.VK_W:
            // up arrow
			keyboard.setVK_W(true);
            break;
        case KeyEvent.VK_S:
            // down arrow
        	keyboard.setVK_S(true);
            break;
        case KeyEvent.VK_D:
            // right arrow
        	keyboard.setVK_D(true);
            break;
        case KeyEvent.VK_A:
            // left arrow
        	keyboard.setVK_A(true);
            break;
        case KeyEvent.VK_R:
            // R
        	keyboard.setVK_R(true);
            break;
        case KeyEvent.VK_SPACE:    
        	keyboard.setVK_Space(true);
        	break;
        case KeyEvent.VK_1:
            // up arrow
			keyboard.setVK_1(true);
            break;
        case KeyEvent.VK_2:
            // up arrow
			keyboard.setVK_2(true);
            break;
        default:
        	break;
    
		}
	}


    public void keyReleased(KeyEvent e) {
    	switch (e.getKeyCode()){
		case KeyEvent.VK_W:
            // up arrow
			keyboard.setVK_W(false);
            break;
        case KeyEvent.VK_S:
            // down arrow
        	keyboard.setVK_S(false);
            break;
        case KeyEvent.VK_D:
            // right arrow
        	keyboard.setVK_D(false);
            break;
        case KeyEvent.VK_A:
            // left arrow
        	keyboard.setVK_A(false);
            break;
        case KeyEvent.VK_R:
            // R
        	keyboard.setVK_R(false);
            break;
        case KeyEvent.VK_SPACE:    
        	keyboard.setVK_Space(false);
        	break;
        default:
        	break;
    
		}
    	
    }


	public Keyboard getKeyboard() {
		return keyboard;
	}


	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}
}

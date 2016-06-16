package tests;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputListener;

public class KeyboardListener extends KeyAdapter implements MouseListener{
	
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
        case KeyEvent.VK_ESCAPE:
            // up arrow
			keyboard.setVK_Escape(true);
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
        case KeyEvent.VK_1:
            // up arrow
			keyboard.setVK_1(false);
			
            break;
        case KeyEvent.VK_2:
            // up arrow
			keyboard.setVK_2(false);
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

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getButton()){
		case 1:
			keyboard.setbT_1(true);
			break;
		case 2:
			keyboard.setbT_2(true);
			break;
		case 3:
			keyboard.setbT_3(true);
			break;
		default:
			break;
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(e.getButton()){
		case 1:
			keyboard.setbT_1(false);
			break;
		case 2:
			keyboard.setbT_2(false);
			break;
		case 3:
			keyboard.setbT_3(false);
			break;
		default:
			break;
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

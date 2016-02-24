package tests;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	
	private KeyboardListener listener = new KeyboardListener();
	
	private Panel pan = new Panel();
	public Frame(){
		
		this.setTitle("R=reset");
		this.setSize(2000, 2000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(pan);
		this.addKeyListener(listener);
		
		this.setVisible(true);
		this.setBackground(Color.white);
		
	}
	public Panel getPan() {
		return pan;
	}

	public void setPan(Panel pan) {
		this.pan = pan;
	}
	public KeyboardListener getListener() {
		return listener;
	}
	public void setListener(KeyboardListener listener) {
		this.listener = listener;
	}

}

package tests;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Button extends GraphicObject{
	String text;
	int Size;
	public Button(int x, int y, int lenght, int height, Color color,String text,int size) {
		super(x, y, lenght, height, color);this.Size=size;this.text=text;
		// TODO Auto-generated constructor stub
	}
	
	
	public void paint(Graphics g){
		g.setColor(color);
		g.setFont(new Font("TimesRoman",Font.PLAIN,Size));
		g.fillRect(x, y, lenght, height);
		g.drawString(text, x+10, y+10);
	}
	
	public void tick(JPanel pan){
		//pan.getm
	}
}

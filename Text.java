package tests;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Text extends GraphicObject{
	
	String text;
	int Size;
	
	public Text(int x, int y, Color color, String text,int size) {
		super(x, y, 0, 0, color);this.text=text;this.Size=size;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(color);
		g.setFont(new Font("TimesRoman",Font.PLAIN,Size));
		g.drawString(text, x, y);
	}

}

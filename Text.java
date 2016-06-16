package tests;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Text extends GraphicObject{
	
	String text;
	int Size;
	
	public Text(int x, int y, Color color, String text,int size) {
		super(x, y, 0, 0, color, text);this.text=text;this.Size=size;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g,int mx, int my,ArrayList<NamedBufferedImage> img){
		g.setColor(color);
		g.setFont(new Font("TimesRoman",Font.PLAIN,Size));
		g.drawString(text, x, y);
	}

}

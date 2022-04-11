package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class SomePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage img;
	private GParagraph para;
	private GButton rect;


	public SomePane(MainApplication app) {
		this.program = app;
		//img = new GImage("robot head.jpg", 100, 100);
		
		rect = new GButton("Log out", 350, 350, 80, 50);
		rect.setFillColor(Color.gray);
		
		//para = new GParagraph("welcome\nto my\nsecret room!", 150, 300);
		//para.setFont("Arial-24");
	}

	@Override
	public void showContents() {
		//program.add(img);
		//program.add(para);
		program.add(rect);
	}

	@Override
	public void hideContents() {
		//program.remove(img);
		//program.remove(para);
		program.remove(rect);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToTask();//changed here
		}
	}
}

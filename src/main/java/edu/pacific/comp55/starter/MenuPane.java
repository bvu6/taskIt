package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.font.*;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import acm.graphics.GObject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class MenuPane extends GraphicsPane {
	private static final String EXIT_ON_CLOSE = null;
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton rect;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		rect = new GButton("Next", 50, 50, 100, 100);
		rect.setFillColor(Color.RED);
		
		
		
	}

	JFrame frame = new JFrame("textbox");
	JTextField textfield = new JTextField("", 10);
	
	public MenuPane() {
		frame.add(textfield);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	

	@Override
	public void showContents() {
		program.add(rect);
	
		
	}

	@Override
	public void hideContents() {
		program.remove(rect);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToSome();
		}
	}
}

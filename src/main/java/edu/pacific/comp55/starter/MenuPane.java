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
	private JTextField field1;
	private JTextField field2;
	private GParagraph pass;
	private GParagraph user;



	public MenuPane(MainApplication app) {
		super();
		program = app;
		rect = new GButton("login", 350, 350, 80, 50);
		rect.setFillColor(Color.cyan);
		
		pass = new GParagraph("\npassword", 290, 290);
		user = new GParagraph("user name", 282, 273);

		
	    JTextField field3 = new JTextField(10);

		
		field1 = new JTextField(10);
	    //field1.setText(10);
	    //add(field1);
	    field2 = new JTextField(10);
	    //field2.setText("          ");
	}

//	JFrame frame = new JFrame("textbox");
//	JTextField textfield = new JTextField("", 10);
	
	
	
	public MenuPane() {
		//frame.add(textfield);
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.pack();
		//frame.setVisible(true);
	}

	
	

	@Override
	public void showContents() {
		program.add(rect);
		program.getGCanvas().add(field1, 350, 290);//Need to put .getGCanvas().add 
		program.getGCanvas().add(field2, 350, 260);//Need to put .getGCanvas().add 
		program.add(pass);
		program.add(user);


	}

	@Override
	public void hideContents() {
		program.remove(rect);
		program.getGCanvas().remove(field1);
		program.getGCanvas().remove(field2);
		program.remove(pass);
		program.remove(user);


	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToSome();
		}
	}
}

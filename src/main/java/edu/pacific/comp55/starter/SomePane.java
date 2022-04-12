package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;


public class SomePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage img;
	private GParagraph displayUserName;
	private GButton rect;
	private GParagraph userName;
	
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;

	private GRect topRect;
	private GRect leftRect;
	private GRect rightRect;
	private GRect centerRect;


	
	public SomePane(MainApplication app) {
		this.program = app;
		//img = new GImage("robot head.jpg", 100, 100);
		
		topRect = new GRect(1000, 47);
		topRect.setFillColor(Color.BLUE);
		topRect.setFilled(true);
		topRect.sendToBack();
		
		leftRect = new GRect(0, 47, 90, 1000);
		leftRect.setFillColor(Color.cyan);
		leftRect.setFilled(true);
		leftRect.sendToBack();
		
		rightRect = new GRect(700, 47, 90, 1000);
		rightRect.setFillColor(Color.black);
		rightRect.setFilled(true);
		rightRect.sendToBack();
		
		
		centerRect = new GRect(90, 47, 610, 800);
		centerRect.setFillColor(Color.DARK_GRAY);
		centerRect.setFilled(true);
		centerRect.sendToBack();
		
		
		
		rect = new GButton("Log out", 730, 10, 40, 30);
		rect.setFillColor(Color.gray);
		
		displayUserName = new GParagraph("user name: ", 30, 30);
		//para.setFont("Arial-24");
		userName = new GParagraph("David", 95, 30);//will have to get user from MenuPane
		
	    one = new JButton("one");
	    two = new JButton("two");
	    three = new JButton("three");
	    four = new JButton("dark");

	    four.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                    
          	   	System.out.println("dark theme button pressed");

                	program.add(centerRect);
                                 
             }// end of actionPerformed
        }); //end of actionListener
	    
	}

	@Override
	public void showContents() {
		//program.add(img);
		program.add(topRect);
		program.add(leftRect);
		program.add(rightRect);
		//program.add(centerRect);

		program.add(displayUserName);
		program.add(userName);
		program.add(rect);
		program.getGCanvas().add(one, 12, 50);
		program.getGCanvas().add(two, 12, 90);
		program.getGCanvas().add(three, 12, 130);
		program.getGCanvas().add(four, 12, 170);
		



	}

	@Override
	public void hideContents() {
		//program.remove(img);
		program.remove(topRect);
		program.remove(leftRect);
		program.remove(rightRect);
		program.remove(centerRect);

		program.remove(displayUserName);
		program.remove(userName);
		program.remove(rect);
		program.getGCanvas().remove(one);
		program.getGCanvas().remove(two);
		program.getGCanvas().remove(three);
		program.getGCanvas().remove(four);
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		//para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToMenu();//changed here program.switchToTask()
		}
	}
}

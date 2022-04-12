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
	private GImage userIcon;
	private GImage editIcon;
	private GImage trashIcon;
	//private GParagraph displayUserName;
	private GButton logOutButton;
	private GParagraph userName;
	
	private JButton taskBoardTab;
	private JButton calendarTab;
	private JButton darkMode;
	private JButton lightMode;

	private GRect topRect;
	private GRect leftRect;
	private GRect rightRect;
	private GRect centerRect;

	
	public SomePane(MainApplication app) {
		this.program = app;
		userIcon = new GImage("userIcon.png", 5, 5);
		editIcon = new GImage("editIcon.png", 300,100);
		trashIcon = new GImage("trashIcon.png", 400,100);
		
		topRect = new GRect(1000, 47);
		//topRect.setFillColor(Color.BLUE);
		topRect.setFillColor(new Color(77,100,102));
		topRect.setFilled(true);
		topRect.sendToBack();
		
		leftRect = new GRect(0, 47, 150, 1000);
		//leftRect.setFillColor(Color.cyan);
		leftRect.setFillColor(new Color (120,158,158));
		leftRect.setFilled(true);
		leftRect.sendToBack();
		
		rightRect = new GRect(700, 47, 400, 1000);
		//rightRect.setFillColor(Color.black);
		rightRect.setFillColor(Color.GRAY);
		rightRect.setFilled(true);
		rightRect.sendToBack();
		
		
		centerRect = new GRect(150, 47, 550, 800);
		centerRect.setFillColor(new Color(58,58,58));
		centerRect.setFilled(true);
		centerRect.sendToBack();
		
		
		logOutButton= new GButton("Log out", 730, 10, 50, 30);
		logOutButton.setFillColor(Color.gray);
		
		//displayUserName = new GParagraph("User: ", 45, 30);
		//para.setFont("Arial-24");
		userName = new GParagraph("David", 45, 30);//will have to get user from MenuPane
		userName.setColor(Color.white);
		
		taskBoardTab = new JButton("Task Board");
		taskBoardTab.setBounds(0, 75, 150, 50);
		calendarTab = new JButton("Calendar");
		calendarTab.setBounds(0, 150, 150, 50);
	    darkMode = new JButton("Dark Mode");
	    darkMode.setBounds(0, 450, 150, 50);
	    lightMode = new JButton("Light Mode");
	    lightMode.setBounds(0, 450, 150, 50);

		darkMode.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                    
          	   	System.out.println("dark theme button pressed");

                	program.add(centerRect);
                	program.add(editIcon);
            		program.add(trashIcon);
                	program.getGCanvas().remove(darkMode);
                	program.getGCanvas().add(lightMode);                                 
             }// end of actionPerformed
        }); //end of actionListener
	   
		lightMode.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("light theme button pressed");
	    		program.remove(centerRect);
	    		program.getGCanvas().remove(lightMode);
	    		program.getGCanvas().add(darkMode);	    	}
	    });
	}

	@Override
	public void showContents() {
		//program.add(img);
		program.add(topRect);
		program.add(leftRect);
		program.add(rightRect);
		//program.add(centerRect);

		program.add(userIcon);
		//program.add(displayUserName);
		program.add(userName);
		program.add(logOutButton);
		
		program.getGCanvas().add(darkMode);
		
		program.add(editIcon);
		program.add(trashIcon);

		program.getGCanvas().add(taskBoardTab);
		program.getGCanvas().add(calendarTab);
		


	}

	@Override
	public void hideContents() {
		//program.remove(img);
		program.remove(topRect);
		program.remove(leftRect);
		program.remove(rightRect);
		program.remove(centerRect);

		program.remove(userIcon);
		//program.remove(displayUserName);
		program.remove(userName);
		program.remove(logOutButton);
		
		program.remove(editIcon);
		program.remove(trashIcon);
		
		program.getGCanvas().remove(taskBoardTab);
		program.getGCanvas().remove(calendarTab);
		program.getGCanvas().remove(darkMode);
		program.getGCanvas().remove(lightMode);
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		//para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == logOutButton) {
			program.switchToMenu();//changed here program.switchToTask()
		}
		else if(obj == editIcon) {
			System.out.println("Edit icon pressed");
		}
		else if(obj == trashIcon) {
			System.out.println("Trash icon pressed");
		}
	}
}

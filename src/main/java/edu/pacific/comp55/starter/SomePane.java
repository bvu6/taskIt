package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.Font;
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
	private GImage plusIcon;
	private GImage whitePlusIcon;
	private GImage editIcon;
	private GImage whiteEditIcon;

	private GImage deleteIcon;
	private GImage whiteDeleteIcon;

	//private GParagraph displayUserName;
	private GButton logOutButton;
	private GParagraph userName;
	private GParagraph taskBoardTitle;
	
	private JButton taskBoardTab;
	//private JButton calendarTab;
	private JButton darkMode;
	private JButton lightMode;

	private GRect topRect;
	private GRect leftRect;
	private GRect rightRect;
	private GRect centerRect;
	private GRect taskBoardBox;
	
	
	public SomePane(MainApplication app) {
		this.program = app;
		userIcon = new GImage("userIcon.png", 5, 5);
		
		plusIcon = new GImage("plusIcon.png", 440, 150);
		whitePlusIcon = new GImage("whitePlusIcon.png", 440, 150);

		editIcon = new GImage("editIcon.png", 484, 150);
		whiteEditIcon = new GImage("whiteEditIcon.png", 484, 150);

		deleteIcon = new GImage("trashIcon.png", 520,150);
		whiteDeleteIcon = new GImage("whiteTrashIcon.png", 520,150);

		topRect = new GRect(800, 47);
		//topRect.setFillColor(Color.BLUE);
		topRect.setFillColor(new Color(77,100,102));
		topRect.setFilled(true);
		topRect.sendToBack();
		
		leftRect = new GRect(0, 47, 150, 1000);
		//leftRect.setFillColor(Color.cyan);
		leftRect.setFillColor(new Color (120,158,158));
		leftRect.setFilled(true);
		leftRect.sendToBack();
		
		rightRect = new GRect(600, 47, 200, 1000);
		//rightRect.setFillColor(Color.black);
		//rightRect.setFillColor(Color.GRAY);
		rightRect.setFillColor(new Color (120,158,158));

		rightRect.setFilled(true);
		rightRect.sendToBack();
		
		
		centerRect = new GRect(150, 47, 550, 800);
		centerRect.setFillColor(new Color(58,58,58));
		centerRect.setFilled(true);
		centerRect.sendToBack();
		
		taskBoardBox = new GRect(200, 75,350,50);
		taskBoardBox.setFillColor(new Color (120,158,158));
		taskBoardBox.setFilled(true);
		
		logOutButton= new GButton("Log out", 730, 10, 50, 30);
		//logOutButton.setFillColor(Color.gray);
		
		//displayUserName = new GParagraph("User: ", 45, 30);
		//para.setFont("Arial-24");
		userName = new GParagraph("David", 45, 30);//will have to get user from MenuPane
		userName.setColor(Color.white);
		
		taskBoardTitle = new GParagraph("TASK BOARD", 300, 108);
		taskBoardTitle.setFont(new Font("Serif", Font.PLAIN, 24));
		
		taskBoardTab = new JButton("Task Board");
		taskBoardTab.setBounds(0, 75, 150, 50);
		//calendarTab = new JButton("Calendar");
		//calendarTab.setBounds(0, 150, 150, 50);
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
                	program.add(taskBoardBox);
                	program.add(taskBoardTitle);
                	program.add(whitePlusIcon);
                	program.add(whiteEditIcon);
            		program.add(whiteDeleteIcon);
                	program.getGCanvas().remove(darkMode);
                	program.getGCanvas().add(lightMode);                                 
             }// end of actionPerformed
        }); //end of actionListener
	   
		lightMode.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("light theme button pressed");
	    		
            	program.remove(whitePlusIcon);
            	program.remove(whiteEditIcon);
        		program.remove(whiteDeleteIcon);
	    		
            	program.add(plusIcon);
            	program.add(editIcon);
        		program.add(deleteIcon);
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
		program.add(taskBoardBox);
		program.add(taskBoardTitle);
		
		program.add(userIcon);
		//program.add(displayUserName);
		program.add(plusIcon);
		program.add(userName);
		program.add(logOutButton);
		
		program.getGCanvas().add(darkMode);
		
		program.add(editIcon);
		program.add(deleteIcon);

		program.getGCanvas().add(taskBoardTab);
		//program.getGCanvas().add(calendarTab);
		


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
		program.remove(deleteIcon);
		
		program.getGCanvas().remove(taskBoardTab);
		//program.getGCanvas().remove(calendarTab);
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
		else if(obj == plusIcon || obj == whitePlusIcon) {
			System.out.println("Create New Task icon pressed");
		}
		else if(obj == editIcon || obj == whiteEditIcon) {
			System.out.println("Edit icon pressed");
		}
		else if(obj == deleteIcon || obj == whiteDeleteIcon) {
			System.out.println("Delecte icon pressed");
		}
	}
}

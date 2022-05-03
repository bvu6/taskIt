package edu.pacific.comp55.starter;
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.Border;

import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GLabel;

public class SomePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private JComboBox<String> filter; 

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
	
	public String User = "default"; 
	
	//private JButton taskBoardTab;
	//private JButton calendarTab;
	private JButton darkMode;
	private JButton lightMode;

	private GRect topRect;
	private GRect leftRect;
	private GRect rightRect;
	private GRect centerRect;
	private GRect taskBoardBox;
	
	private GLabel titleOverview;
	private GLabel categoryOverview;
	private GLabel dueDateOverview;
	private GLabel priorityOverview;
	private GLabel descriptionOverview;
	
	private GLabel test;

	ArrayList<JLabel> taskList = new ArrayList<JLabel>();
	
	
	
	public void setUser(String user) {
		User = user;
		program.remove(userName);
		userName = new GParagraph(User, 45, 30);//**will have to get user from MenuPane
		userName.setColor(Color.white);
		program.add(userName);
		System.out.println("setUser");
	}
	
	public void getTaskLabels() {
		taskList = new ArrayList<JLabel>();
		if(MainApplication.jObject.keySet().contains(User)) {
			System.out.println("task labels");
			JSONArray listofTasks = (JSONArray) MainApplication.jObject.get(User);
			Border border = BorderFactory.createLineBorder(Color.black, 1);
			for(int x = 0; x < listofTasks.size(); x++) {
				JSONObject task = (JSONObject) listofTasks.get(x);
				String title = "Task ID: " + Integer.toString(x) + "\tTitle: " + task.get("title");
				JLabel currentTask = new JLabel();
				currentTask.setText(title);
				currentTask.setBorder(border);
				taskList.add(currentTask);
			}
		}
	}
	
	public SomePane(MainApplication app) {
		this.program = app;
		userIcon = new GImage("userIcon.png", 5, 5);
		
		plusIcon = new GImage("plusIcon.png", 440, 150);
		whitePlusIcon = new GImage("whitePlusIcon.png", 440, 150);

		editIcon = new GImage("editIcon.png", 484, 150);
		whiteEditIcon = new GImage("whiteEditIcon.png", 484, 150);

		deleteIcon = new GImage("trashIcon.png", 520,150);
		whiteDeleteIcon = new GImage("whiteTrashIcon.png", 520,150);
		
		String[] filterOptions = {"Date Created","Due Date", "Priority", "Project"};
	    filter = new JComboBox<>(filterOptions);
	    filter.setBounds(80, 70, 150, 20);
	    filter.setForeground(Color.black);
	    filter.setBackground(Color.white);

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
		
		titleOverview = new GLabel("Title: ", 615,225);
		categoryOverview = new GLabel("Category: ", 615,275);
		dueDateOverview = new GLabel("Due Date: ", 615,325);
		priorityOverview = new GLabel("Priority: ", 615,375);
		descriptionOverview = new GLabel("Description: ", 615,425);
		
		test = new GLabel("somethiing ", 300, 225);
		
		centerRect = new GRect(150, 47, 550, 800);
		centerRect.setFillColor(new Color(58,58,58));
		centerRect.setFilled(true);
		centerRect.sendToBack();
		
		taskBoardBox = new GRect(200, 75,350,50);
		taskBoardBox.setFillColor(new Color (120,158,158));
		taskBoardBox.setFilled(true);
		
		logOutButton= new GButton("Log out", 730, 10, 50, 30);
		
		//displayUserName = new GParagraph("User: ", 45, 30);
		//para.setFont("Arial-24");
		userName = new GParagraph(User, 45, 30);//**will have to get user from MenuPane
		userName.setColor(Color.white);
		
		taskBoardTitle = new GParagraph("TASK BOARD", 300, 108);
		taskBoardTitle.setFont(new Font("Serif", Font.PLAIN, 24));
		
		//taskBoardTab = new JButton("Task Board");
		//taskBoardTab.setBounds(0, 75, 150, 50);
		//calendarTab = new JButton("Calendar");
		//calendarTab.setBounds(0, 150, 150, 50);
	    darkMode = new JButton("Dark Mode");
	    darkMode.setBounds(0, 450, 150, 50);
	    lightMode = new JButton("Light Mode");
	    lightMode.setBounds(0, 450, 150, 50);
	    lightMode.setBackground(Color.gray);
    	lightMode.setOpaque(true);
    	lightMode.setBorderPainted(false);
	    
		darkMode.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                    
          	   	System.out.println("dark theme button pressed");

                	program.add(centerRect);
                	program.add(rightRect);
                	program.add(taskBoardBox);
                	program.add(taskBoardTitle);
                	program.add(whitePlusIcon);
                	program.add(whiteEditIcon);
            		program.add(whiteDeleteIcon);
            		
            		program.add(titleOverview);
            		program.add(categoryOverview);
            		program.add(dueDateOverview);
            		program.add(priorityOverview);
            		program.add(descriptionOverview);
            		
            		program.add(test);
            		
            		filter.setForeground(Color.white);
            		filter.setBackground(Color.gray);
            		
            		program.getGCanvas().add(filter,200,160);
            		program.getGCanvas().revalidate(); 

            		logOutButton.setFillColor(Color.gray);
                	program.getGCanvas().add(logOutButton);                                 
            		logOutButton.setFillColor(Color.gray);
                	program.getGCanvas().remove(darkMode);
                	program.getGCanvas().add(lightMode); 
                	
                	int currentTaskY = 225;
            		for(int x = 0; x < taskList.size(); x++) {
            			program.getGCanvas().add(taskList.get(x), 200, currentTaskY);
            			currentTaskY += 25;
            		}
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
        		
        		filter.setForeground(Color.black);
        	    filter.setBackground(Color.white);
        		
        		program.getGCanvas().add(filter,200,160);
        		program.getGCanvas().revalidate(); 

        		program.remove(centerRect);
        		logOutButton.setFillColor(Color.white);
        		program.add(logOutButton);
	    		program.getGCanvas().remove(lightMode);
	    		program.getGCanvas().add(darkMode);	  
	    		
	    	}
	    });
		plusIcon.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("Create new task button pressed");
            	
	    		hideContents();
	    		program.switchToTask();

	    	}
	    });

	}

	@Override
	public void showContents() {
		getTaskLabels();
		//program.add(img);
		program.add(topRect);
		program.add(leftRect);
		program.add(rightRect);
		//program.add(centerRect);
		program.add(titleOverview);
		program.add(categoryOverview);
		program.add(dueDateOverview);
		program.add(priorityOverview);
		program.add(descriptionOverview);
		
		int currentTaskY = 225;
		for(int x = 0; x < taskList.size(); x++) {
			program.getGCanvas().add(taskList.get(x), 200, currentTaskY);
			currentTaskY += 25;
		}
		
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
		program.getGCanvas().add(filter,200,160);
		program.getGCanvas().revalidate(); 

		

		//program.getGCanvas().add(taskBoardTab);
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
		program.getGCanvas().remove(filter);
		
		for(int x = 0; x < taskList.size(); x++) {
			program.getGCanvas().remove(taskList.get(x));
		}
		
		//program.getGCanvas().remove(taskBoardTab);
		//program.getGCanvas().remove(calendarTab);
		program.getGCanvas().remove(darkMode);
		program.getGCanvas().remove(lightMode);

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		//para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == logOutButton) {
			System.out.println("Log out button pressed");
			program.switchToMenu();//changed here program.switchToTask()
		}
		else if(obj == plusIcon || obj == whitePlusIcon) {
			System.out.println("Create new task icon pressed");
			program.switchToTask();
		}
		else if(obj == editIcon || obj == whiteEditIcon) {
			System.out.println("Edit icon pressed");
		}
		else if(obj == deleteIcon || obj == whiteDeleteIcon) {
			System.out.println("Delete icon pressed");
		}
	}
}

package edu.pacific.comp55.starter;

import java.awt.Color;




import java.awt.font.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GImage;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.parser.*;
import org.json.simple.*;
import org.json.*;
 

import java.sql.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate; 
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;

public class NewTaskPage extends GraphicsPane{
	private MainApplication program; 
	
	private JTextField title;
	private JTextField category;
	//private JTextField dueDate;
	private JTextField description;
	//private JTextField priority;
	private JComboBox<String> priority; 
	
	private GRect background;
	private GParagraph descriptionPar; 
	private GParagraph duedatePar; 
	private GParagraph priorityPar; 
	private GParagraph categoryPar; 
	private GParagraph titlePar; 
	private GParagraph createNewPar; 
	
	private UtilDateModel model; 
	private JDatePanelImpl datePanel; 
	private JDatePickerImpl datePicker; 
	private Properties property; 

	private GImage backArrow;

	private JButton save;
	
	private int taskID; 
	
	public NewTaskPage(MainApplication app) {

		this.program = app;
		
			
		//JSONParser parser = new JSONParser();

		
		background = new GRect(0,0,800,600);
		background.setFillColor(new Color (120,158,158));
		background.setFilled(true);
		descriptionPar = new GParagraph("\nDescription:", 277, 310);
		priorityPar = new GParagraph("\nPriority:", 282, 275);
		duedatePar = new GParagraph("\nDue Date:", 282, 240);
		categoryPar = new GParagraph("\nCategory:", 282, 205);
		titlePar = new GParagraph("Title:", 290, 185);
		createNewPar = new GParagraph("Create New Task", 340, 135); 
		
		title = new JTextField(10);
		category = new JTextField(10);
		//dueDate = new JTextField(10);
		
		model = new UtilDateModel();
		property = new Properties();
		property.put("text.today", "Today");
		property.put("text.month", "Month");
		property.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, property);
		datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		//priority = new JTextField(10);
		String[] priorityOptions = {"Low", "Medium", "High"};
	    priority = new JComboBox<>(priorityOptions);
	    priority.setBounds(80, 50, 135, 20);
	    priority.setForeground(Color.black);
	    priority.setBackground(Color.white);
	   
	   
		description = new JTextField(10);

		save = new JButton("Save");
		backArrow = new GImage("backArrow.png");
		
		
		save.addActionListener(new ActionListener()
         {
              public void actionPerformed(ActionEvent e)
              {
                     
            	           	  
           	   	System.out.println("Save button pressed");
           	   	
           	   	taskID++; 
           	   	System.out.println("\nTaskID: " + taskID);
           	   	
           	   	String titlePrint = title.getText();
                   System.out.println("\nTitle: " + titlePrint);
                   
           	   	String categoryPrint = category.getText();
                   System.out.println("\nCategory: " + categoryPrint);
                   
                System.out.println("\nDue Date: " + datePicker.getModel().getValue());
                
                String priorityPrint = priority.getItemAt(priority.getSelectedIndex());
                   System.out.println("\nPriority: " + priorityPrint);

                   
           	   	String descriptionPrint = description.getText();
                   System.out.println("\nDescription: " + descriptionPrint);
                   
                   JSONObject taskDetails = new JSONObject();
                   taskDetails.put("title: ", titlePrint);   
                   taskDetails.put("category: ", categoryPrint);
                   taskDetails.put("due date: ", datePicker.getModel().getValue());
                   taskDetails.put("priority: ", priorityPrint);
                   
                   JSONObject task = new JSONObject();
                   task.put("task", taskDetails);
                   
                   try {
					FileWriter taskFile = new FileWriter("tasks.json");
					taskFile.write(task.toJSONString());
					taskFile.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                   
                   
                program.switchToSome();
                
                title.setText(""); 
                category.setText(""); 
                datePicker.getJFormattedTextField().setText("");
                priority.setSelectedIndex(0);
                description.setText(""); 
                     
                //should write withing actionlistener
                
                
              }// end of actionPerformed
         });
		
		
		backArrow.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
          	   	System.out.println("Back button pressed");
             }// end of actionPerformed
        });
	}
	

@Override
public void showContents() {
	
	//Need to put .getGCanvas().add 
	program.add(background); 
	program.add(createNewPar); 
	program.add(titlePar); 
	program.add(categoryPar); 
	program.add(duedatePar); 
	program.add(priorityPar); 
	program.add(descriptionPar); 
	program.getGCanvas().repaint();
	program.getGCanvas().add(title, 350, 170);
	program.getGCanvas().add(category, 350, 200);
	//program.getGCanvas().add(dueDate, 350, 237);
	program.getGCanvas().add(datePicker, 350, 237); 
	program.getGCanvas().add(priority, 350,275); 
	program.getGCanvas().revalidate(); 
	program.getGCanvas().add(description, 350, 310);
	program.getGCanvas().add(save, 350, 340);
	program.getGCanvas().add(backArrow);
}

@Override
public void hideContents() {
	//program.remove(img);
	//program.remove(para);
	//program.remove(rect);
	
	program.remove(background);
	program.remove(createNewPar); 
	program.remove(titlePar); 
	program.remove(categoryPar); 
	program.remove(duedatePar);
	program.remove(priorityPar); 
	program.remove(descriptionPar);
	program.getGCanvas().remove(title);
	program.getGCanvas().remove(category);
	program.getGCanvas().remove(datePicker);
	program.getGCanvas().remove(priority);
	program.getGCanvas().remove(description);
	program.getGCanvas().remove(save);
	program.getGCanvas().remove(backArrow);

}

@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == backArrow) {
			System.out.println("Back arrow pressed");
			hideContents();
			program.switchToSome();
		}

		
	}
}
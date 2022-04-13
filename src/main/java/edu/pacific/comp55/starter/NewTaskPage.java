package edu.pacific.comp55.starter;

import java.awt.Color;


import java.awt.font.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import acm.graphics.GObject;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewTaskPage extends GraphicsPane{
	private MainApplication program; 
	
	private JTextField title;
	private JTextField category;
	private JTextField duedate;
	private JTextField description;
	//private JTextField priority;
	private JComboBox priority; 
	
	
	private GParagraph descriptionPar; 
	private GParagraph duedatePar; 
	private GParagraph priorityPar; 
	private GParagraph categoryPar; 
	private GParagraph titlePar; 

	private JButton save; 
	
	public NewTaskPage(MainApplication app) {

		this.program = app;
		//para = new GParagraph("Create New Task", 150, 300);
		
		
		descriptionPar = new GParagraph("\nDescription:", 277, 320);
		priorityPar = new GParagraph("\nPriority:", 282, 275);
		duedatePar = new GParagraph("\nDue Date:", 282, 240);
		categoryPar = new GParagraph("\nCategory:", 282, 205);
		titlePar = new GParagraph("Title:", 290, 185);
		
		title = new JTextField(10);
		category = new JTextField(10);
		duedate = new JTextField(10);
		//priority = new JTextField(10);
		String[] priorityOptions = {"Low", "Medium", "High"};
	    priority = new JComboBox<>(priorityOptions);
	    priority.setBounds(100, 50, 200, 25);
	    priority.setVisible(true);
	   
		description = new JTextField(10);

		save = new JButton("Save");
		
	}

@Override
public void showContents() {
	//program.add(img);
	//program.add(para);
	
	//Need to put .getGCanvas().add 

	program.add(titlePar); 
	program.add(categoryPar); 
	program.add(duedatePar); 
	program.add(priorityPar); 
	program.add(descriptionPar); 
	program.getGCanvas().add(title, 350, 170);
	program.getGCanvas().add(category, 350, 200);
	program.getGCanvas().add(duedate, 350, 237);
	//program.getGCanvas().add(priority, 350, 275);
	program.getGCanvas().add(priority, 350,275); 
	program.getGCanvas().add(description, 350, 320);
	program.getGCanvas().add(save, 350, 350);
	//program.add(rect);
}

@Override
public void hideContents() {
	//program.remove(img);
	//program.remove(para);
	//program.remove(rect);
	
	program.remove(titlePar); 
	program.remove(categoryPar); 
	program.remove(duedatePar);
	program.remove(priorityPar); 
	program.remove(descriptionPar);
	program.getGCanvas().remove(title);
	program.getGCanvas().remove(category);
	program.getGCanvas().remove(duedate);
	program.getGCanvas().remove(priority);
	program.getGCanvas().remove(description);
	program.getGCanvas().remove(save);
}

@Override
	public void mousePressed(MouseEvent e) {
		//para.setText("you need\nto click\non the eyes\nto go back");
		
	}
}
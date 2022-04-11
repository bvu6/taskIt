package edu.pacific.comp55.starter;

import java.awt.Color;

import java.awt.font.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import acm.graphics.GObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewTaskPage extends GraphicsPane{
	private MainApplication program; 
	
	private GParagraph para;

	
	public NewTaskPage(MainApplication app) {
		this.program = app;
		para = new GParagraph("welcome\nto my\nsecret room!", 150, 300);
		
	}

@Override
public void showContents() {
	//program.add(img);
	program.add(para);
	//program.add(rect);
}

@Override
public void hideContents() {
	//program.remove(img);
	program.remove(para);
	//program.remove(rect);
}

@Override
	public void mousePressed(MouseEvent e) {
		//para.setText("you need\nto click\non the eyes\nto go back");
		
	}
}
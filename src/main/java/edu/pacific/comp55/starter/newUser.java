package edu.pacific.comp55.starter;
import java.awt.Color;

import java.awt.font.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import acm.graphics.GObject;
import acm.graphics.GRect;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class newUser extends GraphicsPane{
	private static final String EXIT_ON_CLOSE = null;
	private MainApplication program;
	
	private GRect background;
	private JTextField passWord;
	private JTextField confirmPassword;
	private JTextField userName;
	private GParagraph title;
	private GParagraph pass;
	private GParagraph confirmPass;
	private GParagraph user;
	private GParagraph error;
	private GParagraph error1;
	
	private JButton Cancel;
	private JButton Confirm;
	
	
	private String fileName = "src/main/java/edu/pacific/comp55/starter/userpwd.txt";
	public newUser(MainApplication app) throws IOException{
		super();
		program = app;
		
		title = new GParagraph("New Login", 315, 225);
		
		background = new GRect(0,0,800,600);
		background.setFillColor(new Color (120,158,158));
		background.setFilled(true);
		
		user = new GParagraph("Username", 290, 280);
		pass = new GParagraph("\nPassword", 290, 290);
		confirmPass = new GParagraph("\nConfirm Password", 240, 320);
		
		userName = new JTextField(10);
		passWord = new JTextField(10);
		confirmPassword = new JTextField(10);
		
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName.setText("");
				passWord.setText("");
				confirmPassword.setText("");
				program.switchToMenu();
			}
		});
		Confirm = new JButton("Save Login");
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userName.getText();
				String pass = passWord.getText();
				String confirmPass = confirmPassword.getText();
				if(user.equals("") || pass.equals("") || confirmPass.equals("")) {
					program.remove(error);
					program.add(error1);
				}
				
				else if(confirmPass.equals(pass)) {
					try {
						FileWriter fileWritter = new FileWriter(fileName,true);
						BufferedWriter bw = new BufferedWriter(fileWritter);
						bw.write("\n");
						bw.write(user);
						bw.write(",");
						bw.write(pass);
						bw.close();
					} 
					catch(IOException i){
						i.printStackTrace();
				    }
					program.switchToMenu();
				}
				else {
					program.add(error);
					program.remove(error1);
				}
			}
		});
		error = new GParagraph("Password doesn't match", 350, 360);
		error.setColor(Color.red);
		
		error1 = new GParagraph("Fill in all fields", 350, 360);
		error1.setColor(Color.red);
	}
	
	@Override
	public void showContents() {
		//program.add(rect);
		program.add(background);
		program.add(title);
		program.getGCanvas().add(userName, 350, 260);
		program.getGCanvas().add(passWord, 350, 290);
		program.getGCanvas().add(confirmPassword, 350, 320);
		program.add(pass);
		program.add(confirmPass);
		program.add(user);
		program.getGCanvas().add(Cancel, 360, 395);
		program.getGCanvas().add(Confirm, 355, 370);
		

	}

	@Override
	public void hideContents() {
		//program.remove(rect);
		program.remove(title);
		program.remove(background);
		program.getGCanvas().remove(userName);
		program.getGCanvas().remove(passWord);
		program.getGCanvas().remove(confirmPassword);
		program.remove(pass);
		program.remove(confirmPass);
		program.remove(user);
		program.getGCanvas().remove(Cancel);
		program.getGCanvas().remove(Confirm);
		program.remove(error);
		program.remove(error1);
	}
	
}

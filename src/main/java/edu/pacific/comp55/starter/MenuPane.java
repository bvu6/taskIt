package edu.pacific.comp55.starter;

import java.awt.Color;

import java.awt.font.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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


public class MenuPane extends GraphicsPane {
	private static final String EXIT_ON_CLOSE = null;
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GRect background;

	private GButton rect;
	private JTextField passWord;
	private JTextField userName;
	private GParagraph programTitle;
	private GParagraph pass;
	private GParagraph user;
	private GParagraph error;

	
	private JButton login;
    JPanel jp = new JPanel();


	public MenuPane(MainApplication app) throws IOException {
		super();
		program = app;
		
		background = new GRect(0,0,800,600);
		background.setFillColor(new Color (120,158,158));
		background.setFilled(true);
		
		
		programTitle = new GParagraph("VOLTORB'S TO-DO LIST", 315, 225);		
		
		
		rect = new GButton("Login", 350, 350, 80, 50);
		rect.setFillColor(Color.cyan);
		
		pass = new GParagraph("\nPassword", 290, 290);
		user = new GParagraph("Username", 282, 273);
		error = new GParagraph("Invalid username or password entered", 300, 335);
		error.setColor(Color.red);

		
	    //JTextField field3 = new JTextField(10);

		File userInputFile = new File("userInput.txt");
		userInputFile.createNewFile();
		FileWriter fw = new FileWriter(userInputFile);
		PrintWriter pw = new PrintWriter(fw);

	    pw.write("hello");

		passWord = new JTextField(10);
	    //field1.setText(10);
	    //add(field1);
	    userName = new JTextField(10);
	    //field2.setText("          ");
	    login = new JButton("login");
	    
	    
	    login.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                    
          	   	System.out.println("login button pressed");

          	   	String user = userName.getText();
                 System.out.println("\nuserName: " + user);
                  
              	String pass = passWord.getText();
                System.out.println("\npassWord: " + pass);
                
                if(user.equals("") || pass.equals("")) {
                	program.add(error);
                }
                else {
                	program.switchToSome();
                	program.remove(error);
                }
                    
             }// end of actionPerformed
        }); //end of actionListener
        
        //jp.add(login);
	    pw.close();
	    
	}

	
	public MenuPane() {
		//frame.add(textfield);
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.pack();
		//frame.setVisible(true);
	}

	@Override
	public void showContents() {
		//program.add(rect);
		program.add(background);
		program.add(programTitle);
		program.getGCanvas().add(passWord, 350, 290);//Need to put .getGCanvas().add 
		program.getGCanvas().add(userName, 350, 260);//Need to put .getGCanvas().add 
		program.add(pass);
		program.add(user);
		program.remove(error);
		program.getGCanvas().add(login, 350, 350);
		//program.getGCanvas().setLayout();

	}

	@Override
	public void hideContents() {
		//program.remove(rect);
		program.remove(background);
		program.remove(programTitle);
		program.getGCanvas().remove(passWord);
		program.getGCanvas().remove(userName);
		program.remove(pass);
		program.remove(user);
		program.remove(error);
		program.getGCanvas().remove(login);


	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToSome();
		}
	}
}

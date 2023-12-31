package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPane extends GraphicsPane {
	private static final String EXIT_ON_CLOSE = null;
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GRect background;

	private GButton Login;
	private JTextField passWord;
	private JTextField userName;
	//private GParagraph programTitle;
	private GParagraph pass;
	private GParagraph user;
	private GParagraph error;

	private GImage listItTitle;
	
	private JButton login;
	private JButton newUser;
    JPanel jp = new JPanel();

    private String fileName = "src/main/java/edu/pacific/comp55/starter/userpwd.txt";
    private List<String> userList = new ArrayList<>();
    private List<String> pwdList = new ArrayList<>();

	public MenuPane(MainApplication app) throws IOException {
		super();
		program = app;
		
		background = new GRect(0,0,800,600);
		background.setFillColor(new Color (120,158,158));
		background.setFilled(true);
		
		listItTitle = new GImage("taskItTitle.png",235,130);
		
		//programTitle = new GParagraph("VOLTORB'S TO-DO LIST", 315, 225);		
		
		
		Login = new GButton("Login", 350, 350, 80, 50);
		Login.setFillColor(Color.cyan);
		
		pass = new GParagraph("\nPassword: ", 285, 290);
		pass.setFont(new Font("Serif", Font.PLAIN, 14));

		user = new GParagraph("Username: ", 282, 273);
		user.setFont(new Font("Serif", Font.PLAIN, 14));

		error = new GParagraph("Invalid username or password entered", 275, 335);
		error.setFont(new Font("Serif", Font.PLAIN, 16));

		error.setColor(Color.red);
		
		newUser = new JButton("Create new user");
		newUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				program.switchTonewUser();
			}
		});
		
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
	    login = new JButton("Login");
	    
	    
	    login.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                    
          	   	System.out.println("login button pressed");

          	   	String user = userName.getText();
                 System.out.println("\nuserName: " + user);
                  
              	String pass = passWord.getText();
                System.out.println("\npassWord: " + pass);
                
                getLoginInfo(fileName);
                
                if(user.equals("") || pass.equals("")) {
                	program.add(error);
                }
                else if(userList.contains(user)) {
                	if(pwdList.contains(pass)) {
                		program.remove(error);
                		program.setUser(user);
                		program.switchToSome();
                	}
                	else {
                		program.add(error);
                	}
                }
                else {
                	program.add(error);
                }
                    
             }// end of actionPerformed
        }); //end of actionListener
        
        //jp.add(login);
	    pw.close();
	    
	}
	
	public void getLoginInfo(String Filename) {
		File file = new File(Filename);
	    Scanner sc = null;
	    String login = "";
		try {
			sc = new Scanner(file.getAbsoluteFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    while (sc.hasNextLine()) {
	      login = sc.nextLine();
	      String[] arrOfStr = login.split(",", 0);
	        userList.add(arrOfStr[0]);
	        pwdList.add(arrOfStr[1]);
	    }
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
		//program.add(programTitle);
		program.add(listItTitle);
		program.getGCanvas().add(passWord, 350, 290);//Need to put .getGCanvas().add 
		program.getGCanvas().add(userName, 350, 260);//Need to put .getGCanvas().add 
		program.add(pass);
		program.add(user);
		program.remove(error);
		program.getGCanvas().add(login, 350, 350);
		program.getGCanvas().add(newUser, 325, 375);
		//program.getGCanvas().setLayout();

	}

	@Override
	public void hideContents() {
		//program.remove(rect);
		program.remove(background);
		//program.remove(programTitle);
		program.remove(listItTitle);
		program.getGCanvas().remove(passWord);
		program.getGCanvas().remove(userName);
		program.remove(pass);
		program.remove(user);
		program.remove(error);
		program.getGCanvas().remove(login);
		program.getGCanvas().remove(newUser);


	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == Login) {
			program.switchToTask();
		}
	}
}

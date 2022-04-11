package edu.pacific.comp55.starter;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.ArrayList;
import javax.swing.JComponent;



import java.awt.*;


public class TaskPage extends JFrame {
	public ArrayList<JButton> buttonsList = new ArrayList<JButton>();
	
	public TaskPage(String title) {
		super(title);
		this.setSize(600,400);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for(int x = 0; x < 12; x++) {
			buttonsList.add(new JButton(Integer.toString(x)));
		}

		Container mainContainer = this.getContentPane();
		//mainContainer.setLayout(new BorderLayout(8,6));
		//mainContainer.setBackground(Color.BLACK);
		//this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,  Color.BLACK));
		mainContainer.setBackground(new Color(238,243,189));
		
		JPanel topPanel = new JPanel();
		//topPanel.setBorder(new LineBorder(Color.BLACK, 3));
		topPanel.setBackground(new Color(77,100,102));
		topPanel.setLayout(new FlowLayout(5));
		mainContainer.add(topPanel, BorderLayout.NORTH);
		
/*		for(int x = 0; x < 5; x++) {
			topPanel.add(buttonsList.get(x));
		}
*/	 		
		JPanel leftInnerPanel = new JPanel();
		//middlePanel.setBorder(new LineBorder(Color.black, 3));
		leftInnerPanel.setLayout(new FlowLayout(4,4,4));
		leftInnerPanel.setBackground(new Color (120,158,158));
		
		JPanel leftOuterPanel = new JPanel();
		leftOuterPanel.setLayout(new GridLayout(4,1,5,5));
		//gridPanel.setBorder(new LineBorder(Color.black, 3));
//		leftPanel.setBackground(new Color(77,100,102));
//		leftPanel.setBackground(Color.GRAY);
		leftOuterPanel.setBackground(new Color (120,158,158));
	
		for(int x = 5; x < 9; x++) {
			leftOuterPanel.add(buttonsList.get(x));
		}
		
		JLabel taskListLabel = new JLabel("TASK LIST", SwingConstants.CENTER);
		taskListLabel.setOpaque(true);
		//taskListLabel.setBorder(new LineBorder(Color.black, 3));
		//taskListLabel.setBounds(250,100,100,100);
		
		
		JLabel usernameLabel = new JLabel("Username: David", SwingConstants.LEFT);
		usernameLabel.setForeground(Color.white);
		usernameLabel.setBounds(10, 10, 100, 10);
		
		JButton addButton = new JButton("+");
		addButton.setBounds(350, 150, 20, 20);
		mainContainer.add(addButton);
		
		leftInnerPanel.add(leftOuterPanel);
		mainContainer.add(taskListLabel);
		
		topPanel.add(usernameLabel);
		mainContainer.add(leftInnerPanel, BorderLayout.WEST);
		
		/*
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(3));
		
		for(int x = 9; x < 12; x++) {
			bottomPanel.add(buttonsList.get(x));
		}
		bottomPanel.setBackground(Color.MAGENTA);
		bottomPanel.setBorder(new LineBorder(Color.blue, 3));
		mainContainer.add(bottomPanel, BorderLayout.SOUTH);
		*/
	}
	public static void main(String [] args) {
		TaskPage x = new TaskPage("Task page");
		x.setVisible(true);
	}
}

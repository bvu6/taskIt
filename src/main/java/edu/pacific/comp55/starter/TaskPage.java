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
		this.setSize(800,500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for(int x = 0; x < 12; x++) {
			buttonsList.add(new JButton(Integer.toString(x)));
		}

		Container mainContainer = this.getContentPane();
		//mainContainer.setLayout(new BorderLayout(8,6));
		//mainContainer.setBackground(Color.BLACK);
		//this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,  Color.BLACK));
		//mainContainer.setBackground(new Color(58,58,58)); //COLOR SCHEME 1
		//mainContainer.setBackground(new Color(40,40,40)); //COLOR SCHEME 3
		mainContainer.setBackground(new Color(12,0,50)); //COLOR SCHEME 3.5

		
		JPanel topPanel = new JPanel();
		//topPanel.setBorder(new LineBorder(Color.BLACK, 3));
		//topPanel.setBackground(new Color(77,100,102)); //COLOR SCHEME 1 Muted
		//topPanel.setBackground(new Color(21,60,251)); //COLOR SCHEME 2
		topPanel.setBackground(new Color(25,0,97)); //COLOR SCHEME 3

		topPanel.setLayout(new FlowLayout(5));
		mainContainer.add(topPanel, BorderLayout.NORTH);
		
/*		for(int x = 0; x < 5; x++) {
			topPanel.add(buttonsList.get(x));
		}
*/	 		
		JPanel leftInnerPanel = new JPanel();
		//middlePanel.setBorder(new LineBorder(Color.black, 3));
		leftInnerPanel.setLayout(new FlowLayout(4,4,4));
		//leftInnerPanel.setBackground(new Color (120,158,158)); //COLOR SCHEME 1
		leftInnerPanel.setBackground(new Color (5,119,255)); //COLOR SCHEME 2
		leftInnerPanel.setBackground(new Color (36,0,144)); //COLOR SCHEME 3

		
		JPanel leftOuterPanel = new JPanel();
		leftOuterPanel.setLayout(new GridLayout(4,1,5,5));
		//gridPanel.setBorder(new LineBorder(Color.black, 3));
//		leftPanel.setBackground(new Color(77,100,102));
//		leftPanel.setBackground(Color.GRAY);
		//leftOuterPanel.setBackground(new Color (120,158,158)); //COLOR SCHEME 1
		//leftOuterPanel.setBackground(new Color (5,119,255)); //COLOR SCHEME 2
		leftOuterPanel.setBackground(new Color (36,0,144)); //COLOR SCHEME 3

		for(int x = 0; x < 2; x++) {
			leftOuterPanel.add(buttonsList.get(x));
		}
		
		JPanel rightInnerPanel = new JPanel();
		//middlePanel.setBorder(new LineBorder(Color.black, 3));
		rightInnerPanel.setLayout(new FlowLayout(4,4,4));
		rightInnerPanel.setBackground(Color.gray); //COLOR SCHEME 1
		rightInnerPanel.setBackground(new Color(52,0,211)); //COLOR SCHEME 3

		
		JPanel rightOuterPanel = new JPanel();
		rightOuterPanel.setLayout(new GridLayout(4,1,5,5));
		//gridPanel.setBorder(new LineBorder(Color.black, 3));
//		leftPanel.setBackground(new Color(77,100,102));
//		leftPanel.setBackground(Color.GRAY);
		//rightOuterPanel.setBackground(Color.gray);//COLOR SCHEME 1
		rightOuterPanel.setBackground(new Color(52,0,211)); //COLOR SCHEME 3

		for(int x = 2; x < 5; x++) {
			rightOuterPanel.add(buttonsList.get(x));
		}
		
		//JLabel taskListLabel = new JLabel("TASK LIST", SwingConstants.CENTER);
		//taskListLabel.setOpaque(true);
		//taskListLabel.setBorder(new LineBorder(Color.black, 3));
		//taskListLabel.setBounds(250,100,100,100);
		
		JLabel label1 = new JLabel("TASK LIST", SwingConstants.CENTER);
		label1.setForeground(Color.white);
		
		JLabel usernameLabel = new JLabel("Username: David", SwingConstants.LEFT);
		usernameLabel.setForeground(Color.white);
		usernameLabel.setBounds(10, 10, 100, 10);
		
		JButton addButton = new JButton("+");
		addButton.setBounds(350, 150, 20, 20);
		mainContainer.add(addButton);
		
		leftInnerPanel.add(leftOuterPanel);
		rightInnerPanel.add(rightOuterPanel);
		//mainContainer.add(taskListLabel);
		mainContainer.add(label1);
		
		topPanel.add(usernameLabel);
		mainContainer.add(leftInnerPanel, BorderLayout.WEST);
		mainContainer.add(rightInnerPanel, BorderLayout.EAST);
		
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

package edu.pacific.comp55.starter;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.ArrayList;

import java.awt.*;


public class TaskPage extends JFrame {
	public ArrayList<JButton> something = new ArrayList<JButton>();
	public TaskPage(String title) {
		super(title);
		this.setSize(700,300);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int x = 0; x < 12; x++) {
			something.add(new JButton(Integer.toString(x)));
		}
		
		Container mainContainer = this.getContentPane();
		mainContainer.setLayout(new BorderLayout(8,6));
		mainContainer.setBackground(Color.YELLOW);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,  Color.GREEN));
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(Color.BLACK, 3));
		topPanel.setBackground(Color.ORANGE);
		topPanel.setLayout(new FlowLayout(5));
		mainContainer.add(topPanel, BorderLayout.NORTH);
		
		for(int x = 0; x < 5; x++) {
			topPanel.add(something.get(x));
		}
		
		JPanel middlePanel = new JPanel();
		middlePanel.setBorder(new LineBorder(Color.black, 3));
		middlePanel.setLayout(new FlowLayout(4,4,4));
		middlePanel.setBackground(Color.cyan);
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(4,1,5,5));
		gridPanel.setBorder(new LineBorder(Color.black, 3));
		gridPanel.setBackground(Color.red);
		
		for(int x = 5; x < 9; x++) {
			gridPanel.add(something.get(x));
		}
		
		JLabel label = new JLabel("Center Box", SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBorder(new LineBorder(Color.black, 3));
		
		middlePanel.add(gridPanel);
		mainContainer.add(label);
		mainContainer.add(middlePanel, BorderLayout.WEST);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(3));
		
		for(int x = 9; x < 12; x++) {
			bottomPanel.add(something.get(x));
		}
		bottomPanel.setBackground(Color.MAGENTA);
		bottomPanel.setBorder(new LineBorder(Color.blue, 3));
		mainContainer.add(bottomPanel, BorderLayout.SOUTH);
		
	}
	public static void main(String [] args) {
		TaskPage x = new TaskPage("Task page");
		x.setVisible(true);
	}
}

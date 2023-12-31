package edu.pacific.comp55.starter;

import java.awt.event.ActionEvent;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.Date;

import javax.swing.JFormattedTextField;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class newTask extends JFrame
{
       JPanel panel = new JPanel();

       JLabel projectOutput = new JLabel(); 
       JLabel titleLabel = new JLabel("Title:" , JLabel.LEFT); 
       JLabel categoryLabel = new JLabel ("Category:", JLabel.LEFT); 
       JLabel dateLabel = new JLabel ("Due Date:", JLabel.LEFT); 
       JLabel priorityLabel = new JLabel ("Priority:", JLabel.LEFT); 
       JLabel descriptionLabel = new JLabel ("Description:", JLabel.LEFT);
       JLabel dateCreatedLabel = new JLabel ("Task Created:", JLabel.LEFT); 

       JTextField titleText = new JTextField(20);

       JTextField projectText = new JTextField(20);

       JTextField categoryText = new JTextField(20);
       JTextField dateText = new JTextField(20); 

       JTextField descriptionText = new JTextField(20); 
       DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
       JFormattedTextField today = new JFormattedTextField(dateFormat);


       String[] priorityOptions = {"Low", "Medium", "High"};
       JComboBox<String> priorityComboBox = new JComboBox<>(priorityOptions);
       JButton saveButton = new JButton("Save");

       public newTask()
       {
    	   
              setTitle("Create New Task");
              setVisible(true);
              setSize(340, 250);
              setDefaultCloseOperation(EXIT_ON_CLOSE);
              //jp.add(titleText);

              titleLabel.setBounds(10,20,80,25); 
              panel.add(titleLabel); 
              titleText.setBounds(100,20,145,25); 
              panel.add(titleText); 

              //jl.setBounds(150, 20, 50, 25); 
              //jp.add(jl); //prints out the user input
              
              categoryLabel.setBounds(10,600,80,20); 
              panel.add(categoryLabel); 
              categoryText.setBounds(100,90,145,25); 
              panel.add(categoryText); 
 
              panel.add(dateLabel); 
              panel.add(dateText);
              
              panel.add(priorityLabel); 
              
              //MICHELLE:add buttons here
              panel.add(priorityLabel);

              priorityComboBox.setBounds(100, 50, 200, 25);
              panel.add(priorityComboBox); 

              panel.add(descriptionLabel);
              descriptionText.setBounds(100,90,145,100);
              panel.add(descriptionText); 
              
              panel.add(dateCreatedLabel); 
              today.setName("Today");
              today.setColumns(10);
              today.setEditable(true);
              today.setValue(new Date());
              panel.add(today);
              
              saveButton.setBackground(Color.CYAN);
              saveButton.setOpaque(true);
              saveButton.setBorderPainted(false);
              panel.add(saveButton);
              
              add(panel);
              
              saveButton.addActionListener(new ActionListener()
              {
	               public void actionPerformed(ActionEvent e)
	               {
	                      
	            	   	System.out.println("Save button pressed");

	            	   	String title = titleText.getText();
	                    System.out.println("\nTitle: " + title);
	                    
	            	   	String category = categoryText.getText();
	                    System.out.println("\nGroup: " + category);
	                    
	            	   	String dueDate = dateText.getText();
	                    System.out.println("\nDue Date: " + dueDate);
	                    
	                    String priority = priorityComboBox.getItemAt(priorityComboBox.getSelectedIndex());
	                    System.out.println("\nPriority: " + priority);

	                    /*if (e.getSource() == lowButton){
	                    	String priority = lowButton.getActionCommand();
		                    System.out.println("Priority: "+ priority);
              			}
	                    if (e.getSource() == medButton){
	                    	String priority = medButton.getActionCommand();
		                    System.out.println("Priority: "+ priority);

              			}
	                    if(e.getSource() == highButton){
	                    	String priority = highButton.getActionCommand();
		                    System.out.println("Priority: "+ priority);

              			}*/
	                    
	            	   	String description = descriptionText.getText();
	                    System.out.println("\nDescription: " + description);
	                      
	               }// end of actionPerformed
              }); //end of actionListener
              
       } // end of public newTask
       
        


       public static void main(String[] args)
       {
    	   newTask t = new newTask();
       }
}
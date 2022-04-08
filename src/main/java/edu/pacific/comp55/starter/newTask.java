package edu.pacific.comp55.starter;

import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.time.LocalDate;
import javax.swing.JTextField;
import javax.swing.JComboBox;




public class newTask extends JFrame
{
       JPanel panel = new JPanel();

       JLabel projectOutput = new JLabel(); 
       JLabel titleLabel = new JLabel("Title:" , JLabel.LEFT); 
       JLabel projectLabel = new JLabel ("Project:", JLabel.LEFT); 
       JLabel dateLabel = new JLabel ("Due Date:", JLabel.LEFT); 
       JLabel priorityLabel = new JLabel ("Priority:", JLabel.LEFT); 
       JLabel descriptionLabel = new JLabel ("Description:", JLabel.LEFT);

       
       JTextField titleText = new JTextField(20);
       JTextField projectText = new JTextField(20);
       JTextField descriptionText = new JTextField(20); 
       JTextField dateText = new JTextField(20); 
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
              
              projectLabel.setBounds(10,600,80,20); 
              panel.add(projectLabel); 
              projectText.setBounds(100,90,145,25); 
              panel.add(projectText); 
 
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
              
//              saveButton.setBackground(Color.CYAN);
              panel.add(saveButton);

              
              add(panel);
              
              saveButton.addActionListener(new ActionListener()
              {
	               public void actionPerformed(ActionEvent e)
	               {
	                      
	            	   	System.out.println("Save button pressed");

	            	   	String title = titleText.getText();
	                    System.out.println("\nTitle: " + title);
	                    
	            	   	String project = projectText.getText();
	                    System.out.println("\nProject: " + project);
	                    
	            	   	String dueDate = dateText.getText();
	                    System.out.println("\nDue Date: " + dueDate);
	                   
	            	   	//Highlight the button when pressed
	                    
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
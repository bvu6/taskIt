package edu.pacific.comp55.starter;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout; 
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class newTask extends JFrame
{
       JPanel jp = new JPanel();
       JLabel jl = new JLabel();
       JLabel projectOutput = new JLabel(); 
       JLabel titleLabel = new JLabel("Title:" , JLabel.LEFT); 
       JLabel projectLabel = new JLabel ("Project:", JLabel.LEFT); 
       JLabel dateLabel = new JLabel ("Due Date:", JLabel.LEFT); 
       JLabel priorityLabel = new JLabel ("Priority:", JLabel.LEFT); 
       JLabel descriptionLabel = new JLabel ("Description:", JLabel.LEFT); 
       JTextField jt = new JTextField(20);
       JTextField projectText = new JTextField(20);
       JTextField dateText = new JTextField(20); 
       JTextField descriptionText = new JTextField(20); 
       JButton jb = new JButton("Enter");
       JButton projectB = new JButton ("Enter"); 

       

       public newTask()
       {
    	   
              setTitle("Create New Task");
              setVisible(true);
              setSize(400, 200);
              setDefaultCloseOperation(EXIT_ON_CLOSE);
              //jp.add(jt);
              titleLabel.setBounds(10,20,80,25); 
              jp.add(titleLabel); 
              jt.setBounds(100,20,145,25); 
              jp.add(jt); 

              //jl.setBounds(150, 20, 50, 25); 
              //jp.add(jl); //prints out the user input
              
              projectLabel.setBounds(10,600,80,20); 
              jp.add(projectLabel); 
              projectText.setBounds(100,90,145,25); 
              jp.add(projectText); 
 
              jp.add(dateLabel); 
              jp.add(dateText); 
              jp.add(priorityLabel); 
              //MICHELLE:add buttons here
              
              jp.add(descriptionLabel); 
              jp.add(descriptionText); 
              add(jp);
              

       }


       public static void main(String[] args)
       {
    	   newTask t = new newTask();
       }
}
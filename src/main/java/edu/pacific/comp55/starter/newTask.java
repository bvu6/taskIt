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
       JLabel titleLabel = new JLabel("Title:"); 
       JLabel projectLabel = new JLabel ("Project Label:"); 
       JTextField jt = new JTextField(20);
       JTextField projectText = new JTextField(20);
       JButton jb = new JButton("Enter\n");
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
              jt.setBounds(100,20,165,25); 
              jp.add(jt); 


              jt.addActionListener(new ActionListener()
              {
                     public void actionPerformed(ActionEvent e)
                     {
                           String input = jt.getText();
                           jl.setText(input); 
                     }
              });

              jp.add(jb);
              jb.addActionListener(new ActionListener()
              {
                      public void actionPerformed(ActionEvent e)
                      {
                             String input = jt.getText();
                             jl.setText(input);
                      }
              });
              
              jp.add(jl); //prints out the user input
              
              projectLabel.setBounds(10,50,80,20); 
              jp.add(projectLabel); 
              projectText.setBounds(100,50,165,25); 
              jp.add(projectText); 
              projectText.addActionListener(new ActionListener()
              {
                     public void actionPerformed(ActionEvent e)
                     {
                           String input = projectText.getText();
                           projectOutput.setText(input); 
                     }
              });

              jp.add(projectB);
              projectB.addActionListener(new ActionListener()
              {
                      public void actionPerformed(ActionEvent e)
                      {
                             String input = projectText.getText();
                             projectOutput.setText(input);
                      }
              });
              
              add(jp);
              

       }


       public static void main(String[] args)
       {
    	   newTask t = new newTask();
       }
}
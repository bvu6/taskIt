package edu.pacific.comp55.starter;

import java.awt.event.ActionEvent;
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
       JTextField jt = new JTextField(30);
       JButton jb = new JButton("Enter");

       public newTask()
       {
              setTitle("Create New Task");
              setVisible(true);
              setSize(400, 200);
              setDefaultCloseOperation(EXIT_ON_CLOSE);

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
              add(jp);

       }

       public static void main(String[] args)
       {
    	   newTask t = new newTask();
       }
}
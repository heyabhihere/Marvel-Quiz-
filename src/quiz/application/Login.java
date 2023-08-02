package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JButton rules,back;
    JTextField userName;
//constructer
    Login(){
        //area of screen selector
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //set image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        JLabel image= new JLabel(i1);
        image.setBounds(0,0,740,580);
        add(image);
        
        //heading
        JLabel heading=new JLabel("Welcome To Marvel Universe");
        heading.setBounds(750,60,300,45);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,20));
        heading.setForeground(Color.RED);
        add(heading);
        
        //label for name
        JLabel name=new JLabel("Enter your Name:");
        name.setBounds(810,150,300,20);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        name.setForeground(Color.BLUE);
        add(name);
        
        //input name box
        userName=new JTextField();
        userName.setBounds(735,200,300,25);
        userName.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(userName);
        
        // rules button
        rules= new JButton("Rules");
        rules.setBounds(735,270,120,25);
        rules.setBackground(new Color(0,0,0));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        //back button
        back= new JButton("Back");
        back.setBounds(915,270,120,25);
        back.setBackground(new Color(0,0,0));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        //size of that box
        setSize(1200,600);
        setLocation(50,100);
        setVisible(true);
    }
       
    //abstract class function to perform actions(pre-defined)
        public void actionPerformed(ActionEvent e) {
         if(e.getSource()==rules){
             String name=userName.getText();
                setVisible(false);
                new Rules(name);
        }
            else if(e.getSource()==back){
                setVisible(false);
            }
    } 
        
    public static void main(String args[]){
        new Login();
        
    }

}

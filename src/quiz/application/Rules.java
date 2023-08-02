package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    
    
    String name;
    JButton start,back;
    Rules(String name){
        this.name=name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
        
        //label for heading
        JLabel heading=new JLabel("Welcome " + name + " to MARVEL quiz Game");
        heading.setBounds(50,20,700,30);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,20));
        heading.setForeground(Color.RED);
        add(heading);
        
        //rules
        JLabel rules=new JLabel();
        rules.setBounds(20,90,700,350);
        rules.setFont(new Font("Tahoma",Font.PLAIN,20));
        rules.setText(
                "<html>"+ 
                "1. You will get 15 seconds for each question." + "<br><br>" +
                "2. You can use 50-50 lifeline once." + "<br><br>" +
                "3. All the questions are compulsory." + "<br><br>" +
               "<html>"
        );
        add(rules);
        
        //buttons
        
        back= new JButton("Back");
        back.setBounds(250,500,100,30);
        back.setBackground(new Color(0,0,0));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        start= new JButton("Start");
        start.setBounds(400,500,100,30);
        start.setBackground(new Color(0,0,0));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
    }
       
     public void actionPerformed(ActionEvent e) {
       if(e.getSource()==start){
           setVisible(false);
           new Quiz(name);
       }
       else{
           setVisible(false);
           new Login();
       }
    }
    
    public static void main(String args[]){
        new Rules("user");
    }

    
   
}

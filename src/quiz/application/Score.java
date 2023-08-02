
package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    
        Score(String name, int score){
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // set image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2=i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

    
        JLabel heading = new JLabel("Your score is : " + score);
        heading.setBounds(350, 200, 300, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add( heading);
        
        JLabel Lscore = new JLabel("Thankyou " + name + "for playing this game :");
        Lscore.setBounds(45, 30, 700, 30);
        Lscore.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add( Lscore);
        
        JButton submit = new JButton("Play again");
        submit.setBounds(400, 270, 120, 30);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Login();
    }
    public static void main(String args[]){
        new Score("User",0);
    }

   
}

package quiz.application;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Quiz extends JFrame implements ActionListener
{
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    ImageIcon i1;
    JLabel qno, question;
    String userAns[][] = new String[10][1];
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupOpt;
    JButton next, lifeline, submit;
    public static int timer = 15, ans_given = 0, count = 0, score = 0;
    String userName;
    Quiz(String userName)
    {
        this.userName=userName;
        
        setBounds(0, 0, 1366, 768);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // set image
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 320);
        add(image);

        // ques number
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        // question
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "What is the name of Thor’s hammer.?";
        questions[0][1] = "VANIR";
        questions[0][2] = "MJOLNIR";
        questions[0][3] = "AESIR";
        questions[0][4] = "NORN";

        questions[1][0] = "What is Captain America’s shield made of ?";
        questions[1][1] = "ADAMANTIUM";
        questions[1][2] = "VIBRANIUM";
        questions[1][3] = "PROMOTHUIM";
        questions[1][4] = "CARBONDIAM";

        questions[2][0] = " Before becoming Vision, what is the name of Iron Man’s A.I. butler ?";
        questions[2][1] = "H.O.M.E.R";
        questions[2][2] = "J.A.R.V.I.S";
        questions[2][3] = "A.L.F.R.E.D";
        questions[2][4] = "M.A.R.V.I.N";

        questions[3][0] = "What is the real name of the Black Panther ?";
        questions[3][1] = "T'CHALLA";
        questions[3][2] = "HAWK";
        questions[3][3] = "NOLAN";
        questions[3][4] = "N'JOBU";

        questions[4][0] = "What fake name does Natasha use when she first meets Tony?";
        questions[4][1] = "NATASHA ROMANOFF";
        questions[4][2] = "NATALIA RUMSON";
        questions[4][3] = "SWALINA MURDOK";
        questions[4][4] = "NAYA ROVE";

        questions[5][0] = "Where does Peggy tell Steve she wants to meet him for a dance, before he plunges into the ice?";
        questions[5][1] = "The Cotton Club";
        questions[5][2] = "The Stork Club";
        questions[5][3] = "El Morocco";
        questions[5][4] = "The Copacabana";

        questions[6][0] = "Who does the THANOS sacrifice to acquire the Soul Stone ?";
        questions[6][1] = "NEBULA";
        questions[6][2] = "EBONY";
        questions[6][3] = "GAMORA";
        questions[6][4] = "CULL ODISON";

        questions[7][0] = "What were the three items Rocket claims he needs in order to escape the prison?";
        questions[7][1] = "A security card, a fork, and an ankle monitor";
        questions[7][2] = "A security band, a battery, and a prosthetic leg";
        questions[7][3] = "A pair of binoculars, a detonator, and a prosthetic leg";
        questions[7][4] = "A knife, cable wires, and Peter’s mixtape";

        questions[8][0] = "Who is Black Panther’s sister?";
        questions[8][1] = "SHURI";
        questions[8][2] = "NAKIA";
        questions[8][3] = "RAMONDA";
        questions[8][4] = "OKAYA";

        questions[9][0] = "What landmark does Peter Parker rescue his classmates from in Spider-Man: Homecoming?";
        questions[9][1] = "Washington Monument";
        questions[9][2] = "Statue of Liberty";
        questions[9][3] = "Mount Rushmore";
        questions[9][4] = "Golden Gate Bridge";

        answers[0][1] = "MJOLNIR";
        answers[1][1] = "VIBRANIUM";
        answers[2][1] = "J.A.R.V.I.S";
        answers[3][1] = "T'CHALLA";
        answers[4][1] = "NATASHA ROMANOFF";
        answers[5][1] = "The Stork Club";
        answers[6][1] = "GAMORA";
        answers[7][1] = "A security band, a battery, and a prosthetic leg";
        answers[8][1] = "SHURI";
        answers[9][1] = "Washington Monument";

        // RADIO BUTTONS
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        //for select only one rdio button
        groupOpt = new ButtonGroup();
        groupOpt.add(opt1);
        groupOpt.add(opt2);
        groupOpt.add(opt3);
        groupOpt.add(opt4);

        // buttons for next , lifeline and submit
        next = new JButton("Next");
        next.setBounds(1100, 500, 200, 40);
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 550, 200, 40);
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 600, 200, 40);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);

        setVisible(true);
    }
    
// abstratct class pre defined method for perform actions on buttons
   public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == next)
        {
            repaint();//again play
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1;
            if (groupOpt.getSelection() == null)
            {
                userAns[count][0] = "";
            }
            else
            {
                userAns[count][0] = groupOpt.getSelection().getActionCommand();
            }

            if (count == 8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }
        else if (ae.getSource() == lifeline)
        {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9)
            {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }
            else
            {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
        else
        {
            // submit button
            ans_given = 1;
            if (groupOpt.getSelection() == null)
            {
                userAns[count][0] = "";
            }
            else
            {
                userAns[count][0] = groupOpt.getSelection().getActionCommand();
            }

            for (int i = 0; i < userAns.length; i++)
            {
                if (userAns[i][0].equals(answers[i][1]))
                {
                    score += 10;
                }
            }
            setVisible(false);
            new Score(userName,score);
        }
        
    }
         public void paint(Graphics g)
        {
            super.paint(g);
            //timer 

            String time = "Time left - " + timer + " seconds";
            g.setColor(Color.RED);
            g.setFont(new Font("Tahoma", Font.BOLD, 20));

            if (timer > 0)
            {
                g.drawString(time, 1100, 500);
            }
            else
            {
                g.drawString("Times Up !", 1100, 500);
            }
            timer--;

            try
            {
                Thread.sleep(1000);
                repaint();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            if (ans_given == 1)
            {
                ans_given = 0;
                timer = 15;
            }
            else if (timer < 0)
            {
                timer = 15;
                opt1.setEnabled(true);
                opt2.setEnabled(true);
                opt3.setEnabled(true);
                opt4.setEnabled(true);

                if (count == 8)
                {
                    next.setEnabled(false);
                    submit.setEnabled(true);
                }
                // submit
                if (count == 9)
                {
                    if (groupOpt.getSelection() == null)
                    {
                        userAns[count][0] = "";
                    }
                    else
                    {
                        userAns[count][0] = groupOpt.getSelection().getActionCommand();
                    }

                    for (int i = 0; i < userAns.length; i++)
                    {
                        if (userAns[i][0].equals(answers[i][1]))
                        {
                            score += 10;
                        }
                    }
                        setVisible(false);
                        new Score(userName,score);
                    
                }
                else{
                                if (groupOpt.getSelection() == null)
                                {
                                    userAns[count][0] = "";
                                }
                                else
                                {
                                    userAns[count][0] = groupOpt.getSelection().getActionCommand();
                                }
                                count++;
                                start(count);
                    }
                    
                }
            }
       
            
             public void start(int count){
                qno.setText("" + (count + 1) + ". ");
                question.setText(questions[count][0]);
                
                opt1.setText(questions[count][1]);
                opt1.setActionCommand(questions[count][1]);

                opt2.setText(questions[count][2]);
                opt2.setActionCommand(questions[count][2]);

                opt3.setText(questions[count][3]);
                opt3.setActionCommand(questions[count][3]);

                opt4.setText(questions[count][4]);
                opt4.setActionCommand(questions[count][4]);

                groupOpt.clearSelection();
            }

        
           public static void main(String args[])
            {
                new Quiz("User");
            }
}

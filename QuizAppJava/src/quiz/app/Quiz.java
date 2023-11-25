package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];  // for question array define with programmer
    String answers[][] = new String[10][2];     // for answer define with programmer
    String useranswers[][] = new String[10][1];// for define user define answer with user
    
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    String name;

    Quiz(String name) {
    	
        this.name = name;
//        setSize(1140,650);
        setBounds(50, 0, 1110, 850);
		setLocation(50,0);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz/app/icons/quiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1140, 300);
        add(image);
        
        
       //to define qus no. which place 
        qno = new JLabel();
        qno.setBounds(100,350,50,30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        // to which place the question on the frame 
        question = new JLabel();
        question.setBounds(150,350,500,30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        
        // Question presents 
        questions[0][0] = "Number of primitive data types in Java are.?";
        questions[0][1] = "6";
        questions[0][2] = "7";
        questions[0][3] = "8";
        questions[0][4] = "9";
        
        questions[1][0] = "What is the size of float and double in java.?";
        questions[1][1] = "32 and 64";
        questions[1][2] = "32 and 32";
        questions[1][3] = "64 and 64";
        questions[1][4] = "64 and 32";
        
        questions[2][0] = "Automatic type conversion is possible in which of the possible cases?";
        questions[2][1] = "Byte to int";
        questions[2][2] = "Int to Long";
        questions[2][3] = "Long to int";
        questions[2][4] = "Short to int";
        
        questions[3][0] = "When an array is passed to a method, what does the method receive?";
        questions[3][1] = "The reference of the array";
        questions[3][2] = "A copy of the array";
        questions[3][3] = "Length of the array";
        questions[3][4] = "Copy of first element";
        
        questions[4][0] = "Arrays in java are.?";
        questions[4][1] = "Object References";
        questions[4][2] = "Objects";
        questions[4][3] = "Primitive data type";
        questions[4][4] = "None";
        
        questions[5][0] = "When is the object created with new keyword?";
        questions[5][1] = "At rum time";
        questions[5][2] = "At compile time";
        questions[5][3] = "Depends on the code";
        questions[5][4] = "None";
        
        questions[6][0] = "Identify the corrected definition of a package.?";
        questions[6][1] = "A package is a collection of editing tools";
        questions[6][2] = "A package is a collection of Classes";
        questions[6][3] = "A package is a collection of Classes and interfaces";
        questions[6][4] = "A package is a collection of interfaces";
        
        questions[7][0] = "compareTo() returns";
        questions[7][1] = "True";
        questions[7][2] = "False";
        questions[7][3] = "An int value";
        questions[7][4] = "None";
        
        questions[8][0] = "To which of the following does the class string belong to.";
        questions[8][1] = "java.lang";
        questions[8][2] = "java.awt";
        questions[8][3] = "java.applet";
        questions[8][4] = "java.String";
        
        questions[9][0] = "Total constructor string class have.?";
        questions[9][1] = "3";
        questions[9][2] = "7";
        questions[9][3] = "13";
        questions[9][4] = "20";
        
        
        //Answers presents 
        answers[0][1] = "8";
        answers[1][1] = "32 and 64";
        answers[2][1] = "Int to Long";
        answers[3][1] = "The reference of the array";
        answers[4][1] = "Objects";
        answers[5][1] = "At rum time";
        answers[6][1] = "A package is a collection of Classes and interfaces";
        answers[7][1] = "An int value";
        answers[8][1] = "java.lang";
        answers[9][1] = "13";
        
        // first option place on the place in the frame 
        opt1 = new JRadioButton();
        opt1.setBounds(170,420,400,30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        
        //second option place on the place in the frame 
        opt2 = new JRadioButton();
        opt2.setBounds(170,460,400,30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        
        //third option place on the place in the frame 
        opt3 = new JRadioButton();
        opt3.setBounds(170,500,400,30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        
        //forth option place on the place in the frame 
        opt4 = new JRadioButton();
        opt4.setBounds(170,540,400,30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        
        // to provide the option in the one group
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        
        // to which place define the button next 
        next = new JButton("Next");
        next.setBounds(450,570,200,30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        // which placed Help button 
        lifeline = new JButton("Help");
        lifeline.setBounds(670,570,200,30);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lifeline.setBackground(new Color(22, 99, 54));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        
        // which placed submit button on the scrren
        submit = new JButton("Submit");
        submit.setBounds(890,570,200,30);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(255, 215, 0));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        start(count);
        setVisible(true);  // to press the summit button then this open our Quiz page is closed
        
    }

    
    // to press the button to performed the action
    public void actionPerformed(ActionEvent ae) {
       
    	// ******if you press the next then action performed to define in the below*********
    	if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1;
            
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
            	
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
            
            
 //****** If you press the help button then action performed to define the action below*********
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
                
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
                
            }
            lifeline.setEnabled(false);
            
            
//******if you press the submit button then performed the action to define below*********
        }  else if (ae.getSource() == submit) {
            ans_given = 1;
            
            // if you do not select the option then performed the below 
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            for (int i = 0; i < useranswers.length; i++) {
            	
            	//if the match the programmer ans. to user ans.
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    
    // ***** to define the timer  setup and time up setup  to which place on the screen 
   public void paint(Graphics g) {        
      super.paint(g);        
      String time = "Time left - " + timer + " seconds";  //15        
      g.setColor(Color.RED);        
      g.setFont(new Font("Tahoma", Font.BOLD, 25));        
      
      if (timer > 0) {            
          g.drawString(time, 800, 500);        
     
      }else {            
           g.drawString("Times up!!", 800, 500);        
    
      } 
      timer--;  //14        
   
     try {            
         Thread.sleep(1000);            
         repaint();        
      
     } catch (Exception e) {            
        e.printStackTrace();        
     
     }        
    
      if (ans_given == 1) {           
         ans_given = 0;            
         timer = 15;        
      
      } else if (timer < 0) {           
             timer = 15;            
             opt1.setEnabled(true);            
             opt2.setEnabled(true);            
             opt3.setEnabled(true);            
             opt4.setEnabled(true);            
             if (count == 8) {                
                 next.setEnabled(false);                
                 submit.setEnabled(true);            }            
                
                if (count == 9) { //submit button                
                    
            	     if (groupoptions.getSelection() == null) 
                     {                    
                        useranswers[count][0] = "";                
               
                     } else {                    
                          useranswers[count][0] = groupoptions.getSelection().getActionCommand();                
                   
                    }                
                   for (int i = 0; i < useranswers.length; i++) {                    
                       
                    	if (useranswers[i][0].equals(answers[i][1])) {                        
                    	score += 10;                    
                       
                        } else {                        
                        score += 0;                    
                     }                
                  }                
                    setVisible(false);                
                    new Score(name, score);           
               
                } 
             else {  
                //next button                
                 if (groupoptions.getSelection() == null) {                    
                     useranswers[count][0] = "";               
                 } else {                    
                     useranswers[count][0] = groupoptions.getSelection().getActionCommand();                }                
                    
                    count++;  //0  1               
                     start(count);            
                   }        
                }    
            }

    public void start(int count) {
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
        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
package quiz.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	JTextField text;
	JButton Next , back;
	
	Login(){
		getContentPane().setBackground(Color.WHITE); //to set the backgraund of the frame
		setLayout(null);
		setSize(1000,500);  //set size of the frame 
		
		//set image in the frame
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("quiz/app/icons/login.png"));
		
		//to provide the image width and height
		Image i=i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i);
		
		//to image on the frame 
		JLabel image=new JLabel(i2); // use to visible any text and image on the frame (screen)
		
		// to set image which position
		image.setBounds(450, 0, 550, 500);
		add(image);
		
		JLabel heading =new JLabel("QUIZ TEST"); // to visible text on the screen (Frame)
		heading.setBounds(140, 60, 300, 45); // to set text which position to visible on the frame(Screen)
		heading.setFont(new Font("Viner Hand ITC" , Font.BOLD,40)); // to set color
		heading.setForeground(new Color(22,99,54));
		add(heading);
		
		JLabel name=new JLabel("Enter your Name:");
		name.setBounds(160, 150, 300, 20);
		name.setFont(new Font ("Monolian Baiti",Font.BOLD,18));
		name.setForeground(new Color(22,99,54));
		add(name);
		
		
		text=new JTextField();
		text.setBounds(80,200,300,25);
		text.setFont(new Font("Times New Roman",Font.BOLD,18));
		add(text);
		
		//To Set Button Next
		Next=new JButton("Next");
		Next.setBounds(100, 270, 120, 25);
		Next.setBackground(new Color(22,99,54));
		Next.setForeground(Color.WHITE);
		add(Next);
		Next.addActionListener(this);// to click on the button to go to override actionPerfomed 

		
		
		//To set Button Back 
		back=new JButton("Back");
		back.setBounds(250, 270, 120, 25);
		back.setBackground(new Color(22,99,54));
		back.setForeground(Color.WHITE);
		add(back);
		back.addActionListener(this); // to click the button then go to actionPerfomed the perform action

		
		setLocation(180,100); // frame open to center on the screen
		
		// visibility by default hide hota hai so frame show karne ke liye 
//		setUndecorated(true);
		
		setVisible(true);
		
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==Next) // when Next button click then condition true
		{
			
			String name = text.getText();
			new Rules(name);
			setVisible(false);

		}
		else if(e.getSource()==back) {   // when back button click
			
			System.exit(50);
		}
		
	}



	public static void main(String args[]) {
		new Login();
	}
	
	
}

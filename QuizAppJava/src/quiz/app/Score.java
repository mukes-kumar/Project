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

public class Score extends JFrame implements ActionListener{

	JButton exit;
	 Score(String name , int score)
	{
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("quiz/app/icons/score.png"));
		Image i2= i1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(60,200,200,150 );
		add(image);
		
		
		JLabel heading = new JLabel("Thankyou " +name+ "for Playing QUIZ Test ");
		heading.setBounds(100,0,700,300);
		heading.setFont(new Font("Tahuma" , Font.BOLD,26));
		add(heading);
		
		JLabel Score = new JLabel(" Your Score is : " +score);
		Score.setBounds(350,100,1000,300);
		Score.setFont(new Font("Tahuma" , Font.BOLD,26));
		add(Score);
		

		exit = new JButton("Exit");
		exit.setBounds(380,270,120,30);
		exit.setBackground(new Color(22,99,54));
		exit.setForeground(Color.WHITE);
		exit.addActionListener(this);
		add(exit);
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new Login();
				
			}
			
		});
		
		
		ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("quiz/app/icons/back.png"));
		Image i22= i11.getImage().getScaledInstance(750, 500, Image.SCALE_DEFAULT);
		ImageIcon i33= new ImageIcon(i22);
		JLabel imagee= new JLabel(i33);
		imagee.setBounds(0,0,750,550 );
		add(imagee);
		
		
		
		setSize(750,550);
		setLocation(400,150);
		setLayout(null);
		setVisible(true);
		
//		setUndecorated(true);

		
		
		
	}
	
	
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		if(e.getSource()==exit) {
//			
////			System.exit(50);
//			setVisible(false);
//			new Login();
//			
//		}
//		
//		
//	}



	public static void main(String args[]) {
		new Score("User",0);
	}
	
	
}

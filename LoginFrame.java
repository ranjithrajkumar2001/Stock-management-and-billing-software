package bootathon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;  
public class LoginFrame extends JFrame  implements Serializable{
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton Submit;
	public LoginFrame() {
		setBounds(500,150,900,800);
		setLayout(null); 
		setResizable(false);
	}
	void makeLoginUI() {
               // Image i = Toolkit.getDefaultToolkit().getImage("D:/New folder/nsp.jpeg");
//                          setDefaultCloseOperation(3);
		JLabel heading = new JLabel("LOGIN");
		heading.setForeground(new Color(179, 170, 57));
		heading.setBounds(400,215,400,40);
		Font myfont = new Font("Times New Roman", Font.BOLD, 20);
		setContentPane(new JLabel(new ImageIcon("/root/Downloads/bg1.jpg")));
		heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
		add(heading);
		l1 = new JLabel("USERNAME");
		l2 = new JLabel("PASSWORD");
		l1.setBounds(200, 275, 200, 50);
		l2.setBounds(200, 345, 200, 50);
		l1.setFont(myfont);
		l1.setForeground(new Color(179, 170, 57));
		l2.setFont(myfont);
		l2.setForeground(new Color(179, 170, 57));
		t1 = new JTextField();
		t2 = new JPasswordField();
		t1.setBounds(350, 285, 200, 30);
		t2.setBounds(350, 355, 200, 30);
		t1.setFont(myfont);
		t2.setFont(myfont);
		t1.setBackground(new Color(241, 242, 230));
                t2.setBackground(new Color(241, 242, 230));
	       t1.setForeground(new Color(22, 23, 12));
		t1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//t1.setBackground(Color.YELLOW);
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				// TODO Auto-generated method stub
				
			}
		});
		   t2.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//t2.setBackground(Color.YELLOW);
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		t2.setBackground(Color.WHITE);
		t2.setForeground(new Color(22, 23, 12));
		Submit = new JButton("LOGIN");
		Submit.setBackground(new Color(232, 30, 30));
		Submit.setBounds(405,420,90,40);
                Submit.setForeground(Color.white);
		//Submit.setIcon(new ImageIcon("/root/Downloads/button.jpg"));
		Submit.setHorizontalTextPosition(SwingConstants.CENTER);
		Submit.setFont(new Font("Times New Roman", Font.BOLD,15));
	}
}
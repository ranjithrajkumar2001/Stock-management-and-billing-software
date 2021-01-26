package bootathon;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Jobcard extends JFrame{
	JLabel Label1,Label2,Label3;
        Jobcard j;
   
        	JButton b ;
	JTextField spareName,brand,breed;
	public Jobcard() {
		// TODO Auto-generated constructor stub
		//p1 = (PetrolFrame)obj;
                setBackground(new Color(242, 252, 251));
		j=this;
                b = new JButton("ADD");
		spareName = new JTextField();
                brand = new JTextField();
                breed = new JTextField();
		setLayout(null);
		setBounds(625,260,660,610);
		setContentPane(new JLabel(new ImageIcon("/root/Downloads/bg1.jpg")));
		makeSpareUI();
		getContentPane().setBackground(new Color(135,206,230));
	}
	public void makeSpareUI() {
                Font myfont = new Font("Times New Roman",Font.PLAIN,20);
		Label1 = new JLabel(" SPARE NAME                      :");
		JLabel heading = new JLabel("ADD SPARES TO BUY");
		heading.setBounds(255,0,400,40);
		heading.setFont(new Font("Times New Roman",Font.BOLD,20));
		heading.setForeground(Color.red);
		add(heading);
		Label1.setBounds(50,70,330,50);
		Label1.setForeground(Color.black);
		Label1.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label1);
		Label2 = new JLabel("BRAND SUPPORTED        :");
		Label2.setBounds(50,140,300,50);
		Label2.setForeground(Color.black);
		Label2.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label2);
		Label3 = new JLabel("FUEL TYPE                         :");
		Label3.setBounds(50,210,300,50);
		Label3.setForeground(Color.black);
		Label3.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label3);
		//spareName = new JTextField();
		spareName.setBounds(420,70,200,40);
		spareName.setFont(myfont);
		add(spareName);
		//brand = new JTextField();
		brand.setBounds(420,140,200,40);
		brand.setFont(myfont);
		add(brand);
		//breed = new JTextField();
		breed.setBounds(420,210,200,40);
		breed.setFont(myfont);
		add(breed);
		addButton();
		setVisible(true);
		
	}
	void addButton() {
	
		b.setFont(new Font("Times New Roman",Font.BOLD,20));
		b.setBounds(235,370,150,50);
		b.setBackground(new Color(6, 57, 120));
		b.setForeground(Color.WHITE);
		b.setIcon(new ImageIcon("/root/Downloads/button.jpg"));
		b.setHorizontalTextPosition(SwingConstants.CENTER);
		add(b);
	}
//	public static void main(String[] args) {
//		new Jobcard().makeSpareUI();
//	}
}
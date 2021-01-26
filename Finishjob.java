package bootathon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Finishjob extends JFrame{
	String breed;
	String type;
	String brand;
	JLabel Label1,Label2,Label3,Label4;
	JLabel spareName,brandname,fueltype;
	DieselFrame d1;
	PetrolFrame p1;
	ArrayList<String> data;
        JButton b ;
        String s1,s2,s3;
	public Finishjob(String spare) {
		// TODO Auto-generated constructor stub
		//p1 = (PetrolFrame)obj;
                setBackground(new Color(242, 254, 255));
                b = new JButton("FINISHED");
		data = new ArrayList<String>();
		setLayout(null);
		setBounds(625,260,660,610);
		setContentPane(new JLabel(new ImageIcon("/root/Downloads/bg1.jpg")));
		makeSpareUI();
		setVisible(true);
		getContentPane().setBackground(new Color(135,206,230));
                Database db=new Database();
                System.out.println(spare);
                data=db.finishspare(spare);
                System.out.println(data);
                s1=data.get(0);
                System.out.println(s1);
                 s2=data.get(1);
                System.out.println(s2);
                 s3=data.get(2);
                System.out.println(s3);
                
	}
	public void makeSpareUI() {
                System.out.println(data);

//                Object str[]=data.toArray();
//                String s1=(String)str[0];
//                String s2=(String)str[1];
//                String s3=(String)str[2];
//                System.out.print(s1);
//                System.out.print(s2);
//                System.out.print(s3);
		Font myfont = new Font("Times New Roman",Font.BOLD,20);
		JLabel heading = new JLabel("SCHEDULED JOBS");
		heading.setBounds(250,0,400,50);
		heading.setFont(new Font("Times New Roman",Font.BOLD,20));
		heading.setForeground(Color.red);
		add(heading);
		Label1 = new JLabel(" SPARE NAME                    :");
		Label1.setBounds(50,70,400,50);
		Label1.setForeground(Color.black);
		Label1.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(Label1);
		Label2 = new JLabel("BRAND NAME                    :");
		Label2.setBounds(50,140,400,50);
		Label2.setForeground(Color.black);
		Label2.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(Label2);
		Label3 = new JLabel("FUEL TYPE                      :");
		Label3.setBounds(50,210,400,50);
		Label3.setForeground(Color.black);
		Label3.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(Label3);
		spareName = new JLabel(s1);
		spareName.setBounds(420,70,150,40);
		spareName.setFont(myfont);
		add(spareName);
		brandname = new JLabel(s2);
		brandname.setBounds(420,140,150,40);
		brandname.setFont(myfont);
		add(brandname);
		fueltype= new JLabel(s3);
		fueltype.setBounds(420,210,150,40);
		fueltype.setFont(myfont);
		add(fueltype);
		addButton();
	}
	void addButton() {
		
		b.setFont(new Font("Times New Roman",Font.BOLD,20));
		b.setBounds(230,370,150,50);
		b.setBackground(new Color(6, 57, 120));
		b.setForeground(Color.WHITE);
		b.setIcon(new ImageIcon("/root/Downloads/button.jpg"));
		b.setHorizontalTextPosition(SwingConstants.CENTER);
		
		add(b);
	}
}
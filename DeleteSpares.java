package bootathon;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeleteSpares extends JFrame{
	String breed;
	String type;
	String brand;
	JLabel Label1,Label2,Label3,Label4;
	JLabel spareName,vehicleSuported,quantity,prize;
	DieselFrame d1;
	PetrolFrame p1;
        ArrayList<String> str;
        DeleteSpares d;
	public DeleteSpares(String type, String brand, String breed, JFrame obj) {
		// TODO Auto-generated constructor stub
                d=this;
                setBackground(new Color(242, 254, 255));
                Database db=new Database();
                str=db.sparedret(type,brand,breed);
                spareName=new JLabel(str.get(1));
                vehicleSuported=new JLabel(str.get(0));
                quantity=new JLabel(str.get(2));
                prize=new JLabel(str.get(3));
                
		if(breed.equals("Diesel")) {
			d1 = (DieselFrame)obj;
                        
		}
		else {
			p1 = (PetrolFrame)obj;
		}
		this.type = type;
		this.brand = brand;
		this.breed = breed;
		setLayout(null);
		setBounds(625,260,660,610);
		setContentPane(new JLabel(new ImageIcon("/root/Downloads/bg1.jpg")));
		makeSpareUI();
		
		setVisible(true);
		getContentPane().setBackground(new Color(135,206,230));
	}
	public void makeSpareUI() {
		Font myfont = new Font("Times New Roman",Font.BOLD,20);
		JLabel heading = new JLabel(breed+" BASED "+type+" IN "+brand);
		heading.setBounds(150,0,400,40);
		heading.setFont(new Font("Times New Roman",Font.BOLD,18));
		heading.setForeground(Color.red);
		add(heading);
		Label1 = new JLabel(" SPARE NAME                      :");
		Label1.setBounds(40,70,330,50);
		Label1.setForeground(Color.black);
		Label1.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label1);
		Label2 = new JLabel("VEHICLE SUPPORTED        :");
		Label2.setBounds(50,140,300,50);
		Label2.setForeground(Color.black);
		Label2.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label2);
		Label3 = new JLabel("QUANTITY                           :");
		Label3.setBounds(50,210,300,50);
		Label3.setForeground(Color.black);
		Label3.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label3);
		Label4 = new JLabel("PRIZE                                  :");
		Label4.setBounds(50,280,300,50);
		Label4.setForeground(Color.black);
		Label4.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label4);
		//spareName = new JLabel(type);
		spareName.setBounds(420,140,200,40);
		spareName.setFont(myfont);
		add(spareName);
		//vehicleSuported = new JLabel("All Brands");
		vehicleSuported.setBounds(420,70,200,40);
		vehicleSuported.setFont(myfont);
		add(vehicleSuported);
		//quantity = new JLabel("0");
		quantity.setBounds(420,210,200,40);
		quantity.setFont(myfont);
		add(quantity);
		//prize = new JLabel("1000");
		prize.setBounds(420,280,200,40);
		prize.setFont(myfont);
		add(prize);
		addButton();
	}
	void addButton() {
		JButton b = new JButton("DELETE");
		b.setFont(new Font("Times New Roman",Font.BOLD,20));
		b.setBounds(200,370,300,50);
		b.setBackground(new Color(232, 30, 30));
		b.setForeground(Color.WHITE);
		b.setIcon(new ImageIcon("/root/Downloads/button.jpg"));
		b.setHorizontalTextPosition(SwingConstants.CENTER);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(breed.equals("Diesel")) {
					Database db = new Database();
					boolean flag=db.deletespare(str.get(0),brand,breed); 
                                        System.out.println(spareName.getText());
                                        if(flag) {
					 JOptionPane.showMessageDialog(d,"Deleted Succesfully"); 
                                         d1.addLable(brand);
					d1.addCombo(brand);
					d1.addButton(brand);
                                         setVisible(false);
                                         }
                                    else {
					 JOptionPane.showMessageDialog(d,"Enter Valid Credentials"); 
                                        }
					
				}
				else {
					Database db = new Database();
					boolean flag2=db.deletespare(str.get(0),brand,breed); 
                                         if(flag2) {
					 JOptionPane.showMessageDialog(d,"Deleted Succesfully"); 
                                         p1.addLable(brand);
					 p1.addCombo(brand);
					 p1.addButton(brand);
                                         setVisible(false);
                                         }
                                    else {
					 JOptionPane.showMessageDialog(d,"Enter Valid Credentials"); 
                                        }
					
			}
                        }
		});
		add(b);
	}
}
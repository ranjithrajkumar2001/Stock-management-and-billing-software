package bootathon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateSpares extends JFrame{
	String breed;
	String type;
	String brand;
	JLabel Label1,Label2,Label3,Label4,Label5;
	JTextField spareName,vehicleSuported,quantity,prize,threshold;
	DieselFrame d1;
	PetrolFrame p1;
        CreateSpares c;
	public CreateSpares(String type, String brand, String breed,JFrame obj) {
		// TODO Auto-generated constructor stub
		//p1 = (PetrolFrame)obj;
                c=this;
                setBackground(new Color(242, 254, 255));
                spareName=new JTextField();
                vehicleSuported=new JTextField();
                quantity=new JTextField();
                prize=new JTextField();
                threshold=new JTextField();
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
		JLabel heading = new JLabel(breed+" BASED "+"SPARE"+" IN "+brand);
		heading.setBounds(150,0,400,40);
		heading.setFont(new Font("Times New Roman",Font.BOLD,18));
		heading.setForeground(Color.red);
		add(heading);
		Label1 = new JLabel(" SPARE NAME                 ");
		Label1.setBounds(40,70,330,50);
		Label1.setForeground(Color.black);
		Label1.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label1);
		Label2 = new JLabel("VEHICLE SUPPORTED        ");
		Label2.setBounds(50,140,300,50);
		Label2.setForeground(Color.black);
		Label2.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label2);
		Label3 = new JLabel("QUANTITY                    ");
		Label3.setBounds(50,210,300,50);
		Label3.setForeground(Color.black);
		Label3.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label3);
		Label4 = new JLabel("PRIZE                         ");
		Label4.setBounds(50,280,300,50);
		Label4.setForeground(Color.black);
		Label4.setFont(new Font("Times New Roman",Font.PLAIN,20));
		add(Label4);
                Label5 = new JLabel("THRESHOLD                  ");
		Label5.setBounds(50,350,300,50);
		Label5.setFont(new Font("Times New Roman",Font.PLAIN,20));
		Label5.setForeground(Color.black);
                add(Label5);
		//spareName = new JTextField();
		spareName.setBounds(420,70,200,40);
		spareName.setFont(myfont);
		add(spareName);
		//vehicleSuported = new JTextField();
		vehicleSuported.setBounds(420,140,200,40);
		vehicleSuported.setFont(myfont);
		add(vehicleSuported);
		//quantity = new JTextField();
		quantity.setBounds(420,210,200,40);
		quantity.setFont(myfont);
		add(quantity);
		//prize = new JTextField();
		prize.setBounds(420,280,200,40);
		prize.setFont(myfont);
		add(prize);
                threshold.setBounds(420,350,200,40);
		threshold.setFont(myfont);
		add(threshold);
		addButton();
	}
	void addButton() {
		JButton b = new JButton("CREATE");
		b.setFont(new Font("Times New Roman",Font.BOLD,20));
		b.setBounds(200,440,300,50);
		b.setBackground(new Color(113, 153, 150));
		b.setForeground(Color.BLACK);
		b.setIcon(new ImageIcon("/root/Downloads/button.jpg"));
		b.setHorizontalTextPosition(SwingConstants.CENTER);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(breed.equals("Diesel")) {
					Database db = new Database();
					boolean flag=db.addspare(spareName.getText(),breed,vehicleSuported.getText(),quantity.getText(),prize.getText(),brand,threshold.getText());
                                       // System.out.println("hello");
                                         if(flag) {
					 JOptionPane.showMessageDialog(c,"New spare added Succesfully"); 
                                         d1.addLable(brand);
					d1.addCombo(brand);
					d1.addButton(brand);
                                         setVisible(false);
                                         }
                                    else {
					 JOptionPane.showMessageDialog(c,"Enter Valid Credentials"); 
                                        }
					
				}
				else {
					Database db = new Database();
					boolean flag2=db.addspare(spareName.getText(),breed,vehicleSuported.getText(),quantity.getText(),prize.getText(),brand,threshold.getText()); 
                                        
                                          if(flag2) {
					 JOptionPane.showMessageDialog(c,"New spare added Succesfully"); 
                                       	p1.addLable(brand);
					p1.addCombo(brand);
					p1.addButton(brand);
                                        setVisible(false);
                                        }
                                          else
                                          {
                                               JOptionPane.showMessageDialog(c,"Enter Valid Credentials"); 
                                          }
			}
                        }
		});
		add(b);
	}
	
}
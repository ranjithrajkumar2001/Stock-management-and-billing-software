package bootathon;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;  

public class Spares extends JFrame  implements Serializable{
	JButton petrol,diesel;
	JButton delete;
//	int key; 
	public Spares() {
		
		petrol = new JButton();
		diesel = new JButton();
		setContentPane(new JLabel(new ImageIcon("/root/Downloads/bg1.jpg")));
		setBounds(625,260,660,610);
		setLayout(null); 
	}
	void makeSparesUI() {
            
             setBackground(new Color(242, 254, 255));
             JButton addField = new JButton("ADD");
              Font myfont = new Font("Times New Roman", Font.BOLD, 20);
		petrol.setBounds(85,100,200,200);
		petrol.setFont(myfont);
		petrol.setForeground(Color.BLACK);
		petrol.setBackground(new Color(162, 191, 46));
		petrol.setIcon(new ImageIcon("D:/petrologo.png"));
		petrol.setHorizontalTextPosition(SwingConstants.CENTER);
		diesel.setBounds(350,100,200,200);
		diesel.setFont(myfont);
		diesel.setIcon(new ImageIcon("D:/dieselogo.png"));
		diesel.setBackground(new Color(46, 148, 166));
		diesel.setForeground(Color.BLACK);
		diesel.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setBounds(220,420,200,50);
		delete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 delete.setForeground(Color.WHITE);
                delete.setBackground(new Color(232, 30, 30));
		delete.setIcon(new ImageIcon("/root/Downloads/button.jpg"));
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		
	}
}
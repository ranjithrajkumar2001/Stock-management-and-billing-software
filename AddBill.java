package bootathon;
import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;  

public class AddBill extends JFrame  implements Serializable{
	JComboBox spareList,Lable;
	JButton add;
	public AddBill() {
		// TODO Auto-generated constructor stub
		createFrame();
	}
	void createFrame() {       
            setBackground(new Color(242, 254, 255));
        setContentPane(new JLabel(new ImageIcon("/root/Downloads/bg1.jpg")));
        setBounds(625,260,660,610);
		setLayout(null);
		addLable();
		addCombo();
	}
	void addLable() {
        JLabel lable = new JLabel("CHOOSE BRAND AND TYPE");        
        Font myfont = new Font("TIMES NEW ROMAN", Font.BOLD, 20);
        Font myfont1 = new Font("TIMES NEW ROMAN", Font.BOLD, 20);
        String type[]={"Petrol","Diesel"};
	Lable = new JComboBox(type);
        Lable.setBounds(120,200,150,50);
        Lable.setForeground(Color.black);
        Lable.setFont(myfont1);
	Lable.setVisible(true);
	add(Lable);
	}
	void addCombo() {
            Database db=new Database();
        Font myfont = new Font("roboto", Font.BOLD, 20);
		Object brand[]=db.brandNames().toArray();         
		spareList = new JComboBox(brand);
		spareList.setBounds(400,200,150,50);
        spareList.setFont(myfont);
		spareList.setVisible(true);
		add(spareList);
	}
     
}
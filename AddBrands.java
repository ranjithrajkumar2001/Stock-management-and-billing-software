package bootathon;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;  


public class AddBrands extends JFrame  implements Serializable{
	public AddBrands() {
		setLayout(null);
		setContentPane(new JLabel(new ImageIcon("/root/Downloads/bg1.jpg")));
		setBounds(625,260,660,610);
                setBackground(new Color(242, 254, 255));
               
	}
	void makeUI() {
		JLabel nameOfBrand = new JLabel("ENTER BRAND NAME");
                nameOfBrand.setForeground(Color.red);
		nameOfBrand.setFont(new Font("Times New Roman", Font.BOLD, 20));
		//nameOfBrand.setForeground(Color.red);
		nameOfBrand.setBounds(230,50,300,50);
                nameOfBrand.setBackground(new Color(242, 254, 255));
		add(nameOfBrand);
	}
}
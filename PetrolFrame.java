
package bootathon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;  

public class PetrolFrame extends JFrame  implements Serializable{
	JComboBox spareList;
	String brand;
	String breed;
	PetrolFrame f;
	public PetrolFrame() {
		// TODO Auto-generated constructor stub
                spareList = new JComboBox();
		f = this;
		this.breed = "Petrol";
	}
	void createFrame(String brand) {
                setBackground(new Color(242, 254, 255));
		this.brand = brand;
		setBounds(625,260,660,610);
		setLayout(null);
	        setContentPane(new JLabel(new ImageIcon("/root/Downloads/bg1.jpg")));
		addLable(brand);
		addCombo(brand);
		addButton(brand);
	        setVisible(true);
	}
	void addLable(String brand) {
                
                Font myfont = new Font("TIMES NEW ROMAN", Font.BOLD, 20);
                Font myfont1 = new Font("TIMES NEW ROMAN", Font.BOLD, 20);
		JLabel brandName = new JLabel(brand+" PETROL BASED SPARES");
		brandName.setBounds(150,55,700,60);
                brandName.setForeground(Color.red);
                brandName.setFont(myfont);
		brandName.setVisible(true);
		add(brandName);
		JLabel Lable = new JLabel("SPARE  :");
		Lable.setBounds(140,207,300,60);
                Lable.setForeground(Color.black);
                Lable.setFont(myfont1);
		Lable.setVisible(true);
		add(Lable);
	}
	void addCombo(String brand) 
        {
                Database db=new Database();
                Font myfont = new Font("TIMES NEW ROMAN", Font.BOLD, 20);
		Object spare[]=db.spare("petrol", brand).toArray(); 
                System.out.println(db.spare("petrol", brand));
		spareList.removeAllItems();
                for(Object s:spare)
                {
                    spareList.addItem(s);
                }
		spareList.setBounds(250,210,250,50);
                spareList.setFont(myfont);
		spareList.setVisible(true);
		add(spareList);
	}
	void addButton(String brand){
                Font myfont = new Font("TIMES NEW ROMAN", Font.BOLD, 15);
		JButton create,read,update,delete;                
		create = new JButton("CREATE");
		read = new JButton("VIEW");
		update = new JButton("UPDATE");
		delete = new JButton("DELETE");
                
//                create.setIcon(new ImageIcon("/root/Downloads/createbg.jpeg"));
//                read.setIcon(new ImageIcon("/root/Downloads/readbg.jpeg"));
//                update.setIcon(new ImageIcon("/root/Downloads/updatebg.jpeg"));
//                delete.setIcon(new ImageIcon("/root/Downloads/deletebg.jpeg"));
                validate();
                create.setHorizontalTextPosition(SwingConstants.CENTER);
                read.setHorizontalTextPosition(SwingConstants.CENTER);
                update.setHorizontalTextPosition(SwingConstants.CENTER);
                delete.setHorizontalTextPosition(SwingConstants.CENTER);
                create.setBackground(new Color(6, 57, 120));
                read.setBackground(new Color(6, 57, 120));
                create.setForeground(Color.WHITE);
                update.setForeground(Color.WHITE);
                read.setForeground(Color.WHITE);
                 delete.setForeground(Color.WHITE);
                delete.setBackground(new Color(232, 30, 30));
                update.setBackground(new Color(6, 57, 120));
                
                create.setFont(myfont);
                read.setFont(myfont);
                update.setFont(myfont);
                delete.setFont(myfont);

		create.setBounds(130,350,150,40);
		read.setBounds(390,350,150,40);
		update.setBounds(130,450,150,40);
		delete.setBounds(390,450,150,40);
		
		create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = (String) spareList.getSelectedItem();
				new CreateSpares(s, brand, "Petrol",f).makeSpareUI();
			}
		});
		
		read.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = (String) spareList.getSelectedItem();
				new ViewSpares(s, brand, "Petrol",f).makeSpareUI();
			}
		});
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = (String) spareList.getSelectedItem();
				new UpdateSpares(s, brand, "Petrol",f).makeSpareUI();
			}
		});
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = (String) spareList.getSelectedItem();
				new DeleteSpares(s, brand, "Petrol",f).makeSpareUI();
			}
		});
		create.setVisible(true);
		read.setVisible(true);
		update.setVisible(true);
		delete.setVisible(true);
		add(create);
		add(read);
		add(update);
	    add(delete);           
	}
}
package bootathon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

public class Bill extends JFrame{
	String breed;
	String type;
	String brand;
	JLabel Label1,Label2,Label3,Label4;
	JLabel spareName,vehicleSuported,quantity,prize;
	public Bill() {
		// TODO Auto-generated constructor stub
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	}
	void makeBill(ArrayList<String> spare, ArrayList<String> quanity, ArrayList<String> prize) {
            try{
            File file=new File("bill.txt");
            if(!(file.exists()))
                    {
                        file.createNewFile();
                    }
            FileWriter fw=new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw=new BufferedWriter(fw);
            Date today=new Date();
            SimpleDateFormat f1=new SimpleDateFormat("dd MMMMM yyyy");
            SimpleDateFormat f2=new SimpleDateFormat("h:mm a");
            bw.write("              NS POWERDRIVE");
            bw.newLine();
            bw.write("DATE: "+f1.format(today));
            bw.newLine();
            bw.write("TIME: "+f2.format(today));
            bw.newLine();
            bw.write("--------------------------------------------------------");
            bw.newLine();
            bw.write("1/54,MTP Main Road");
            bw.newLine();
            bw.write("Opp Thambu HR.Sec School,");
            bw.newLine();
            bw.write("Press Colony,Coimbatore-19");
            bw.newLine();
            bw.write("Phone number:9600 676 888");
            bw.newLine();
            bw.write("Gmail:nspowerdrive@gmail.com");
            bw.newLine();
	 JLabel imageicon = new JLabel();
	 ImageIcon img = new ImageIcon("D:/nsp.jpeg");
	 imageicon.setIcon(new ImageIcon(img.getImage().getScaledInstance(130,100,Image.SCALE_SMOOTH)));
	 imageicon.setBounds(130,20,130,50);
	 add(imageicon);
   	 JLabel companyname=new JLabel("NS power Drives");	
   	 Font myfont = new Font("Times New Roman", Font.CENTER_BASELINE, 15);
   	 companyname.setFont(myfont);
   	 companyname.setBounds(130, 60, 200, 30);
   	 JLabel dashboard=new JLabel("----------------------------------------------------------------------");	
         bw.write("--------------------------------------------------------");
         bw.newLine();
   	 dashboard.setFont(myfont);
   	 dashboard.setBounds(0, 70, 500, 30);
   	 JLabel adress1=new JLabel("99c kempatty colony");	
   	 adress1.setFont(myfont);
   	 adress1.setBounds(110, 90, 500, 30);
  	 JLabel adress2=new JLabel("Street-7 South ukkadam,cbe-1");	
  	 adress2.setFont(myfont);
  	 adress2.setBounds(90, 110, 500, 30);
  	 JLabel line1=new JLabel("----------------------------------------------------------------------");	
  	 line1.setFont(myfont);
  	 line1.setBounds(0, 130, 500, 30);
  	 bw.write("     Spare           Quantity            Price");
         bw.newLine();
         bw.write("--------------------------------------------------------");
         bw.newLine();
         JLabel heading = new JLabel("    Spare                     Quantity                        Price");
  	 heading.setBounds(0,150,500,30);
  	 heading.setFont(myfont);
  	 JLabel line2=new JLabel("----------------------------------------------------------------------");	
 	 line2.setFont(myfont);
 	 line2.setBounds(0, 170, 500, 30);
 	 int y = 190;
 	 int sum = 0;
 	 int iter = 0;
 	 for(String s: spare) {
 		 JLabel l1 = new JLabel(s);
 		 l1.setBounds(20,y,100,30);
 		 l1.setFont(myfont);
 		 add(l1);
 		 JLabel l2 = new JLabel(quanity.get(iter));
		 l2.setBounds(160,y,100,30);
		 l2.setFont(myfont);
		 add(l2);
		 String price = Integer.toString(Integer.parseInt(quanity.get(iter))*Integer.parseInt(prize.get(iter)));
		 JLabel l3 = new JLabel(price);
		 sum+=Integer.parseInt(price);
 		 l3.setBounds(290,y,100,30);
 		 l3.setFont(myfont);
 		 add(l3);
 		 y+=20;
                 bw.write("      "+s+"          "+quanity.get(iter)+"           "+price);
                 bw.newLine();
 		 iter++;
 	 }
         
 	 JLabel line3=new JLabel("----------------------------------------------------------------------");	
	 line3.setFont(myfont);
	 line3.setBounds(0, y, 500, 30);
	 y+=20;
	 String s = Integer.toString(sum);
	 //JLabel heading = new JLabel("Spare                     Quantity                          Prize");
	 JLabel totalcost = new JLabel("                   Total Prize                                "+s);
	 totalcost.setBounds(0,y,500,30);
	 totalcost.setFont(myfont);
	 y+=20;
	 JLabel line4=new JLabel("----------------------------------------------------------------------");	
	 line4.setFont(myfont);
	 line4.setBounds(0, y, 500, 30);
	 y+=10;
	 JLabel line5=new JLabel("----------------------------------------------------------------------");	
	 line5.setFont(myfont);
	 line5.setBounds(0, y, 500, 30);
	 y+=50;
	 JLabel line6=new JLabel("**********************************************************************");	
	 line6.setFont(myfont);
	 line6.setBounds(0, y, 500, 30);
         bw.write("--------------------------------------------------------");
         bw.newLine();
	 bw.write("        Total Prize        "+s);
         bw.newLine();
         bw.write("--------------------------------------------------------");
         bw.newLine();
         bw.write("--------------------------------------------------------");
         bw.newLine();
         bw.newLine();
         bw.write("*********************************************************");
         bw.newLine();
         bw.write("         Thank You,Come Again            ");
         bw.newLine();
         bw.write("*********************************************************");
         bw.newLine();
         bw.close();
         y+=20;
	 JLabel thank = new JLabel("                    Thank You,Come Again                            ");
	 thank.setBounds(0,y,500,30);
	 thank.setFont(myfont);
	 y+=20;
	 JLabel line7=new JLabel("**********************************************************************");	
	 line7.setFont(myfont);
	 line7.setBounds(0, y, 500, 30);
	 y+=20;
	 setBounds(400,100,370,y+80);
     add(adress1);
     add(adress2);
     add(companyname);
     add(line1);
     add(line3);
     add(heading);
     add(line2);
     add(line4);
     add(line5);
     add(line6);
     add(line7);
     add(thank);
     add(totalcost);
     add(dashboard);  
     
      
      }
            catch(Exception e)
            {
                
            }

        
	}
//	public static void main(String[] args) {
//		Bill b = new Bill();
//		ArrayList<String> spare,quantity,prize;
//		spare = new ArrayList<String>();
//		spare.add("Oil Filter");
//		spare.add("Air Filter");
//		spare.add("Cluch Plate");
//                spare.add("summa");
//		quantity = new ArrayList<String>();
//		quantity.add("3");
//		quantity.add("3");
//		quantity.add("1");
//                quantity.add("10");
//		prize = new ArrayList<String>();
//		prize.add("300");
//		prize.add("156");
//		prize.add("1000");
//                prize.add("300");
//		b.makeBill(spare,quantity,prize);
// 		b.setVisible(true);
//	}
}
package bootathon;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.io.*;

import java.util.ArrayList;  

class MainFrame extends JFrame implements Serializable
 {	  JPanel panel1,panel2,panel3,panel4,panel5;
 	  JScrollPane pa,pa1,pa2,pa3;
 	  JButton[] allBrands;	
          JButton[] availablejobs;
          JButton addjobcard;
          JTable j;
          ArrayList<String> alljobs;
 	  JComboBox<Object>[] billingField1;
 	  JTextField[] billingField2;
 	  JTextField[] billingField3;
 	  JButton[] billingField4;
          JButton logout;
          boolean flag;
 	  ArrayList<String> brands,brandforbill,typeforbill;
 	  Database db;
   	  int ite=0;
          int iterator=0;
          int jobiter=0;
   	  Image backgroundImage;
          JButton jobcard;
          JButton checkout;
          JButton analyse;
   	  public MainFrame() { 
          checkout=new JButton();
          alljobs=new ArrayList<String>();
          availablejobs=new JButton[100];
          addjobcard=new JButton("ADD");
          logout=new JButton("LOGOUT");
          jobcard=new JButton("NOTIFICATION");
   	  setResizable(false);	
   	  db = new Database();
          analyse=new JButton();
   	  allBrands = new JButton[100];
	  panel1 = new JPanel();
	  panel2 = new JPanel();
          panel4=new JPanel();
          panel5=new JPanel();
	  brands = new ArrayList<String>();
          brands=db.brandNames();
	  brandforbill = new ArrayList<String>();
	  typeforbill  = new ArrayList<String>();
          billingField1=new JComboBox[100];
          billingField2=new JTextField[100];
          billingField3=new JTextField[100];
          billingField4=new JButton[100];
   }
          

   void makeMainframeUI(){
       setContentPane(new JLabel(new ImageIcon("/root/Downloads/bg1.jpg")));
	    Font myfont = new Font("Times New Roman", Font.BOLD, 15);
	  //  setContentPane(new JLabel(new ImageIcon("/root/Downloads/bg1.jpg")));
                setDefaultCloseOperation(3);
	        setBounds(500,150,900,800);
                setDefaultCloseOperation(3);
		setLayout(null);
		setBackground(new Color(255, 255, 252));
                ImageIcon i2=new ImageIcon(new ImageIcon("D:/frame4.png").getImage().getScaledInstance(855,750,Image.SCALE_SMOOTH));
                JLabel image2=new JLabel();
                image2.setBounds(20,-15,1150,800);
                image2.setIcon(i2);
                add(image2);
		panel1.setBounds(130,80,640,600);
		panel1.setBackground(new Color(242, 254, 255));
		panel1.setPreferredSize(new Dimension(500, 500));
		panel1.setLayout(null);
		panel2.setBounds(130,80,640,600);
		panel2.setBackground(new Color(242, 254, 255));
		panel2.setVisible(false);
		panel2.setLayout(null);
		panel3 = new JPanel();
		panel3.setBounds(130,80,640,600);
		panel3.setBackground(new Color(242, 254, 255));
		panel3.setVisible(false);
		panel3.setLayout(null);
		panel5.setBounds(130,80,640,600);
		panel5.setBackground(new Color(242, 254, 255));
		panel5.setVisible(false);
		panel5.setLayout(null);
		add(panel1);
		add(panel2);
		add(panel3);
                add(panel5);
		//Creating Button
		JButton spares,billing,addUser;
		spares = new JButton("SPARES");
                spares.setForeground(Color.WHITE);
		spares.setIcon(new ImageIcon("/root/Downloads/pane1.jpeg"));
		spares.setHorizontalTextPosition(SwingConstants.CENTER);
		spares.setFont(myfont);
		spares.setBackground(new Color(217, 194, 22));
		spares.setBounds(80,30,150,40);
		spares.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(true);
				pa.setVisible(true);
				panel2.setVisible(false);
				pa1.setVisible(false);
				panel3.setVisible(false);
                                panel4.setVisible(false);
				pa2.setVisible(false);
                                panel5.setVisible(false);
                                pa3.setVisible(false);
                             			}
		});
		billing = new JButton("BILLING");
                billing.setForeground(Color.WHITE);
		billing.setIcon(new ImageIcon("/root/Downloads/pane2.jpeg"));
		billing.setHorizontalTextPosition(SwingConstants.CENTER);
		billing.setFont(myfont);
		billing.setBounds(380,30,150,40);
		billing.setBackground(new Color(217, 194, 22));
		billing.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pa.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(true);
				pa1.setVisible(true);
				panel3.setVisible(false);
                                panel4.setVisible(false);
				pa2.setVisible(false);
                                panel5.setVisible(false);
                                pa3.setVisible(false);
			}
		});
		addUser = new JButton("ADD USER");
		addUser.setIcon(new ImageIcon("/root/Downloads/pane3.jpeg"));
		addUser.setHorizontalTextPosition(SwingConstants.CENTER);
		addUser.setFont(myfont);
		addUser.setBounds(80,690,150,40);
                addUser.setForeground(Color.WHITE);
		addUser.setBackground(new Color(6, 57, 120));
		addUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pa.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
				pa1.setVisible(false);
				panel3.setVisible(true);
                                panel4.setVisible(false);
				pa2.setVisible(false);
                                panel5.setVisible(false);
                                pa3.setVisible(false);
				
			}
		});
                analyse = new JButton();
                analyse.setForeground(Color.WHITE);
		analyse.setIcon(new ImageIcon("/root/Downloads/pane1.jpeg"));
		analyse.setHorizontalTextPosition(SwingConstants.CENTER);
		analyse.setFont(myfont);
		analyse.setBackground(Color.WHITE);
		analyse.setBounds(410,690,80,40);
                analyse.setIcon(new ImageIcon("D:/analysebutton.png"));
                analyse.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                                pa.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
				pa1.setVisible(false);
				panel3.setVisible(false);
                                panel4.setVisible(false);
				pa2.setVisible(false);
                                panel5.setVisible(false);
                                pa3.setVisible(true);
//				
           }
       });
		
		logout.setIcon(new ImageIcon("/root/Downloads/pane3.jpeg"));
		logout.setHorizontalTextPosition(SwingConstants.CENTER);
		logout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		logout.setBounds(680,690,150,40);
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(232, 30, 30));
		add(logout);
                jobcard.setIcon(new ImageIcon("/root/Downloads/pane3.jpeg"));
		jobcard.setHorizontalTextPosition(SwingConstants.CENTER);
		jobcard.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jobcard.setBounds(680,30,150,40);
                jobcard.setForeground(Color.WHITE);
		jobcard.setBackground(new Color(217, 194, 22));
                jobcard.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               panel1.setVisible(true);
				pa.setVisible(false);
				panel2.setVisible(false);
				pa1.setVisible(false);
				panel3.setVisible(false);
                                panel4.setVisible(true);
				pa2.setVisible(true);
                                panel5.setVisible(false);
                                pa3.setVisible(false);
           }
       });
		add(jobcard);
		add(spares);
		add(billing);
		add(addUser);
                add(analyse);
   }
   void panel1Components(){
	   Font myfont = new Font("Times New Roman", Font.BOLD, 15);
	   JButton addNewBrand = new JButton();
	   addNewBrand.setFont(myfont);
          // addNewBrand.setBackground(new Color(50, 168, 135));
           addNewBrand.setBackground(new Color(242, 254, 255));
           addNewBrand.setIcon(new ImageIcon("D:/add4.png"));
	   addNewBrand.setHorizontalTextPosition(SwingConstants.CENTER);
	   addNewBrand.setBounds(530,20,80,40);
	   panel1.add(addNewBrand);
	   addNewBrand.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AddBrands add = new AddBrands();
					add.makeUI();
					JTextField text = new JTextField();
					text.setFont(myfont);
					text.setBounds(190,170,300,50);
					add.add(text);
					JButton addField = new JButton("ADD");
					addField.setFont(myfont);
					addField.setBackground(new Color(6, 57, 120));
					addField.setForeground(Color.WHITE);
					//.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\bootcampjava\\button.jpeg"));
					addField.setHorizontalTextPosition(SwingConstants.CENTER);
					addField.setBounds(290,260,100,40);
					add.add(addField);
					add.setVisible(true);
					addField.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							setVisible(false);
							Font buttonFont = new Font("Times New Roman", Font.BOLD, 30);
							//brands.add(text.getText());
                                                        db.addBrand(text.getText());
							makePanel1Dynamic();
							setVisible(true);
						}
					});
				}
			});
   }
   void panel2Components(){
            JLabel l1=new JLabel("SPARE");
            JLabel l2=new JLabel("QUANTITY");
            JLabel l3=new JLabel("PRICE");
            l1.setBounds(37,10,150,70);
            l2.setBounds(195,10,150,70);
            l3.setBounds(390,10,150,70);
            l1.setForeground(Color.red);
            l2.setForeground(Color.red);
            l3.setForeground(Color.red);
	   Font myfont = new Font("Times New Roman", Font.BOLD, 20);
	   JButton addNewItem = new JButton();
           l1.setFont(myfont);
           l2.setFont(myfont);
           l3.setFont(myfont);
	   addNewItem.setFont(myfont);
	   addNewItem.setHorizontalTextPosition(SwingConstants.CENTER);
	   addNewItem.setBounds(530,20,80,40);
           addNewItem.setBackground(new Color(242, 254, 255));
           addNewItem.setIcon(new ImageIcon("D:/add4.png"));
	   panel2.add(addNewItem);
           panel2.add(l1);
           panel2.add(l2);
           panel2.add(l3);
	   addNewItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AddBill add = new AddBill();
					JButton addField = new JButton("ADD");
					addField.setFont(myfont);
					addField.setBackground(new Color(6, 57, 120));
					addField.setForeground(Color.WHITE);
					//addField.setIcon(new ImageIcon("/root/Downloads/button.jpg"));
					addField.setHorizontalTextPosition(SwingConstants.CENTER);
					addField.setBounds(290,280,100,40);
					add.add(addField);
					add.setVisible(true);
					addField.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							setVisible(false);
							
							Font buttonFont = new Font("Times New Roman", Font.BOLD, 15);
							String s = (String) add.spareList.getSelectedItem();
							brandforbill.add(s);
							 s = (String) add.Lable.getSelectedItem();
							typeforbill.add(s);
							makePanel2Dynamic();
							setVisible(true);
						}
					});
					
				}
			});
   }
   void adjustPanel1DynamicVisiblity() {
	   for(int i=0; i<ite; i++) {
	    	allBrands[i].setVisible(false);
	    }
   }
   void adjustPanel2DynamicVisiblity(){
	    for(int i=0; i<iterator; i++) {
	    	billingField1[i].setVisible(false);
	    	billingField2[i].setVisible(false);
	    	billingField3[i].setVisible(false);
	    	billingField4[i].setVisible(false);
	    }
   }
   void makecheckout()
   {
       ArrayList<String> spare=new ArrayList<>();
       ArrayList<String> quantity=new ArrayList<>();
       ArrayList<String> price=new ArrayList<>();
        for(int i=0; i<iterator; i++) {
	    	billingField1[i].setVisible(false);
	    	billingField2[i].setVisible(false);
	    	billingField3[i].setVisible(false);
	    	billingField4[i].setVisible(false);
                String s=(String)billingField1[i].getSelectedItem();
                db.checkout(s, brandforbill.get(i), typeforbill.get(i), billingField2[i].getText());
                spare.add(s);
                quantity.add(billingField2[i].getText());
                price.add(billingField3[i].getText());
	    }
        checkout.setVisible(false);
        brandforbill.clear();
        typeforbill.clear();
        Bill b=new Bill();
//        System.out.println(spare);
//        System.out.println(quantity);
//        System.out.println(price);
        
        b.makeBill(spare, quantity, price);
        b.setVisible(true);
   }
   void adjustPanel4DynamicVisibility(){
       for(int i=0;i<jobiter;i++)
       {
           availablejobs[i].setVisible(false);
       }
   }
   
  void panel4Components(){
      panel4.setLayout(null);
	   Font myfont = new Font("Times New Roman", Font.BOLD, 20);
	   JButton addNewBrand = new JButton();
	   addNewBrand.setFont(myfont);
	   addNewBrand.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\bootcampjava\\button.jpeg"));
	   addNewBrand.setHorizontalTextPosition(SwingConstants.CENTER);
	   addNewBrand.setBackground(new Color(242, 254, 255));
	   addNewBrand.setBounds(530,20,80,40);
           addNewBrand.setIcon(new ImageIcon("D:/add4.png"));
	   panel4.add(addNewBrand);
	   addNewBrand.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Jobcard j = new Jobcard();
					j.makeSpareUI();
                                        j.b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
                            Database db=new Database();
                            boolean jobcardstatus=db.jobcard(j.brand.getText(),j.breed.getText(),j.spareName.getText());
                            if(jobcardstatus)
                            {
                                
                                JOptionPane.showMessageDialog(j,"Added Successfully"); 
                                j.setVisible(false);
                                makePanel4Dynamic();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(j,"Enter Valid Credentials"); 
                            }
				// TODO Auto-generated method stub
				
			}
		});
				}
			});
   }
  void showPanel4DynamicVisiblity() {
     Database db=new Database();
                ArrayList<String> list=new ArrayList<>();
                list=db.notipetrol();
                for(String s:list)
                {
                    String[] str=s.split("\\.");
                    String st=str[1].substring(0,1);
                    db.jobcard(str[1],"petrol",str[0]+"_"+st+"_p");
                    System.out.println(str[0]);
                }
//                 System.out.println(list);
                list=db.notidiesel();
                System.out.println(list);
            adjustPanel4DynamicVisibility();
            //setVisible(false);
	    int y=100;
		int iter=0;
		alljobs=db.sparelist();
                System.out.println(alljobs);
		System.out.println(brands+" "+"Pechi");
		
		for(String s:alljobs) {
			Font buttonFont = new Font("Times New Roman", Font.BOLD, 20);
			availablejobs[iter] = new JButton(s);
			availablejobs[iter].setFont(buttonFont);
			availablejobs[iter].setIcon(new ImageIcon("/root/Downloads/brand.jpeg"));
			availablejobs[iter].setHorizontalTextPosition(SwingConstants.CENTER);
			availablejobs[iter].setBounds(230,y,150,50);
                        availablejobs[iter].addActionListener(new ActionListener() {
                        String value=s;
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             System.out.println(value+" "+"hello");
                            Finishjob f=new Finishjob(value);
                            f.makeSpareUI();
                            f.b.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Database db=new Database();
                                    boolean finishsts=db.delete(value);
                                    if(finishsts)
                                    {
                                         JOptionPane.showMessageDialog(f,"Finished JOB Successfully"); 
                                         f.setVisible(false);
                                         showPanel4DynamicVisiblity();
                                         //setVisible(true);
                                    }
                                    else
                                    {
                                         JOptionPane.showMessageDialog(f,"Enter Valid Credential"); 
                                         f.setVisible(false);
                                    }
                                }
                            });
                         }
                     });
                        availablejobs[iter].setBackground(new Color(7, 125, 101));
                        availablejobs[iter].setForeground(Color.WHITE);
			final String KEY= s;
			final int iterator = iter;
			panel4.add(availablejobs[iter]);
			
			y+=70;
			iter++;
//                          Font myfont = new Font("Times New Roman", Font.BOLD, 17);
//                    checkout.setBounds(350,280,100,40);
//                    checkout.setBackground(new Color(6, 57, 120));
//                    checkout.setForeground(Color.WHITE);
//                    checkout.setVisible(true);
//                    checkout.setFont(myfont);
		}
		jobiter = iter;
		adjustPanel4DynamicVisibility();
		for(int i=0; i<jobiter; i++) {
			availablejobs[i].setVisible(true);
	    }
                                //System.out.println(jobiter);
                
		panel4.setVisible(true);
                
   }
 
   void makePanel4Dynamic(){
              Database db=new Database();
                ArrayList<String> list=new ArrayList<>();
                list=db.notipetrol();
                for(String s:list)
                {
                    String[] str=s.split("\\.");
                    String st=str[1].substring(0,1);
                    db.jobcard(str[1],"petrol",str[0]+"_"+st+"_p");
                    System.out.println(str[0]);
                }
//                 System.out.println(list);
                list=db.notidiesel();
                System.out.println(list);
                for(String s:list)
                {
                    String[] str=s.split("\\.");
                   String st=str[1].substring(0,1);  
                    db.jobcard(str[1],"Diesel",str[0]+"_"+st+"_d");
                             System.out.println(str[0]);
               }
                adjustPanel4DynamicVisibility();
                checkout.setVisible(false);
	        int y=100;
		int iter=0; 
		alljobs=db.sparelist();
		System.out.println(brands+" "+"Pechi");
		for(String s:alljobs) {
                     System.out.print(iter);
			Font buttonFont = new Font("Times New Roman", Font.BOLD, 20);
			
                        availablejobs[iter] = new JButton(s);
			availablejobs[iter].setFont(buttonFont);
                       // availablejobs[iter].setBackground(new Color(7, 125, 101));
                        availablejobs[iter].setForeground(Color.WHITE);
			//availablejobs[iter].setIcon(new ImageIcon("/root/Downloads/brand.jpeg"));
			availablejobs[iter].setHorizontalTextPosition(SwingConstants.CENTER);
			availablejobs[iter].setBounds(230,y,150,50);
                        availablejobs[iter].addActionListener(new ActionListener() {
                        String value=s;
                         @Override
                         public void actionPerformed(ActionEvent e) {
                            Finishjob f=new Finishjob(value);
                            f.makeSpareUI();
                            f.b.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Database db=new Database();
                                    boolean finishsts=db.delete(value);
                                    if(finishsts)
                                    {
                                         JOptionPane.showMessageDialog(f,"Finished JOB Successfully"); 
                                         f.setVisible(false);
                                         showPanel4DynamicVisiblity();
                                        // setVisible(true);
                                    }
                                    else
                                    {
                                         JOptionPane.showMessageDialog(f,"Enter Valid Credential"); 
                                         f.setVisible(false);
                                    }
                                }
                            });
                         }
                     });
                        availablejobs[iter].setBackground(new Color(7, 125, 101));
                    
			final String KEY= s;
			final int iterator = iter;
			panel4.add(availablejobs[iter]);
			y+=70;
			iter++;
                       
      
		}
                //System.out.println(iter);
		jobiter = iter;
		adjustPanel4DynamicVisibility();
		for(int i=0; i<jobiter; i++) {
			availablejobs[i].setVisible(true);
	    }
               // System.out.println(jobiter);
            
		panel4.setVisible(true);
   }
   void makePanel2Dynamic(){
	    adjustPanel2DynamicVisiblity();
	    int y=100;
		int iter=0;
		
		System.out.println(brandforbill+" "+"Pechi");
		for(String s:brandforbill) {
			Font buttonFont = new Font("Times New Roman", Font.BOLD, 20);
			final int key = iter;
                        Object str[]=db.spare(typeforbill.get(key), s).toArray();
			billingField1[iter] = new JComboBox<Object>(str);
			billingField1[iter].setFont(buttonFont);
			billingField1[iter].setBounds(2,y,150,50);
			billingField2[iter] = new JTextField();
			billingField2[iter].setFont(buttonFont);
			billingField2[iter].setBounds(180,y,150,50);
			billingField3[iter] = new JTextField();
			billingField3[iter].setFont(buttonFont);
			billingField3[iter].setBounds(350,y,150,50);
                        checkout.setEnabled(false);
                        checkout.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                makecheckout();
                            }
                        });
            flag=true;
			billingField2[iter].addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					try {
                                            Database db=new Database();
                                            String st=(String)billingField1[key].getSelectedItem();
                                                int b=db.quantity(st, brandforbill.get(key), typeforbill.get(key));
						int val = Integer.parseInt(billingField2[key].getText());
						if(val>b) {
							billingField2[key].setBackground(Color.RED);
                                                        checkout.setEnabled(false);
                                                        flag=false;
						}
						else {
							billingField2[key].setBackground(Color.WHITE);
                                                        checkout.setEnabled(false);
						}
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println(e2);
						billingField2[key].setBackground(Color.RED);
                                                checkout.setEnabled(false);
                                                flag=false;
                                        }
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			if(true) {
				checkout.setEnabled(false);
				billingField3[iter].addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						try {
	                                           
							int val = Integer.parseInt(billingField3[key].getText());
							checkout.setEnabled(true);
							billingField3[key].setBackground(Color.white);
						} catch (Exception e2) {
							// ODO: handle exception
							
							billingField3[key].setBackground(Color.RED);
	                                                checkout.setEnabled(false);
	                                                flag=false;
	                                        }
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
			billingField4[iter] = new JButton();
			billingField4[iter].setFont(buttonFont);
                        billingField4[iter].setBackground(new Color(242, 254, 255));
			billingField4[iter].setBounds(520,y,80,40);
			billingField4[iter].setIcon(new ImageIcon("D:/delete.png"));
			billingField4[iter].setHorizontalTextPosition(SwingConstants.CENTER);
			billingField4[iter].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					brandforbill.remove(key);
					typeforbill.remove(key);
					billingField1[key].setVisible(false);
					billingField2[key].setVisible(false);
					billingField3[key].setVisible(false);
					billingField4[key].setVisible(false);
					adjustPanel2DynamicVisiblity();
					iterator--;
					showPanel2DynamicVisiblity();
				}
			});
			panel2.add(billingField1[iter]);
			panel2.add(billingField2[iter]);
			panel2.add(billingField3[iter]);
			panel2.add(billingField4[iter]);
			y+=100;
			iter++;
                        System.out.println("hello");
                         Font myfont = new Font("Times New Roman", Font.BOLD, 20);
                    checkout.setBounds(250,280,150,40);
                    checkout.setBackground(new Color(179, 170, 57));
                    checkout.setIcon(new ImageIcon("d:/cko2.png"));
                    checkout.setVisible(true);
                    checkout.setFont(myfont);
                    panel2.add(checkout);
		}
		iterator = iter;
		adjustPanel2DynamicVisiblity();
		for(int i=0; i<iterator; i++) {
	    	billingField1[i].setVisible(true);
	    	billingField2[i].setVisible(true);
	    	billingField3[i].setVisible(true);
	    	billingField4[i].setVisible(true);
	    }
                
		panel2.setVisible(true);
		
   }
   void showPanel2DynamicVisiblity() {
	   adjustPanel2DynamicVisiblity();
	    int y=100;
		int iter=0;
		
		System.out.println(brandforbill+" "+"Pechi");
		for(String s:brandforbill) {
			Font buttonFont = new Font("Times New Roman", Font.BOLD, 20);
			final int key = iter;
                       Object str[]=db.spare(typeforbill.get(key), s).toArray();
			billingField1[iter] = new JComboBox<Object>(str);
			billingField1[iter].setFont(buttonFont);
			billingField1[iter].setBounds(2,y,150,50);
			billingField2[iter] = new JTextField();
			billingField2[iter].setFont(buttonFont);
			billingField2[iter].setBounds(180,y,150,50);
			billingField3[iter] = new JTextField();
			billingField3[iter].setFont(buttonFont);
			billingField3[iter].setBounds(350,y,150,50);
                       checkout.setEnabled(false);
                       checkout.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent e) {
                               makecheckout();
                           }
                       });
           flag=true;
			billingField2[iter].addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					try {
                                           Database db=new Database();
                                           String st=(String)billingField1[key].getSelectedItem();
                                               int b=db.quantity(st, brandforbill.get(key), typeforbill.get(key));
						int val = Integer.parseInt(billingField2[key].getText());
						if(val>b) {
							billingField2[key].setBackground(Color.RED);
                                                       checkout.setEnabled(false);
                                                       flag=false;
						}
						else {
							billingField2[key].setBackground(Color.WHITE);
                                                       checkout.setEnabled(false);
						}
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println(e2);
						billingField2[key].setBackground(Color.RED);
                                               checkout.setEnabled(false);
                                               flag=false;
                                       }
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			if(true) {
				checkout.setEnabled(false);
				billingField3[iter].addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						try {
	                                           
							int val = Integer.parseInt(billingField3[key].getText());
							checkout.setEnabled(true);
							billingField3[key].setBackground(Color.white);
						} catch (Exception e2) {
							// TODO: handle exception
							
							billingField3[key].setBackground(Color.RED);
	                                                checkout.setEnabled(false);
	                                                flag=false;
	                                        }
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
			billingField4[iter] = new JButton();
			billingField4[iter].setFont(buttonFont);
			billingField4[iter].setBounds(510,y,70,50);
			billingField4[iter].setIcon(new ImageIcon("D:/delete.png"));
			billingField4[iter].setHorizontalTextPosition(SwingConstants.CENTER);
			billingField4[iter].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					brandforbill.remove(key);
					typeforbill.remove(key);
					billingField1[key].setVisible(false);
					billingField2[key].setVisible(false);
					billingField3[key].setVisible(false);
					billingField4[key].setVisible(false);
					adjustPanel2DynamicVisiblity();
					iterator--;
					showPanel2DynamicVisiblity();
				}
			});
			panel2.add(billingField1[iter]);
			panel2.add(billingField2[iter]);
			panel2.add(billingField3[iter]);
			panel2.add(billingField4[iter]);
			y+=100;
			iter++;
                       System.out.println("hello");
                        Font myfont = new Font("Times New Roman", Font.BOLD, 20);
                   checkout.setBounds(250,280,150,40);
                   checkout.setBackground(new Color(179, 170, 57));
                   checkout.setIcon(new ImageIcon("d:/cko2.png"));
                   checkout.setVisible(true);
                   checkout.setFont(myfont);
                   panel2.add(checkout);
		}
		iterator = iter;
		adjustPanel2DynamicVisiblity();
		for(int i=0; i<iterator; i++) {
	    	billingField1[i].setVisible(true);
	    	billingField2[i].setVisible(true);
	    	billingField3[i].setVisible(true);
	    	billingField4[i].setVisible(true);
	    }
               
		panel2.setVisible(true);		
   }
   void showPanel1DynamicVisiblity() {
	    int y=120;
		int iter=0;
                
		brands=db.brandNames();
                JButton addField = new JButton("ADD");
                Font myfont = new Font("Times New Roman", Font.PLAIN, 20);
                addField.setFont(myfont);
		addField.setBackground(new Color(49, 183, 232));
		addField.setForeground(Color.WHITE);
		System.out.println(brands+" "+"Pechi");
		
		for(String s:brands) {
			Font buttonFont = new Font("Times New Roman", Font.PLAIN, 20);
			allBrands[iter] = new JButton(s);
			allBrands[iter].setFont(buttonFont);
			allBrands[iter].setBackground(new Color(7, 125, 101));
			allBrands[iter].setIcon(new ImageIcon("/root/Downloads/brand.jpeg"));
			allBrands[iter].setHorizontalTextPosition(SwingConstants.CENTER);
			allBrands[iter].setBounds(250,y,150,50);
                        allBrands[iter].setForeground(Color.WHITE);
			final String KEY= s;
			final int iterator = iter;
			allBrands[iter].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Spares spare = new Spares();
					//spare.key = KEY;
					spare.delete = new JButton("DELETE "+s);
                                        spare.delete.setForeground(Color.WHITE);
                                        spare.delete.setBackground(new Color(232, 30, 30));
					spare.delete.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
						//	remove(allBrands);
							int output = JOptionPane.showConfirmDialog(panel1
						               , "Are You Sure want to Delete?"
						               ,"Notification"
						               ,JOptionPane.YES_NO_CANCEL_OPTION,
						               JOptionPane.INFORMATION_MESSAGE);

						            if(output == JOptionPane.YES_OPTION){
						            	spare.dispatchEvent(new WindowEvent(spare, WindowEvent.WINDOW_CLOSING));
										allBrands[iterator].setVisible(false);
										//brands.remove(s);
                                                                                db.deleteBrand(KEY);
										adjustPanel1DynamicVisiblity();
										showPanel1DynamicVisiblity();
						            }
							
							
						}
					});
					spare.makeSparesUI();
					spare.petrol.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							PetrolFrame p = new PetrolFrame();
							p.createFrame(s);
							
						}
					});
					spare.diesel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							DieselFrame d = new DieselFrame();
							d.createFrame(s);
							
						}
					});
					spare.add(spare.petrol);
					spare.add(spare.diesel);
					spare.add(spare.delete);
					spare.setVisible(true);
				}
			});
			panel1.add(allBrands[iter]);
			y+=70;
			iter++;
		}
		ite = iter;
		adjustPanel1DynamicVisiblity();
		for(int i=0; i<ite; i++) {
	    	allBrands[i].setVisible(true);
	    }
		panel1.setVisible(true);
   }
   void makePanel1Dynamic(){
             brands=db.brandNames(); 
	    adjustPanel1DynamicVisiblity();
	    int y=120;
		int iter=0;
		 JButton addField = new JButton("ADD");
                Font myfont = new Font("Times New Roman", Font.PLAIN, 20);
					addField.setFont(myfont);
					addField.setBackground(new Color(49, 183, 232));
					addField.setForeground(Color.BLACK);
		System.out.println(brands+" "+"Pechi");
		for(String s:brands) {
			Font buttonFont = new Font("Times New Roman", Font.PLAIN, 20);
			
			allBrands[iter] = new JButton(s);
			allBrands[iter].setFont(buttonFont);
                        allBrands[iter].setForeground(Color.WHITE);
			allBrands[iter].setBackground(new Color(7, 125, 101));
			allBrands[iter].setIcon(new ImageIcon("/root/Downloads/brand.jpeg"));
			allBrands[iter].setHorizontalTextPosition(SwingConstants.CENTER);
			allBrands[iter].setBounds(250,y,150,50);
			final String KEY= s;
			final int iterator = iter;
			allBrands[iter].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Spares spare = new Spares();
					//spare.key = KEY;
					spare.delete = new JButton("DELETE "+s);
                                        spare.delete.setForeground(Color.WHITE);
                                        spare.delete.setBackground(new Color(232, 30, 30));
					spare.delete.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
						//	remove(allBrands);
							int output = JOptionPane.showConfirmDialog(spare
						               , "Are You Sure want to Delete?"
						               ,"Notification"
						               ,JOptionPane.YES_NO_CANCEL_OPTION,
						               JOptionPane.DEFAULT_OPTION
						               );
									
						            if(output == JOptionPane.YES_OPTION){
						            	spare.dispatchEvent(new WindowEvent(spare, WindowEvent.WINDOW_CLOSING));
										allBrands[iterator].setVisible(false);
										//brands.remove(s);
                                                                                db.deleteBrand(KEY);
										adjustPanel1DynamicVisiblity();
										showPanel1DynamicVisiblity();
						            }
							
						}
					});
					spare.makeSparesUI();
					spare.petrol.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							new PetrolFrame().createFrame(s);
							
						}
					});
					spare.diesel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							new DieselFrame().createFrame(s);
							
						}
					});
					spare.add(spare.petrol);
					spare.add(spare.diesel);
					spare.add(spare.delete);
					spare.setVisible(true);
				}
			});
			panel1.add(allBrands[iter]);
			y+=70;
			iter++;
		}
		ite = iter;
		adjustPanel1DynamicVisiblity();
		for(int i=0; i<ite; i++) {
	    	allBrands[i].setVisible(true);
	    }
		panel1.setVisible(true);
   }
  
   public void makeRegisterationUI(){
	    Font myfont = new Font("Times New Roman", Font.BOLD,15);
             Font myfont2 = new Font("Times New Roman", Font.BOLD,20);
	    JLabel heading = new JLabel("CREATE NEW USER");
		heading.setBounds(220,20,200,40);
		heading.setForeground(Color.RED);
		heading.setFont(myfont2);
		panel3.add(heading);
		JLabel rusername = new JLabel("USERNAME");
		rusername.setBounds(50,20,200,200);
		rusername.setFont(myfont);
		panel3.add(rusername);
		JLabel rname = new JLabel("NAME");
		rname.setBounds(50,90,200,200);
		rname.setFont(myfont);
		panel3.add(rname);
		JLabel rpassword = new JLabel("PASSWORD");
		rpassword.setBounds(50,160,200,200);
		rpassword.setFont(myfont);
		panel3.add(rpassword);
		JLabel repassword = new JLabel("CONFIRM PASSWORD");
		repassword.setBounds(50,230,300,200);
		repassword.setFont(myfont);
		panel3.add(repassword);
		JTextField username,name;
		JPasswordField p1,p2;
		username = new JTextField();
		username.setForeground(Color.BLACK);
		username.setBounds(250,100,300,40);
		username.setFont(myfont);
		panel3.add(username);
	        name = new JTextField();
	        name.setForeground(Color.BLACK);
	        name.setBounds(250,170,300,40);
	        name.setFont(myfont);
		panel3.add(name);
		p1 = new JPasswordField();
		p1.setBounds(250,240,300,40);
		p1.setFont(myfont);
		p1.setForeground(Color.BLACK);
		panel3.add(p1);
		p2 = new JPasswordField();
		p2.setBounds(250,310,300,40);
		p2.setForeground(Color.BLACK);
		p2.setFont(myfont);
		panel3.add(p2);
		JButton register = new JButton("REGISTER");
		register.setBounds(160,400,150,50);
		register.setFont(new Font("Times New Roman", Font.BOLD, 15));
		register.setBackground(new Color(6, 57, 120));
                register.setForeground(Color.WHITE);
		register.setIcon(new ImageIcon("/root/Downloads/button.jpg"));
		register.setHorizontalTextPosition(SwingConstants.CENTER);
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				 boolean registerationStatus = db.addUser(name.getText(),username.getText(),p1.getText(),p2.getText());
				 if(registerationStatus) {
					 JOptionPane.showMessageDialog(panel3,"New user Added Succesfully"); 
				 }
				 else {
					 JOptionPane.showMessageDialog(panel3,"Enter Valid Credentials"); 
				 }
			}
		});
		panel3.add(register);
                JButton deleteUser = new JButton("DELETE USER");
		deleteUser.setBounds(360,400,150,50);
		deleteUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
                  deleteUser.setForeground(Color.WHITE);
                 deleteUser.setBackground(new Color(232, 30, 30));
		deleteUser.setIcon(new ImageIcon("/root/Downloads/button.jpg"));
		deleteUser.setHorizontalTextPosition(SwingConstants.CENTER);
		deleteUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				 boolean registerationStatus = db.deleteuser(username.getText(),name.getText(),p1.getText());
				 if(registerationStatus) {
					 JOptionPane.showMessageDialog(panel3,"Deleted Succesfully"); 
				 }
				 else {
					 JOptionPane.showMessageDialog(panel3,"Enter Valid Username"); 
				 }
			}
		});
		panel3.add(deleteUser);
   }
 
   static void makeloginui()
   {
       LoginFrame f=new LoginFrame();
	   f.makeLoginUI();
            f.setBackground(new Color(255, 255, 252));
            ImageIcon i2=new ImageIcon(new ImageIcon("D:/New folder/frame.png").getImage().getScaledInstance(1100,1000,Image.SCALE_SMOOTH));
            JLabel image2=new JLabel();
            image2.setBounds(-100,-20,1000,800);
            image2.setIcon(i2);
            f.add(image2);
            ImageIcon i=new ImageIcon(new ImageIcon("D:/New folder/nsp.jpeg").getImage().getScaledInstance(250,250,Image.SCALE_SMOOTH));
            JLabel image=new JLabel();
            image.setBounds(320,40,300,300);
            image.setIcon(i);
            f.add(image);
               
            
	   Font myfont = new Font("Times New Roman", Font.BOLD, 20);
	   f.Submit.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Database db = new Database();
                        //Serialization se=new Serialization();
			boolean loginStatus = db.login(f.t1.getText(),f.t2.getText());
			if(loginStatus == false ){
				 JOptionPane.showMessageDialog(f,"Enter Valid Credentials"); 
			}
			if(loginStatus) {
                          // Serialization
                              String filename = "Cookie.txt";
			try
			{ 
                               
				Cookie object = new Cookie(f.t1.getText(),f.t2.getText()); 
				FileOutputStream file = new FileOutputStream(filename); 
				ObjectOutputStream out = new ObjectOutputStream(file); 
				out.writeObject(object); 
				out.close(); 
				file.close(); 
				System.out.println("Object has been serialized"); 
			} 
			catch(IOException ex) 
			{ 
				System.out.println("IOException is caught"); 
			}
                     
			f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
                        makemainframe();
			
		}
		}
		
	});
	   
	   f.add(f.l1);
	   f.add(f.l2);
	   f.add(f.t1);
	   f.add(f.t2);
	   f.add(f.Submit);
	   f.setVisible(true); 
   }
   static void makemainframe()
   {
       Font myfont = new Font("Times New Roman", Font.BOLD, 10);
       String filename = "Cookie.txt"; 
       MainFrame f1 = new MainFrame();
			f1.makeMainframeUI();
                        f1.logout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				       String filename = "Cookie.txt";
			try
			{ 
                               
				Cookie object = new Cookie("ecfoifnwecoxomfwgrwgrwgrg","!@#$%^&*()"); 
				FileOutputStream file = new FileOutputStream(filename); 
				ObjectOutputStream out = new ObjectOutputStream(file); 
				out.writeObject(object); 
				out.close(); 
				file.close(); 
				System.out.println("Object has been serialized"); 
			} 
			catch(IOException ex) 
			{ 
				System.out.println("IOException is caught"); 
			}
                     	f1.setVisible(false);
			makeloginui();
				}
			});
			//panel1 Page
                        f1.panel1Components();
                        f1.makePanel1Dynamic();
			f1.pa = new JScrollPane(f1.panel1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        f1.pa.setBounds(130,80,640,600);
	        f1.pa.setBackground(Color.DARK_GRAY);
	        Container c = f1.getContentPane();
	        c.setLayout(null);
	        f1.panel1.setPreferredSize(new Dimension(400, 2000));
	        c.add(f1.pa);
			//Panel2 Page
	        f1.pa1 = new JScrollPane(f1.panel2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        f1.pa1.setBounds(130,80,640,600);
	        Container c1 = f1.getContentPane();
	        c1.setLayout(null);
	        f1.panel2.setPreferredSize(new Dimension(1000, 50000));
                f1.panel2Components();
                f1.makePanel2Dynamic();
                
	        c.add(f1.pa1);
			//Panel4 Page
                         f1.pa2 = new JScrollPane(f1.panel4,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        f1.pa2.setBounds(130,80,640,600);
	       // Container c1 = f1.getContentPane();
	        c1.setLayout(null);
	        f1.panel4.setPreferredSize(new Dimension(1000, 50000));
                 f1.panel4Components();
                f1.makePanel4Dynamic();
	        c.add(f1.pa2);
                  Database db=new Database();
                 String[][] data=db.analyse();
                 String[] columnnames={"Sparename","Brandname","Fueltype","Quantity"};
                 JTable table=new JTable(data,columnnames);
                 f1.panel5.setLayout(null);
                 //f1.pa3.add(table);
                 table.setBounds(130,80,640,600);
                f1.pa3 = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        f1.pa3.setBounds(130,80,640,600);
                f1.panel5.setPreferredSize(new Dimension(1000, 50000));
                f1.pa3.setBackground(new Color(242, 254, 255));
                table.setFont(myfont);
                table.setBackground(new Color(242, 254, 255));
                c.add(f1.pa3);
	        f1.makeRegisterationUI();
			f1.panel4.setBackground(new Color(242, 252, 251));
                       
			f1.panel3.setFont(myfont);
		    f1.setVisible(true);
                    
   }
    
    void makepanel4components()
   {
       
   }
   public static void main(String arg[]) throws Exception 
   {
            String filename = "Cookie.txt"; 
	   
	   Cookie object1 = null; 

		// Deserialization 
		try
		{ 
			
			// Reading the object from a file 
			FileInputStream file = new FileInputStream(filename); 
			ObjectInputStream in = new ObjectInputStream(file); 
			
			// Method for deserialization of object 
			object1 = (Cookie)in.readObject(); 
			
			in.close(); 
			file.close(); 
                        Database db=new Database();
			String username=object1.username;
                        String password=object1.password;
                        boolean loginStatus = db.login(username,password);
                        if(loginStatus)
                        {
                            makemainframe();
                        }
                        else
                        {
                            makeloginui();
                        }
                             
		} 
		
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
                        makeloginui();
		} 
		
		catch(ClassNotFoundException ex) 
		{ 
			System.out.println("ClassNotFoundException is caught"); 
                        makeloginui();
                }
                
	   
   }
      
 }
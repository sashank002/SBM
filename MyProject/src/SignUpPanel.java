
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SignUpPanel extends JPanel implements ActionListener{
	JLabel fName,lName,mName,phNo,add,acNo,usNa,Pass,confPass,city,brName,zipcode,EAdd,Dob,gender,state,religion,cata;
	JLabel ifName,ilName,imName,iadd,iphNo,icity,izipcode,iEAdd;
	JLabel ifsc1,acctype;
	JLabel cr_lab;
	Font f1,f2,f3,f4;
	JPanel top,bottom;
	JTextField fname_tf,lname_tf,mname_tf,ph_tf,accno_tf,user_tf,ifsc_tf,add_tf,city_tf,brName_tf,zip_tf,EAdd_tf;
	JPasswordField pass1,pass2;
	Choice acc_ch;
	JButton cancle,register;
	MainFrame mf;
	SignUpPanel12 sp12;
	CardLayout c;
	Choice date,month,year,state_ch,cata_ch,religion_ch;
	CheckboxGroup cbg;
	Checkbox male,female,other;
	
	Color caret;
	
	Border mb;
	RoundedBorder rb1;
	
	//pattern of email
	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	
	public SignUpPanel(MainFrame mf){
		setLayout(null);
		this.mf=mf;
		caret=Color.orange;
		c=mf.cards;
		
		rb1=new RoundedBorder(new Color(93,188,210),0,50,0,false);
		mb=BorderFactory.createMatteBorder(0,0,2,0,Color.white);
		
		
		top=new JPanel();
		top.setBounds(180,20,700,60);
		
		top.setBorder(rb1);
		top.setBackground(new Color(0,2,52));
		
		
		bottom=new JPanel();
		bottom.setBounds(180,90,700,470);
		//bottom.setBorder(BorderFactory.createLineBorder(Color.black));
		bottom.setBorder(rb1);
		bottom.setBackground(new Color(0,2,52));
		
		
		setBackground(Color.white);
		//wall=new JLabel(new ImageIcon("src\\img1.jpg"));
		//wall.setBounds(0,0,1080,600);
		
		
		
		f1=new Font("Arial",Font.BOLD,40);
		top.setLayout(null);
		bottom.setLayout(null);
		
		cr_lab=new JLabel("Create New Account");
		cr_lab.setBounds(150,10,500,50);
		cr_lab.setFont(f1);
		cr_lab.setForeground(Color.white);
		top.add(cr_lab);
		
		f2=new Font("Arial",Font.BOLD+Font.PLAIN,13);
		f3=new Font("Arial",Font.BOLD+Font.PLAIN,13);
		f4=new Font("Arial",Font.PLAIN+Font.BOLD,10);
		
		
		
		
		// FULL NAME 
		fName=new JLabel("First Name");
		fName.setBounds(10,5,100,15);
		fName.setFont(f2);
		fName.setForeground(Color.white);
		bottom.add(fName);
		
		lName=new JLabel("Last Name");
		lName.setBounds(470,5,100,15);
		lName.setFont(f2);
		lName.setForeground(Color.white);
		bottom.add(lName);
		
		mName=new JLabel("Middle Name");
		mName.setBounds(240,5,100,15);
		mName.setFont(f2);
		mName.setForeground(Color.white);
		bottom.add(mName);
		
		fname_tf=new JTextField();
		fname_tf.setBounds(10,20,200,25);
		fname_tf.setFont(f3);
		fname_tf.setCaretColor(caret);
		apply(fname_tf);
		bottom.add(fname_tf);
		
		lname_tf=new JTextField();
		lname_tf.setBounds(470,20,200,25);
		apply(lname_tf);
		bottom.add(lname_tf);
		
	 	mname_tf=new JTextField();
	  	mname_tf.setBounds(240,20,200,25);
	 	apply(mname_tf);
	 	bottom.add(mname_tf);
	 	
	 	ifName=new JLabel("enter alphabets only");       // ERROR MESSAGE
	 	ifName.setBounds(10,45,200,15);
	 	doStyle(ifName);
	 	bottom.add(ifName);
	 	ifName.setVisible(false);
		
		imName=new JLabel("enter alphabets only");       // ERROR MESSAGE
	 	imName.setBounds(240,45,200,15);
	 	doStyle(imName);
	 	bottom.add(imName);
	 	imName.setVisible(false);
		
	 	ilName=new JLabel("enter alphabets only");       // ERROR MESSAGE
	 	ilName.setBounds(470,45,200,15);
	 	doStyle(ilName);
	 	bottom.add(ilName);
	 	ilName.setVisible(false);
	 	
	 	
	 	// ADDRESS
		add=new JLabel("Address");
		add.setBounds(10,60,100,15);
		add.setFont(f2);
		add.setForeground(Color.white);
		bottom.add(add);
		
		add_tf=new JTextField();
		add_tf.setBounds(10,75,680,50);
		apply(add_tf);
		bottom.add(add_tf);
		
		iadd=new JLabel("Invalid Address");
		iadd.setBounds(10,125,100,10);
		doStyle(iadd);
		bottom.add(iadd);
		iadd.setVisible(false);
		
		
		// DOB 
		Dob=new JLabel("Date Of Birth");
		Dob.setBounds(10,140,100,15);
		Dob.setFont(f2);
		Dob.setForeground(Color.white);
		
		bottom.add(Dob);
		
		date=new Choice();
		date.setBounds(10,155,60,25);
		date.setFont(f3);
		date.setBackground(new Color(0,2,52));
		date.setForeground(Color.white);
		bottom.add(date);
		
		for(int i=1;i<=31;i++)
		{
			date.add(""+i);
		}
		
		month=new Choice();
		month.setBounds(75,155,120,25);
		month.setFont(f3);
		month.setBackground(new Color(0,2,52));
		month.setForeground(Color.white);
		bottom.add(month);
		
		month.add("January");
		month.add("February");
		month.add("March");
		month.add("April");
		month.add("May");
		month.add("June");
		month.add("July");
		month.add("August");
		month.add("September");
		month.add("October");
		month.add("November");
		month.add("December");
		
		year=new Choice();
		year.setBounds(200,155,100,25);
		year.setFont(f3);
		year.setBackground(new Color(0,2,52));
		year.setForeground(Color.white);
		bottom.add(year);
		
		for(int i=60;i<=99;i++)
		{
			year.add("19"+i);
		}
		for(int i=0;i<=5;i++)
		{
			year.add("200"+i);
		}
		
		
		
		
		// GENDER
		
		gender=new JLabel("Gender");
		gender.setBounds(350,140,100,15);
		gender.setFont(f2);
		gender.setForeground(Color.white);
		bottom.add(gender);
		
		cbg=new CheckboxGroup();
		male=new Checkbox("Male",cbg,true);
		female=new Checkbox("Female",cbg,false);
		other=new Checkbox("Other",cbg,false);
		
		male.setBounds(350,155,80,25);
		female.setBounds(430,155,80,25);
		other.setBounds(510,155,80,25);
		
		male.setFont(f3);
		male.setBackground(new Color(0,2,52));
		male.setForeground(Color.white);
		
		female.setFont(f3);
		female.setBackground(new Color(0,2,52));
		female.setForeground(Color.white);
		
		other.setFont(f3);
		other.setBackground(new Color(0,2,52));
		other.setForeground(Color.white);
		
		
		bottom.add(male);
		bottom.add(female);
		bottom.add(other);
		
		
		
		
		// CITY
		city=new JLabel("City");
		city.setBounds(10,185,100,15);
		city.setFont(f2);
		city.setForeground(Color.white);
		bottom.add(city);
		
		city_tf=new JTextField();
		city_tf.setBounds(10,200,300,25);
		apply(city_tf);
		bottom.add(city_tf);
		
		icity=new JLabel("enter alphabets only");
		icity.setBounds(10,225,300,15);
		doStyle(icity);
		bottom.add(icity);
		icity.setVisible(false);
		
		
		
		// PINCODE
		zipcode=new JLabel("Pin Code");
		zipcode.setBounds(350,185,100,15);
		zipcode.setFont(f2);
		zipcode.setForeground(Color.white);
		bottom.add(zipcode);
		
		zip_tf=new JTextField();
		zip_tf.setBounds(350,200,300,25);
		apply(zip_tf);
		bottom.add(zip_tf);
		
		izipcode=new JLabel("enter digits only");
		izipcode.setBounds(350,225,300,15);
		doStyle(izipcode);
		bottom.add(izipcode);
		izipcode.setVisible(false);
		
		
		// STATE
		state=new JLabel("State");
		state.setBounds(10,240,100,15);
		state.setFont(f2);
		state.setForeground(Color.white);
		bottom.add(state);
		
		state_ch=new Choice();
		state_ch.setBounds(10,255,300,30);
		state_ch.setFont(f3);
		state_ch.setBackground(new Color(0,2,52));
		state_ch.setForeground(Color.white);
		bottom.add(state_ch);
		
		state_ch.add("Andhra Pradesh");
		state_ch.add("Arunachal Pradesh");
		state_ch.add("Assam");
		state_ch.add("Bihar");
		state_ch.add("Chhattisgarh");
		state_ch.add("Goa");
		state_ch.add("Gujarat");
		state_ch.add("Haryana");
		state_ch.add("Himachal Pradesh");
		state_ch.add("Jharkhand");
		state_ch.add("Karnataka");
		state_ch.add("Kerala");
		state_ch.add("Madhya Pradesh");
		state_ch.add("Maharashtra");
		state_ch.add("Manipur");
		state_ch.add("Meghalaya");
		state_ch.add("Mizoram");
		state_ch.add("Nagaland");
		state_ch.add("Odisha");
		state_ch.add("Punjab");
		state_ch.add("Rajasthan");
		state_ch.add("Sikkim");
		state_ch.add("Tamil Nadu");
		state_ch.add("Telangana");
		state_ch.add("Tripura");
		state_ch.add("Uttar Pradesh");
		state_ch.add("Uttarakhand");
		state_ch.add("West Bengal");
		
		
		
		// PHONE NO
		phNo=new JLabel("Phone Number");
		phNo.setBounds(350,240,100,15);
		phNo.setFont(f2);
		phNo.setForeground(Color.white);
		bottom.add(phNo);
		
		ph_tf=new JTextField();
		ph_tf.setBounds(350,255,300,25);
		apply(ph_tf);
		bottom.add(ph_tf);
		
		iphNo=new JLabel("enter digits only");
		iphNo.setBounds(350,280,300,15);
		doStyle(iphNo);
		bottom.add(iphNo);
		iphNo.setVisible(false);
		
		
		
		
		// EMAIL ID
		EAdd=new JLabel("Email Address");
		EAdd.setBounds(10,295,100,15);
		EAdd.setFont(f2);
		EAdd.setForeground(Color.white);
		bottom.add(EAdd);
		
		EAdd_tf=new JTextField();
		EAdd_tf.setBounds(10,310,680,25);
		apply(EAdd_tf);
		bottom.add(EAdd_tf);
		
		iEAdd=new JLabel("enter a valid email address");
		iEAdd.setBounds(10,335,680,10);
		doStyle(iEAdd);
		bottom.add(iEAdd);
		iEAdd.setVisible(false);
		
		
		// RELIGION
		religion=new JLabel("Religion");
		religion.setBounds(10,350,100,15);
		religion.setFont(f2);
		religion.setForeground(Color.white);
		bottom.add(religion);
		
		religion_ch=new Choice();
		religion_ch.setBounds(10,365,330,30);
		religion_ch.setFont(f3);
		religion_ch.setBackground(new Color(0,2,52));
		religion_ch.setForeground(Color.white);
		bottom.add(religion_ch);
		
		religion_ch.add("Hindu");
		religion_ch.add("Sikh");
		religion_ch.add("Muslim");
		religion_ch.add("Christian");
		religion_ch.add("Others");
		
		
		
		
		// CATAGORY
		cata=new JLabel("Catagory");
		cata.setBounds(350,350,100,15);
		cata.setFont(f2);
		cata.setForeground(Color.white);
		bottom.add(cata);
		
		cata_ch=new Choice();
		cata_ch.setBounds(350,365,330,30);
		cata_ch.setFont(f3);
		cata_ch.setBackground(new Color(0,2,52));
		cata_ch.setForeground(Color.white);
		bottom.add(cata_ch);
		
		cata_ch.add("SC");
		cata_ch.add("ST");
		cata_ch.add("OBC");
		cata_ch.add("GENERAL");
		
		
		cancle=new JButton("CANCEL");
		cancle.setBounds(150,420,170,40);
		cancle.setFont(f2);
		cancle.setBackground(new Color(93, 188, 210));
		cancle.setBorder(rb1);
		cancle.addActionListener(this);
		bottom.add(cancle);
		
		register=new JButton("NEXT");
		register.setBounds(360,420,170,40);
		register.setFont(f2);
		register.addActionListener(this);
		register.setBackground(new Color(235,145,0));
		register.setBorder(rb1);
		bottom.add(register);  
		
		cancle.setForeground(Color.white);
		register.setForeground(Color.white);
		
		//setBackground(Color.yellow);
		
		
		//bottom.setBackground(Color.grey);
	
		
		//add(wall);
		add(top);
		add(bottom);
		//setVisible(true);
		

	
		
		
		
		//setVisible(true);
		

		fname_tf.addKeyListener(new KeyAdapter() {                             //**********change
	        @Override
	        public void keyReleased (KeyEvent e) {
	        	try {
	        		char c = e.getKeyChar();//stores the text entered in textfield

	        		if(!(Character.isAlphabetic(c)))
	                {
	        			
	        			if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
	        				
	        				ifName.setVisible(false);

	        			}
	        			else {		
	        				//fname_tf.setText("");
	        				ifName.setVisible(true);
	        				fname_tf.setText(fname_tf.getText().replaceAll("[^A-Za-z]","")); 
	    	     			
	        			}
	                }
	        		else {
	        			
	        			ifName.setVisible(false);
	        		}
	        		
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
	        }
	    });
		
		
		
		mname_tf.addKeyListener(new KeyAdapter() {                  //***********change
	        @Override
	        public void keyReleased (KeyEvent e) {
	        	try {
	        		char c = e.getKeyChar();//stores the text entered in textfield
	        		
	        		if(!(Character.isAlphabetic(c)))
	                {
	        			//mname_tf.setText("");
	        			if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
	        				
	        				imName.setVisible(false);

	        			}
	        			else {				

	        				imName.setVisible(true);
		        			mname_tf.setText(mname_tf.getText().replaceAll("[^A-Za-z]","")); 
	        			}
	        			
	        			
	                }
	        		else {
	        			
	        			imName.setVisible(false);
	        		}
	        		
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
	        }
	    });
		
		
		
		
		lname_tf.addKeyListener(new KeyAdapter() {                                      //******change
	        @Override
	        public void keyReleased (KeyEvent e) {
	        	try {
	        		char c = e.getKeyChar();//stores the text entered in textfield
	        		if(!(Character.isAlphabetic(c)))
	                {
	        			if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
	        				
	        				ilName.setVisible(false);

	        			}
	        			else {				

	        				ilName.setVisible(true);
		        			lname_tf.setText(lname_tf.getText().replaceAll("[^A-Za-z]","")); 

	        			}
	        			
	        			
	                }
	        		else {
	        			
	        			ilName.setVisible(false);
	        		}
	        		
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
	        }
	    });
		
		
		
		add_tf.addKeyListener(new KeyAdapter() {                                      //******change
	        @Override
	        public void keyReleased (KeyEvent e) {
	        	try {
	        		char c = e.getKeyChar();//stores the text entered in textfield
	        		if(!(Character.isAlphabetic(c)) && !(Character.isDigit(c)) && !(e.getKeyCode()==KeyEvent.VK_COMMA) && !(e.getKeyCode()==KeyEvent.VK_MINUS)&&!(e.getKeyCode()==KeyEvent.VK_SPACE))
	                {
	        			if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
	        				
	        				iadd.setVisible(false);

	        			}
	        			else {				

	        				iadd.setVisible(true);
	        				add_tf.setText(add_tf.getText().replaceAll("[^A-Za-z0-9,-]","")); 

	        			}
	        			
	        			
	                }
	        		else {
	        			
	        			iadd.setVisible(false);
	        		}
	        		
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
	        }
	    });
		
		
		

		city_tf.addKeyListener(new KeyAdapter() {                //**************change
	        @Override
	        public void keyReleased (KeyEvent e) {
	        	try {
	        		char c = e.getKeyChar();//stores the text entered in textfield
	        		if(!(Character.isAlphabetic(c)))
	                {
	        			if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
	        				
	        				icity.setVisible(false);

	        			}
	        			else {				

	        				icity.setVisible(true);
		        			city_tf.setText(city_tf.getText().replaceAll("[^A-Za-z]","")); 

	        			}
	        			

	        			
	                }
	        		else {
	        			
	        			icity.setVisible(false);
	        		}
	        		
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
	        }
	    });
		
		
		
		zip_tf.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (zip_tf.getText().length() >= 6 ) // limit textfield to 6 characters
		            e.consume();                      // stops consuming input
		    }  
		});
		
		

		zip_tf.addKeyListener(new KeyAdapter() {                                    //************ change
	        @Override
	        public void keyReleased (KeyEvent e) {
	        	try {
	        		char c = e.getKeyChar();//stores the text entered in textfield
	        		
	        		
	        		if((Character.isDigit(c)) || e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
	        			
	        			izipcode.setVisible(false);

	        			
	        		}
	        		else {
	        			
	        			izipcode.setVisible(true);
	        		//	ph_tf.setText(amt.getText().substring(0,amt.getText().length()-1));    // this is manual way
	        			zip_tf.setText(zip_tf.getText().replaceAll("[^0-9]",""));
	        			
	        		}
	        		
	        		
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
	        }
	    });
		
		
		
		ph_tf.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (ph_tf.getText().length() >= 10 ) // limit textfield to 10 characters
		            e.consume(); 
		    }  
		});
		
		
		

		ph_tf.addKeyListener(new KeyAdapter() {                                    // ***************change
	        @Override
	        public void keyReleased (KeyEvent e) {
	        	try {
	        		char c = e.getKeyChar();//stores the text entered in textfield
	        		
	        		
	        		if((Character.isDigit(c)) || e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
	        			
	        			iphNo.setVisible(false);

	        			
	        		}
	        		else {
	        			
	        			iphNo.setVisible(true);
	        		//	ph_tf.setText(amt.getText().substring(0,amt.getText().length()-1));    // this is manual way
	        			ph_tf.setText(ph_tf.getText().replaceAll("[^0-9]",""));
	        			
	        		}
	        		
	        		
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
	        }
	    });
		
		
		
		
	
		

	}
	
	
	void apply(JTextField jc)
    {
        jc.setFont(f3);
        jc.setBackground(new Color(0,0,0,4));
        jc.setOpaque(false);
        jc.setCaretColor(caret);
        jc.setForeground(Color.orange);
        jc.setBorder(mb);
    }
	
	
	void doStyle(JLabel jl)
	{
		jl.setForeground(Color.red);
		jl.setFont(f4);
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		if(s.equals("NEXT"))
		{
			
		
			
			
			if(fname_tf.getText().equals("") || lname_tf.getText().equals("") || mname_tf.getText().equals("") || ph_tf.getText().equals("") || add_tf.getText().equals("") || city_tf.getText().equals("") || zip_tf.getText().equals("")) {

				
				JOptionPane.showMessageDialog(this," Fill all the required fields ","Invalid",JOptionPane.ERROR_MESSAGE);
				
			}
			
			else {
				
				if (!EAdd_tf.getText().matches(EMAIL_PATTERN)) {
					
					EAdd_tf.setText("");
					JOptionPane.showMessageDialog(this," Enter a avalid email address ","Invalid",JOptionPane.ERROR_MESSAGE);

				}
				
				else if(ph_tf.getText().toString().length()!=10) {
					
					ph_tf.setText("");
					JOptionPane.showMessageDialog(this," Enter a avalid phone number ","Invalid",JOptionPane.ERROR_MESSAGE);

					
				}
				else if(zip_tf.getText().toString().length()!=6) {
					
					zip_tf.setText("");
					JOptionPane.showMessageDialog(this," Enter a valid PIN code ","Invalid",JOptionPane.ERROR_MESSAGE);

					
				}
				
					
				else {
					//signup panel 2
					sp12=new SignUpPanel12(mf,this);
					mf.main.add(sp12,"sign12");
					c.show(mf.main,"sign12");
				}
			}
			
		}
		else
		{
			c.show(mf.main,"home");
		}
		
		
	}
	

}
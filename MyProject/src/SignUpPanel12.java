
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

public class SignUpPanel12 extends JPanel  implements ActionListener
{
	JLabel branch,ifsc,pan,aadhar,acc,username,pass,confpass;
	JTextField branch_tf,ifsc_tf,pan_tf,aadhar_tf,username_tf;
	JPasswordField pass_tf,confpass_tf;
	JLabel ibranch,iifsc,ipan,iaadhar;
	MainFrame mf;
	SignUpPanel2 sp2;
	CardLayout c;
	Choice acc_ch;
	JPanel jp;
	JButton back,register;
	SignUpPanel sp;
	Font f1,f2,f3,f4;
	RoundedBorder rb;
	Border mb;
	
	
	Color caret;
	String ifsc_pattern = "^[A-Z]{4}0[A-Z0-9]{6}$";
	
	String pancard_pattern = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
	
	String aadhar_pattern = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
	
	
	private void disableKeys(InputMap inputMap) {                             //***** change     // used to disable left and right key 
        String[] keys = {"LEFT", "RIGHT"};
        for (String key : keys) {
            inputMap.put(KeyStroke.getKeyStroke(key), "none");
        }
    }
	
	
	SignUpPanel12(MainFrame mf,SignUpPanel sp)
	{
		this.mf=mf;
		this.sp=sp;
		c=mf.cards;
		setLayout(null);
		setBackground(Color.white);
		
		rb=new RoundedBorder(new Color(93,188,210),0,50,0,false);
		mb=BorderFactory.createMatteBorder(0,0,2,0,Color.white);
		
		caret=Color.orange;
		
		jp=new JPanel();
		jp.setBounds(180,20,700,530);
		jp.setBackground(new Color(0,2,52));
		jp.setBorder(rb);
		add(jp);
		
		f2=new Font("Arial",Font.BOLD+Font.PLAIN,13);
		f3=new Font("Arial",Font.BOLD+Font.PLAIN,13);
		f4=new Font("Arial",Font.PLAIN+Font.BOLD,10);
		
		rb=new RoundedBorder(new Color(93,188,210),0,50,0,false);
		
		jp.setLayout(null);
		
		
		// BRANCH
		branch=new JLabel("Branch");
		branch.setBounds(10,10,100,15);
		branch.setFont(f2);
		branch.setForeground(Color.white);
		jp.add(branch);
		
		branch_tf=new JTextField();
		branch_tf.setBounds(10,25,680,25);
		apply(branch_tf);
		branch_tf.setCaretColor(caret);
		jp.add(branch_tf);
		
		ibranch=new JLabel("enter alphabets only");
		ibranch.setBounds(10,50,680,10);
		doStyle(ibranch);
		jp.add(ibranch);
		ibranch.setVisible(false);
		
		
		// IFSC
		ifsc=new JLabel("IFSC Code");
		ifsc.setBounds(10,70,680,15);
		ifsc.setFont(f2);
		ifsc.setForeground(Color.white);
		jp.add(ifsc);
		
		ifsc_tf=new JTextField();
		ifsc_tf.setBounds(10,85,680,25);
		apply(ifsc_tf);
		ifsc_tf.setCaretColor(caret);
		jp.add(ifsc_tf);
		
		iifsc=new JLabel("invalid");
		iifsc.setBounds(10,110,680,10);
		doStyle(iifsc);
		jp.add(iifsc);
		iifsc.setVisible(false);
		
		
		
		// PAN
		pan=new JLabel("Pan-Card Number");
		pan.setBounds(10,130,680,15);
		pan.setFont(f2);
		pan.setForeground(Color.white);
		jp.add(pan);
		
		pan_tf=new JTextField();
		pan_tf.setBounds(10,145,680,25);
		apply(pan_tf);
		pan_tf.setCaretColor(caret);
		jp.add(pan_tf);
		
		ipan=new JLabel("invalid");
		ipan.setBounds(10,170,680,10);
		doStyle(ipan);
		jp.add(ipan);
		ipan.setVisible(false);
		
		
		// AADHAR CARD
		aadhar=new JLabel("Aadhar-Card Number");
		aadhar.setBounds(10,190,680,15);
		aadhar.setFont(f2);
		aadhar.setForeground(Color.white);
		jp.add(aadhar);
		
		aadhar_tf=new JTextField();
		aadhar_tf.setBounds(10,205,680,25);
		apply(aadhar_tf);
		aadhar_tf.setCaretColor(caret);
		jp.add(aadhar_tf);
		
		
		disableKeys(aadhar_tf.getInputMap());  
		
		
		iaadhar=new JLabel("invalid");
		iaadhar.setBounds(10,230,680,10);
		doStyle(iaadhar);
		jp.add(iaadhar);
		iaadhar.setVisible(false);
		
		
		
		// ACCOUNT TYPE
		acc=new JLabel("Account Type");
		acc.setBounds(10,250,680,15);
		acc.setFont(f2);
		acc.setForeground(Color.white);
		jp.add(acc);
		
		acc_ch=new Choice();
		acc_ch.setBounds(10,265,680,25);
		acc_ch.setFont(f3);
		
		acc_ch.setBackground(new Color(0,2,52));
		acc_ch.setForeground(Color.white);
		jp.add(acc_ch);

		
		acc_ch.add("SAVINGS");
		acc_ch.add("CURRENT");
		
		
		// USERNAME
		username=new JLabel("Username");
		username.setBounds(10, 310, 680, 15);
		username.setFont(f2);
		username.setForeground(Color.white);
		jp.add(username);
		
		
		username_tf=new JTextField();
		username_tf.setBounds(10,325,680,25);
		username_tf.setCaretColor(caret);
		apply(username_tf);
		jp.add(username_tf);
		
		
		
		
		// PASSWORD
		pass=new JLabel("Password");
		pass.setBounds(10, 370, 680, 15);
		pass.setFont(f2);
		pass.setForeground(Color.white);
		jp.add(pass);
		
		
		pass_tf=new JPasswordField();
		pass_tf.setBounds(10,385,680,25);
		pass_tf.setCaretColor(caret);
		apply(pass_tf);
		jp.add(pass_tf);
		
		
		
		// CONFIRM PASSWORD
		confpass=new JLabel("Confirm Password");
		confpass.setBounds(10, 430, 680, 15);
		confpass.setFont(f2);
		confpass.setForeground(Color.white);
		jp.add(confpass);
		
		
		confpass_tf=new JPasswordField();
		confpass_tf.setBounds(10,445,680,25);
		confpass_tf.setCaretColor(caret);
		apply(confpass_tf);
		jp.add(confpass_tf);
		
		
		
		
		
		back=new JButton("BACK");
		back.setBounds(150,480,170,40);
		back.setFont(f2);
		back.setBorder(rb);
		back.setBackground(new Color(93,188,210));
		jp.add(back);
		back.setForeground(Color.white);
		
		
		register=new JButton("REGISTER");
		register.setBounds(360,480,170,40);
		back.setFont(f2);
		register.setBorder(rb);
		register.setBackground(new Color(235,145,0));
		register.setForeground(Color.white);
		jp.add(register);
		
		
		back.addActionListener(this);
		register.addActionListener(this);
		
		
		
		
		
		

		
		branch_tf.addKeyListener(new KeyAdapter() {                               //***********change
        @Override
        public void keyReleased (KeyEvent e) {
        	try {
        		char c = e.getKeyChar();//stores the text entered in textfield
        		
        		if(!(Character.isAlphabetic(c)))
                {
        			
        			if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
        				
        				ibranch.setVisible(false);

        			}
        			else {		
        				//fname_tf.setText("");
        				ibranch.setVisible(true);
	        			branch_tf.setText(branch_tf.getText().replaceAll("[^A-Za-z]","")); 

        			}
        			
        			
                }
        		else {
        			
        			ibranch.setVisible(false);
        		}
        	}
        	catch(Exception e1) {
        		e1.printStackTrace();
        	}
        }
    });
	
		
		
/////////////////////////////////////////////////////////////////////////////



		aadhar_tf.addKeyListener(new KeyAdapter() {                                               //************change
			    public void keyPressed(KeyEvent e) { 
			    	
			    	
			    	if(!(e.getKeyCode()==KeyEvent.VK_BACK_SPACE)) {
			    		
			    		
			    		if(aadhar_tf.getText().length() == 4) {
				    		
				    		aadhar_tf.setText(aadhar_tf.getText()+" ");
				    	}
				    	
				    	else if(aadhar_tf.getText().length() == 9) {
				    		
				    		aadhar_tf.setText(aadhar_tf.getText()+" ");
				    	}
			    		
			    			 
			    		
			    	}
			    	
			    }  
			});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		aadhar_tf.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (aadhar_tf.getText().length() >= 14 ) // limit textfield to 10 characters
		            e.consume(); 
		    }  
		});
		
		pan_tf.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (pan_tf.getText().length() >= 10 ) // limit textfield to 10 characters
		            e.consume(); 
		    }  
		});
		
		ifsc_tf.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (ifsc_tf.getText().length() >= 11 ) // limit textfield to 10 characters
		            e.consume(); 
		    }  
		});
		
		
	}
	

	void doStyle(JLabel jl)
	{
		jl.setForeground(Color.red);
		jl.setFont(f4);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		String na=e.getActionCommand();
		
		
		if(na.equals("REGISTER")) {
			
			
			String pwd = new String(pass_tf.getPassword());
			String confpwd = new String(confpass_tf.getPassword());
			
			 if(!pwd.equals(confpwd)) {
				
				
				confpass_tf.setText("");
				JOptionPane.showMessageDialog(this," Passwords doesn't match ","Invalid",JOptionPane.ERROR_MESSAGE);

			 	}
			 else if(!ifsc_tf.getText().matches(ifsc_pattern)) {
				 
				 
				 
				 	ifsc_tf.setText("");
					JOptionPane.showMessageDialog(this," Enter a valid IFSC code  \n  eg: SBIN0125620","Invalid",JOptionPane.ERROR_MESSAGE);
				 
				 
			 }
			 else if(!pan_tf.getText().matches(pancard_pattern)) {
				 

				 	pan_tf.setText("");
					JOptionPane.showMessageDialog(this," Enter a valid PAN card number  \n  eg: AAAPZ1234C","Invalid",JOptionPane.ERROR_MESSAGE);
				 
			 }
			 else if(!aadhar_tf.getText().matches(aadhar_pattern)) {
				 
				 	aadhar_tf.setText("");
					JOptionPane.showMessageDialog(this," Enter a valid Aadhar card number  \n  eg: 4991 1866 5246 ","Invalid",JOptionPane.ERROR_MESSAGE);
				 
			 }
				
			 else {
				 toCreateFile();	
			 }
		
		}
		
		else if(na.equals("BACK"))
		{
			c.show(mf.main,"sign");
		}
	}

	
	void apply(JTextField jc)
    {
        jc.setFont(f3);
        jc.setCaretColor(caret);
        jc.setBackground(new Color(0,0,0,4));
        jc.setOpaque(false);
        jc.setForeground(Color.orange);
        jc.setBorder(mb);
    }
	private void toCreateFile()
	{
		boolean exist=false;
		File fa=new File("./security_folder");
		
		String na[];
		na=fa.list();
		String path="./security_folder/"+username_tf.getText()+"@"+(2019033800+(na.length/2))+".txt";  
		
		int i=0;
		try
		{
			
			
			
			String user_na="";
			
			
			while(i<na.length)
			{
				user_na=na[i].substring(0,na[i].indexOf("@")); 
				 if(0==(username_tf.getText()).compareTo(user_na))
					{
					username_tf.setText("");
					exist=true;//joptionpane
					break;
					}
				i++;
			}
			
					if(exist==false)
					{
						File f=new File(path);
						FileWriter fw=new FileWriter(f,true);
						BufferedWriter bf=new BufferedWriter(fw);
					
						
						bf.write("USERNAME : "+username_tf.getText());
						bf.newLine();
						bf.write("PASSWORD : "+pass_tf.getText());//new String(pass1.getPassword())
						bf.newLine();
						bf.write("ACCOUNT TYPE : "+acc_ch.getSelectedItem());
						bf.newLine();
						bf.write("BRANCH NAME : "+branch_tf.getText());
						bf.newLine();
						bf.write("IFSC CODE : "+ifsc_tf.getText());
						bf.newLine();
						bf.write("AADHAR CARD NUMBER : "+aadhar_tf.getText());
						bf.newLine();
						bf.write("PANCARD NUMBER : "+pan_tf.getText());
						bf.newLine();
						bf.write("CITY NAME : "+sp.city_tf.getText());
						bf.newLine();
						bf.write("STATE NAME : "+sp.state_ch.getSelectedItem());
						bf.newLine();
						bf.write("PIN CODE : "+sp.zip_tf.getText());
						bf.newLine();
						bf.write("FNAME : "+sp.fname_tf.getText());
						bf.newLine();
						bf.write("MNAME : "+sp.mname_tf.getText());
						bf.newLine();
						bf.write("LNAME : "+sp.lname_tf.getText());
						bf.newLine();
						bf.write("GENDER : "+ (sp.cbg.getSelectedCheckbox()).getLabel());
						bf.newLine();
						bf.write("DOB : "+sp.month.getSelectedItem()+" "+sp.date.getSelectedItem()+", "+sp.year.getSelectedItem());
						bf.newLine();
						bf.write("RELIGION : "+sp.religion_ch.getSelectedItem());
						bf.newLine();
						bf.write("CATAGORY : "+sp.cata_ch.getSelectedItem());
						bf.newLine();
						bf.write("ADDRESS : "+sp.add_tf.getText());
						bf.newLine();
						bf.write("PHONE NO. : "+sp.ph_tf.getText());
						bf.newLine();
						bf.write("EMAIL ADDRESS : "+sp.EAdd_tf.getText());
						bf.newLine();
					
											
					
						bf.close();
						sp2=new SignUpPanel2(mf,username_tf.getText());
						mf.main.add(sp2,"sign2");
						c.show(mf.main,"sign2");
						}
					else
					{
					JOptionPane.showMessageDialog(this," TRY ANOTHER USERNAME ","Invalid",JOptionPane.ERROR_MESSAGE);
					username_tf.setText("");
					}
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

}


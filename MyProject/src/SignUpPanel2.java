import java.awt.CardLayout;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SignUpPanel2 extends JPanel {

	
	JLabel acc_no,amt,pin1,pin2,h1,h2,iamt,ipin1,ipin2;
	JPanel sp,top,bottom;
	CardLayout c;
	MainFrame mf;
	Font f1,f2,f3;
	JTextField pin1_tf,pin2_tf,amt_tf;
	File f;
	JButton ok;
	
	int flag=0;
	
	long acc=2019033800;
	SignUpPanel2 sp2;
	SignUpPanel2(MainFrame mf,String user_na)
	{
		
		setBackground(Color.white);
		try
		{
		setLayout(null);
		this.mf=mf;
		c=mf.cards;

		RoundedBorder rb;
		Border mb;
		
		rb=new RoundedBorder(new Color(93,188,210),0,50,0,false);
		mb=BorderFactory.createMatteBorder(0,0,2,0,Color.white);
		
		top=new JPanel();
		top.setBounds(180,20,700,400);
		top.setBorder(rb);
		top.setBackground(new Color(93, 188, 210));
		
		
		bottom=new JPanel();
		bottom.setBounds(180,200,700,350);
		bottom.setBorder(rb);
		bottom.setBackground(new Color(0,2,52));
		
		//setBackground(new Color(93, 188, 210));
		
		top.setLayout(null);
		bottom.setLayout(null);
		
		
		f1=new Font("Helvetica",Font.PLAIN+Font.BOLD,25);
		f2=new Font("Arial",Font.BOLD+Font.PLAIN,17);
		f3=new Font("Arial",Font.BOLD+Font.PLAIN,13);

		
		
		f=new File("./security_folder");
		int count=f.list().length;
		acc+=(--count)/2;
		
		BufferedWriter bf=new BufferedWriter(new FileWriter("./security_folder/"+user_na+"@"+acc+".txt",true));
		bf.write("ACCOUNT NUMBER : "+acc);
		
		
		h1=new JLabel("YOU ARE REGISTERED SUCESSFULLY !!");
		h1.setBounds(20,20,700,50);
		h1.setHorizontalAlignment(0);//for center alignment
		h1.setFont(f1);
		
		h2=new JLabel("YOUR ACCOUNT NUMBER IS :-");
		h2.setBounds(20,80,700,50);
		h2.setHorizontalAlignment(0);
		h2.setFont(f1);
		
		
		amt=new JLabel("Opening Balance : ");
		amt.setBounds(200,50,200,25);
		amt.setForeground(Color.white);
		amt.setFont(f2);
		
		iamt=new JLabel("enter only numerical value");
		iamt.setBounds(200,100,350,35);
		iamt.setBackground(Color.red);
		iamt.setForeground(Color.red);
		//iamt.setFont(f2);
		iamt.setVisible(false);
		bottom.add(iamt);
		
		
		amt_tf=new JTextField();
		amt_tf.setBounds(200,75,200,25);
		amt_tf.setForeground(Color.orange);
		amt_tf.setOpaque(false);
		amt_tf.setBackground(new Color(0,0,0,4));
		amt_tf.setFont(f2);
		amt_tf.setBorder(mb);


		

		amt_tf.addKeyListener(new KeyAdapter() {                                    //************ change
	        @Override
	        public void keyReleased (KeyEvent e) {
	        	try {
	        		char c = e.getKeyChar();//stores the text entered in textfield
	        		
	        		
	        		if((Character.isDigit(c)) || e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
	        			
	        			iamt.setVisible(false);

	        			
	        		}
	        		else {
	        			
	        			iamt.setVisible(true);
	        		//	ph_tf.setText(amt.getText().substring(0,amt.getText().length()-1));    // this is manual way
	        			amt_tf.setText(amt_tf.getText().replaceAll("[^0-9]",""));
	        			
	        		}
	        		
	        		
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
	        }
	    });
		
		
		
		
		amt_tf.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				String s=amt_tf.getText();
				try {
					int amt=Integer.parseInt(s);
					if(amt>1000) {
						ok.setVisible(true);
					}
					else {
						ok.setVisible(false);
					}
				}
				catch(Exception ee) {
					//JOptionPane.showMessageDialog(sp2, "Enter Numeric Value", "Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		
		
		
acc_no=new JLabel(""+acc);
		acc_no.setBounds(180,130,300,50);
		acc_no.setHorizontalAlignment(0);
		acc_no.setFont(f1);
		
		
		
		
		pin1=new JLabel("Enter Pin : ");
		pin1.setBounds(200,50,200,25);
		pin1.setForeground(Color.white);
		pin1.setFont(f2);
		
		
		pin1_tf=new JTextField();
		pin1_tf.setBounds(200,75,200,25);
		pin1_tf.setForeground(Color.orange);
		pin1_tf.setOpaque(false);
		pin1_tf.setBackground(new Color(0,0,0,4));
		pin1_tf.setFont(f2);
		pin1_tf.setBorder(mb);

		ipin1=new JLabel("enter only numerical value");
		ipin1.setBounds(400,75,200,25);
		ipin1.setBackground(Color.red);
		ipin1.setForeground(Color.red);
		//iamt.setFont(f2);
		ipin1.setVisible(false);
		bottom.add(ipin1);
		
		
		pin2=new JLabel("Confirm pin : ");
		pin2.setBounds(200,110,200,25);
		pin2.setForeground(Color.white);
		pin2.setFont(f2);
		
		
		pin2_tf=new JTextField();
		pin2_tf.setBounds(200,135,200,25);
		pin2_tf.setForeground(Color.orange);
		pin2_tf.setOpaque(false);
		pin2_tf.setBackground(new Color(0,0,0,4));
		pin2_tf.setFont(f2);
		pin2_tf.setBorder(mb);
		
		ipin2=new JLabel("enter only numerical value");
		ipin2.setBounds(400,135,200,25);
		ipin2.setBackground(Color.red);
		ipin2.setForeground(Color.red);
		//iamt.setFont(f2);
		ipin2.setVisible(false);
		bottom.add(ipin2);
		
		
		
		pin1_tf.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				try {
	        		char c = e.getKeyChar();//stores the text entered in textfield
	        		
	        		
	        		if((Character.isDigit(c)) || e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
	        			
	        			ipin1.setVisible(false);

	        			
	        		}
	        		else {
	        			
	        			ipin1.setVisible(true);
	        		//	ph_tf.setText(amt.getText().substring(0,amt.getText().length()-1));    // this is manual way
	        			pin1_tf.setText(pin1_tf.getText().replaceAll("[^0-9]",""));
	        			
	        		}
	        		
	        		
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
				
				
			}			
			
		});
		
		
		pin1_tf.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (pin1_tf.getText().length() >= 4 ) // limit textfield to 6 characters
		            e.consume();                      // stops consuming input
		    }  
		});
		
		
		pin2_tf.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (pin2_tf.getText().length() >= 4 ) // limit textfield to 6 characters
		            e.consume();                      // stops consuming input
		    }  
		});
		
		
		
		
		pin2_tf.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				try {
	        		char c = e.getKeyChar();//stores the text entered in textfield
	        		
	        		
	        		if((Character.isDigit(c)) || e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
	        			
	        			ipin2.setVisible(false);

	        			
	        		}
	        		else {
	        			
	        			ipin2.setVisible(true);
	        		//	ph_tf.setText(amt.getText().substring(0,amt.getText().length()-1));    // this is manual way
	        			pin2_tf.setText(pin2_tf.getText().replaceAll("[^0-9]",""));
	        			
	        		}
	        		
	        		
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
				
				
			}			
			
		});
		
		
		
		
		
		
		
		
		
		
		
		ok=new JButton("Ok");
		ok.setBounds(250,290,200,40);
		ok.setFont(f3);
		ok.setBorder(rb);
		ok.setBackground(new Color(93, 188, 210));
		ok.setForeground(Color.white);
		ok.setVisible(false);
		applyCondition(false);
		//ok.addActionListener(e->mf.cards.show(mf.main,"home"));
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				try {
				if(Integer.parseInt(amt_tf.getText())>1000&&pin1_tf.getText().equals("")&&pin2_tf.getText().equals("")) {
					if(flag==0) {
					bf.newLine();
					bf.write("Balance : "+amt_tf.getText());
				applyCondition(true);
				flag=1;
					}
					else {
						
						JOptionPane.showMessageDialog(sp2, "Pin Field shouldn't be empty!!", "Error ",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				else if(pin1_tf.getText().length()!=4) {
					
					JOptionPane.showMessageDialog(sp2, "Enter a 4 digit PIN!!", "Error ",JOptionPane.ERROR_MESSAGE);

					
				}
				else if(!(pin1_tf.getText()).equals(pin2_tf.getText())) {
					JOptionPane.showMessageDialog(sp2, "Value entered in both pin must be same...", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					
						bf.newLine();
						bf.write("PIN NO : "+pin1_tf.getText());
						bf.close();
						f.setReadOnly();//for having read only format in file
					Process p = Runtime.getRuntime().exec("attrib +H " + f.getPath());
					p.waitFor(); 
					
							
					c.show(mf.main,"home");			
			}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		
		add(bottom);
		add(top);
		
		
		top.add(h1);
		top.add(h2);
		top.add(acc_no);
		
		bottom.add(amt);
		bottom.add(amt_tf);
		bottom.add(ok);
		
		bottom.add(pin1_tf);
		bottom.add(pin2_tf);
		bottom.add(pin1);
		bottom.add(pin2);
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void applyCondition(Boolean flag){
		
		amt.setVisible(!flag);
		amt_tf.setVisible(!flag);
		pin1.setVisible(flag);
		pin2.setVisible(flag);
		pin1_tf.setVisible(flag);
		pin2_tf.setVisible(flag);
	}
}

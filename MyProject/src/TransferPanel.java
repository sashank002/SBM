import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class TransferPanel extends JPanel {
	
	JLabel heading,rs,word,name1,acno,iacno,iamt;
	NumberToWord n;
	JTextField acno_tf,amt;
	JButton transfer;
	Font f;
	Color cpanel,c;
	Border b,b1;
	TransferPanel t;
	
public 	TransferPanel(){
	setLayout(null);
	t=this;
	f=new Font("arial",Font.BOLD,25);
	c=new Color(0,2,52);
	cpanel=new Color(184, 225, 244);
	setBackground(cpanel);
	
	b=BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),new LineBorder(Color.black));
	b1=BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black);
	
	 heading=new JLabel("ENTER THE AMOUNT YOU WANT TO TRANSFER : ");
	 heading.setBounds(10,50,770,50);
	 heading.setHorizontalAlignment(0);
	 applyCondition(heading);
	 
	 	
	 
	 
	 
	 

		rs=new JLabel("Rs.");
		rs.setBounds(300,150,50,30);
		applyCondition(rs);
		
		
		 amt=new JTextField();//TextField For Taking Amount From User...
		 amt.setBounds(350,150,100,30);
		 amt.setBorder(b1);
		 amt.setOpaque(false);
		 amt.setBackground(new Color(0,0,0,4));
		 applyCondition(amt);
		 
		 iamt=new JLabel("enter only numerical values");            //*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&  
		 iamt.setBounds(460, 150, 200, 30);
		 iamt.setForeground(Color.red);
		 iamt.setVisible(false);
			

		 iacno=new JLabel("enter only numerical values");             //*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&  
		 iacno.setBounds(520, 230, 200, 30);
		 iacno.setForeground(Color.red);
		 iacno.setVisible(false);
		 
		 
		 acno=new JLabel("To Account Number :");
		 acno.setBounds(10,200,750,30);
		 acno.setHorizontalAlignment(0);
		 acno.setFont(f);
		 
		 
		 name1=new JLabel();
		 name1.setBounds(10, 310, 750, 30);
		 name1.setHorizontalAlignment(0);
		 name1.setFont(f);
		// name1.setVisible(true);
		 
		// ac_no.setBorder(BorderFactory.)
		// applyCondition(acno);
		 
		 
		 transfer=new JButton("Transfer");
		 transfer.setBounds(290,400,200,30);
		 transfer.setHorizontalAlignment(0);
		 transfer.setFont(f);
		 transfer.setBackground(c);
		 transfer.setForeground(Color.white);
		 transfer.setBorder(b);
		 transfer.setVisible(false);
		 
		 
		 
		 acno_tf=new JTextField();
		 acno_tf.setBounds(290,240 , 200,30);
		acno_tf .setBorder(b1);
		acno_tf.setOpaque(false);
		 acno_tf.setBackground(new Color(0,0,0,4));
		 System.out.println("key bahar");

		 
		 amt.addKeyListener(new KeyAdapter() {                                      //*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&    
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
		        			amt.setText(amt.getText().replaceAll("[^0-9]",""));
		        			
		        		}
		        		
		        		
		        	}
		        	catch(Exception e1) {
		        		e1.printStackTrace();
		        	}
		        }
		    });
		 
		 
		 
		 amt.addKeyListener(new KeyAdapter() {                           //*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&    
			    public void keyReleased(KeyEvent e) { 
			    	
			        if (amt.getText().length() >= 5 && !(amt.getText().toString().equals("10000"))) {                      // limit textfield to 6 characters
			            
			        	e.consume(); 										// stops consuming input
		        		JOptionPane.showMessageDialog(null, "MAXIMUM LIMIT is 10,000  rupees","Error", JOptionPane.ERROR_MESSAGE);
			        	amt.setText("10000");	
			        }                                           
			    }  
			});
		 
		 
		 
		 
		 
		 acno_tf.addKeyListener(new KeyAdapter() {                                      //*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&    
		        @Override
		        public void keyReleased (KeyEvent e) {
		        	try {
		        		char c = e.getKeyChar();//stores the text entered in textfield
		        		
		        		
		        		if((Character.isDigit(c)) || e.getKeyCode()==KeyEvent.VK_BACK_SPACE || e.getKeyCode()==KeyEvent.VK_CAPS_LOCK || e.getKeyCode()==KeyEvent.VK_SHIFT || e.getKeyCode()==KeyEvent.VK_ENTER) {
		        			
		        			iacno.setVisible(false);

		        			
		        		}
		        		else {
		        			
		        			iacno.setVisible(true);
		        		//	ph_tf.setText(amt.getText().substring(0,amt.getText().length()-1));    // this is manual way
		        			acno_tf.setText(acno_tf.getText().replaceAll("[^0-9]",""));
		        			
		        		}
		        		
		        		
		        	}
		        	catch(Exception e1) {
		        		e1.printStackTrace();
		        	}
		        }
		    });
		 
		 
		 acno_tf.addKeyListener(new KeyAdapter() {                      //*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&
			    public void keyTyped(KeyEvent e) { 
			        if (acno_tf.getText().length() >= 10 ) // limit textfield to 6 characters
			            e.consume();                      // stops consuming input
			    }  
			});
		 
		 
		 
		 
		 acno_tf.addKeyListener(new KeyAdapter(){
			 @Override
			 public void keyReleased(KeyEvent e) {
				 
				 int i=0;
				 String s=acno_tf.getText();
				 long no=0;
				 try
				 {
				 no=Long.parseLong(s);
				 }
				 catch(NumberFormatException e1)
				 {
				 }
				 // boolean b=false;
				 
				 if(s.length()==10) {
					 System.out.println("if 1 list");

					File f=new File("./security_folder");
					int n=f.list().length;
					
					if(n/2>=(no-2019033800)) {
						

						String name[]=f.list();
						
						for(i=0;i<name.length;i++) {

							if(name[i].endsWith(s+".txt")) {
								

								break;
							}
							
						}
						
						try {
							 System.out.println(" try");

							BufferedReader br=new BufferedReader(new FileReader("./security_folder/"+name[i]));
							
							
							new StorageClass1(br);
							
							name1.setText(StorageClass1.rec[10].substring(StorageClass1.rec[10].indexOf(": ")+2,StorageClass1.rec[10].length())+" "+StorageClass1.rec[11].substring(StorageClass1.rec[11].indexOf(": ")+2,StorageClass1.rec[11].length())+" "+StorageClass1.rec[12].substring(StorageClass1.rec[12].indexOf(": ")+2,StorageClass1.rec[12].length()));
							name1.setVisible(true);
							//br.close();
							
							//			 add(name1);
							transfer.setVisible(true);
							
							br.close();
						}
						catch(Exception ee) {
							
						}
						
						
					}
				 }
				 else {
						name1.setVisible(false);

					 transfer.setVisible(false);
				 }
			 }
			 
		 });
		 
		 
		 
		 transfer.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 //System.out.println(" transfer");
				 String s=acno_tf.getText();
				 long no=Long.parseLong(s);
				 
				 
				 int pin1=Integer.parseInt(StorageClass.list[22]);
				 
				 
				 int pin=Integer.parseInt(JOptionPane.showInputDialog(t,"Enter Pin "));					
					while(pin!=pin1) {
						JOptionPane.showMessageDialog(t,"Invalid Pin ","Error",JOptionPane.CANCEL_OPTION);
						
						pin=Integer.parseInt(JOptionPane.showInputDialog(t,"Enter Pin "));
						
						
					}
					
					
				if(pin==pin1) {//after pin has been verified
					 	
					 int bal=(Integer.parseInt(StorageClass.list[21])-Integer.parseInt(amt.getText()));
					 if(bal<0) {
						  JOptionPane.showMessageDialog(null, "Trasaction Failed\nAmount Entered Is Greater Than Account Balance", "Insufficient Balance",JOptionPane.ERROR_MESSAGE);

					  }
					 else if(bal<1000) {
						  JOptionPane.showMessageDialog(null, "Transaction Failed\n Account Balance less than Rs. 1000", "Limit Exceeded",JOptionPane.ERROR_MESSAGE);
					  }
					  else {
						  				  
					  StorageClass.list[21]=""+(Integer.parseInt(StorageClass.list[21])-Integer.parseInt(amt.getText()));
					  InitialLeftPanel.balance.setText(" Balance : Rs. "+StorageClass.list[21]+".00");
					  AccountDetail.balance1.setText(": Rs. "+StorageClass.list[21]+".00");
					
					  System.out.println(StorageClass1.rec[21]);
					StorageClass1.rec[21]="Balance : "+(Integer.parseInt(StorageClass1.rec[21].substring(StorageClass1.rec[21].indexOf(": ")+2,StorageClass1.rec[21].length()))+Integer.parseInt(amt.getText()));	
      			   	System.out.print(StorageClass1.rec[21]);
					JOptionPane.showMessageDialog(t,"Rs "+amt.getText()+".00 Debited to XXXXXXX"+(no-2019033000));
					
					String s1=StorageClass1.rec[0].substring(StorageClass1.rec[0].indexOf(": ")+2,StorageClass1.rec[0].length());
					String s2=StorageClass1.rec[20].substring(StorageClass1.rec[20].indexOf(": ")+2,StorageClass1.rec[20].length());
					
					SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					  Date d=new Date();
					
					
					try
					{
					File f=new File("./security_folder/"+s1+"@"+s2+".txt");
					f.setWritable(true);
					BufferedWriter bf=new BufferedWriter(new FileWriter("./security_folder/"+s1+"@"+s2+".txt"));
					StorageClass1.updat(bf);
					bf.close();
					
					
					BufferedWriter bf1=new BufferedWriter(new FileWriter("./security_folder/transfer@"+s1+".txt",true));//opening transfer file of client
					 bf1.write(formatter.format(d)+"          Rs. "+amt.getText()+".00 CREDITED into your Account From A/c No. "+StorageClass.list[20]);
	                  bf1.newLine();
	                  bf1.close();
					f.setReadOnly();
					
					
					BufferedWriter bf2=new BufferedWriter(new FileWriter("./security_folder/transfer@"+StorageClass.list[0]+".txt",true));//opening transfer file of client
					 bf2.write(formatter.format(d)+"          Rs. "+amt.getText()+".00 DEBITED from your Account to A/c No. "+s2);
	                  bf2.newLine();
	                  bf2.close();
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
			 }
			 }
		 });

		 applyCondition(acno_tf);
		 
		 
		 
		
		 
		 
		
	add(rs);
	add(heading);
	add(amt);
	add(acno);
	add(acno_tf);
	add(name1);
	add(transfer);
	add(iamt);
	add(iacno);
	}
	
	void applyCondition(JComponent jc) {
		jc.setFont(f);
		jc.setForeground(c);
		
	}
	

}

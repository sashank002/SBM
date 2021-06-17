
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

 public class DepositPanel extends JPanel{
	JLabel l,word,m;
	JTextField amt;
	NumberToWord n;
	String s,s1;
	Border b,b1;
	JButton deposit;
	Font tf,wf,tff;
	JLabel wall;//Background Image
	JLabel rs;
	DepositPanel p;//Reference Of This Panel
	Color tc;//transparent color
	int n1;		
	int pin1,pin;
	Color cpanel,c;
	public DepositPanel(){
		setLayout(null);
		tc=new Color(0,0,0,4);//for making background transparent
		c=new Color(0,2,52);
		
		n=new NumberToWord();
		p=this;
		 pin1=Integer.parseInt(StorageClass.list[22]);
		b=BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),new LineBorder(Color.black));
		b1=BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black);
		
		cpanel=new Color(184, 225, 244);
		setBackground(cpanel);
	
		tf=new Font("Helvetica CY",Font.PLAIN,25);//Font for text 
		tff=new Font("Arial",Font.BOLD,20);//Font for text Field
		wf=new Font("consolas",Font.BOLD+Font.PLAIN,18);//Font for wordField
		
		
		//Background Image Named "wall"
		wall=new JLabel(new ImageIcon("src\\img1.jpg"));
		wall.setBounds(0,0,780,500);
		
		rs=new JLabel("Rs.");
		rs.setBounds(300,200,50,30);
		rs.setFont(tff);
		rs.setBackground(c);
	
	 l=new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT : ");
	 l.setBounds(100,100,680,50);
	 l.setFont(tf);
	 l.setForeground(c);
	 
	 //label  "YOUR ENTERED AMOUNT IS  :"
	 m=new JLabel("YOUR ENTERED AMOUNT IS :");
	 m.setBounds(280,320,380,50);
	 m.setFont(tff);
	 m.setForeground(c);
	 
	 word=new JLabel();//Label of converted number into Amount
	 word.setForeground(c);
	word.setFont(wf);
	word.setHorizontalAlignment(0);
	word.setBounds(25,350,690,100);
	
	 amt=new JTextField();//TextField For Taking Amount From User...
	 amt.setBounds(350,200,100,30);
	 amt.setFont(tff);
	amt.setBorder(b1);
	amt.setForeground(c);
	amt.setCaretColor(c);
	 applyCondition(amt);
	 
	 deposit=new JButton("Deposit"); //BUtton for deposit
	 deposit.setBounds(350,250,100,30);
	 deposit.setBorder(b);
	 deposit.setForeground(Color.white);
	 deposit.setBackground(new Color(0,2,52));
	// applyCondition(deposit);
	
	 deposit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			s1=amt.getText();
			String spin="";
			int pin=0;
			try {
				if(!s1.equals("")) {
			int a=JOptionPane.showConfirmDialog(p," Do You Want To Deposit "+s+" Rupees");
			
			if(a==0) {//For yes option
				try
				{
					 spin=JOptionPane.showInputDialog(p,"Enter Pin ");
					 pin=Integer.parseInt(spin);	
					
				}
				catch(Exception e1) {
					
				}
				
				if(!(spin.equals("")))
						{
				
					while(pin!=pin1) {
						JOptionPane.showMessageDialog(p,"Invalid Pin ","Error",JOptionPane.CANCEL_OPTION);
						
						pin=Integer.parseInt(JOptionPane.showInputDialog(p,"Enter Pin "));
					}
				if(pin==pin1) {//after pin has been verified
					
				  JOptionPane.showMessageDialog(p,s+" Rupees  Deposited Sucessfully... ");  
				  word.setText("");
				
				 // DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				  SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				  Date d=new Date();
				  //code for deposit
				  		 
				  StorageClass.list[21]=""+(Integer.parseInt(StorageClass.list[21])+Integer.parseInt(amt.getText()));
				  InitialLeftPanel.balance.setText(" Balance : Rs. "+StorageClass.list[21]+".00");
				  AccountDetail.balance1.setText(": Rs. "+StorageClass.list[21]+".00");
				  BufferedWriter br=new BufferedWriter(new FileWriter("./security_folder/transfer@"+StorageClass.list[0]+".txt",true));
                  br.write(formatter.format(d)+"          Rs. "+amt.getText()+".00 DEPOSITED into your account ");
                  br.newLine();
                  br.close();
				  
				  amt.setText("");
				  
				}
				
				
				}
					else
					{
						JOptionPane.showMessageDialog(p,"Pin Can't Be Empty","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				}
				else
				{
					JOptionPane.showMessageDialog(p,"Amount Can't Be Empty ","Error",JOptionPane.CANCEL_OPTION);
				}
			
				  
			
				
		}//end of try block
		
		catch(Exception exp) {
			
			JOptionPane.showMessageDialog(null, "Enter Numeric Value","Error", JOptionPane.ERROR_MESSAGE);
		}
		}
	 });
	 
	 
	
	  
	  
		 amt.addKeyListener(new KeyAdapter() {						//*****change	// 1 key listener na 3 bhaag padya chhe  this is 1st
		        @Override
		        public void keyReleased (KeyEvent e) {
		        	
		        	
		        		char c=e.getKeyChar();
		        		
		        	
		        		if((Character.isDigit(c)) || (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) || (e.getKeyCode()==KeyEvent.VK_ENTER)) {
		        			
		        			
		        		}
		        		else {
		        	        			//amt.setText(amt.getText().substring(0,amt.getText().length()-1));    // this is manual way
		        			amt.setText(amt.getText().replaceAll("[^0-9]",""));
			        		JOptionPane.showMessageDialog(null, "Enter numeric value","Error", JOptionPane.ERROR_MESSAGE);
		        			
		        		}
		        		
		        	
		        }
		    });
		 
		 
		 
		 amt.addKeyListener(new KeyAdapter() {							                     //********* this is 2nd
		        @Override
		        public void keyReleased (KeyEvent e) {
		        	
		        	try {
		        		
		        		s1=amt.getText();//stores the text entered in textfield
		        		n1=Integer.parseInt(s1);
		        		
		        		
		        		if(s1.equals("")) {
		        			word.setText("");
		        		}
		        		else {
		            
		             s=n.convertNumberToWords(n1);//store the word format of number 
		            word.setText(s+" Rupees Only");
		            
		        	}
		        	}
		        	catch(Exception e1) {
		        		
		        		//e1.printStackTrace();
		        	}
		        }
		    });
		 
		 
		 
		 
		 amt.addKeyListener(new KeyAdapter() {                                               // ***********this is third
			    public void keyReleased(KeyEvent e) { 
			    	
			        if (amt.getText().length() >= 6 && !(amt.getText().toString().equals("100000"))) {                      // limit textfield to 6 characters
			            
			        	e.consume(); 										// stops consuming input
		        		JOptionPane.showMessageDialog(null, "MAXIMUM LIMIT is 1 lakh rupees","Error", JOptionPane.ERROR_MESSAGE);
			        	amt.setText("100000");	
			        	n1=100000;
			        	s=n.convertNumberToWords(100000);
			        	word.setText(s+" Rupees Only");
			        	System.out.println("n1"+n1);

			        }                                           
			    
			   
			    	if(amt.getText().equals("")) {
			    		word.setText("");
			    	}
			    }
			    
			});
			

		 
	 
	 
	
	
	 	 
	 //ADDING COMPONENTS TO PANEL
	 add(l);
	 add(rs);
	 add(m);
	 add(amt);
	 add(word);
	 add(deposit);
	// add(wall);
	 
	}
	/** THIS METHOD CONTAINS REQUIRED ADDTIONS FOR EDITING PURPOSE**/
 void applyCondition(JComponent jc) {
	 jc.setForeground(Color.black);
	 jc.setBackground(tc);
	 jc.setOpaque(false);

 }

}

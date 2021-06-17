
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

public class WithdrawPanel extends JPanel{
	JLabel l,word,m;
	JTextField amt;
	NumberToWord n;
	String s,s1;
	JButton withdraw;
	Font tf,wf,tff;
	JLabel wall;//Background Image
	JLabel rs;
	int n1;
	WithdrawPanel p;//Reference Of This Panel
	Color tc,cpanel,c;//transparent color
	
	Border b,b1;
	private int pin,pin1;
	public WithdrawPanel(){
		setLayout(null);
		tc=new Color(0,0,0,4);//for making background transparent
		c=new Color(0,2,52);
		cpanel=new Color(184, 225, 244);
		
		b=BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),new LineBorder(Color.black));
		b1=BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black);
		
		setBackground(cpanel);
		n=new NumberToWord();
		p=this;
		pin1=Integer.parseInt(StorageClass.list[22]);
	
		tf=new Font("Helvetica CY",Font.PLAIN,25);//Font for text 
		tff=new Font("Arial",Font.BOLD,20);//Font for text Field
		wf=new Font("consolas",Font.BOLD+Font.PLAIN,18);//Font for wordField
		
		
		//Background Image Named "wall"
		wall=new JLabel(new ImageIcon("src\\img1.jpg"));
		wall.setBounds(0,0,780,500);
		
		rs=new JLabel("Rs.");
		rs.setBounds(300,200,50,30);
		rs.setForeground(c);
		rs.setFont(tff);
	
	 l=new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW : ");
	 l.setBounds(100,100,680,50);
	 l.setFont(tf);
	l.setBackground(c);
	 l.setForeground(Color.black);
	 
	 //label  "YOUR ENTERED AMOUNT IS  :"
	 m=new JLabel("YOUR ENTERED AMOUNT IS :");
	 m.setBounds(280,320,380,50);
	 m.setFont(tff);
	 m.setBackground(c);
	 m.setForeground(Color.black);
	 
	 
	 
	 withdraw=new JButton("Withdraw"); //BUtton for deposit
	withdraw.setBounds(350,250,100,30);
	withdraw.setBorder(b);
	withdraw.setBackground(c);
	withdraw.setForeground(Color.white);
	 //applyCondition(withdraw);
	
	withdraw.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			s1=amt.getText();
			try {
				if(!s1.equals("")) {
			int a=JOptionPane.showConfirmDialog(p," Do You Want To Withdraw "+s+" Rupees");
			
			if(a==0) {//For yes option
				 pin=Integer.parseInt(JOptionPane.showInputDialog(p,"Enter Pin "));;
				
				
					while(pin!=pin1) {
						JOptionPane.showMessageDialog(p,"Invalid Pin ","Error",JOptionPane.CANCEL_OPTION);
						
						pin=Integer.parseInt(JOptionPane.showInputDialog(p,"Enter Pin "));;
					}
				if(pin==pin1) {//after pin has been verified
					
				 
				  
				  //code for withdrawel
				  int bal=(Integer.parseInt(StorageClass.list[21])-Integer.parseInt(amt.getText()));
				  if(bal<0) {
					  JOptionPane.showMessageDialog(null, "Amount Entered Is Greater Than Account Balance", "Insufficient Balance",JOptionPane.ERROR_MESSAGE);

				  }
				  else if(bal<1000) {
					  JOptionPane.showMessageDialog(null, "Amount Cannot be Withdrawn\n Account Balance less than Rs. 1000", "Limit Exceeded",JOptionPane.ERROR_MESSAGE);
					  
				  }else {
					  
					  SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					  Date d=new Date();
					  
				  StorageClass.list[21]=""+(Integer.parseInt(StorageClass.list[21])-Integer.parseInt(amt.getText()));
				  InitialLeftPanel.balance.setText(" Balance : Rs. "+StorageClass.list[21]+".00");
				  AccountDetail.balance1.setText(": Rs. "+StorageClass.list[21]+".00");
				  JOptionPane.showMessageDialog(p,s+" Rupees  Withdrawn Sucessfully... ");  
				  
				  BufferedWriter br=new BufferedWriter(new FileWriter("./security_folder/transfer@"+StorageClass.list[0]+".txt",true));
                  br.write(formatter.format(d)+"          Rs. "+amt.getText()+".00 Withdrawn from  your account ");
                  br.newLine();
                  br.close();
                  
				  amt.setText("");
				  word.setText("");
				  }
				}
				
				}
				}
			
				else
				{
					JOptionPane.showMessageDialog(null, "Amount Can't Be Empty","Error", JOptionPane.ERROR_MESSAGE);

				}

			
				
		}//end of try block		
		catch(Exception exp) {
			exp.printStackTrace();
		}
		}
	 });
	 
	 
	 word=new JLabel();//Label of converted number into Amount
	 word.setForeground(c);
	word.setFont(wf);
	//word.setBackground(c);
	word.setHorizontalAlignment(0);
	word.setBounds(25,350,690,100);
	
	 amt=new JTextField();//TextField For Taking Amount From User...
	 amt.setBounds(350,200,100,30);
	 amt.setFont(tff);
	amt.setBorder(b1);
	amt.setForeground(c);
	amt.setCaretColor(c);
	 applyCondition(amt);
	  
	 amt.addKeyListener(new KeyAdapter() {						//*****change	// 1 key listener na 3 bhaag padya chhe  this is 1st
	        @Override
	        public void keyReleased (KeyEvent e) {
	        	
	        	
	        		char c=e.getKeyChar();
	        		
	        	
	        		if((Character.isDigit(c)) || (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) || (e.getKeyCode()==KeyEvent.VK_ENTER)) {
	        			
	        			
	        		}
	        		else {
	        			
	        			
	        			amt.setText(amt.getText().replaceAll("[^0-9]",""));
		        		JOptionPane.showMessageDialog(null, "Enter numeric value","Error", JOptionPane.ERROR_MESSAGE);
	        			
	        		}
	        		
	        	
	        }
	    });
	 
	 
	  
	 amt.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyReleased (KeyEvent e) {
	        	try {
	        		 s1=amt.getText();//stores the text entered in textfield
	        		if(s1.equals("")) {
	        			word.setText("");
	        		}
	        		else {
	             n1=Integer.parseInt(s1);
	             s=n.convertNumberToWords(n1);//store the word format of number 
	            word.setText(s+" Rupees Only");
	            
	        	}
	        	}
	        	catch(Exception e1) {
	        		e1.printStackTrace();
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
		    }  
		});
	 
	


	 
	 
	
	
	 	 
	 //ADDING COMPONENTS TO PANEL
	 add(l);
	 add(rs);
	 add(m);
	 add(amt);
	 add(word);
	 add(withdraw);
	 //add(wall);
	 
	}
	/** THIS METHOD CONTAINS REQUIRED ADDTIONS FOR EDITING PURPOSE**/
 void applyCondition(JComponent jc) {
	 jc.setForeground(Color.black);
	 jc.setBackground(tc);
	 jc.setOpaque(false);
 }

}
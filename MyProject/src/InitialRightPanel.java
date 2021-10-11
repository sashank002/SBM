import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class InitialRightPanel extends JPanel{
	
	Color tc;//for transparent color
	Color cpanel;
	JButton deposit,withdraw,ac_detail,per_detail,transfer,transaction;
	JLabel wall;
	JLabel Deposit,Withdraw,Ac_detail,Per_detail,Transfer,Transaction;
	Color brc;
	DashboardPanel dash;
	CardLayout rcard,lcard;
	Font fl;//font for label of buttons
	HistoryPanel history;
	Border b,b1;
	
	public InitialRightPanel(DashboardPanel dash){
			setLayout(null);
			this.dash=dash;
			cpanel=new Color(125,205,254);
			//cpanel=new Color(223,240,216);
			brc=Color.orange;
			
			//setBackground(cpanel);
			
			wall=new JLabel(new ImageIcon("src\\img1.jpg"));
			wall.setBounds(0,0,780,500);
			
			tc=new Color(0,0,0,4);
				
			fl=new Font("Arial",Font.BOLD+Font.PLAIN,14);
			
			rcard=dash.cright;
			lcard=dash.cleft;
		deposit=new JButton(new ImageIcon("src\\deposit.png"));
		withdraw=new JButton(new ImageIcon("src\\withdraw.png"));
		ac_detail=new JButton(new ImageIcon("src\\acdetails.png"));
		per_detail=new JButton(new ImageIcon("src\\per_info.png"));
		transfer=new JButton(new ImageIcon("src\\transfer.png"));
		transaction=new JButton(new ImageIcon("src\\history.png"));
		
		//setting buttons in this panel
		//button dimensions 200x150
		
		deposit.setBounds(100,80,100,100);
		withdraw.setBounds(340,80,100,100);
		transfer.setBounds(590,80,100,100);
		ac_detail.setBounds(100,270,100,100);
		per_detail.setBounds(340,270,100,100);
		transaction.setBounds(590,270,100,100);
		
		
		//deposit.setBorder(BorderFactory.createLineBorder(Color.black, 5, true));
		
		b=BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),new LineBorder(Color.white,2));
		b1=BorderFactory.createCompoundBorder(new LineBorder(Color.white,2),BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createMatteBorder(0, 0, 0,7, brc)));	
		
		deposit.addActionListener(e-> {
			applyBorder();
			 dash.lnp.deposit.setBorder(b1);
			 
			rcard.show(dash.right,"deposit");
			lcard.show(dash.left,"navi");
		});
		
		
		withdraw.addActionListener(e-> {
			applyBorder();
			 dash.lnp.withdraw.setBorder(b1);

				rcard.show(dash.right,"withdraw");
				lcard.show(dash.left,"navi");
			}
		);
		
		transfer.addActionListener(e-> {
			applyBorder();
			 dash.lnp.transfer.setBorder(b1);

				rcard.show(dash.right,"transfer");
				lcard.show(dash.left,"navi");
			}
		);
		
		
		per_detail.addActionListener(e-> {
			applyBorder();
			 dash.lnp.per_detail.setBorder(b1);
			rcard.show(dash.right,"pdetail");
			lcard.show(dash.left,"navi");
		}
	);
		ac_detail.addActionListener(e->{
			applyBorder();
			 dash.lnp.ac_detail.setBorder(b1);
			rcard.show(dash.right,"acdetail");
			lcard.show(dash.left,"navi");
		});
		transaction.addActionListener(e->{
			applyBorder();
			history=new HistoryPanel();
			dash.right.add(history,"history");
			 dash.lnp.transaction.setBorder(b1);
			rcard.show(dash.right,"history");
			lcard.show(dash.left,"navi");
		});
		
		
		
		
		Deposit=new JLabel("Deposit");
		
		Withdraw=new JLabel("Withdraw");
		Transfer=new JLabel("Transfer Money");
		Ac_detail=new JLabel("A/C Details");
		Per_detail=new JLabel("Personal Details");
		Transaction=new JLabel("Transaction History");
		
		
		
		Deposit.setBounds(130, 200, 100, 30);
		Withdraw.setBounds(360, 200, 100, 30);
		Transfer.setBounds(600, 200, 150, 30);
		Ac_detail.setBounds(120, 390, 100, 30);
		Per_detail.setBounds(350, 390, 150, 30);
		Transaction.setBounds(580, 390, 150, 30);
		
		
		Deposit.setFont(fl);
		
		Withdraw.setFont(fl);
		Transfer.setFont(fl);
		Ac_detail.setFont(fl);
		Per_detail.setFont(fl);
		Transaction.setFont(fl);
		
		applyCondition(deposit);
		applyCondition(withdraw);
		applyCondition(transfer);
		applyCondition(ac_detail);
		applyCondition(per_detail);
		applyCondition(transaction);
		
		
		applyCondition(Deposit);
		applyCondition(Withdraw);
		applyCondition(Transfer);
		applyCondition(Ac_detail);
		applyCondition(Per_detail);
		applyCondition(Transaction);

		
		deposit.setBorderPainted(false);
		withdraw.setBorderPainted(false);
		transfer.setBorderPainted(false);
		ac_detail.setBorderPainted(false);
		per_detail.setBorderPainted(false);
		transaction.setBorderPainted(false);
		
		
		add(Deposit);
		add(Withdraw);
		add(Ac_detail);
		add(Per_detail);
		add(Transfer);
		add(Transaction);
		
		add(deposit);
		add(withdraw);
		add(ac_detail);
		add(per_detail);
		add(transfer);
		add(transaction);
		
		add(wall);
	}

	/** THIS METHOD CONTAINS REQUIRED ADDTIONS FOR EDITING PURPOSE**/
	 void applyCondition(JComponent jc) {
		 jc.setForeground(Color.black);
		 jc.setBackground(tc);
		 
		 jc.setOpaque(false);
	 }
	 
	 void applyBorder() {
		 
		
		
		 
		
		 dash.lnp.deposit.setBorder(b);
		 dash.lnp.withdraw.setBorder(b);
		 dash.lnp. transfer.setBorder(b);
		 dash.lnp. ac_detail.setBorder(b);
		 dash.lnp.per_detail.setBorder(b);
		 dash.lnp.transaction.setBorder(b);
	 }
}

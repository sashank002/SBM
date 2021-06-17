import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class LeftNaviPanel extends JPanel{
	
JButton home,deposit,withdraw,transfer,transaction,ac_detail,per_detail;


DashboardPanel dash;//Reference of "DashBoardPanel"


JLabel wall;

Font f;

Border b,b1;

Color tc;//Transparent color
Color cpanel,brc;
HistoryPanel history;
public LeftNaviPanel(DashboardPanel dash) {
	setLayout(new GridLayout(8,0,10,10));
	
	this.dash=dash;
	
	brc=Color.orange;
	
	cpanel=new Color(0,2,52);
//	b=BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 0,10, brc),BorderFactory.createRaisedBevelBorder()));
	
	
	b=BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),new LineBorder(Color.white,2));
	b1=BorderFactory.createCompoundBorder(new LineBorder(Color.white,2),BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),BorderFactory.createMatteBorder(0, 0, 0,7, brc)));	
	
	
	
	setBackground(cpanel);
	
	f=new Font("calibri",Font.BOLD,18);
	
	
	tc=new Color(0,0,0,4);//for having transparent effect
	
	//Background Image "wall"
	
	wall=new JLabel(new ImageIcon("src\\3.jpeg"));
	wall.setBounds(0,0,300,500);
	
	//Initializing buttons
	
	home=new JButton("Home");

	deposit=new JButton("Deposit");

	
	
	withdraw=new JButton("Withdraw");
	transfer=new JButton("Transfer Money");
	transaction=new JButton("Transactions");
	ac_detail=new JButton("A/C Details");
	per_detail=new JButton("Personal Details");
	
	//setting bounds of buttons
	 /*                                //button dimensions 300 x 50
	home.setBounds(0,100,300,50);
	deposit.setBounds(0,150,300,50);
	withdraw.setBounds(0,200,300,50);
	transfer.setBounds(0,250,300,50);
	ac_detail.setBounds(0,300,300,50);
	per_detail.setBounds(0,350,300,50);
	transaction.setBounds(0,400,300,50);
	*/
	
	home.addActionListener(e-> {
		
			dash.cright.show(dash.right,"initial");
			dash.cleft.show(dash.left,"detail");
		
	});
	
	
	deposit.addActionListener(e->{
		applyBorder();
		deposit.setBorder( b1);
	dash.cright.show(dash.right,"deposit");
	});//lambda Expression
	
	withdraw.addActionListener(e->{
		applyBorder();
		withdraw.setBorder(b1);
		
		dash.cright.show(dash.right,"withdraw");});
	
	
	
	transfer.addActionListener(e->{
		applyBorder();
	transfer.setBorder(b1);
		
		dash.cright.show(dash.right,"transfer");});
	
	per_detail.addActionListener(e->{
		applyBorder();
		per_detail.setBorder(b1);
		
		dash.cright.show(dash.right,"pdetail");});
	
	ac_detail.addActionListener(e->{
		
		applyBorder();
		ac_detail.setBorder(b1);
		dash.cright.show(dash.right,"acdetail");});
	
	
transaction.addActionListener(e->{
		history=new HistoryPanel();
		applyBorder();
		dash.right.add(history,"history");
		transaction.setBorder(b1);
		dash.cright.show(dash.right,"history");});
	
	//Applying Condition for Making It Transparent
	applyCondition(home);
	applyCondition(deposit);
	applyCondition(withdraw);
	applyCondition(transfer);
	applyCondition(ac_detail);
	applyCondition(per_detail);
	applyCondition(transaction);
	
	
	
	
	      //ADDING ELEMENTS TO PANEL
			add(home);
			add(deposit);
			add(withdraw);
			add(transfer);
			add(ac_detail);
			add(per_detail);
			add(transaction);
			//add(wall);
			
	
}

/** THIS METHOD CONTAINS REQUIRED ADDTIONS FOR EDITING PURPOSE**/
void applyCondition(JComponent jc) {
	 jc.setForeground(Color.white);
	 jc.setBackground(tc);
	 jc.setFont(f);
	//jc.setBorder(BorderFactory.createRaisedBevelBorder());
	 jc.setOpaque(false);
}

void applyBorder() {
	 
	home.setBorder(b);
	deposit.setBorder(b);
	 withdraw.setBorder(b);
	 transfer.setBorder(b);
	 ac_detail.setBorder(b);
	per_detail.setBorder(b);
	transaction.setBorder(b);
}

}

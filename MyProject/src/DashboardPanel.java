import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DashboardPanel extends JPanel {
JPanel up,left,right;//sub panels of Dashboard panel
JButton b;
JLabel wall,logo;

JLabel heading;

Font hf;//heading Font

Color tc;//transparent color

CardLayout c,cleft,cright;

MainFrame mf;
Color cpanel;

InitialLeftPanel ilp;
LeftNaviPanel lnp;

InitialRightPanel irp;
DepositPanel deposit;
WithdrawPanel withdraw;
TransferPanel transfer;
PersonalDetail pdetail;
AccountDetail acdetail;
//HistoryPanel history;

public DashboardPanel(MainFrame mf){
	this.mf=mf;
	
	
	cpanel=new Color(0,2,52);//color of panel  dark blue
	
	
	
	logo=new JLabel(new ImageIcon("src\\log2.png"));//Sbm logo
	logo.setBounds(10,10,300,80);
	
	tc=new Color(0,0,0,4);//transparent color
	hf=new Font("Helvetica",Font.BOLD,30);
	         
	//cradlayout object of main frame
	c=mf.cards; //
	
	 //card layout for left panel 
	cleft=new CardLayout();
	
	//cardlayout for right panel
	cright=new CardLayout();
	
	setLayout(null);
	
	//initializing panel 
	up=new JPanel();
	left=new JPanel();
	right=new JPanel();
	up.setLayout(null);
	
	//applying cardlayout to left and right panel
	left.setLayout(cleft);
	right.setLayout(cright);
	
	//LOGOUT BUTTON 
	b=new JButton(new ImageIcon("src\\logout.png"));
	b.setBounds(850,10,180,70);
	

	
	b.addActionListener((e)->{
	
	int a=JOptionPane.showConfirmDialog(null,"Do you want to Logout ?");
	
	if(a==0) {//for yes option
		
		try
		{
			StorageClass.upDate();
		//code for storing new data 
		File f=new File("./security_folder/"+StorageClass.list[0]+"@"+StorageClass.list[20]+".txt");
		f.setWritable(true);
		BufferedWriter bf=new BufferedWriter(new FileWriter("./security_folder/"+StorageClass.list[0]+"@"+StorageClass.list[20]+".txt"));
		
		File f1=new File("./security_folder/"+"transfer@"+StorageClass.list[0]+".txt");
        f1.createNewFile();
		
		bf.write("USERNAME : "+StorageClass.list[0]);
		bf.newLine();
		bf.write("PASSWORD : "+StorageClass.list[1]);//new String(pass1.getPassword())
		bf.newLine();
		bf.write("ACCOUNT TYPE : "+StorageClass.list[2]);
		bf.newLine();
		bf.write("BRANCH NAME : "+StorageClass.list[3]);
		bf.newLine();
		bf.write("IFSC CODE : "+StorageClass.list[4]);
		bf.newLine();
		bf.write("AADHAR CARD NUMBER : "+StorageClass.list[5]);
		bf.newLine();
		bf.write("PANCARD NUMBER : "+StorageClass.list[6]);
		bf.newLine();
		bf.write("CITY NAME : "+StorageClass.list[7]);
		bf.newLine();
		bf.write("STATE NAME : "+StorageClass.list[8]);
		bf.newLine();
		bf.write("PIN CODE : "+StorageClass.list[9]);
		bf.newLine();
		bf.write("FNAME : "+StorageClass.list[10]);
		bf.newLine();
		bf.write("MNAME : "+StorageClass.list[11]);
		bf.newLine();
		bf.write("LNAME : "+StorageClass.list[12]);
		bf.newLine();
		bf.write("GENDER : "+StorageClass.list[13]);
		bf.newLine();
		bf.write("DOB : "+StorageClass.list[14]);
		bf.newLine();
		bf.write("RELIGION : "+StorageClass.list[15]);
		bf.newLine();
		bf.write("CATAGORY : "+StorageClass.list[16]);
		bf.newLine();
		bf.write("ADDRESS : "+StorageClass.list[17]);
		bf.newLine();
		bf.write("PHONE NO. : "+StorageClass.list[18]);
		bf.newLine();
		bf.write("EMAIL ADDRESS : "+StorageClass.list[19]);
		bf.newLine();
		bf.write("ACCOUNT NUMBER : "+StorageClass.list[20]);
		bf.newLine();
		bf.write("Balance : "+StorageClass.list[21]);
		bf.newLine();
		bf.write("PIN NO : "+StorageClass.list[22]);
		bf.close();
		f.setReadOnly();
		c.show(mf.main,"home");
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	});
	
	b.setBorderPainted(false);
	applyCondition(b);
	
	heading=new JLabel("Welcome, "+StorageClass.list[10]+"!!");
	heading.setBounds(310,10,460,80);
	heading.setHorizontalAlignment(0);
	
	
	heading.setFont(hf);
	heading.setForeground(Color.white);
	
	up.add(logo);
	up.add(heading);
	up.add(b);//adding logout button
	up.setBackground(cpanel);
	
	
	//setting bounds of panels 
	
	up.setBounds(0,0,1080,100);
	left.setBounds(0,100,300,500);
	right.setBounds(300,100,780,500);
	
	//BORDER CONFIGURATION FOR DASHBOARD PANEL
	
	Border compound,compound1,compound3,compound2;
	
	{
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();//
	       Border loweredbevel = BorderFactory.createLoweredBevelBorder();//
		Border whiteline = BorderFactory.createLineBorder(Color.white,2);
		 
	       Border matte=BorderFactory.createMatteBorder(2, 0, 0, 1, Color.white);
	       Border matte1=BorderFactory.createMatteBorder(2, 1, 0, 0, Color.white);
	       
	        compound = BorderFactory.createCompoundBorder(
                    whiteline,raisedbevel);
	        
	        compound1=BorderFactory.createCompoundBorder(
                    whiteline,loweredbevel);
	        
	        compound2=BorderFactory.createCompoundBorder(
	        		matte1,loweredbevel);
	        
	        compound3=BorderFactory.createCompoundBorder(
	        		matte,raisedbevel);
		
	}
	
	//up.setBorder(compound);//setting
	left.setBorder(compound3);
	right.setBorder(compound2);

	
	
	//right card layout
	irp=new InitialRightPanel(this);
	deposit=new DepositPanel();
	withdraw=new WithdrawPanel();
	transfer=new TransferPanel();
	pdetail=new PersonalDetail();
	acdetail=new AccountDetail();
	
	
	right.add(irp,"initial");
	right.add(deposit,"deposit");
	right.add(withdraw,"withdraw");
	right.add(transfer,"transfer");
	right.add(pdetail,"pdetail");
	right.add(acdetail,"acdetail");
	//right.add(history,"history");
	
	
	//left card layout
	ilp=new InitialLeftPanel();
	left.add(ilp,"detail");
	
	lnp=new LeftNaviPanel(this);
	left.add(lnp,"navi");
	
	add(up);
	add(left);
	add(right);
}
/** THIS METHOD CONTAINS REQUIRED ADDTIONS FOR EDITING PURPOSE**/
void applyCondition(JComponent jc) {
	 jc.setForeground(Color.black);
	 jc.setBackground(tc);
	 
	 jc.setOpaque(false);
}
	
}

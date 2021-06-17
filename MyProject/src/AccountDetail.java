import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountDetail extends JPanel{
	 JLabel branch,ifsc,actype,acno,pan,aadhar,balance;
	
	  JLabel branch1,ifsc1,actype1,acno1,pan1,aadhar1;
	
	  
	  Color cpanel;
	static JLabel balance1;
	Font f1,f2;
	
	JLabel wall;
	
	AccountDetail(){
		
		cpanel=new Color(184, 225, 244);
		setLayout(new GridLayout(8,2,10,20));
		
		setBackground(cpanel);
		
		f1=new Font("arial",Font.BOLD,25);
		f2=new Font("arial",Font.ITALIC+Font.BOLD,20);
		
		wall=new JLabel(new ImageIcon("src\\img1.jpg"));
		wall.setBounds(0,0,780,500);
		
		acno=new JLabel("Account No. ");
		applyCondition(acno);
		
		actype=new JLabel("Account Type  ");
		applyCondition(actype);
		
		
		balance=new JLabel("Account Balance ");
		applyCondition(balance);
		
		ifsc=new JLabel("IFSC NO  ");
		applyCondition(ifsc);
		
		branch=new JLabel("Branch  ");
		applyCondition(branch);
		
		aadhar=new JLabel("Linked Aadhar No. ");
		applyCondition(aadhar);
		
		pan=new JLabel("Linked Pan No. "); 
		applyCondition(pan);
		
		
		
		
		
		acno1=new JLabel(": "+StorageClass.list[20]);
		actype1=new JLabel(": "+StorageClass.list[2]);
		balance1=new JLabel(": Rs. "+StorageClass.list[21]+".00");
		ifsc1=new JLabel(": "+StorageClass.list[4]);
		branch1=new JLabel(": "+StorageClass.list[3]);
		aadhar1=new JLabel(": "+StorageClass.list[5]);
		pan1=new JLabel(": "+StorageClass.list[6]);
		

		
				applyCondition1(acno1);
		
		applyCondition1(actype1);
		
		
		applyCondition1(balance1);
		
		applyCondition1(ifsc1);
		
		applyCondition1(branch1);
		
		applyCondition1(aadhar1);
		
		applyCondition1(pan1);
		
		
		add(acno);
		add(acno1);

		add(actype);
		add(actype1);

		add(balance);
		add(balance1);

		add(ifsc);
		add(ifsc1);

		add(branch);
		add(branch1);
		
		add(aadhar);
		add(aadhar1);
		
		add(pan);
		add(pan1);
		
		
		//add(wall);
		
		
	}
	
	
	
void	applyCondition(JLabel jc){
			
		jc.setFont(f1);
		jc.setHorizontalAlignment(0);
		jc.setBackground(new Color(184, 225, 244));
	
	}

void applyCondition1(JComponent jc) {
	
	jc.setBackground(new Color(184, 225, 244));

	jc.setFont(f2);
}

}

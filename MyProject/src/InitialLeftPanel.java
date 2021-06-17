import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InitialLeftPanel extends JPanel   {
	
	JLabel name,ac_no,ac_type,branch;
	static JLabel balance;
	Color cpanel;
	Font f;
	
	InitialLeftPanel(){
		setLayout(new GridLayout(10,0));
		f=new Font("calibri",Font.PLAIN,25);
		
		cpanel=new Color(0,2,52);
		
		
		
		name=new JLabel(""+StorageClass.list[10].toUpperCase()+" "+StorageClass.list[12].toUpperCase());
		
		
		applyCondition(name);
		name.setFont(new Font("arial",Font.BOLD+Font.PLAIN,25));
		
		ac_no=new JLabel("A/c No. : "+StorageClass.list[20]);
		
		ac_no.setFont(f);
		applyCondition(ac_no);
		
		ac_type=new JLabel(" A/c Type : "+StorageClass.list[2]);
		applyCondition(ac_type);
		
		
		balance=new JLabel(" Balance : Rs. "+StorageClass.list[21]+".00");
		applyCondition(balance);
		
		
		branch=new JLabel(" Branch Name : "+StorageClass.list[3]);
		applyCondition(branch);
		
		
		setBackground(cpanel);
		
		add(name);
		add(ac_no);
		add(ac_type);
		add(balance);
		add(branch);
		
		
		
	}
	
	
	void applyCondition(JLabel jl){
		jl.setFont(f);
		jl.setForeground(Color.white);
		jl.setHorizontalAlignment(0);
		
	}

}

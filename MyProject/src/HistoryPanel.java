import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class HistoryPanel extends JPanel {

	JPanel jp;
	JScrollPane jsp;
	JLabel jb1,jb2;
	Font f;
	JLabel label[];
	int i=0;
	Color c,cpanel;
	Border b;
	
	List <String> al;
	
	HistoryPanel()
	{
		c=new Color(0,2,52);
		cpanel=new Color(184, 225, 244);
		//setBackground(cpanel);
		f=new Font("calibri",Font.BOLD,25);
		   b=BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createMatteBorder(3,3,1,1,c));
setBorder(b);
		try
		{
		   jp=new JPanel();
		   jp.setLayout(new GridLayout(0,1));
		   jp.setBackground(cpanel);
		   jp.setBorder(b);
		   BufferedReader br=new BufferedReader(new FileReader("./security_folder/transfer@"+StorageClass.list[0]+".txt"));
		   String s=br.readLine();
		   
		   
		   al=new ArrayList<String>();
		   while(s!=null)
		   {
			   i++;
			   al.add(s);
			   s=br.readLine();
		   }
		   
		   label = new JLabel [i]; 
		   
		   for (int i=(al.size()-1);i>=0;i--)
		   		{  
			      label[i] = new JLabel(al.get(i));  
			      label[i].setForeground(c);
			      label[i].setFont(f);
			      
			      jp.add(label[i]); 
			      
			    }
		   
		   
		   jsp=new JScrollPane(jp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		   jsp.setPreferredSize(new Dimension(750,450));
		   add(jsp);
	}
	catch(Exception e)
		{
		
		}
	}
}

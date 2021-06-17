import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PersonalDetail extends JPanel{
	
	JLabel name,fr_name,dob,gender,no,email,add,city,pincode,category,religion;
	
	JLabel name1,fr_name1,dob1,gender1,no1,email1,add1,city1,pincode1,category1,religion1;
	
	JLabel wall;
	Color cpanel;
	
	PersonalDetail(){
		setLayout(new GridLayout(12,2));
		cpanel=new Color(184, 225, 244);
		setBackground(cpanel);
		
		wall=new JLabel(new ImageIcon("src\\img1.jpg"));
		wall.setBounds(0,0,780,500);
		
		   name= new JLabel("Name ");
		   name.setOpaque(false);
		   name.setBackground(new Color(0,0,0,4));
		
		   applyCondition(name);
		  
		   name1= new JLabel(": "+StorageClass.list[10].toUpperCase()+" "+StorageClass.list[12].toUpperCase());
		 		   applyCondition1(name1);
		   
		fr_name= new JLabel("Father's Name ");
				 applyCondition(fr_name);
		
		 
			fr_name1= new JLabel(":  "+StorageClass.list[11].toUpperCase()+" "+StorageClass.list[12].toUpperCase());
			
			 applyCondition1(fr_name1);
		
		    dob= new JLabel("Date Of Birth ");
		    applyCondition(dob);
		    
		    
		    dob1= new JLabel(":  "+StorageClass.list[14]);
		    applyCondition1(dob1);
		    
		    
		 gender= new JLabel("Gender ");
		 
		 applyCondition(gender);
		 
		 gender1= new JLabel(": "+StorageClass.list[13]);
		 applyCondition1(gender1);
		 
		     no= new JLabel("Moblie No. ");
		     applyCondition(no);
		     
		     no1= new JLabel(":  "+StorageClass.list[18]);
		     applyCondition1(no1);
		     
		     add=  new JLabel("Address ");
		     applyCondition(add);
		     
		     add1=  new JLabel(":  "+StorageClass.list[17]);
		     applyCondition1(add1);
		     
		  email= new JLabel("E-mail Id ");
		  applyCondition(email);
		  
		  
		  email1= new JLabel(":  "+StorageClass.list[19]);
		  applyCondition1(email1);
		  
		   city= new JLabel(" City ");
		   applyCondition(city);
		   
		   city1= new JLabel(":  "+StorageClass.list[7]);
		   applyCondition1(city1);
		   
		pincode= new JLabel("Pin Code ");
		 applyCondition(pincode);
		 
		 pincode1= new JLabel(":  "+StorageClass.list[9]);
			 applyCondition1(pincode1);
		
	   category= new JLabel("Category  ");
	   applyCondition(category);
	   

	   category1= new JLabel(":  "+StorageClass.list[16]);
	   applyCondition1(category1);
	   
	   religion= new JLabel("Religion ");
	   applyCondition(religion);
	   
	   religion1= new JLabel(":  "+StorageClass.list[15]);
	   applyCondition1(religion1);
	   
	   
		
		add(name);
		add(name1);
		
		add(fr_name);
		add(fr_name1);
		
		add(dob);
		add(dob1);
		
		add(gender);
		add(gender1);
		
		add(no);
		add(no1);
		
		add(email);
		add(email1);
		
		add(add);
		
		add(add1);
		
		add(city);
		add(city1);
		
		add(pincode);
		add(pincode1);
		
		add(category);
		add(category1);
		
		add(religion);
		add(religion1);	
		
		
		
		
		
		
	}
	void applyCondition(JLabel jl){
		jl.setFont(new Font("Helvetica",Font.BOLD,20));
		jl.setHorizontalAlignment(0);
		
		//jl.setText("Name :");
		//jl.add(wall);
		
		
	}
	
	void applyCondition1(JLabel jl){
		
		jl.setFont(new Font("Helvetica",Font.ITALIC+Font.BOLD,20));
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		//jl.setBorder(BorderFactory.createLineBorder(Color.blue));
	}

}

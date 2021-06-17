import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginPanel extends JPanel{
	JTextField user;
	JPasswordField pass;
	
	Border b1,b2;
	Font f1,f2;
	JLabel username,password;
	
	
	LoginPanel(){
		setLayout(null);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		b1=BorderFactory.createRaisedBevelBorder();
		b2=BorderFactory.createLoweredBevelBorder();
		//addWindowListener()
		
			/////////////
		
			f1=new Font("arial",Font.PLAIN,20);
			f2=new Font("Helvetica CY",Font.PLAIN+Font.BOLD,20);
		
		
		username=new JLabel("Username : ");
		username.setForeground(Color.black);
		username.setBounds(80,50,150,30);
		username.setFont(f1);
		
		
		password=new JLabel("Password : ");
		password.setBounds(80,250,150,30);
		password.setForeground(Color.black);
		password.setFont(f1);
		
		
		user=new JTextField();
		user.setOpaque(false);
		user.setForeground(Color.black);
		user.setBounds(250,50,150,30);
		user.setFont(f2);
		user.setBorder(b2);
		
		
		
		pass=new JPasswordField();
		pass.setOpaque(false);
		pass.setForeground(Color.black);
		pass.setBounds(250,110,150,30);
		pass.setFont(f2);
		pass.setBorder(b2);
		
		
		
		this.setBorder(b1);
		this.setOpaque(false);
		
		
		add(username);
		add(password);
		add(user);
		add(pass);
	}

}

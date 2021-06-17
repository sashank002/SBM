import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class MainFrame extends JFrame implements ActionListener
{
	public JPanel main,home,register;
	public CardLayout cards;
	JButton Login,Register;
	JTextField user;
	JPasswordField pass;
	Border b1,b2;
	Color c,tc;//transparent color
	JLabel username,password;
	Font f1,f2;
	JCheckBox show;
	JLabel showpass;
	StorageClass sc;//for temporary storing data
	
	Color lback,rback;
	
	LoginPanel l;
	
	JPanel left,right;
	
	JLabel wall;
	JLabel ll;
	RoundedBorder rb,rb2;//Roundeed Border
	
	Border bb;
	
	SignUpPanel sup;
	DashboardPanel dash;
	
	public MainFrame(String s)
	{
		super(s);
		///////////////////////////////////////////////////////general
		JLabel wel=new JLabel("WELCOME TO STUDENT'S BANK OF MSU ");
		wel.setFont(new Font("Helvetica",Font.PLAIN,35));
		wel.setBounds(180,50,800,40);
		
		cards=new CardLayout();//object of card layout
		main=new JPanel();
		main.setLayout(cards);//applying card layout to the frame
		MainFrame mf=this;
		/////////////////////////////////////////////////////////Border
		b1=BorderFactory.createRaisedBevelBorder();
		b2=BorderFactory.createLoweredBevelBorder();
		  LineBorder line = new LineBorder(Color.white, 1, true);
		  
		  //rouded boder 
		 rb=new RoundedBorder(lback,0,75,0,false);
		 rb2=new RoundedBorder(lback,0,50,0,false);
		
		 //for setting border of username and password field
		 
		 bb=BorderFactory.createMatteBorder(0,0,2,0,Color.white);
		 
		 /////////////////////////////////////////////////////////Fonts
		f1=new Font("arial",Font.PLAIN+Font.BOLD,20);//for labels
		f2=new Font("Helvetica CY",Font.PLAIN+Font.BOLD,17);  //for buttons
		
		wall=new JLabel(new ImageIcon("src\\white.png"));
		wall.setBounds(0, 0, 1080, 600);
		
		ll=new JLabel(new ImageIcon("src\\login logo.png"));// setting SBM logo in label
		///color
		
		
		
		rback=new Color(0,2,52);
		//lback=Color.white;
		lback=new Color(93, 188, 210);
	
	
		///////////////////////////////////////////////////////home panel
		home=new JPanel();
		home.setLayout(null);
		home.setBackground(lback);
		
		
		
		left=new JPanel();
		left.setBounds(0,0,570,600);
		left.setBackground(lback);
		
		
		left.setBorder(rb);
		
		 
	//	left.setOpaque(false);
		
		right=new JPanel();
		right.setBounds(530,0,570,565);
		right.setBackground(rback);
		//
	//right.setBorder(null);
		right.setBorder(rb);
		//right.setBorder();
		
		home.add(right);
		//
		
		home.add(left);
		
	//	left.setLayout(new BorderLayout());
		right.setLayout(null);
		left.setLayout(null);
		
		ll.setBounds(0,170,534,142);
		//left.add(BorderLayout.CENTER,ll);
		left.add(ll);
		
		////////////////////////////////////////////username and password label
		username=new JLabel("Username : ");
		username.setForeground(Color.white);
		username.setBounds(100,100,150,30);
		username.setFont(f1);
		
		password=new JLabel("Password : ");
		password.setBounds(100,170,150,30);
		password.setForeground(Color.white);
		password.setFont(f1);
	
		user=new JTextField();
		user.setOpaque(false);
		user.setForeground(Color.orange);
		user.setBounds(100,130,400,30);
		user.setFont(f1);
		user.setCaretColor(Color.orange);
		user.setBorder(bb);
		
		
		pass=new JPasswordField();
		pass.setOpaque(false);
		pass.setForeground(Color.orange);
		pass.setBounds(100,200,400,30);
		pass.setFont(f1);
		pass.setCaretColor(Color.orange);
		pass.setBorder(bb);
		pass.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				showpass.setText(pass.getText());
			}
		});
			
		
		
		
		
		show=new JCheckBox("Show Password");
		show.setBounds(100,240,150,30);
		applyCondition(show);
		show.setForeground(Color.white);
		show.addItemListener(i->{
			if(i.getStateChange()==1) {
				showpass.setVisible(true);
				
				
			}
			else {
				showpass.setVisible(false);
			}
		});
		
		showpass=new JLabel(""+pass.getText());
		showpass.setBounds(100,270, 150, 30);
		showpass.setForeground(Color.orange);
		showpass.setVisible(false);
		showpass.setFont(f1);
		applyCondition(showpass);
		
		
		Login=new JButton("Login");///////////////////////Login button
		Login.setBorder(rb2);
		Login.setForeground(Color.white);
		Login.setFont(f2);
		Login.setBackground(lback);
		Login.setBounds(80,350,170,50);
		
		Register=new JButton("Register");////////////////////Register button
		Register.setBounds(260,350,170,50);
		Register.setBorder(rb2);
		Register.setForeground(Color.white);
		Register.setFont(f2);
		Register.setBackground(new Color(235,145,0));
		
		
		
		
		
		
		//home.add(wel);
		right.add(Login);
		right.add(Register);
		right.add(username);
		right.add(password);
		right.add(user);
		right.add(pass);
		right.add(pass);
		right.add(showpass);
		right.add(show);	
	//	home.add(wall);//
		main.add(home,"home");
		
		add(main);
		
		addWindowListener(new WindowAdapter() {
			
			
			public void windowClosing(WindowEvent e) {
				
				
					StorageClass.upDate();
				
				
					
					
				
				
			}
			
			
		
		});
		
	
		//
		
		Login.addActionListener(this);
		Register.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		

		pass.addKeyListener(new KeyAdapter() {                                  //***********change
        @Override
        public void keyReleased (KeyEvent e) {
        	try {
        		
        		
        		if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
        			//mname_tf.setText("");
        			if(!(user.getText().equals("")||pass.getText().equals("")))//checking if username or password is not empty
        			{
        				if(isLogin())
        				{
        					user.setText("");
        					pass.setText("");
        				
        				
        					dash=new DashboardPanel(mf);
        					main.add(dash,"dash");
        					
        					
        					cards.show(main,"dash");
        				}
        				else
        				{//dialogbox for if entry field  is incorrect with data available
        					JOptionPane.showMessageDialog(null," Invalid Username Or Password","Invalid",JOptionPane.ERROR_MESSAGE);
        				}			
        			}
        			else {
        				//dialogbox for if entry field  is empty
        				JOptionPane.showMessageDialog(null," Username Or Password Is Empty","Empty",JOptionPane.ERROR_MESSAGE);
        			}
        			
                }
        		
        	}
        	catch(Exception e1) {
        		e1.printStackTrace();
        	}
        }
    });
	
		

	}
	
	








	@Override
	public void actionPerformed(ActionEvent e) {
		
		String na=e.getActionCommand();
		if(na.equals("Login"))
		{if(!(user.getText().equals("")||pass.getText().equals("")))//checking if username or password is not empty
		{
			if(isLogin())
			{
				user.setText("");
				showpass.setText("");
				show.setSelected(false);
				pass.setText("");
			
				File f1=new File("./security_folder/"+"transfer@"+user.getText()+".txt");
		        try {
					f1.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		        user.setText("");
				pass.setText("");
		        
				dash=new DashboardPanel(this);
				main.add(dash,"dash");
				cards.show(main,"dash");
			}
			else
			{//dialogbox for if entry field  is incorrect with data available
				JOptionPane.showMessageDialog(this.home," Invalid Username Or Password","Invalid",JOptionPane.ERROR_MESSAGE);
			}			
		}
		else {
			//dialogbox for if entry field  is empty
			JOptionPane.showMessageDialog(this.home," Username Or Password Is Empty","Empty",JOptionPane.ERROR_MESSAGE);
		}
		
		
		}
		else
		{
			sup=new SignUpPanel(this);//registering new user
			main.add(sup,"sign");
			cards.show(main,"sign");
		}
		
	
	}
	
	private boolean isLogin()
	{	
		boolean isAlive=false;
		try
		{
			File f=new File("./security_folder");
			String[] na=f.list();
			int i=0;
			
			while(i<na.length)
			{
				if((user.getText()).equals(na[i].substring(0,na[i].indexOf("@"))))
				{
					isAlive=true;
					break;
			   }
				i++;
			}
			
			if(isAlive==true)
			{
				sc=new StorageClass();
				int k;
				BufferedReader br=new BufferedReader(new FileReader("./security_folder/"+na[i]));
				i=0;
				String line=br.readLine();
				while(line!=null)
				{
					k=line.indexOf(": ");
					StorageClass.list[i]=line.substring(k+2,line.length());
					
					line=br.readLine();
					i++;
				}
				br.close();
				//user.setText(list[1]);
				if(StorageClass.list[1].equals(pass.getText()))
				return true;
				else
				return false;
			}
			else
			{
				user.setText("");
				pass.setText("");
				return false;
			}
		}
		catch(Exception e)
		{
			user.setText(e.getMessage());
		}
return false;		 
	}
	
	
	/** THIS METHOD CONTAINS REQUIRED ADDTIONS FOR EDITING PURPOSE**/
	 void applyCondition(JComponent jc) {
		
		 jc.setBackground(tc);
		 
		 jc.setOpaque(false);
	 }
}



public class BankManagementSystem
{
	public static void main(String args[])
	{
		MainFrame mf=new MainFrame("");
		mf.setVisible(true);
		//mf.setSize(new Dimension(1024,768));
		mf.setSize(1080,600);
		mf.setLocation(100,10);
	
		mf.setResizable(false);
	}

}
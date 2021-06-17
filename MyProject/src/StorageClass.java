import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class StorageClass {
public static String list[];

public static String list1[];

 	StorageClass(){
 		
 		list=new String[30];
 		
 		list1=new String[30];
 		
 		
 	}
 	
 	public static void upDate() {
 		try
		{
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
		
		}
		catch(Exception e1)
		{
			
		}
 	}
 	
 public static 	void upDate1() {
	 
	 
	 try
		{
		//code for storing new data 
		File f=new File("./security_folder/"+StorageClass.list[0]+"@"+StorageClass.list[20]+".txt");
		f.setWritable(true);
		BufferedWriter bf=new BufferedWriter(new FileWriter("./security_folder/"+StorageClass.list[0]+"@"+StorageClass.list[20]+".txt"));
		
		File f1=new File("./security_folder/"+"transfer@"+StorageClass.list[0]+".txt");
     f1.createNewFile();
		
		bf.write("USERNAME : "+StorageClass.list1[0]);
		bf.newLine();
		bf.write("PASSWORD : "+StorageClass.list[1]);//new String(pass1.getPassword())
		bf.newLine();
		bf.write("ACCOUNT TYPE : "+StorageClass.list1[2]);
		bf.newLine();
		bf.write("BRANCH NAME : "+StorageClass.list1[3]);
		bf.newLine();
		bf.write("IFSC CODE : "+StorageClass.list1[4]);
		bf.newLine();
		bf.write("AADHAR CARD NUMBER : "+StorageClass.list1[5]);
		bf.newLine();
		bf.write("PANCARD NUMBER : "+StorageClass.list1[6]);
		bf.newLine();
		bf.write("CITY NAME : "+StorageClass.list1[7]);
		bf.newLine();
		bf.write("STATE NAME : "+StorageClass.list1[8]);
		bf.newLine();
		bf.write("PIN CODE : "+StorageClass.list1[9]);
		bf.newLine();
		bf.write("FNAME : "+StorageClass.list1[10]);
		bf.newLine();
		bf.write("MNAME : "+StorageClass.list1[11]);
		bf.newLine();
		bf.write("LNAME : "+StorageClass.list1[12]);
		bf.newLine();
		bf.write("GENDER : "+StorageClass.list1[13]);
		bf.newLine();
		bf.write("DOB : "+StorageClass.list1[14]);
		bf.newLine();
		bf.write("RELIGION : "+StorageClass.list1[15]);
		bf.newLine();
		bf.write("CATAGORY : "+StorageClass.list1[16]);
		bf.newLine();
		bf.write("ADDRESS : "+StorageClass.list1[17]);
		bf.newLine();
		bf.write("PHONE NO. : "+StorageClass.list1[18]);
		bf.newLine();
		bf.write("EMAIL ADDRESS : "+StorageClass.list1[19]);
		bf.newLine();
		bf.write("ACCOUNT NUMBER : "+StorageClass.list1[20]);
		bf.newLine();
		bf.write("Balance : "+StorageClass.list1[21]);
		bf.newLine();
		bf.write("PIN NO : "+StorageClass.list1[22]);
		bf.close();
		f.setReadOnly();
		
		}
		catch(Exception e1)
		{
			
		}
 	}
 	
 	
}

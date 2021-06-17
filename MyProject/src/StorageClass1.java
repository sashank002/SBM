import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class StorageClass1 {

	static String []rec;
	String f;
	static int i=0;
	StorageClass1(BufferedReader br) {
		
		rec=new String[27];
		
		try {
			f=br.readLine();
			
			i=0;
			
			while(f!=null) {
				
				rec[i++]=f;
				f=br.readLine();
				
			}
			
				br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
			static void updat(BufferedWriter bw)throws IOException
			{
				for(int j=0;j<i;j++)
				{
				bw.write(rec[j]);
				bw.newLine();
				}
				bw.close();
			}
}

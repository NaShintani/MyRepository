import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ServerData {
	public ServerData(){
		
	}
	
	public void makeUser(String usrname,String pass){
		try{
			  File file = new File(usrname+".txt");
			  FileWriter filewriter = new FileWriter(file);

			  filewriter.write(usrname+" "+pass);
			}catch(IOException e){
			  System.out.println(e);
			}

	}
	
	public void queryUser(){
		
	}
	
	public void saveData(){
		
	}
	
	public void loadData(){
		
	}
	
	
	
}

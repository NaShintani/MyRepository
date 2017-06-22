
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Receiver extends Thread{
	private Socket socket;
	private ServerData sd;
	
	
	public Receiver(Socket socket, int playerNo){
		 this.socket = socket;
		    System.out.println("ê⁄ë±Ç≥ÇÍÇ‹ÇµÇΩ "
		                       + socket.getRemoteSocketAddress());
	}
	
	public void run() {
	    try {
	    	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	        String line;
	      while ( (line = in.readLine()) != null ) {
	        System.out.println(socket.getRemoteSocketAddress()
	                           + " éÛêM: " + line);
	        out.println(line);
	        System.out.println(socket.getRemoteSocketAddress()
	                           + " ëóêM: " + line);
	        
	        sd=new ServerData();
			switch (line){
			case "a": break;
			
			default:  ;
			}
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        if (socket != null) {
	          socket.close();
	        }
	      } catch (IOException e) {}
	      System.out.println("êÿífÇ≥ÇÍÇ‹ÇµÇΩ "
	                         + socket.getRemoteSocketAddress());
	    }
	  }	
	
	
		
}


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	private int port; // サーバの待ち受けポート
	//private static PrintWriter [] out; //データ送信用オブジェクト
	//private Receiver [] receiver; //データ受信用オブジェクト
	private int player_number=0;

	public Server(int port){
		this.port = port; //待ち受けポートを渡す
		//out = new PrintWriter [1000]; //データ送信用オブジェクトを2クライアント分用意
		//receiver = new Receiver [1000]; //データ受信用オブジェクトを2クライアント分用意
		
	}
	
	public void main(){
		ServerSocket serverSocket = null;
		try{
			serverSocket = new ServerSocket(port);
			
			while(true){
				Socket socket = serverSocket.accept();
				new Receiver(socket,player_number).start();
				player_number++;
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally {
		      try {
		          if (serverSocket != null) {
		            serverSocket.close();
		          }
		        } catch (IOException e) {}
		}
	}
	
}


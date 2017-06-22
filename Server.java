
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	private int port; // �T�[�o�̑҂��󂯃|�[�g
	//private static PrintWriter [] out; //�f�[�^���M�p�I�u�W�F�N�g
	//private Receiver [] receiver; //�f�[�^��M�p�I�u�W�F�N�g
	private int player_number=0;

	public Server(int port){
		this.port = port; //�҂��󂯃|�[�g��n��
		//out = new PrintWriter [1000]; //�f�[�^���M�p�I�u�W�F�N�g��2�N���C�A���g���p��
		//receiver = new Receiver [1000]; //�f�[�^��M�p�I�u�W�F�N�g��2�N���C�A���g���p��
		
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


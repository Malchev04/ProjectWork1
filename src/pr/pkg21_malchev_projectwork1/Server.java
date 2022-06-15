package pr.pkg21_malchev_projectwork1;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ilja Maksimovs
 */
public class Server {
    private ServerSocket serverSocket;
    private javax.swing.JTextArea serverOutputArea;
    
    public Server(ServerSocket serverSocket, javax.swing.JTextArea serverOutputArea){
        this.serverSocket = serverSocket;
        this.serverOutputArea = serverOutputArea;
    }
    
    public void startServer(){
        try{
            while(!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                serverOutputArea.setText(serverOutputArea.getText()+ "A new client has connected!" + "\n");
                
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void closeServerSocket(){
        try{            
            if(serverSocket != null){
                serverSocket.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

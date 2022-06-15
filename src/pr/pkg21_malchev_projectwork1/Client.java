package pr.pkg21_malchev_projectwork1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Ilja Maksimovs
 */
public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;
    
    javax.swing.JTextPane chatArea;
    javax.swing.JTextField userMessageField;
    
    public Client(Socket socket, String username, javax.swing.JTextPane chatArea, javax.swing.JTextField userMessageField){
        try{
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
            
            this.chatArea = chatArea;
            this.userMessageField = userMessageField;
            
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            
        }catch(Exception ex){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    
    public void sendMessage(){
        try{            
            if(socket.isConnected()){
                String messageToSend = userMessageField.getText();
                
                int position = chatArea.getDocument().getLength();
                chatArea.getDocument().insertString(position, "You: " + messageToSend + "\n", TextPresets.getBold());
                
                bufferedWriter.write(username + ": " + messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }catch(Exception ex){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    
    public void listenForMessage(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                String msgFromGroupChat;
                while(socket.isConnected()){
                    try{
                        msgFromGroupChat = bufferedReader.readLine();
                        
                        int position = chatArea.getDocument().getLength();
                        chatArea.getDocument().insertString(position, msgFromGroupChat + "\n", TextPresets.getBold());
                        
                    } catch(Exception ex){
                        closeEverything(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }
    
    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){                
        try{
            int position = chatArea.getDocument().getLength();
            chatArea.getDocument().insertString(position, "Connection to server has been lost!\n", TextPresets.getBoldRed());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //chatArea.setText(chatArea.getText() + "<b>Connection to server has been lost!</b>" + "\n");
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

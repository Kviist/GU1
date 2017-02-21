package datShat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ChatClient {
	
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	private ChatController controller;
	
	public ChatClient(){ 
		
	}
	
	public void setController(ChatController controller){
		this.controller = controller;
	}
	
	public void connect(){
		try{
			socket = new Socket("62.20.136.176", 1337);
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			
			
			dos.writeUTF("VEM ÄR DETTA PUTIN");
			dos.writeUTF("We are connected");
			dos.flush();
			
			new Listener().start();
			int i = 0;
			while(i<5){
				String awnser = JOptionPane.showInputDialog("hej");
				dos.writeUTF(awnser);
				dos.flush();
				i++;
			}
		}
		catch(IOException e){
			System.out.println("Kunde inte connecta");
		} 
	}
	
	public void disconnect(){
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println("Gick inte att stänga");
		}
	}
	
	private class Listener extends Thread{
		String respons;
		public void run(){
			
			while(true){
				try {
					respons = dis.readUTF();
                    System.out.println(respons);
                       
				} catch (IOException e) {
					System.out.println("Gick inte");
				}
				
			}
		}
	}

}

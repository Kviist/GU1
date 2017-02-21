package datShat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ShatServer {

	private ChatController controller;

	public ShatServer(int port, ChatController controller) {
		new ClientHandler(port).start();
		this.controller = controller;
	}

	private class ClientHandler extends Thread {
		int port;
		ArrayList<String> list = new ArrayList<String>();
		InetAddress address;
		String request;
		DataOutputStream dos;
		DataInputStream dis;

		public ClientHandler(int port) {
			this.port = port;
			try {
				address = InetAddress.getByName("192.168.1.234");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public void run() {
			try (ServerSocket serverSocket = new ServerSocket(port, 50, address)) {
				System.out.println(serverSocket.getLocalPort());

				Socket socket = serverSocket.accept();
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
				while (true) {
					System.out.println(socket.getInetAddress());

					list.add(dis.readUTF());
					dos.writeUTF(list.toString());
					dos.flush();
					System.out.println(list.toString());
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}

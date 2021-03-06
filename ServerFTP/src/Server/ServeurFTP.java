package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ServeurFTP {
	
	private ServerSocket serverSock;
	public int port;
	
	public ServeurFTP(int port) {
		try {
			this.serverSock = new ServerSocket();
			this.port = port;
			InetSocketAddress addr = new InetSocketAddress(this.port);
			this.serverSock.bind(addr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void listen() {
		System.out.println("Listening on port "+this.serverSock.getLocalPort());
		while(true) {
			Socket socket;
			try {
				socket = this.serverSock.accept();
				FTPSession session = new FTPSession(socket);
				//afin de r?cup?rer la requ?te du client
				session.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}



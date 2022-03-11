package Server;

import Server.ServeurFTP;

public class Main {

	public static void main(String[] args) {
		ServeurFTP server = new ServeurFTP(21);
		server.listen();

	}

}

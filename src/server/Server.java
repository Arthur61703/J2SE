package server;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws Exception{
		
			ServerSocket server = new ServerSocket(8888);
			Socket socket = server.accept();
			
			FileInputStream in = new FileInputStream("D:/1.html");
			OutputStream out = socket.getOutputStream();
			
			byte[] buffer = new byte[100];
			int lenth = 0;
			while((lenth=in.read(buffer))>0){
				out.write(buffer);
				out.flush();
			}
			
			out.close();
			in.close();
			socket.close();
			server.close();

	}
}

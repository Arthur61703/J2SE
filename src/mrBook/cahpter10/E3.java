package mrBook.cahpter10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class E3 {
	//发送端程序
	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(3000);//建立发送快递点，快递点编号为3000
			String str = "HEllO Arthur";
			/***从端口号3000发往端口号1521***/
			DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("127.0.0.2"), 1521);
			ds.send(dp);
			ds.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}

package mrBook.cahpter10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class E3 {
	//���Ͷ˳���
	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(3000);//�������Ϳ�ݵ㣬��ݵ���Ϊ3000
			String str = "HEllO Arthur";
			/***�Ӷ˿ں�3000�����˿ں�1521***/
			DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("127.0.0.2"), 1521);
			ds.send(dp);
			ds.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}

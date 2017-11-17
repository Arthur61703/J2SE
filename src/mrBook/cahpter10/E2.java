package mrBook.cahpter10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class E2 {
	//接收端程序
	public static void main(String[] args) {
		try {
			byte[] buf = new byte[1024];
			DatagramSocket ds = new DatagramSocket(1521);//创建一个端口号为8954的快递点
			DatagramPacket dp = new DatagramPacket(buf, 1024);//准备一个包裹
			System.out.println("ready to receive....");
			ds.receive(dp);/**快递点做好接受包裹的准备**/
			System.out.println("------------------------------分割线-------------------------------------");
			String str = new String(dp.getData(),0,dp.getLength())+"from"+dp.getAddress().getHostAddress()+":"+dp.getPort();
			System.out.println(str);
			ds.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}

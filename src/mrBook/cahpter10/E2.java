package mrBook.cahpter10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class E2 {
	//���ն˳���
	public static void main(String[] args) {
		try {
			byte[] buf = new byte[1024];
			DatagramSocket ds = new DatagramSocket(1521);//����һ���˿ں�Ϊ8954�Ŀ�ݵ�
			DatagramPacket dp = new DatagramPacket(buf, 1024);//׼��һ������
			System.out.println("ready to receive....");
			ds.receive(dp);/**��ݵ����ý��ܰ�����׼��**/
			System.out.println("------------------------------�ָ���-------------------------------------");
			String str = new String(dp.getData(),0,dp.getLength())+"from"+dp.getAddress().getHostAddress()+":"+dp.getPort();
			System.out.println(str);
			ds.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}

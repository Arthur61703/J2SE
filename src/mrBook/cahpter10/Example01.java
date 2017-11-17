package mrBook.cahpter10;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example01 {

	public static void main(String[] args) throws IOException {
		try {
			InetAddress localAddress = InetAddress.getLocalHost();
			InetAddress remoteAddress = InetAddress.getByName("www.baidu.com");
			
			String localIp = localAddress.getHostAddress();
			String remoteIp = remoteAddress.getHostAddress();
			System.out.println(localIp+"-----"+remoteIp);
			System.out.println(remoteAddress.isReachable(100));
			System.out.println(remoteAddress.getHostName());
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}

	}

}

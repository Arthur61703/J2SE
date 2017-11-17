package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import server.MP3Player;


public class WebMonitor {

	public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException, IOException, InterruptedException {
		
		BufferedReader buffer = createStream();	
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/src/log.txt",true);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos,"utf-8"));
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		String l = null;
		String m = null;
		int a=0,b=1;
		
		while((l=buffer.readLine())!=null){
			a=l.length();
			sb1.append(sb2);

		}
		buffer.close();

		for(int i=1; i<=10000; i++){	
			BufferedReader buffer2 = createStream();	
			while((m=buffer2.readLine())!=null){
				b=m.length();
				sb2.append(m);
			}
			String log = "刷新次数："+i+",原网页大小："+a+",网页变动字节大小："+(a-b);
			writer.write(log);
			writer.newLine();
			writer.flush();
			System.out.println(log);
//			if((a-b)>100 || (b-a)>100){//比对网页大小来判断是否有更新
			if(sb2.toString().contains("<span>刚刚</span>")){//通过比对网页中是否有更新字样（更准确）
			
				/**如果网页内容有变化，则打开音乐Kiss the rain**/
				MP3Player mp3 = new MP3Player(System.getProperty("user.dir")+"/src/kiss the rain.mp3");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = df.format(new Date());
				System.out.println(time);// new Date()为获取当前系统时间
				writer.write(time);
				writer.newLine();
				writer.write("---------------------------------------------------------");
				writer.newLine();
				writer.flush();
				mp3.play();			
				break;
			}
			a=b;/**消除系统更新偏差**/
			Thread.sleep(10000);			
			buffer2.close();
		}
		writer.close();
		fos.close();
	}
	public static BufferedReader createStream() throws MalformedURLException, IOException, UnsupportedEncodingException {		
		/**连接知乎个人主页**/
//		URL url = new URL("https://www.zhihu.com/people/kingzai-da-gong/activities");
//		URL url = new URL("https://www.zhihu.com/people/shouter/activities");//眉间尺
		URL url = new URL("https://www.zhihu.com/people/radioactive-84/activities");
		
		HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
		urlcon.setRequestProperty("contentType", "utf-8");
		urlcon.setConnectTimeout(60000);
		urlcon.setReadTimeout(60000);
		urlcon.connect();
		/**获取输出流（字节转字符流）**/
		InputStream is = urlcon.getInputStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is,"utf-8"));//指定读入的编码
		return buffer;
	}
		
		

}

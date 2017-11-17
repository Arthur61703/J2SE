package exercise;

import java.io.IOException;


import server.MP3Player;

public class E32 {

	public static void main(String[] args) throws IOException {
//		List<String> list = new ArrayList<String>();
//		list.add("*\r"
//			   + "**\r"
//			   + "***");
//		
//		for(String l:list){
//			System.out.println(l);
//		}
//		InputStream fis = new FileInputStream("C:/kiss the rain.mp3");
//		AudioInputStream as = new AudioInputStream((TargetDataLine) fis);
//		
//		Runtime.getRuntime().exec("C:/kiss the rain.mp3");
		System.out.println(System.getProperty("user.dir"));
		MP3Player mp3 = new MP3Player(System.getProperty("user.dir")+"/src/kiss the rain.mp3");
		mp3.play();	

	}

}

package exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class E50 {

	public static void main(String[] args) throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"/src/exercise/6617.pfm");
//		File file = new File("C:\\Users\\King\\Desktop\\test.pfm");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		StringBuffer sb = new StringBuffer();
		int count = 0;
		File outFile = new File("C:\\Users\\King\\Desktop\\test.pfm");
		FileOutputStream fos = new FileOutputStream(outFile);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));//字节流转字符流(字符流要注意编码)
//		System.out.println(System.getProperty("file.encoding"));
		
		addSpace(br, sb, count, bw);
//		deleteSpace(br, sb, count, bw);

	}

	private static void deleteSpace(BufferedReader br, StringBuffer sb, int count, BufferedWriter bw) throws IOException {
		String buffer;
		while((buffer = br.readLine())!=null){
			if(count>=11 && count<=30 && buffer.length()>=21){
				
				buffer = buffer.substring(0, 15)+buffer.substring(21, buffer.length());//删除字符串中指定位置的子串
			}
			count++;
			System.out.println(buffer);
			bw.write(buffer);
			bw.newLine();
			bw.flush();
		}
		
		bw.close();
		br.close();
	}


	public static void addSpace(BufferedReader br, StringBuffer sb, int count, BufferedWriter bw) throws IOException {
		String buffer;
		while((buffer = br.readLine())!=null){
			sb.append(buffer);
			if(count>=11 && count<=30 && buffer.length()>=15){
				sb.insert(15, "      ");//向指定行中插入6个空格
			}
			count++;
			buffer = sb.toString();
			System.out.println(buffer);
			bw.write(buffer);
			bw.newLine();
			bw.flush();
			sb.delete(0, buffer.length());//每次注意要清空sb
		}
		
		bw.close();
		br.close();
	}

}

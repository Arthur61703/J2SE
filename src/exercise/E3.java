package exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class E3 {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("D:\\Program Files");
		File outFile = new File("C:\\Users\\King\\Desktop\\dir.txt");
		FileOutputStream fos = new FileOutputStream(outFile,false);//字节流
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"utf-8"));//字节流转字符流(字符流要注意编码)
		showdir(file,bw);
		fos.close();

	}

	private static void showdir(File file, BufferedWriter bw) throws IOException {
		
		File[] dir = file.listFiles();//列出子目录下的内容（进入下一级目录）
		for(File f:dir){
			if(f.isDirectory()){
				showdir(f,bw);//递归调用
			}else{
				if(f.toString().endsWith(".java")){
					bw.write(f.toString());
					bw.newLine();
					bw.flush();
					System.out.println(f);
				}
			}
		}
	}

}

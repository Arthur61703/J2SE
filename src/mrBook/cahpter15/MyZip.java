package mrBook.cahpter15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyZip {
	
	private void zip(String zipFilename, File inputFile){
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(zipFilename);
			ZipOutputStream out = new ZipOutputStream(fos);//包装流
			
			zip(out,inputFile,"");
			
			System.out.println("压缩中。。。");
			out.close();
			fos.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	private void zip(ZipOutputStream out, File file, String base) {
		
		if(file.isDirectory()){
			File[] fl = file.listFiles();//???
			if(base.length()!=0){
				try {
					out.putNextEntry(new ZipEntry(base+"/"));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			
			for(int i = 0; i<fl.length; i++){
				zip(out,fl[i],base+fl[i]);
			}
		}else{
			try {
				out.putNextEntry(new ZipEntry(base));
				FileInputStream in = new FileInputStream(file);
				int b;
				System.out.println(base);
				while((b = in.read())!=-1){
					out.write(b);
				}
				in.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		
		MyZip book = new MyZip();//实例化本类对象
		
		File file  = new File("E:/hello.txt");
		
		book.zip("E:/hello.zip", file);//调用本类下的方法
	}

}

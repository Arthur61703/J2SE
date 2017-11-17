package mrBook.cahpter5;

import java.util.Scanner;

public class E1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一组字符串：");
		String str  = scanner.nextLine();
		char[] cha = str.toCharArray();
		char[] CHA = new char[cha.length];
		for(int i = 0; i<cha.length; i++){
			if(cha[i]<65 || cha[i]>122){
				System.out.println("输入的不是字母");
			}else{
				if(cha[i]>=65 && cha[i]<=90){//大写转小写
					CHA[i] = (char)(cha[i]+32);//涉及类型转换的细节
				}
				if(cha[i]>=97 &&cha[i]<=122){
					CHA[i] = (char)(cha[i]-32);
				}
			}
		}
		for(char c:CHA){
			System.out.print(c);
		}
	}

}

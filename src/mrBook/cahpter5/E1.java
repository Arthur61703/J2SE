package mrBook.cahpter5;

import java.util.Scanner;

public class E1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String str  = scanner.nextLine();
		char[] cha = str.toCharArray();
		char[] CHA = new char[cha.length];
		for(int i = 0; i<cha.length; i++){
			if(cha[i]<65 || cha[i]>122){
				System.out.println("����Ĳ�����ĸ");
			}else{
				if(cha[i]>=65 && cha[i]<=90){//��дתСд
					CHA[i] = (char)(cha[i]+32);//�漰����ת����ϸ��
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

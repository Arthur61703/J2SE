package mrBook.cahpter4;

import java.util.Scanner;

public class E1 {
	public static void main(String[] args){
		int x = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("please input one number:");
		if(scanner.hasNextInt()){
			x = scanner.nextInt();
			input(x);
		}else{
			System.out.println("����Ĳ�������");
		}
	}

	private static void input(int x) {
		try {
			if(x>0){
				if(x%2==0){
					System.out.println(x+"Ϊż��");
				}else{
					System.out.println(x+"Ϊ����");
				}
			}else{
				System.out.println("�����������Ϊ����");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		System.out.println("runtime over");
	}
}

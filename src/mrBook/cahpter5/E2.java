package mrBook.cahpter5;

import java.util.Scanner;

public class E2 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String rex = "^[1][5][0-9][0-9]{8}$";
		if(str1.matches(rex)){
			System.out.println("号码合法");
		}else{
			System.out.println("号码非法");
		}
	}
}

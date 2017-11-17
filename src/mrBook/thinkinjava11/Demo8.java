package mrBook.thinkinjava11;

public class Demo8 {

	public static void main(String[] args) {
		System.out.println(add(2,3));

	}
	
	public static int add(int n, int m){
		//n为数字，m为循环次数
		int number = n;
		int total = n;
		for(int i = 2; i<=m; i++){
			number = number*10 + n;//乘10加本身
			total +=number;
		}
		return total;
	}
}

package mrBook.thinkinjava11;

public class Demo8 {

	public static void main(String[] args) {
		System.out.println(add(2,3));

	}
	
	public static int add(int n, int m){
		//nΪ���֣�mΪѭ������
		int number = n;
		int total = n;
		for(int i = 2; i<=m; i++){
			number = number*10 + n;//��10�ӱ���
			total +=number;
		}
		return total;
	}
}

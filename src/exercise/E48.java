package exercise;

public class E48 {
	/**ĳ����˾���ù��õ绰�������ݣ���������λ���������ڴ��ݹ������Ǽ��ܵģ����ܹ������£�ÿλ���� ������5,Ȼ���úͳ���10���������������***/
	public static void main(String[] args) {
		int original = 1111;
		int first = ((original/1000)+5)%10;
		int seconde = ((original/100)%10+5)%10;
		int third = ((original/10)%10+5)%10;
		int fourth = (original%10+5)%10;
//		System.out.println(first);
//		System.out.println(seconde);
//		System.out.println(third);
//		System.out.println(fourth);
		int new_number = first*1000+seconde*100+third*10+fourth;
		System.out.println("original="+original);
		System.out.println("after encryption:"+new_number);

	}

}

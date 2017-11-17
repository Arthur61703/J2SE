package exercise;

public class E48 {
	/**某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：每位数字 都加上5,然后用和除以10的余数代替该数字***/
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

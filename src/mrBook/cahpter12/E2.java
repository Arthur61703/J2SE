package mrBook.cahpter12;

public class E2 {

	public static void main(String[] args) {
		Number num = new Number();
		int max = 0;
		try {
			max = num.count(200, 300);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(max);
	}

}

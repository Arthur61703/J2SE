package mrBook.thinkinjava11;

public class DemoComparator {

	public static void main(String[] args) {
		AppleComparator app = new AppleComparator();
		
		Apple a1 = new Apple("small");
		Apple a2 = new Apple("small");
		
		System.out.println(app.compare(a1,a2));
		
	}

}

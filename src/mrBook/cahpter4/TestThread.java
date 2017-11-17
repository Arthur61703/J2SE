package mrBook.cahpter4;

public class TestThread {
	public static void main(String[] args) throws InterruptedException{
		E5 e = new E5();
		Thread t = new Thread(e);
		
		long start = System.currentTimeMillis();
		
		t.start();
		
		
		
		
		System.out.println("start="+start);
	}

}

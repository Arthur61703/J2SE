package mrBook.cahpter5;

public class E11 {

	public static void main(String[] args) {
		SaleThread st = new SaleThread();
		
		new Thread(st,"�߳�һ").start();
		new Thread(st,"�̶߳�").start();
		new Thread(st,"�߳���").start();
		new Thread(st,"�߳���").start();
		new Thread(st,"�߳���").start();
		new Thread(st,"�߳���").start();
		
	}

}

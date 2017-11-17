package mrBook.cahpter5;

public class E11 {

	public static void main(String[] args) {
		SaleThread st = new SaleThread();
		
		new Thread(st,"线程一").start();
		new Thread(st,"线程二").start();
		new Thread(st,"线程三").start();
		new Thread(st,"线程四").start();
		new Thread(st,"线程五").start();
		new Thread(st,"线程六").start();
		
	}

}

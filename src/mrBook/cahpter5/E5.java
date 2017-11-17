package mrBook.cahpter5;

public class E5 implements Runnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MinPriority());
		Thread t2 = new Thread(new MaxPriority());
		Thread t3 = new Thread(new E5());
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void run() {
		for(int i = 0; i<10; i++){
			System.out.println(Thread.currentThread().getName()+"正在运行"+i);
		}
	}
	
	

}

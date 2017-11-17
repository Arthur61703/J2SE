package multithreading;

public class MultiThread {

	public static void main(String[] args) {
		
		Resource resource = new Resource(90,true);
		Producer pro = new Producer(resource);
		Consumer con = new Consumer(resource);
		Thread t1 = new Thread(con);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(pro);
		Thread t4 = new Thread(pro);
		Thread t5 = new Thread(pro);
		
//		t1.setPriority(10);
//		t2.setPriority(0);
//		t3.setPriority(0);
//		t4.setPriority(0);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
//		t5.start();
	}

}

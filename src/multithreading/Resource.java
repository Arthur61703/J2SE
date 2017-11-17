package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
	
	private int product;
	private boolean flag;
	private final Lock lock = new ReentrantLock();
	private final Condition consumer = lock.newCondition();
	private final Condition producer = lock.newCondition();

	public Resource(int product,boolean flag) {
		super();
		this.product = product;
		this.flag = flag;
	}
	
	public void consumer() throws InterruptedException{
		try {
			lock.lock();
			while(true){
				
				if(!flag){
					try {
//						this.wait();
						consumer.await();
						Thread.sleep(500);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				if(this.product<=0){
					System.out.println("ȱ��");
					continue;
				}
				System.out.println("�����������˵�"+this.product+"����Ʒ");
				this.product--;
				flag=false;
				Thread.sleep(500);
//				this.notifyAll();
				producer.signalAll();
			}
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}
	
	public void producer() throws InterruptedException{
		try {
			lock.lock();
			while(true){
				
				if(flag){
					
					try {
//						this.wait();
						producer.await();
						Thread.sleep(200);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				if(this.product>=100){
					System.out.println("������");
					Thread.yield();
					continue;
				}
				this.product++;
				System.out.println("�����������˵�"+this.product+"����Ʒ");
//				this.notifyAll();
				consumer.signalAll();
				flag=true;
				Thread.sleep(200);
			}
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}

}

package mrBook.cahpter5;

import java.util.concurrent.locks.Lock;

public class SaleThread implements Runnable {
	
	private int ticket = 10;

	@Override
	public void run() {
		while(true){
			
			synchronized (this) {
				/**将共享资源放进代码块中**/
				if(ticket>0){
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName()+"卖出的票号："+ticket);
					ticket--;
				}else{
					break;
				}
				
				
				
				
				
			}
		}
		
	}

}

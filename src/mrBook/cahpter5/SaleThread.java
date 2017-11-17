package mrBook.cahpter5;

import java.util.concurrent.locks.Lock;

public class SaleThread implements Runnable {
	
	private int ticket = 10;

	@Override
	public void run() {
		while(true){
			
			synchronized (this) {
				/**��������Դ�Ž��������**/
				if(ticket>0){
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName()+"������Ʊ�ţ�"+ticket);
					ticket--;
				}else{
					break;
				}
				
				
				
				
				
			}
		}
		
	}

}

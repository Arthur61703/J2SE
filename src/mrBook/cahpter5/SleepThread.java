package mrBook.cahpter5;

public class SleepThread implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			if(i==3){
				try {
					
					Thread.sleep(500);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
			System.out.println("分线程正在输出："+i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}

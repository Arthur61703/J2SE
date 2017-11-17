package mrBook.cahpter5;

public class E8 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new SleepThread());//创建线程并开启线程
		t1.start();
		for(int i = 0; i<10; i++){
//			if(i==5){
//				try {
//					
//					Thread.sleep(5000);
//					
//				} catch (InterruptedException e) {
//					
//					e.printStackTrace();
//				}
//			}
			
			System.out.println("主线程正在输出："+i);
			System.out.println("主线程让步");
			try {
				t1.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}

		}
	}

}

package mrBook.cahpter5;

public class E8 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new SleepThread());//�����̲߳������߳�
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
			
			System.out.println("���߳����������"+i);
			System.out.println("���߳��ò�");
			try {
				t1.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}

		}
	}

}

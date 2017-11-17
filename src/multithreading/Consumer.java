package multithreading;

public class Consumer implements Runnable{
	private Resource resource;

	public Consumer(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run(){
			try {
				resource.consumer();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	}

}

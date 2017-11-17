package multithreading;

public class Producer implements Runnable{
	
	private Resource resource;
	

	public Producer(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run(){
			try {
				resource.producer();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	}


}

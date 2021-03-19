package march19;

public class SynchronousThread extends Thread{
	public SynchronousThread(String name) {
		super(name);
	}
	public static synchronized void print(String name) {
		for (int i = 1; i < 6; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread " + name + " at " + i);
		}
	}
	public void run() {
		print(getName());
	}	
}

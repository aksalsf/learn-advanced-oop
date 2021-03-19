package march19;

public class AsynchronousThread extends SynchronousThread{
	
	public AsynchronousThread(String name) {
		super(name);
	}
	
	public void run() {
		for(int i=0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread " + getName() + " at " + i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronousThread I1 = new SynchronousThread("I1");
		SynchronousThread I3 = new SynchronousThread("I3");
		AsynchronousThread I2 = new AsynchronousThread("I2");
		AsynchronousThread I4 = new AsynchronousThread("I4");
		
		I1.start();
		try {
			// Biar I1 jalan duluan dari I2
			I1.join(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		I3.start();
		I2.start();
		try {
			// I2 jalan 3 detik lebih awal dari I4
			I2.join(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		I4.start();
		
	}

}


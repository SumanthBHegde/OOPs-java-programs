package prg7;

class ThreadA extends Thread{
	static Object lock = new Object();
	
	ThreadA(Object lock){
		this.lock = lock;
	}
	
	public void run() {
		synchronized(lock){
			System.out.println("Thread 1 Started");
			for (int i = 1; i<=5; i++) {
				System.out.println("Thread 1 : "+i);
				try {
					Thread.sleep(2000);
					lock.wait();
//					lock.notify();
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Thread 1 Exiting");
		}
	}
}

class ThreadB extends Thread{
	Object lock;
	ThreadB(Object lock){
		this.lock = lock;
	}
	public void run() {
		
		synchronized(lock){
			System.out.println("Thread 2 Started");
			for (int i = 10; i<=15; i++) {
				System.out.println("Thread 2 : "+i);
				try {
					if (i == 12) {
						System.out.println("Thread 2 is yielding ....");
						Thread.yield();
//						ThreadA.lock.notify();
						lock.notify();
//						lock.wait();
					}
//					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Thread 2 Exiting");
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		Object lock = new Object();
		ThreadA t1 = new ThreadA(lock);
		ThreadB t2 = new ThreadB(lock);
		t1.start();
		t2.start();
	}

}

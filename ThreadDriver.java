package prg7;

class Thread1 extends Thread{
	public void run() {
		System.out.println("Thread 1 Started");
		for (int i = 1; i<=5; i++) {
			System.out.println("Thread 1 : "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread 1 Exiting");
	}
}

class Thread2 extends Thread{
	public void run() {
		System.out.println("Thread 2 Started");
		for (int i = 10; i<=15; i++) {
			System.out.println("Thread 2 : "+i);
			try {
				if (i == 12) {
					System.out.println("Thread 2 is yielding ....");
					Thread.yield();
				}
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread 2 Exiting");
	}
}

class Thread3 extends Thread{
	Thread thread_to_wait;
	Thread3(Thread t){
		this.thread_to_wait = t;
	}
	
	public void run() {
		System.out.println("Thread 3 is waiting for Thread 1 to finish...");
		try {
			thread_to_wait.join();
			System.out.println("Thread 1 done, Thread 3 is Starting");
			for (int i = 100; i<=102; i++) {
				System.out.println("Thread 3 : "+i);
				Thread.sleep(2000);
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread 3 is Exiting ...");
	}
}

public class ThreadDriver {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3(t1);
		System.out.println("Thread 1 priority : "+ t1.getPriority());
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Thread 1 priority : "+ t1.getPriority());
//		System.out.println("Thread 2 priority : "+ t2.getPriority());
//		System.out.println("Thread 3 priority : "+ t3.getPriority());
		t1.start();
		t1.stop();
		t2.start();
		t3.start();
	}

}




//try {
//	System.out.println("Thread 1 Sleeping for 2 seconds");
//	Thread.sleep(2000);
//} catch (InterruptedException e) {
//	e.printStackTrace();
//}


//try {
//	if (i == 1) {
//	
//		System.out.println("Thread 1 is yielding ....");
//		Thread.yield();
//	}
////	Thread.sleep(2000);
//} catch (Exception e) {
//	e.printStackTrace();
//}




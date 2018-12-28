package concurrent.thread.interact.join;

import org.junit.jupiter.api.Test;

public class TestJoin {

	/**
	 * 调用者等待被调用者执行完毕
	 */
	@Test
	public void test(){
		ThreadA a = new ThreadA();
		a.start();
		try {
			a.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("a join over...");
	}
}
class ThreadA extends Thread{
	
	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("threadA sleep over...");
	}

}
class ThreadB extends Thread{
	
}
/**
*   (用一句话描述该文件做什么)
* @Filename TestThreadClose.java
* @Package concurrent.thread
* @author neo
* @since 2018年3月13日 上午9:46:52
* @Version V1.0
*/
package concurrent.thread.interact.interrupt;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestThreadClose
 * @author neo
 * @since 2018年3月13日 上午9:46:52
 */
public class TestThreadClose {
	
	@Test
	public void testInterrupt()throws Exception{
		Thread a = new Thread(new CycleTask());
		a.start();
		Thread.sleep(10000);
		a.interrupt();
		Thread.sleep(10000);
		System.out.println("over---------------------");
	}
}

class CycleTask implements Runnable{

	boolean isRunning = true;
	
	@Override
	public void run() {
		while(isRunning){
			System.out.println(Thread.currentThread().getName());
			System.out.println("cycle run...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				//isRunning = false;
			}
		}
		System.out.println("CycleTask is over");
	}
	
}
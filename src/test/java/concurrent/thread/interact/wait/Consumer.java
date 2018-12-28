/**
*   (用一句话描述该文件做什么)
* @Filename Consumer.java
* @Package concurrent.case1
* @author neo
* @since 2018年3月9日 上午11:44:18
* @Version V1.0
*/
package concurrent.thread.interact.wait;

/**
 *   (这里用一句话描述这个类的作用)
 *    Consumer
 * @author neo
 * @since 2018年3月9日 上午11:44:18
 */
public class Consumer implements Runnable{

	private Object cache;
	
	
	public Consumer(Object cache) {
		super();
		this.cache = cache;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (cache) {
				if(allow(cache)){
					System.out.println("cache notify...");
					cache.notify();
				} else {
					dosomething(cache);	
				}
				
			}
		}
	}

	private boolean allow(Object cache2) {
		return true;
	}

	private void dosomething(Object cache2) {
		
	}
}

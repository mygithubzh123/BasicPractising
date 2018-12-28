/**
*   (用一句话描述该文件做什么)
* @Filename Producer.java
* @Package concurrent.case1
* @author neo
* @since 2018年3月9日 上午11:41:55
* @Version V1.0
*/
package concurrent.thread.interact.wait;

/**
 *   (这里用一句话描述这个类的作用)
 *    Producer
 * @author neo
 * @since 2018年3月9日 上午11:41:55
 */
public class Producer implements Runnable{

	private Object cache;
	
	
	public Producer(Object cache) {
		super();
		this.cache = cache;
	}

	@Override
	public void run() {
		while(true){
			synchronized (cache) {
				if(allow(cache)){
					dosomething(cache);	
				} else {
					try {
						System.out.println("cache wait...");
						cache.wait();
						System.out.println("wait over");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}

	private boolean allow(Object cache2) {
		return false;
	}

	private void dosomething(Object cache2) {
		
	}
}

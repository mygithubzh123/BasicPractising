/**
*   (用一句话描述该文件做什么)
* @Filename LockHandler.java
* @Package concurrent.vo
* @author neo
* @since 2018年3月9日 上午11:24:34
* @Version V1.0
*/
package concurrent.vo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *   (这里用一句话描述这个类的作用)
 *    LockHandler
 * @author neo
 * @since 2018年3月9日 上午11:24:34
 */
public class LockHandler implements Handler{
	
	private static int count = 0;
	
	private Lock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	@Override
	public void handle() throws Exception {
		lockHandle();
	}

	public void lockHandle()throws Exception{
		lock.lock();
		condition.await();
		count++;
		System.out.println(Thread.currentThread().getId()+"执行了handle方法，结果是:"+count);
		Thread.sleep(1000);
		lock.unlock();
	}
	
	public void notifyMe()throws Exception{
		lock.lock();
		condition.signal();
		lock.unlock();
	}

}

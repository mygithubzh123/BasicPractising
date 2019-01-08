package concurrent.lock;

import concurrent.synchronize.counter.AbstractCounter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *   互斥器操作  LockHandler
 * @author neo
 * @since 2018年3月9日 上午11:24:34
 */
public class LockHandlerWithCondition extends AbstractCounter {
	
	private static int count = 0;
	
	private Lock lock = new ReentrantLock(true);
	
	private Condition condition = lock.newCondition();
	
	@Override
	public void count() {
		lockHandle();
	}

	public void lockHandle(){
		lock.lock();
		System.out.println(Thread.currentThread().getId()+"执行了handle方法，结果是:"+ ++count);
		lock.unlock();
	}
	
	public void notifyMe()throws Exception{
		lock.lock();
		condition.signal();
		lock.unlock();
	}

}

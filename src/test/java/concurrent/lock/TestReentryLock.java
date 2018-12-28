/**
*   (用一句话描述该文件做什么)
* @Filename TestReentryLock.java
* @Package concurrent
* @author neo
* @since 2018年3月9日 上午10:37:30
* @Version V1.0
*/
package concurrent.lock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestReentryLock
 * @author neo
 * @since 2018年3月9日 上午10:37:30
 */
public class TestReentryLock {
	
	ExecutorService executor = Executors.newCachedThreadPool();
	
	CountDownLatch latch = new CountDownLatch(1); 
	
	/**
	 * 一个线程可以递归调用同步方法，多次持有同一把锁 从lock的state可以看出持有次数
	 * 只有当一个线程对该lock的持有次数降低到0,其他线程才有机会获取该lock
	 * 
	 * 默认是非公平锁,公平锁会在一个线程释放lock后,寻找等待该锁时间最长的线程
	 * 
	 * 获取了锁但是仍旧不能执行任务的情况 用条件对象实现
	 * 
	 */
	@Test
	public void test()throws Exception{
		Boxer willams = new Boxer("willams",true);
		FightTask et = new FightTask(willams,"世界拳王争霸赛");
		FightTask et2 = new FightTask(willams,"WWD格斗赛");
		executor.execute(et);
		executor.execute(et2);
		latch.await();
	}

}

class FightTask implements Runnable{
	
	private String matchName;

	Boxer x;
	
	/**
	*   ReentranceTask构造方法
	* @param x
	*/
	public FightTask(Boxer x,String matchName) {
		super();
		this.x = x;
		this.matchName = matchName;
	}

	@Override
	public void run() {
		try {
			x.fight(matchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
class Boxer {
	
	private String name;
	
	/**
	*   Boxer构造方法
	* @param isUnruly
	*/
	public Boxer(String name,boolean isUnruly) {
		super();
		this.isUnruly = isUnruly;
		this.name = name;
	}

	Lock lock = new ReentrantLock();
	
	Condition condition = lock.newCondition();
	
	boolean  isUnruly;
	
	public void fight(String matchName)throws Exception{
		lock.lock();
		register(matchName);
		
		if(isUnruly){
			Thread.sleep(2000);
			System.out.println("拳手【"+name +"】在【"+matchName+"】比赛中打了2小时,中途退出");
			isUnruly = false;
			condition.await();
			Thread.sleep(1000);
			System.out.println("拳手【"+name +"】在【"+matchName+"】比赛中打了1小时比赛");
		} else {
			Thread.sleep(3000);
			System.out.println("拳手【"+name +"】在【"+matchName+"】比赛中打满3小时比赛");
			System.out.println("拳手【"+name +"】决定继续去【"+matchName+"】比赛中打完之前未完成的比赛");
			condition.signal();
		}
		lock.unlock();
	}
	
	public void register(String matchName)throws Exception{
		lock.lock();
		System.out.println("拳手【"+name+"】登记比赛【"+ matchName +"】耗时1小时");
		Thread.sleep(1000);
		lock.unlock();
	}
	
}
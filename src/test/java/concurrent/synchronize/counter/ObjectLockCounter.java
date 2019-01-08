package concurrent.synchronize.counter;

/**
 *   ObjectLock counter
 * @author neo
 * @since 2018年3月9日 上午11:21:24
 */
public class ObjectLockCounter extends AbstractCounter {

	private static int count = 0;
	
	/**
	 * 以一个公共的对象作为锁
	 */
	private final Object lock = new Object();

	@Override
	public void count() {
		lockHandle();
	}

	private void lockHandle() {
		synchronized (lock) {
			System.out.println(Thread.currentThread().getId()+"执行了handle方法，结果是:"+ ++count);
		}
	}
}

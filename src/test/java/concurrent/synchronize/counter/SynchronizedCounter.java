package concurrent.synchronize.counter;

/**
 *   同步计数器
 *    Handler
 * @author neo
 * @since 2018年3月9日 上午11:10:26
 */
public class SynchronizedCounter extends AbstractCounter{
	
	private static int count = 0;

	@Override
	public void count() {
		synHandle();
	}

	private synchronized void synHandle(){
		System.out.println(Thread.currentThread().getId()+"执行了handle方法，结果是:"+ ++count);
	}
}

package concurrent.synchronize.counter;

/**
 * 简单计数器
 *
 * @author liaofeng
 * 2019/1/8 5:22 PM
 */
public class SimpleCounter extends AbstractCounter {

	private static int count = 0;

	@Override
	public void count() {
		System.out.println(Thread.currentThread().getId()+"执行了count方法，结果是:"+ ++count);
	}
}

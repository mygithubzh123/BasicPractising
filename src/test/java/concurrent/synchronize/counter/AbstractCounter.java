package concurrent.synchronize.counter;

/**
 * 公共的计数器
 *
 * @author neo
 * 2019/1/8 5:28 PM
 */
public abstract class AbstractCounter implements Counter {

	protected static int count = 0;

	public abstract  void count();



}

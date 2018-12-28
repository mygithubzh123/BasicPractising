/**
*   (用一句话描述该文件做什么)
* @Filename LockHandler.java
* @Package concurrent.vo
* @author neo
* @since 2018年3月9日 上午11:21:24
* @Version V1.0
*/
package concurrent.vo;

/**
 *   (这里用一句话描述这个类的作用)
 *    LockHandler
 * @author neo
 * @since 2018年3月9日 上午11:21:24
 */
public class ObjLockHandler implements Handler {

	private static int count = 0;
	
	/**
	 * 以一个公共的对象作为锁
	 */
	private static Object lock = new Object();
	
	
	@Override
	public void handle() throws Exception {
		lockHandle();
	}

	public void lockHandle()throws Exception{
		synchronized (lock) {
			count++;
			System.out.println(Thread.currentThread().getId()+"执行了handle方法，结果是:"+count);
			Thread.sleep(100);
			System.out.println("霸占执行...");
			lockHandle();
		}
	}
}

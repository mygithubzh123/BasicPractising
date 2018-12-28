/**
*   (用一句话描述该文件做什么)
* @Filename Handler.java
* @Package concurrent.vo
* @author neo
* @since 2018年3月9日 上午11:10:26
* @Version V1.0
*/
package concurrent.vo;

/**
 *   (这里用一句话描述这个类的作用)
 *    Handler
 * @author neo
 * @since 2018年3月9日 上午11:10:26
 */
public class SynchronizedHandler implements Handler{
	
	private static int count = 0;
	
	@Override
	public void handle() throws Exception {
		synHandle();
	}

	public synchronized void synHandle()throws Exception{
		count++;
		System.out.println(Thread.currentThread().getId()+"执行了handle方法，结果是:"+count);
		Thread.sleep(1000);
	}
}

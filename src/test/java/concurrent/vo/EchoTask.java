/**
*   (用一句话描述该文件做什么)
* @Filename EchoTask.java
* @Package concurrent
* @author neo
* @since 2018年3月9日 上午10:40:42
* @Version V1.0
*/
package concurrent.vo;

/**
 *   (这里用一句话描述这个类的作用)
 *    EchoTask
 * @author neo
 * @since 2018年3月9日 上午10:40:42
 */
public class EchoTask implements Runnable{

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ping ......");
		}
	}
	
}

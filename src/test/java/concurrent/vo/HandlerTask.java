/**
*   (用一句话描述该文件做什么)
* @Filename HandleTask.java
* @Package concurrent.vo
* @author neo
* @since 2018年3月9日 上午11:09:39
* @Version V1.0
*/
package concurrent.vo;


/**
 *   (这里用一句话描述这个类的作用)
 *    HandleTask
 * @author neo
 * @since 2018年3月9日 上午11:09:39
 */
public class HandlerTask implements Runnable{
	
	private Handler handler;
	
	public HandlerTask(Handler handler) {
		super();
		this.handler = handler;
	}

	@Override
	public void run() {
		try {
			while(true){
				handler.handle();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

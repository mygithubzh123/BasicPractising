/**
*   (用一句话描述该文件做什么)
* @Filename TestThreadState.java
* @Package concurrent.thread
* @author neo
* @since 2018年3月13日 上午9:40:42
* @Version V1.0
*/
package concurrent.thread.attribute;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestThreadState
 * @author neo
 * @since 2018年3月13日 上午9:40:42
 */
public class TestThreadState {
	
	@Test
	public void test()throws Exception{
		System.out.println(Thread.currentThread().getState());
	}

}

/**
*   (用一句话描述该文件做什么)
* @Filename TestBasicLog.java
* @Package log
* @author neo
* @since 2018年3月8日 上午10:10:17
* @Version V1.0
*/
package log;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestBasicLog
 * @author neo
 * @since 2018年3月8日 上午10:10:17
 */
public class TestBasicLog {

	@Test
	public void testLogger()throws Exception{
		Logger.getGlobal().info("abdc");
		Logger.getGlobal().info("abdc");
		Logger.getGlobal().info("abdc");
		Logger.getGlobal().info("abdc");
		Logger.getGlobal().info("abdc");
		Logger.getLogger(this.getClass().getName()).info("adc");
		Logger.getGlobal().warning("warning");
	}
}

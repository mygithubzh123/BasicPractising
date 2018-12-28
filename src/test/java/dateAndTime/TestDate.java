/**
*   (用一句话描述该文件做什么)
* @Filename TestDate.java
* @Package dateAndTime
* @author neo
* @since 2018年2月26日 下午2:43:15
* @Version V1.0
*/
package dateAndTime;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestDate
 * @author neo
 * @since 2018年2月26日 下午2:43:15
 */
public class TestDate {

	/**
	 * date表示时间点
	 * calendar表示时间历法
	*   (这里用一句话描述这个方法的作用)
	* @Method testGregorian
	* @throws Exception void
	* @author neo
	* @since 2018年2月26日 下午2:58:08
	 */
	@Test
	public void testGregorian()throws Exception{
		GregorianCalendar c = new GregorianCalendar();
		System.out.println(c);
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test
	public void testCalendar()throws Exception{
		Calendar c = Calendar.getInstance();
		System.out.println(c.getFirstDayOfWeek());
		
		c = Calendar.getInstance(Locale.ITALY);
		System.out.println(c.getFirstDayOfWeek());
	}
}

/**
*   (用一句话描述该文件做什么)
* @Filename TestStringFormat.java
* @Package charseq
* @author neo
* @since 2018年2月26日 上午11:54:20
* @Version V1.0
*/
package lang.charseq;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestStringFormat
 * @author neo
 * @since 2018年2月26日 上午11:54:20
 */
public class TestStringFormat {

	@Test
	public void test()throws Exception{
		double a = 10000.0/3.0;
		System.out.println(a);
		System.out.printf("%s %8.2f",a);
	}
}

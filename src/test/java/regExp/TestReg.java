/**
*   (用一句话描述该文件做什么)
* @Filename TestReg.java
* @Package regExp
* @author neo
* @since 2018年2月26日 下午2:01:29
* @Version V1.0
*/
package regExp;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestReg
 * @author neo
 * @since 2018年2月26日 下午2:01:29
 */
public class TestReg {

	/**
	 * 	a.replaceAll(regex, replacement)
		a.replaceFirst(regex, replacement)
		a.split(regex)
	*   (这里用一句话描述这个方法的作用)
	* @Method test
	* @throws Exception void
	* @author neo
	* @since 2018年2月26日 下午2:10:30
	 */
	@Test
	public void test()throws Exception{
		String a = "a.b.c.d";
		a.matches("regex");
		a.split("regex");
	}
	
	@Test
	public void testMatch()throws Exception{
//		String exp = "^[\\$a-zA-Z][\\$a-zA-Z0-9_]*$";
//		String a = "[$aA][$aA1_]1";
//		System.out.println(a.matches(exp));
		String exp = "^[\\$a-zA-z]$";
		String a = "[$]";
		System.out.println(a.matches(exp));
	}
	
}

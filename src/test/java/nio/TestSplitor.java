/**
*   (用一句话描述该文件做什么)
* @Filename TestSplitor.java
* @Package nio
* @author neo
* @since 2018年2月26日 下午12:11:00
* @Version V1.0
*/
package nio;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestSplitor
 * @author neo
 * @since 2018年2月26日 下午12:11:00
 */
public class TestSplitor {

	/**
	 * 斜杠
	 * 本地路径   Unix 和windows都支持
	 * 网络路径  统一
	 * 类路径
	 * 
	 * 反斜杠斜杠
	 * 在编译的时候 反斜杠优用于两种情况
	 * 			1，用于转义  \b  \t
	 * 			2，用于路径  windows风格(windows同时支持两种风格的路径  \ /)
	*   (这里用一句话描述这个方法的作用)
	* @Method test
	* @throws Exception void
	* @author neo
	* @since 2018年2月26日 下午12:13:43
	 */
	@Test
	public void test()throws Exception{
		//File f = new File("F:\apache-maven-3.3.9\LICENSE");
		File f = new File("F:\\apache-maven-3.3.9\\LICENSE");
		System.out.println(f.getAbsolutePath());
		f = new File("F:/apache-maven-3.3.9/LICENSE");
		System.out.println(f.getAbsolutePath());
	}
}

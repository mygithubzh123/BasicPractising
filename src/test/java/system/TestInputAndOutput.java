/**
*   (用一句话描述该文件做什么)
* @Filename TestSystemIn.java
* @Package system
* @author neo
* @since 2018年2月26日 上午11:33:41
* @Version V1.0
*/
package system;

import org.junit.jupiter.api.Test;

import java.io.Console;
import java.util.Scanner;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestSystemIn
 * @author neo
 * @since 2018年2月26日 上午11:33:41
 */
public class TestInputAndOutput {

	@Test
	public void testScanner()throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.println("what's your name?:");
		String name = scanner.next();
		System.out.println("hello! "+name);
		scanner.close();
	}
	
	/**
	 * console必须从控制台启动
	*   (这里用一句话描述这个方法的作用)
	* @Method testConsole
	* @throws Exception void
	* @author neo
	* @since 2018年2月26日 上午11:53:27
	 */
	@Test
	public void testConsole()throws Exception{
		Console console = System.console();
		String id = console.readLine("your id:");
		char[] passwd = console.readPassword("your passwd:");
		System.out.println("check id【"+id+"】 and password【"+ new String(passwd)+"】");
	}
}

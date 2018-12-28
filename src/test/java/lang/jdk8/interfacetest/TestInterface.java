/**
 *   (用一句话描述该文件做什么)
 * @Filename TestInterface.java
 * @Package java8.interfacetest
 * @author neo
 * @since 2018年2月24日 下午5:03:49
 * @Version V1.0
 */
package lang.jdk8.interfacetest;

import org.junit.jupiter.api.Test;

import java.net.UnknownHostException;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestInterface
 * @author neo
 * @since 2018年2月24日 下午5:03:49
 */
public class TestInterface {

	@Test
	public void test() throws UnknownHostException {
		DefaultInterface di = new InterfaceImpl();
		di.defaultMethod();
		FunctionInter fi = new FunctionInterImpl();
		fi.dosomething();
	}
}
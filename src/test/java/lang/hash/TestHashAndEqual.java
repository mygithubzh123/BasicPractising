/**
*   (用一句话描述该文件做什么)
* @Filename TestHashAndEqual.java
* @Package hash
* @author neo
* @since 2018年2月26日 下午4:26:09
* @Version V1.0
*/
package lang.hash;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestHashAndEqual
 * @author neo
 * @since 2018年2月26日 下午4:26:09
 */
public class TestHashAndEqual {

	@Test
	public void test()throws Exception{
		A a = new A();
		Thread.sleep(2000);
		A b = new A();
		System.out.println(a.equals(b));
	}
}
class A {

	@Override
	public int hashCode() {
		return (int)(System.currentTimeMillis()/10000);
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	
}
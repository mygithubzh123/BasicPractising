/**
*   (用一句话描述该文件做什么)
* @Filename TestOverride.java
* @Package oop
* @author neo
* @since 2018年2月26日 下午3:55:31
* @Version V1.0
*/
package oop;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestOverride
 * @author neo
 * @since 2018年2月26日 下午3:55:31
 */
public class TestOverride {

	@Test
	public void test()throws Exception{
		A a = new B();
		a.getName();
		
		B b = new B();
		((A)b).getName();
	}
}
class A {
	public void getName(){
		System.out.println("A class");
	}
}
class B extends A{

	@Override
	public void getName() {
		System.out.println("B class");
	}
}
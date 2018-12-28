/**
*   (用一句话描述该文件做什么)
* @Filename TestDefaultMethod.java
* @Package java8
* @author neo
* @since 2017年5月10日 上午11:09:49
* @Version V1.0
*/
package lang.jdk8.interfacetest;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestDefaultMethod
 * @author neo
 * @since 2017年5月10日 上午11:09:49
 */
public class TestDefaultMethod {

	@Test
	public void test()throws Exception{
		Drinkable.flow();
		Drinkable drink = new Beer();
		drink.drink();
		drink.pour();
	}
}
interface Drinkable{
	
	public void drink();
	
	default void pour()throws Exception{
		System.out.println("pour down the drink");
	}
	
	static void flow()throws Exception{
		System.out.println("drink flow away");
	}
}
class Beer implements Drinkable{

	@Override
	public void drink() {
		System.out.println("drink beer...");
	}

	@Override
	public void pour() throws Exception {
		System.out.println("pour down the beer");
	}
}

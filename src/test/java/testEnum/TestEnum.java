/**
*   (用一句话描述该文件做什么)
* @Filename TestEnum.java
* @Package testEnum
* @author neo
* @since 2018年2月26日 下午2:15:44
* @Version V1.0
*/
package testEnum;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestEnum
 * @author neo
 * @since 2018年2月26日 下午2:15:44
 */
public class TestEnum {

	@Test
	public void test()throws Exception{
		CarEnum car1 = CarEnum.BENZ;
		CarEnum car2 = CarEnum.BMW;
		CarEnum car3 = CarEnum.BENZ;
		System.out.println(car1.equals(car3));
		System.out.println(car2);
		System.out.println(car1 == car3);
	}
	
	@Test
	public void testSize()throws Exception{
		SizeEnum se = SizeEnum.SMALL;
		System.out.println(se);
		System.out.println(se.ordinal());
	}
}


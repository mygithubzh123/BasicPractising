/**
*   (用一句话描述该文件做什么)
* @Filename TestStrictMath.java
* @Package math
* @author neo
* @since 2018年2月26日 上午10:13:53
* @Version V1.0
*/
package math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestStrictMath
 * @author neo
 * @since 2018年2月26日 上午10:13:53
 */
public class TestStrictMath {

	@Test
	public void test()throws Exception{
		System.out.println("=========================TestPow");
		System.out.println(StrictMath.pow(0.2,2));
		System.out.println(Math.pow(0.2,2));
		
		BigDecimal bc = new BigDecimal(0.2d);
		bc = bc.pow(2);
		System.out.println(bc.toString());
		
		System.out.println("=========================TestFloorDiv");
		System.out.println(Math.floorDiv(1, 2));
		System.out.println(Math.floorDiv(2, 2));
		System.out.println(Math.floorDiv(3, 2));
		System.out.println(Math.floorDiv(4, 2));
		
		System.out.println("=======================TestULP");
		System.out.println(Math.ulp(1));
		System.out.println(Math.ulp(1.001));
		System.out.println(Math.ulp(1.000));
	}
}

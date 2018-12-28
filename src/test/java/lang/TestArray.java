/**
*   (用一句话描述该文件做什么)
* @Filename TestArray.java
* @Package array
* @author neo
* @since 2018年2月26日 下午4:09:12
* @Version V1.0
*/
package lang;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestArray
 * @author neo
 * @since 2018年2月26日 下午4:09:12
 */
public class TestArray {

	@Test
	public void test()throws Exception{
		int[] a = {1,2,3,4,5};
		int[] b = {1,2,3,4};
		int[] c = {1,2,3,4,6};
		int[] d = {1,2,3,4,5};
		System.out.println(Arrays.equals(a, b));
		System.out.println(Arrays.equals(a, c));
		System.out.println(Arrays.equals(a, d));
	}
}

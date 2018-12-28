/**
*   (用一句话描述该文件做什么)
* @Filename TestObejcts.java
* @Package jdk7.objects
* @author neo
* @since 2018年2月26日 下午4:15:59
* @Version V1.0
*/
package lang.jdk7;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestObejcts
 * @author neo
 * @since 2018年2月26日 下午4:15:59
 */
public class TestObejcts {
	
	int[] a = {1,2,3,4,5};
	int[] d = {1,2,3,4,5};

	@Test
	public void test()throws Exception{
		System.out.println(Objects.equals(a, d));
		System.out.println(Objects.deepEquals(a, d));
		
	}
}

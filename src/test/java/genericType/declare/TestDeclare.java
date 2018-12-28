/**
*   (用一句话描述该文件做什么)
* @Filename TestDeclare.java
* @Package genericType.declare
* @author neo
* @since 2018年3月8日 上午10:43:18
* @Version V1.0
*/
package genericType.declare;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestDeclare
 * @author neo
 * @since 2018年3月8日 上午10:43:18
 */
public class TestDeclare {
	
	@Test
	public void testUseInField()throws Exception{
		List<String> list = new ArrayList<>();
		list.add("abc");
	}
	
	public static <T> String getName(T t)throws Exception{
		return t.getClass().getName();
	}
	
	public static <T extends Comparable<String>> void getMin(T t)throws Exception{
		
	}
	
	@Test
	public void testUseInMethod()throws Exception{
		System.out.println(TestDeclare.getName("abc"));
		TestDeclare.getMin("abc");
	}
	
	
}

/**
*   (用一句话描述该文件做什么)
* @Filename TestListContains.java
* @Package collection
* @author neo
* @since 2018年3月5日 下午3:39:03
* @Version V1.0
*/
package collection;

//import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestListContains
 * @author neo
 * @since 2018年3月5日 下午3:39:03
 */
public class TestListContains {

	List<String> alist = Arrays.asList("a","b","c");
	
	/**
	 * Collection<T>.contains -> List.contains -> List.indexOf -> T.equals
	 */
	@Test
	public void test()throws Exception{
		Assertions.assertTrue(alist.contains("a"));
	}
}

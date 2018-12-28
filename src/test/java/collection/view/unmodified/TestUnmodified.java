/**
*   (用一句话描述该文件做什么)
* @Filename TestUnmodified.java
* @Package collection.view.unmodified
* @author neo
* @since 2018年3月12日 下午5:10:46
* @Version V1.0
*/
package collection.view.unmodified;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestUnmodified
 * @author neo
 * @since 2018年3月12日 下午5:10:46
 */
public class TestUnmodified {
	
	List<String> list = new ArrayList<>();
	
	Set<String> set = new HashSet<>();
	
	Map<String,Object> map = new HashMap<>();
	
	@Test
	public void test()throws Exception{
		List<String> newList = Collections.unmodifiableList(list);
		System.out.println(newList.getClass());
	}
}

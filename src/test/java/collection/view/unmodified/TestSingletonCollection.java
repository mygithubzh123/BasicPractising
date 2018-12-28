/**
*   (用一句话描述该文件做什么)
* @Filename TestSingletonCollection.java
* @Package collection.view.unmodified
* @author neo
* @since 2018年3月12日 下午5:02:27
* @Version V1.0
*/
package collection.view.unmodified;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestSingletonCollection
 * @author neo
 * @since 2018年3月12日 下午5:02:27
 */
public class TestSingletonCollection {

	/**
	 * 单例集合不允许修改
	 * 底层 abstractCollection,abstractMap
	 */
	@Test
	public void test()throws Exception{
		Set<String> set = Collections.singleton("ABC");
		List<String> list = Collections.singletonList("ABC");
		Map<String,Object> map = Collections.singletonMap("ABC",new Object());
		
		set.add("abc");
		list.add("abc");
		map.put("abc", new Object());
	}
}

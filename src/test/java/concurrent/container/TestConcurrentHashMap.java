/**
*   (用一句话描述该文件做什么)
* @Filename TestConcurrentHashMap.java
* @Package concurrent
* @author neo
* @since 2017年6月13日 下午12:12:37
* @Version V1.0
*/
package concurrent.container;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestConcurrentHashMap
 * @author neo
 * @since 2017年6月13日 下午12:12:37
 */
public class TestConcurrentHashMap {

	Map<String,Object> map = new ConcurrentHashMap<>();
	
	@BeforeEach
	public void setup(){
		map.put("a", Integer.valueOf(1));
	}
	
	@Test
	public void test(){
		System.out.println(map);
	}
}

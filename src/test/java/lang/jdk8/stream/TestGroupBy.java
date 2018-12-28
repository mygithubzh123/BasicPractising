/**
*   (用一句话描述该文件做什么)
* @Filename TestStream.java
* @Package java8
* @author neo
* @since 2017年5月10日 上午10:59:30
* @Version V1.0
*/
package lang.jdk8.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestStream
 * @author neo
 * @since 2017年5月10日 上午10:59:30
 */
public class TestGroupBy {

	Map<Integer,List<String>> target = new HashMap<>();
	
	List<String> names = new ArrayList<>();
	
	@BeforeEach
	public void setup(){
		names.add("apple");
		names.add("jamesi");
		names.add("daviddd");
		names.add("lucy");
		names.add("lily");
	}

	@Test
	public void test()throws Exception{
		target = names.stream().collect(Collectors.groupingBy((String e) ->e.length()));
		System.out.println(target);
		names.stream().collect(Collectors.groupingBy(String::length));
	}
}

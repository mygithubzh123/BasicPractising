/**
*   (用一句话描述该文件做什么)
* @Filename TestMatch.java
* @Package java8.stream
* @author neo
* @since 2017年5月10日 下午3:14:27
* @Version V1.0
*/
package lang.jdk8.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestMatch
 * @author neo
 * @since 2017年5月10日 下午3:14:27
 */
public class TestMatch {
	
	List<String> target = new ArrayList<>();
	
	@BeforeEach
	public void setup(){
		target.add("asbd");
		target.add(null);
		target.add("asbccd");
		target.add("asoiiobd");
	}

	@Test
	public void test(){
		System.out.println(target.stream().allMatch(value -> value != null));	
		System.out.println(target.stream().anyMatch(value -> value.length() == 4));
		System.out.println(target.stream().anyMatch(value -> value.length() == 6));
	}
	
	@Test
	public void teardown(){
		
	}

}

/**
*   (用一句话描述该文件做什么)
* @Filename TestMethod.java
* @Package java8.method
* @author neo
* @since 2017年5月17日 上午10:25:22
* @Version V1.0
*/
package lang.jdk8.method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestMethod
 * @author neo
 * @since 2017年5月17日 上午10:25:22
 */
public class TestMethod {

	List<String> strs;
	
	@BeforeEach
	public void setup(){
		strs = new ArrayList<>();
		strs.add("abc");
		strs.add("abc");
		strs.add("abc");
		strs.add("abc");
	}
	
	@Test
	public void test(){
		strs.stream().map(str -> str.substring(1)).forEach(value -> System.out.println(value));
		strs.stream().map(str -> str.substring(1)).forEach(value -> System.out.println(value));
	}
}

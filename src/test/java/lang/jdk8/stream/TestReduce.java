/**
*   (用一句话描述该文件做什么)
* @Filename TestReduce.java
* @Package java8
* @author neo
* @since 2017年5月10日 上午10:39:39
* @Version V1.0
*/
package lang.jdk8.stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestReduce
 * @author neo
 * @since 2017年5月10日 上午10:39:39
 */
public class TestReduce {
	
	List<String> target = new ArrayList<>();
	
	@BeforeEach
	public void setup(){
		target.add("asbd");
		target.add("asdfbd");
		target.add("asbccd");
		target.add("asoiiobd");
	}

	@Test
	public void test(){
		int sum = target.stream().mapToInt(value -> value.length()).reduce(0, (a,b)-> a+b);
		int sum1 = target.stream().mapToInt(value -> value.length()).sum();
		System.out.println(sum);
		System.out.println(sum1);
	}
	
	@AfterEach
	public void teardown(){
		
	}
}

/**
*   (用一句话描述该文件做什么)
* @Filename TestReduce.java
* @Package java8.reduce
* @author neo
* @since 2017年6月12日 上午11:21:52
* @Version V1.0
*/
package lang.jdk8.reduce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestReduce
 * @author neo
 * @since 2017年6月12日 上午11:21:52
 */
public class TestReduce {

	private List<Integer> list;
	
	@BeforeEach
	public void setup(){
		list = Arrays.asList(2,3,4);
	}
	
	@Test
	public void test() throws Exception{
		Integer option = list.stream().reduce(null, (a,b)-> a+b);
		//int a = option.orElseThrow(() -> new Exception("no result"));
		System.out.println(option);
	}
	
}

/**
*   (用一句话描述该文件做什么)
* @Filename TestSpliterator.java
* @Package java8
* @author neo
* @since 2017年5月10日 上午11:21:48
* @Version V1.0
*/
package lang.jdk8.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestSpliterator
 * @author neo
 * @since 2017年5月10日 上午11:21:48
 */
public class TestSpliterator {
	
	ExecutorService executor = Executors.newFixedThreadPool(5);

	List<Object> target = new ArrayList<>();
	
	@BeforeEach
	public void setup(){
		target.add("aaaaa");
		target.add("bbbbb");
		target.add("ccccc");
		target.add("ddddd");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
		target.add("eeeee");
	}

	@Test
	public void testTryAdvance(){
		Spliterator<Object> split = target.spliterator();
		boolean result = false;
		do{
			result = split.tryAdvance(value -> System.out.println(value.toString()));	
		} while(result);
	}
	
	@Test
	public void testTrysplit(){
		Spliterator<Object> split = target.spliterator();
		split.forEachRemaining(value -> System.out.println(value.hashCode()));
		Spliterator<Object> splitcopy = split.trySplit();
		splitcopy.forEachRemaining(ss -> System.out.println(ss.hashCode()));
	}
	
	@Test
	public void teardown(){

	}
}

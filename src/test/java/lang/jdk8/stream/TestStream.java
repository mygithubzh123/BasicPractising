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
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestStream
 * @author neo
 * @since 2017年5月10日 上午10:59:30
 */
public class TestStream {

	List<String> target = new ArrayList<>();
	
	@BeforeEach
	public void setup(){
		target.add("asbd");
		target.add("asdfbd");
		target.add("asbccd");
		target.add("asoiiobd");
	}

	@Test
	public void test()throws Exception{
		int a = target.spliterator().characteristics();
		long size = target.spliterator().estimateSize();
		System.out.println(a);
		System.out.println(size);
	}
	
	@Test
	public void testArray(){
	    long[] arrayOfLong = new long [20000];       
	    Arrays.parallelSetAll(arrayOfLong,index -> ThreadLocalRandom.current().nextInt(1000000));
	    Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i+" "));
	    System.out.println("=================");
	    Arrays.parallelSort(arrayOfLong);
	    Arrays.stream(arrayOfLong).limit(10).forEach(
	    i -> System.out.print(i+" "));
	    System.out.println("=================");
	}
	
	@Test
	public void teardown(){
		
	}
}

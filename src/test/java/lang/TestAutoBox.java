package lang;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 *   (用一句话描述该文件做什么)
 * @Filename TestBox.java
 * @Package 
 * @author neo
 * @since 2017年5月11日 下午12:54:45
 * @Version V1.0
 */

/**
 *   (这里用一句话描述这个类的作用)
 *    TestBox
 * @author neo
 * @since 2017年5月11日 下午12:54:45
 */
public class TestAutoBox {

	@Test
	public void test(){
		Integer i = 100;
		Integer b = 100;
		System.out.println(i == b);
	}
	
	@Test
	public void test200(){
		Integer i = 200;
		Integer b = 200;
		System.out.println(i == b);
	}
	
	@Test
	public void testObject()throws Exception{
		Integer i = new Integer(200);
		Integer b = new Integer(200);
		System.out.println(i == b);
		System.out.println(i.equals(b));
	}
	
	List<Integer> list = Arrays.asList(new Integer(100),new Integer(500),new Integer(1000));
	
	/**
	 * 个体与集合中元素比较时，集合中元素安装个体的类型进行自动拆箱
	 */
	@Test
	public void testList(){
		int a = 1000;
		Integer ai = new Integer(1000);
		System.out.println(list.stream().anyMatch(e -> e == a));
		System.out.println(list.stream().anyMatch(e -> e.equals(a)));
		System.out.println(list.stream().anyMatch(e -> e == ai));
		System.out.println(list.stream().anyMatch(e -> e.equals(ai)));
		
		System.out.println(list.contains(a));
		System.out.println(list.contains(ai));
	}
}

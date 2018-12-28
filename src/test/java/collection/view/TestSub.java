/**
*   (用一句话描述该文件做什么)
* @Filename TestSub.java
* @Package collection.view
* @author neo
* @since 2018年3月12日 下午4:37:03
* @Version V1.0
*/
package collection.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestSub
 * @author neo
 * @since 2018年3月12日 下午4:37:03
 */
public class TestSub {

	List<Integer> list = new ArrayList<>();
	
	@BeforeEach
	public void setup()throws Exception{
		for(int i =1;i<101;i++){
			list.add(i);
		}
	}
	
	/**
	 * subList是ArrayList的一个内部类
	 * 结构比ArrayList更简单
	 * subList内部包含父List的引用，对subList的修改会影响到父List
	 * subList添加元素,会同步再父List中对应位置添加,如果是插入,后面元素依次挪动
	 */
	@Test
	public void test()throws Exception{
		List<Integer> sublist = list.subList(0, 49);
		System.out.println(sublist);
		System.out.println(sublist.getClass().getName());
		sublist.add(100);
		System.out.println(sublist);
		System.out.println(list);
	}

}

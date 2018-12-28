/**
*   (用一句话描述该文件做什么)
* @Filename TestSuper.java
* @Package genericType.wildcard
* @author neo
* @since 2018年3月8日 下午2:10:03
* @Version V1.0
*/
package genericType.wildcard;

import genericType.vo.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestSuper
 * @author neo
 * @since 2018年3月8日 下午2:10:03
 */
public class TestSuper {
	
	private List<? super Person> list = new ArrayList<>();
	
	List<Person> persons = new ArrayList<>();
	
	@Test
	public void test() throws Exception{
		list.add(new Person());
		add(list);
		add(persons);
	}

	public static List<Comparable<String>> add(List<? super Person> persons)throws Exception{
		return new ArrayList<>();
	}
}

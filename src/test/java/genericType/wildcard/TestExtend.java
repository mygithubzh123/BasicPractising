/**
*   (用一句话描述该文件做什么)
* @Filename TestExtend.java
* @Package genericType.wildcard
* @author neo
* @since 2018年3月8日 上午10:37:16
* @Version V1.0
*/
package genericType.wildcard;

import genericType.vo.Employee;
import genericType.vo.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestExtend
 * @author neo
 * @since 2018年3月8日 上午10:37:16
 */
public class TestExtend {

	List<Person> list = new ArrayList<>();
	
	List<? extends Person> subList = new ArrayList<Person>();
	
	List<? super Person> supList = new ArrayList<>();
	
	List<Employee> emps = new ArrayList<>();
	
	@Test
	public void test(){
		//subList.add(new Person());
		//subList.add(new Employee());
		supList.add(new Person());
		supList.add(new Employee());
		System.out.println(supList);
	}
	
	public static void add(List<? extends Person> list){
		System.out.println(list);
	}
}



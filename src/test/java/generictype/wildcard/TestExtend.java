package generictype.wildcard;

import generictype.vo.Employee;
import generictype.vo.Manager;
import generictype.vo.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TestExtend
 * @author neo
 * @since 2018年3月8日 上午10:37:16
 */
public class TestExtend {

	private List<Person> personList = new ArrayList<>();

	private List<? extends Person> personSubList = new ArrayList<>();

	private List<? super Person> personSuperList = new ArrayList<>();

	private List<Employee> employees = new ArrayList<>();

	private List<Manager> managers = new ArrayList<>();

	@Test
	void testBorder(){
		personList.add(new Person());
		personList.add(new Employee());
		personList.add(new Manager());


		//此处personSubList是 Person的某一个未知子类的集合，只能存放Person 的该子类元素，但是这个子类类型未限定
		//Person不是该子类元素，Person的其他子类也不是该子类元素,所以这里都无法通过类型检测
//		personSubList.add(new Person());
//		personSubList.add(new Employee());
//		personSubList.add(new Manager());
//		personSubList.add(new Object());
		personSubList.add(null);//此集合只能插入null元素,因为声明元素类型是未知的，而限定该集合只能插入该未知类型及子类型。

		//此处personSuperList集合存放Person的某个超类元素类型
		//Person类是该类的子类，可以向上转型，所以Person类及Person类的子类都可以放入该集合中
		personSuperList.add(new Person());
		personSuperList.add(new Employee());
		personSuperList.add(new Manager());

		//不带限定类的集合,可以插入声明类及子类元素
		employees.add(new Manager());
		managers.add(new Manager());

		System.out.println(personList);
		System.out.println(personSubList);
		System.out.println(personSuperList);
		System.out.println(employees);
		System.out.println(managers);
	}
	
}



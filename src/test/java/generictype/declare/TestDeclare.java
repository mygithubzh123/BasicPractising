package generictype.declare;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TestDeclare
 * @author neo
 * @since 2018年3月8日 上午10:43:18
 */
public class TestDeclare {

	/**
	 * 静态方法或者静态代码块，不能使用泛型
	 */
//	public static <T> init(T t){
//		System.out.println(t);
//		return t;
//	}

	@Test
	void testUseInField(){
		List<String> list = new ArrayList<>();
		list.add("abc");
		System.out.println(list.get(0));
	}

	@Test
	void testRuntimeClass() {
		List<String> listStr = new ArrayList<>();
		listStr.add("abc");
		List<Integer> listInteger = new ArrayList<>();
		listInteger.add(2);
		System.out.println(listStr.getClass());
		System.out.println(listInteger.getClass());
	}

	@Test
	void testType(){
		List<String> listStr = new ArrayList<>();
//		if(listStr instanceof List<String>){
//
//		}
		System.out.println(listStr);
	}
}

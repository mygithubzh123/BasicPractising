package lang.runtime;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestObejcts
 * @author neo
 * @since 2018年2月26日 下午4:15:59
 */
public class TestObjects {
	
	private int[] a = {1,2,3,4,5};
	private int[] d = {1,2,3,4,5};

	@Test
	void test(){
		System.out.println(Objects.equals(a, d));
		System.out.println(Objects.deepEquals(a, d));
	}

	@Test
	void testTools(){
		Object object = new Object();
		Objects.requireNonNull(object);
		Objects.requireNonNull(object," is null");
		Objects.requireNonNull(object,()-> " is null at"+System.currentTimeMillis());

		object = null;
		System.out.println(Objects.isNull(object));
		System.out.println(Objects.nonNull(object));

		System.out.println(Objects.compare(1,3,Integer::compareTo));

	}
}

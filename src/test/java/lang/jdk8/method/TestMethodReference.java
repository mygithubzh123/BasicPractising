package lang.jdk8.method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法引用
 *
 * @author neo
 * 2018/10/30 5:16 PM
 */
public class TestMethodReference {

	List<Integer> ints;

	@BeforeEach
	public void setup(){
		ints = new ArrayList<>();
		ints.add(12312);
		ints.add(4455);
		ints.add(4422355);
		ints.add(4459995);
		ints.add(44455);
	}

	@Test
	public void testMax(){
		System.out.println(ints.stream().max(Integer::compareTo).get());
	}
}

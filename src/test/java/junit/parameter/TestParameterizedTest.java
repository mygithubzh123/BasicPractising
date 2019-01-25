package junit.parameter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

/**
 * 参数注入
 *
 * @author neo
 * 2019/1/25 4:00 PM
 */
public class TestParameterizedTest {

	@ExtendWith(RandomIntegerGenerator.class)
	@Test
	void testParameterResolver(int random) {
		System.out.println("随机数："+random);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a","b","c"})
	@Test
	void testValueSource(String str) {
		System.out.println("测试字符串:"+str);
	}

	@ParameterizedTest
	@EnumSource(JunitVersionEnum.class)
	@Test
	void testEnumSource(JunitVersionEnum junitVersionEnum) {
		System.out.println(junitVersionEnum);
	}

	@ParameterizedTest
	@MethodSource("getStringStream")
	@Test
	void testMethodSource(String str) {
		System.out.println(str);
	}

	/**
	 * 作为source的方法必须返回iterator，stream,或者数组
	 * @return
	 */
	private static Stream<String> getStringStream(){
		return Stream.of("a","b");
	}
}

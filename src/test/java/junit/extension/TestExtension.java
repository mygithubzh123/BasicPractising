package junit.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * 测试扩展点注入
 *
 * @author neo
 * 2019/1/25 2:29 PM
 */
@ExtendWith(MyBeforeEachCallback.class)
@ExtendWith(MyAfterEachCallback.class)
public class TestExtension {

	@Test
	void test1(){
		System.out.println("doing test1");
	}

	@Test
	void test2(){
		System.out.println("doing test2");
	}

}


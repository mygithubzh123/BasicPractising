package collection.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 测试枚举
 *
 * @author neo
 * 2019/1/11 11:39 AM
 */
public class TestEnumeration {

	private ClassLoader classLoader;

	@BeforeEach
	void setup(){
		classLoader = Thread.currentThread().getContextClassLoader();
	}

	@Test
	void test1() throws IOException {
		Enumeration<URL> urls = classLoader.getResources("./annotation");
		while (urls.hasMoreElements()){
			URL url1 = urls.nextElement();
			System.out.println(url1);
		}

	}
}

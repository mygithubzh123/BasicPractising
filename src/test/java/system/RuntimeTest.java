package system;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Properties;

/**
 * 测试运行时常量
 *
 * @author neo
 * 2018/10/30 2:15 PM
 */
public class RuntimeTest {

	@Test
	public void testLineSeparator(){
		String line = System.getProperty("line.separator");
		System.out.println(line);
	}

	@Test
	public void testRuntimeParam(){
		Map<String, String> envMap = System.getenv();
		System.out.println(envMap);
		String processNumber = System.getenv("NUMBER_OF_PROCESSORS");
		System.out.println("processNumber:"+processNumber);

		Properties properties = System.getProperties();
		System.out.println(properties);
		String vendor = System.getProperty("java.vendor.url");
		System.out.println("vendor:"+vendor);

		System.out.println(System.getProperty("java.vendor.url", "http://java.openjdk.com/"));

		System.out.println(envMap.get("line.separator"));

	}
}

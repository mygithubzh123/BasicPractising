package classloader;

import org.junit.jupiter.api.Test;
import regExp.TestGroup;

/**
 * @author neo
 * 2018/11/1 8:21 PM
 */
public class TestGetResource {

	@Test
	public void testGetResourceByClass(){
		System.out.println(TestGetResource.class.getResource("/").getPath());
		System.out.println(TestGetResource.class.getResource("").getPath());

//		System.out.println(TestGetResource.class.getClassLoader().getResource("/").getPath());
		System.out.println(TestGetResource.class.getClassLoader().getResource("").getPath());

	}
}

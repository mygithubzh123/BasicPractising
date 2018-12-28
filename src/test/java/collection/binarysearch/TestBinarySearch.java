package collection.binarysearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestBinarySearch
 * @author neo
 * @since 2018年4月23日 下午5:07:23
 */
public class TestBinarySearch {
	
	List<String> a = Arrays.asList("1","2","3","4"
			,"6","7","8","9","10");
	
	@Test
	public void test(){
		System.out.println(a.size() + Collections.binarySearch(a, "5"));
		System.out.println(a.size() + Collections.binarySearch(a, "11"));
	}

}

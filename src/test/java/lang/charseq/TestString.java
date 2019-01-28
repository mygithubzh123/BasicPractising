package lang.charseq;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestString
 * @author neo
 * @since 2018年2月26日 上午11:09:59
 */
public class TestString {

	@Test
	public void test()throws Exception{
		String a = " abc ccb ";
		String b = "==========";
		System.out.println(b+a+b);
		System.out.println(b+a.trim()+b);
		
		System.out.println(trimMiddle(a));
		System.out.println(trimMiddle(b));
	}
	
	public static String trimMiddle(String s)throws Exception{
		Optional<String> option = Arrays.asList(s.split(" ")).stream().reduce((a,b) -> a+b);
		return option.get();
	}
}

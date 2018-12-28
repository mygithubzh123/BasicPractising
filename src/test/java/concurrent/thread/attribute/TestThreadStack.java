package concurrent.thread.attribute;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 测试stackTrace
 *
 * @author neo
 * 2018/9/13 上午10:45
 */
public class TestThreadStack {

	@Test
	public void test1(){
		for(StackTraceElement e:Thread.currentThread().getStackTrace()){
			System.out.println(e);
		}
	}

	@Test
	public void test2(){
		Thread.getAllStackTraces().forEach((key, value) -> {
			System.out.println("==================");
			System.out.println(key);
			System.out.println(Arrays.toString(value));
		});
	}

	//1545293640010973
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}
}

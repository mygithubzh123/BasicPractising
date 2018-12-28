/**
*   (用一句话描述该文件做什么)
* @Filename TestConsumer.java
* @Package java8.actionParameter
* @author neo
* @since 2017年5月11日 上午11:03:32
* @Version V1.0
*/
package lang.jdk8.actionParameter;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestConsumer
 * @author neo
 * @since 2017年5月11日 上午11:03:32
 */
public class TestConsumer {
	
	@Test
	public void test(){
		String a = "abc";
		MyStringPrintFirstCharConsumer mpfcc = new MyStringPrintFirstCharConsumer();
		MyStringPrintConsumer mpc = new MyStringPrintConsumer();
		consumerString(mpfcc,a);
		consumerString(mpc,a);
	}
	
	public static void consumerString(Consumer<String> c,String s){
		c.accept(s);
	}

}
class MyStringPrintFirstCharConsumer implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println(t.charAt(0));
	}
	
}
class MyStringPrintConsumer implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println(t);
	}
	
}
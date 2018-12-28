/**
*   (用一句话描述该文件做什么)
* @Filename TestSupplier.java
* @Package java8.actionParameter
* @author neo
* @since 2017年5月11日 上午10:49:44
* @Version V1.0
*/
package lang.jdk8.actionParameter;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.function.Supplier;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestSupplier
 * @author neo
 * @since 2017年5月11日 上午10:49:44
 */
public class TestSupplier {

	@Test
	public void test(){
		MyDateTimeKeySupplier mdp = new MyDateTimeKeySupplier();
		MyHashSupplier s = new MyHashSupplier();
		System.out.println(getKey(mdp));
		System.out.println(getKey(s));
	}
	
	public static String getKey(Supplier<String> s){
		return s.get(); 
	}
	
}
class MyHashSupplier implements Supplier<String>{

	@Override
	public String get() {
		Object o = new Object();
		return o.hashCode()+"";
	}
	
}
class MyDateTimeKeySupplier implements Supplier<String>{

	@Override
	public String get() {
		Date now = new Date();
		return now.getTime()+"";
	}
	
}

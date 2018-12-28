/**
*   (用一句话描述该文件做什么)
* @Filename TestPredicate.java
* @Package java8.actionParameter
* @author neo
* @since 2017年5月11日 上午10:46:56
* @Version V1.0
*/
package lang.jdk8.actionParameter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestPredicate
 * @author neo
 * @since 2017年5月11日 上午10:46:56
 */
public class TestPredicate {

	
	@BeforeEach
	public void setup(){
	}

	@Test
	public void test(){
		MyPredicate mp = new MyPredicate();
		System.out.println(mp.test(""));
	}
	
	@AfterEach
	public void teardown(){
		
	}
	
	
}
class MyPredicate implements Predicate<String>{

	/* (非 Javadoc)
	* <p>Title: test</p>
	* <p>Description: </p>
	* @param t
	* @return
	* @see java.util.function.Predicate#test(java.lang.Object)
	*/
	@Override
	public boolean test(String t) {
		if(t.length() > 0){
			return true;
		}
		return false;
	}
	
}
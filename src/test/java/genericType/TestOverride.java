/**
*   (用一句话描述该文件做什么)
* @Filename TestOverride.java
* @Package genericType
* @author neo
* @since 2018年2月9日 上午11:01:39
* @Version V1.0
*/
package genericType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestOverride
 * @author neo
 * @since 2018年2月9日 上午11:01:39
 */
public class TestOverride {

	@BeforeEach
	public void setup()throws Exception{
		
	}
	
	@Test
	public void test()throws Exception{
		Point a = new Point(0,0);
		Point b = new Point(1,1);
		System.out.println(a.compareTo(b) > 0);
	}
}

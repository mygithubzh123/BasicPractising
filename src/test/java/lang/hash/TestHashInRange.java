/**
*   (用一句话描述该文件做什么)
* @Filename TestHashInRange.java
* @Package hash
* @author neo
* @since 2018年3月8日 下午4:20:20
* @Version V1.0
*/
package lang.hash;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestHashInRange
 * @author neo
 * @since 2018年3月8日 下午4:20:20
 */
public class TestHashInRange {
	
	int n = 15;
	
	@Test
	public void testHash(){
		System.out.println(1 & 15);
		System.out.println(17 & 15);
	}
	
	@Test
	public void test()throws Exception{
		int newi = 0;
		long a = System.nanoTime();
		for(int i=1;i<1000_000_000;i++){
			newi = i & n;
		}
		long b = System.nanoTime();
		for(int i=1;i<1000_000_000;i++){
			newi = i % n;
		}
		long c = System.nanoTime();
		System.out.println((b-a));
		System.out.println((c-b));
		System.out.println(newi);
	}

}

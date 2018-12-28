/**
*   (用一句话描述该文件做什么)
* @Filename TestArrayClone.java
* @Package lang.clone
* @author neo
* @since 2018年2月28日 上午10:50:45
* @Version V1.0
*/
package lang.clone;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestArrayClone
 * @author neo
 * @since 2018年2月28日 上午10:50:45
 */
public class TestArrayClone {

	/**
	 * 数组的clone是浅拷贝
	 */
	@Test
	public void testBasic()throws Exception{
		int[] a = {1,2,3,4};
		int[] b = a.clone();
		System.out.println(a);
		System.out.println(b);
		System.out.println(Arrays.toString(b));
		
		String[] c = {"1","2"};
		System.out.println(c);
		String[] d = c.clone();
		System.out.println(d);
	}
	
	@Test
	public void testType()throws Exception{
		A[] as = {new A(1,new B()),new A(2,new B()),new A(3,new B())};
		System.out.println(as);
		System.out.println(Arrays.toString(as));
		A[] newAs = as.clone();
		System.out.println(newAs);
		System.out.println(Arrays.toString(newAs));
	}
}
class A {
	int id;
	B b;
	/**
	*   A构造方法
	* @param id
	* @param b
	*/
	public A(int id, B b) {
		super();
		this.id = id;
		this.b = b;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("A [id=").append(id).append(", b=").append(b)
				.append("]");
		return builder.toString();
	}
	
}
class B {
	
}


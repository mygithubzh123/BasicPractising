/**
*   (用一句话描述该文件做什么)
* @Filename TestProtected.java
* @Package lang.clone.testprotected
* @author neo
* @since 2018年2月28日 上午10:20:00
* @Version V1.0
*/
package lang.clone;

import lang.clone.testprotected.Father;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestProtected
 * @author neo
 * @since 2018年2月28日 上午10:20:00
 */
public class TestProtected {
	
	public static void main(String[] args) throws Exception {
		Father f = new Father();
		System.out.println(f);
		//f的getMoney方法不可见，如果本类在和Father在同一个包下，是可见的
		//f.getMoney();
	}

}

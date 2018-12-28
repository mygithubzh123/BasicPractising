/**
*   (用一句话描述该文件做什么)
* @Filename TestCharSeq.java
* @Package charseq
* @author neo
* @since 2018年2月24日 下午5:13:11
* @Version V1.0
*/
package lang.charseq;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestCharSeq
 * @author neo
 * @since 2018年2月24日 下午5:13:11
 */
public class TestCharSeq {

	@Test
	public void test()throws Exception{
		int i = 0;
		char s = '0';
		System.out.println(i+s);
		
		s = '我';
		System.out.println(Integer.toHexString(new Integer(i+s)));
		s = '\u6211';
		System.out.println(s);
		
		s = '\u0065';
		System.out.println(s);
		
		s = '\u2122';
		System.out.println(s);
	}
	
	/**
	 * 代码点表示unicode字符编码中 任意一个字符所对应的数值
	 * char对应一个字符单元
	 * 一个代码点可能由一个代码单元组成，也可能由两个代码单元组成
	 * 调用字符串的charAt方法获取的是代码单元
	 * 调用字符串的codepointAt方法获取的是代码点
	 * 
	 * 当字符串中存在 数值超过65535的字符时
	 * charAt方法获取的是对应序号的代码单元所表示的字符
	 * codepointAt获取的是对应序号的代码点的数值
	 * 
	*   (这里用一句话描述这个方法的作用)
	* @Method testJoint
	* @throws Exception void
	* @author neo
	* @since 2018年2月26日 上午10:54:21
	 */
	@Test
	public void testJoint()throws Exception{
		String s = "abc\u2122";
		System.out.println(s);
		s = "\u1D56B";
		System.out.println(s);
		s = "\uD835\uDD6B";
		System.out.println(s);
		System.out.println(s.charAt(0));
		System.out.println(Integer.toHexString(s.codePointAt(0)));
		System.out.println(s.length());
		System.out.println(s.codePointCount(0,s.length()));
		
		char c = '\u2122';
		//char c = '\u1D56B'; 非法，字符常量只能用2个字节表示
		System.out.println(c);
		
	}
}

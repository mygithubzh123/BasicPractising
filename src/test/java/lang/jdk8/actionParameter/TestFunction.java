/**
*   (用一句话描述该文件做什么)
* @Filename TestFunction.java
* @Package java8.actionParameter
* @author neo
* @since 2017年5月11日 上午11:08:34
* @Version V1.0
*/
package lang.jdk8.actionParameter;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestFunction
 * @author neo
 * @since 2017年5月11日 上午11:08:34
 */
public class TestFunction {
	
	@Test
	public void test() throws Exception{
		MyFunction<Integer> mf = new MyFunction<Integer>();
		System.out.println(doFun(mf,123));
	}

	public static <T> String doFun(Function<T,String> f,T t)throws Exception{
		return f.apply(t);
	}
}
class MyFunction<T> implements Function<T, String>{

	@Override
	public String apply(T t) {
		return t.toString() + "str";
	}
	
}

package lang.jdk8.interfacetest;

import java.util.function.Function;

/**
 *   (用一句话描述该文件做什么)
 * @Filename Function.java
 * @Package 
 * @author neo
 * @since 2017年5月2日 下午5:16:13
 * @Version V1.0
 */
public class AddFunction implements Function<Integer,String>{

	@Override
	public String apply(Integer t) {
		return t.toString();
	}
}

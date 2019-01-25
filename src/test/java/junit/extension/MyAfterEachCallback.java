package junit.extension;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * 自定义扩展
 *
 * @author neo
 * 2019/1/25 2:37 PM
 */
public class MyAfterEachCallback implements AfterEachCallback {

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		System.out.println("结束测试"+context.getDisplayName());
	}
}
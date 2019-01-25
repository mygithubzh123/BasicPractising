package junit.extension;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * 自定义扩展
 *
 * @author neo
 * 2019/1/25 2:36 PM
 */
public class MyBeforeEachCallback implements BeforeEachCallback {

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		System.out.println("开始测试" + context.getDisplayName());
	}
}

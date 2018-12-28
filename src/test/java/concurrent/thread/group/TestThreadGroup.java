package concurrent.thread.group;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 测试ThreadGroup
 *
 * @author neo
 * @create 2018/9/5 下午5:22
 */
public class TestThreadGroup {

	@BeforeEach
	public void setup(){

	}

	@Test
	public void testDefaultGroup(){
		Thread parent = Thread.currentThread();
		ThreadGroup g = null;
		SecurityManager security = System.getSecurityManager();
		if (security != null) {
			g = security.getThreadGroup();
		}
		if (g == null) {
			g = parent.getThreadGroup();
		}
		System.out.println(g);
	}

	@AfterEach
	public void teardown(){

	}
}

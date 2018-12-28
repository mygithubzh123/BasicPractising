package concurrent.executor.ThreadPoolExecutor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * 测试ThreadPoolExecutor的前后切面方法
 *
 * @author neo
 * 2018/9/26 4:43 PM
 */
public class TestExecutorAspect {

	ExecutorService executor;

	CountDownLatch latch ;

	@BeforeEach
	public void setup(){
		executor = new MyThreadPoolExecutor(1, 1,
				0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
		latch = new CountDownLatch(1);
	}

	@Test
	public void testUp() throws InterruptedException {
		executor.execute(new RunnableA());
		latch.await();
	}

}

class MyThreadPoolExecutor extends ThreadPoolExecutor{

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("execute "+r.toString());
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.out.println("execute "+r.toString());
	}
}
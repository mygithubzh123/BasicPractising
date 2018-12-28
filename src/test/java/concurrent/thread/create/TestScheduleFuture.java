package concurrent.thread.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class TestScheduleFuture {
	
	private ExecutorService executor;
	
	@BeforeEach
	public void setup(){
		executor = Executors.newCachedThreadPool();
	}
	
	@Test
	public void testCyclicFuture(){
		executor.execute(new CyclicFutureRunnable());
	}
}

class CyclicFutureRunnable implements Runnable {

	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	@Override
	public void run() {
		RunnableScheduledFuture<String> future = (RunnableScheduledFuture<String>)executor.schedule(new Callable<String>() {
			@Override
			public String call() {
				System.out.println("calling-------------");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("call over");
				return System.currentTimeMillis() + "";
			}
		}, 2, TimeUnit.SECONDS);
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				future.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

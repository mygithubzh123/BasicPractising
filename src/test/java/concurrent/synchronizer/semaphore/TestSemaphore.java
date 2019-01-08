package concurrent.synchronizer.semaphore;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 测试信号量
 *
 * @author liaofeng
 * 2019/1/8 11:08 AM
 */
public class TestSemaphore {

	private ExecutorService executorService = Executors.newCachedThreadPool();

	private static List<Worker> workerList;

	@BeforeAll
	static void setup(){
		workerList = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			workerList.add(new Worker(i+1));
		}
	}

	@Test
	void test() {
		workerList.forEach(e -> executorService.execute(new PrintTask(e)));
	}

	@AfterAll
	static void tearDown() throws InterruptedException {
		TimeUnit.MINUTES.sleep(10);
	}

}

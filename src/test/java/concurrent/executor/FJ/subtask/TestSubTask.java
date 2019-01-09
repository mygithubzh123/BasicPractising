package concurrent.executor.FJ.subtask;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 测试分任务
 *
 * @author liaofeng
 * 2019/1/9 12:24 PM
 */
public class TestSubTask {

	private List<Task> tasks;

	private ForkJoinPool pool = new ForkJoinPool();

	private ExecutorService executorService = Executors.newCachedThreadPool();

	@BeforeEach
	void setup(){
		tasks = new ArrayList<>(1000);
		for (int i = 0; i < 1000; i++) {
			tasks.add(new Task(i+1));
		}
	}

	@Test
	void testExecute() throws ExecutionException, InterruptedException {
		long a = System.currentTimeMillis();
		TaskRunner runner = new TaskRunner(tasks);
		Future<List<String>> future = executorService.submit(runner);
		System.out.println(future.get());
		long b = System.currentTimeMillis();
		System.out.println("time:"+(b-a));
	}

	@Test
	void testForkJoin() throws InterruptedException, ExecutionException {
		long a = System.currentTimeMillis();
		TaskHandler handler = new TaskHandler(tasks);
		pool.execute(handler);
		List<String> results = handler.get();
		long b = System.currentTimeMillis();
		System.out.println("time:"+(b-a));
		System.out.println(results);
	}

	@AfterAll
	static void testDown(){
		try {
			TimeUnit.MINUTES.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

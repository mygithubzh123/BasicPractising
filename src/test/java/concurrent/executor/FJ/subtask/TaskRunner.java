package concurrent.executor.FJ.subtask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 线程执行器
 *
 * @author liaofeng
 * 2019/1/9 3:03 PM
 */
public class TaskRunner implements Callable<List<String>> {

	private List<Task> tasks;

	public TaskRunner(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public List<String> call() {
		List<String> a = new ArrayList<>();
		tasks.forEach(e -> a.add(e.doit()));
		return a;
	}
}

package concurrent.executor.FJ.subtask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * 任务处理器
 *
 * @author liaofeng
 * 2019/1/9 12:19 PM
 */
public class TaskHandler extends RecursiveTask<List<String>> {

	private List<Task> tasks;

	public TaskHandler(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	protected List<String> compute() {
		List<TaskHandler> taskHandlers = new ArrayList<>();
		List<String> results = new ArrayList<>();
		int size = tasks.size() ;
		int currentSize;
		if(size > 5){
			TaskHandler handler = new TaskHandler(tasks.subList(5,size));
			handler.fork();
			taskHandlers.add(handler);
			currentSize = 5;
		} else {
			currentSize = size;
		}
		for (int i = 0; i < currentSize; i++) {
			results.add(tasks.get(i).doit());
		}
		for(TaskHandler handler:taskHandlers){
			results.addAll(handler.join());
		}
		return results;
	}
}

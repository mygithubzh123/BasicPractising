package concurrent.executor.FJ;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class TestFJPool {

	public static final String FOLDER = "/Users/neo/Documents/develop/greattimes/产品文档/NPDS";

	public static final String EXTENSION = "doc";

	@Test
	public void test() {
		ForkJoinPool pool = new ForkJoinPool();
		FolderProcessor system = new FolderProcessor(FOLDER, EXTENSION);
		pool.execute(system);
		do {
			System.out.printf("******************************************\n");
			System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
			System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
			System.out.printf("******************************************\n");
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!system.isDone());
		pool.shutdown();
		List<String> results;
		results = system.join();
		System.out.printf("System: %d files found.\n", results.size());
	}

}

class FolderProcessor extends RecursiveTask<List<String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4449553765639527182L;

	private String path;

	private String extension;

	public FolderProcessor(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}

	@Override
	protected List<String> compute() {
		List<String> list = new ArrayList<>();
		List<FolderProcessor> tasks = new ArrayList<>();
		File file = new File(path);
		File content[] = file.listFiles();
		if (content != null) {
			for (int i = 0; i < content.length; i++) {
				if (content[i].isDirectory()) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					FolderProcessor task=new FolderProcessor(content[i].getAbsolutePath(), extension);
					task.fork();
					tasks.add(task);
				} else {
					if (checkFile(content[i].getName())){
						list.add(content[i].getAbsolutePath());
					}
				}
			}
			if (tasks.size()>50) {
				System.out.printf("%s: %d tasks ran.\n",file.getAbsolutePath(),tasks.size());
			}
			addResultsFromTasks(list,tasks);
		}
		return list;
	}

	private void addResultsFromTasks(List<String> list,List<FolderProcessor> tasks) {
		for (FolderProcessor item: tasks) {
			list.addAll(item.join());
		}
	}
	
	private boolean checkFile(String name) {
		return name.endsWith(extension);
	}

}

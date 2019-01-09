package concurrent.executor.FJ.subtask;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 任务
 *
 * @author neo
 * 2019/1/9 12:18 PM
 */
public class Task {

	private int id;

	public Task(int id) {
		this.id = id;
	}

	public String doit(){
		Random r = new Random();
		int timeout = r.nextInt(10)+10;
		try {
			TimeUnit.MILLISECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" do task "+id);
		return String.valueOf(timeout);
	}
}

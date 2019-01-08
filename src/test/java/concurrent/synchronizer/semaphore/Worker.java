package concurrent.synchronizer.semaphore;

/**
 * 员工
 *
 * @author neo
 * 2019/1/8 11:15 AM
 */
public class Worker {

	private int id;

	public Worker(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Worker{" +
				"id=" + id +
				'}';
	}
}

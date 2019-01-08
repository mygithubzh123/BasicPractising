package concurrent.synchronizer.semaphore;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 打印机
 *
 * @author liaofeng
 * 2019/1/8 11:09 AM
 */
public class Printer {

	private int id;

	public Printer(int id) {
		this.id = id;
	}

	public void print() throws InterruptedException {
		Random r = new Random();
		int time = r.nextInt(10) + 1;
		TimeUnit.SECONDS.sleep(time);
		System.out.println("printer "+id+" print for time :"+time);
	}

	@Override
	public String toString() {
		return "Printer{" +
				"id=" + id +
				'}';
	}
}

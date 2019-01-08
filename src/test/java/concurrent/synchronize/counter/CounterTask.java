package concurrent.synchronize.counter;

import java.util.concurrent.TimeUnit;

/**
 * @author liaofeng
 * 2019/1/8 5:44 PM
 */
public class CounterTask implements Runnable{

	private Counter counter;

	public CounterTask(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		while(true){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter.count();
		}
	}
}

package concurrent.synchronizer.cylicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 红军
 *
 * @author liaofeng
 * 2019/1/8 12:05 PM
 */
public class RedArmy implements Runnable {

	private int index;

	private CyclicBarrier barrier;

	public RedArmy(int index,CyclicBarrier barrier) {
		this.index = index;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		Random r = new Random();
		int time = r.nextInt(10)+1;
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(toString()+"到达遵义会师...");
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(toString()+"向延安出发...");
	}

	@Override
	public String toString() {
		return "红【" + index +
				"】军";
	}
}

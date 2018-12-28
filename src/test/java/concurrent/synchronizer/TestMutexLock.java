package concurrent.synchronizer;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMutexLock {

	ExecutorService executor = Executors.newCachedThreadPool();

	CountDownLatch latch = new CountDownLatch(1);

	@Test
	public void test() throws Exception {
		Lock lock = new ReentrantLock();
		Task et = new Task(lock, 1_000);
		Task et2 = new Task(lock, 1_000);
		executor.execute(et);
		executor.execute(et2);
		latch.await();
	}
}

class MutexLock {
	
	private Sync sync = new Sync();
	
	public void lock(){
		sync.acquire(1);
	}

	class Sync extends AbstractQueuedSynchronizer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1568219394266916565L;

		@Override
		protected boolean tryAcquire(int arg) {
			int state = getState();
			if (state == 0) {
				state = 1;
				return true;
			} else {
				return false;
			}
		}

		@Override
		protected boolean tryRelease(int arg) {
			int state = getState();
			if (state == 1) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		protected boolean isHeldExclusively() {
			if (getState() != 0) {
				return true;
			} else {
				return false;
			}
		}
	}

}
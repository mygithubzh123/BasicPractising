package concurrent.executor.ScheduleThreadExecutor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.*;

/**
 *   (用一句话描述该文件做什么)
 * @Filename TestScheduler.java
 * @Package 
 * @author neo
 * @since 2016年3月18日 上午11:27:57
 * @Version V1.0
 */

/**
 *   (这里用一句话描述这个类的作用)
 *    TestScheduler
 * @author neo
 * @since 2016年3月18日 上午11:27:57
 */
public class TestScheduler {

	ScheduledThreadPoolExecutor executor;

	@BeforeEach
	public void setup(){
		executor = new ScheduledThreadPoolExecutor(1);
	}

	@Test
	public void testSchedule() throws InterruptedException,ExecutionException {
		ScheduledFuture<String> future1 = executor.schedule(new Task1(), 5,TimeUnit.SECONDS);
		System.out.println(future1.getDelay(TimeUnit.SECONDS));
		System.out.println(future1.get());
		System.out.println(future1.isDone());
	}

	@Test
	public void testScheduleAtFixRate(){
		Runnable a = new Runnable1();
		ScheduledFuture<?> future2  = executor.scheduleAtFixedRate(a,0,8,TimeUnit.SECONDS);
		while(true){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(future2.isDone());
		}
	}

}
class Task1 implements Callable<String> {  
    
    @Override  
    public String call() throws Exception {  
        return "Task1 running: " + new Date()  ;
    }  
}
class Runnable1 implements Runnable{

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("sleep over"+new Date());

	}
}
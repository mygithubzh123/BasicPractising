package concurrent.thread.create;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestRunnable {
	
	@Test
	public void testCreate(){
		//构造器新建
		Runnable a = new RunnableA();
		//匿名内部类新建
		Runnable b = new Runnable() {
			@Override
			public void run() {
				//do something
			}
		};
		//函数式接口新建
		Runnable c = () -> {
			//do something
		};
		System.out.println(a.getClass().getName());//...RunnableA
		System.out.println(b.getClass().getName());//...TestRunnable$1
		System.out.println(c.getClass().getName());//...TestRunnable$$Lambda$2/1066376662
	}

	@Test
	public void testUse() throws InterruptedException, ExecutionException{
		//Runnable实例
		new Thread(new RunnableA()).start();
		//Runnable 是函数接口
		new Thread(() -> {
			System.out.println("I am a new runnable");
		}).start();
		//调度器调度任务
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new RunnableA());
		
		//调度器提交任务
		Future<?> future = executor.submit(new DelayedRunnable());
		System.out.println("调度结果:"+future.get());
	}
}
class RunnableA implements Runnable{

	@Override
	public void run() {
		System.out.println("I am RunnableA");
	}
}
class DelayedRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("DelayedRunnable run in...");
		long a = System.currentTimeMillis();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long b = System.currentTimeMillis();
		System.out.println("DelayedRunnable run out after "+ (b-a)/1000 +" sec");
	}
	
}
package concurrent.thread.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *   (这里用一句话描述这个类的作用)
 *    Test
 * @author neo
 * @since 2016年3月7日 下午3:26:15
 */
public class TestFuture {
	
	private ExecutorService executor;
	
	@BeforeEach
	public void setup(){
		executor = Executors.newCachedThreadPool();
	}
	
	@Test
	public void testCreate() throws Exception{
		Future<String> fa = executor.submit(new CallableA());
		Future<?> fb = executor.submit(new RunnableA());
		Future<String> fc = executor.submit(new RunnableA(), "fail");
		System.out.println("fb:"+fb.getClass().getName());
		System.out.println(fa.get());
		System.out.println(fb.get());
		System.out.println(fc.get());
	}
	
	@Test
	public void testBatchFuture()throws Exception{
		Collection<Callable<String>> ccs = new ArrayList<>();
		ccs.add(new CallableA());
		ccs.add(new CallableA());
		ccs.add(new CallableA());
		List<Future<String>> fs = executor.invokeAll(ccs);
		for(Future<String> e:fs){
			if(e.isDone()){
				System.out.println(e.get());
			}
		}
	}
	
	@Test
	public void testGet(){
		Future<String> f = executor.submit(new InterruptableCallable());
		try{
			System.out.println("result:"+f.get());	
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCancle(){
		Future<?> f = executor.submit(new InterruptableRunnable());
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(!f.isDone()){
			//f.cancel(true);
			f.cancel(false);
		}
		try{
			System.out.println("result:"+f.get());	
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
class InterruptableRunnable implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(10_000);
			System.out.println("sleeping was over");
		} catch (InterruptedException e) {
			System.out.println("sleeping was interruptted");
		}
	}
}
class InterruptableCallable implements Callable<String>{

	@Override
	public String call() {
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "success";
	}
}
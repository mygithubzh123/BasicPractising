package concurrent.executor.ThreadPoolExecutor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutor {

	ExecutorService executor;
	
	CountDownLatch latch ;
	
	@BeforeEach
	public void setup(){
		executor = Executors.newSingleThreadExecutor();
		latch = new CountDownLatch(1);
	}
	
	@Test
	public void testUp(){
		executor.execute(new RunnableA());

	}

	@Test
	public void testInvokeAll(){
		List<Callable<String>> list = new ArrayList<>();
		Callable<String> a = new CallableA();
		Callable<String> b = new CallableA();
		Callable<String> c = new CallableA();
		list.add(a);
		list.add(b);
		list.add(c);
		try {
			executor.invokeAll(list);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterEach
	public void tearDown(){
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class RunnableA implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(1000*10);
			System.out.println("sleep out");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class CallableA implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "success";
	}

}
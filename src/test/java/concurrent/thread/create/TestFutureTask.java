package concurrent.thread.create;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestFutureTask {
	
	ExecutorService executor;
	
	@BeforeEach
	public void setup(){
		executor  = Executors.newCachedThreadPool();
	}
	
	@Test
	public void testFutureTask() throws InterruptedException, ExecutionException{
		FutureTask<String> ft = new FutureTask<>(new CallableA());
		executor.submit(ft);
		System.out.println(ft.get());
		ft.run();
	}
}

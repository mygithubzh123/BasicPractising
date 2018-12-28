package concurrent.atimic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicObject {
	
	ExecutorService executor;
	
	@BeforeEach
	public void setup(){
		executor = Executors.newFixedThreadPool(5);
	}
	
	@Test
	public void testatomic(){
		executor.execute(new Punch2Go());
		executor.execute(new Punch2Go());
		while(true){
			System.out.println(Punch2Go.count.get());
		}
	}
	
	@AfterEach
	public void teardown(){

	}
}
class Punch2Go implements Runnable{

	static AtomicInteger count = new AtomicInteger(0);
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count.incrementAndGet();
		}
	}
}
package concurrent.thread.attribute;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadLock {
	
	ExecutorService executor;
	
	@BeforeEach
	public void setup(){
		executor = Executors.newFixedThreadPool(5);
	}
	
	@Test
	public void test(){
		Schronizer s = new Schronizer();
		RunnableA ea = new RunnableA(s);
		executor.execute(ea);
		while(true){
			System.out.println(ea.helsLock());
			try {
				Thread.sleep(1_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class RunnableA implements Runnable{
	
	Schronizer s;
	
	public RunnableA(Schronizer s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		synchronized(s){
			System.out.println(Thread.holdsLock(s));
			s.sleeps();
		}
	}
	
	public boolean helsLock(){
		return Thread.holdsLock(s);
	}
}
class Schronizer {
	
	public void sleeps(){
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
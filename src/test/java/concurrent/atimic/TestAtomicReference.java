package concurrent.atimic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {
	
	ExecutorService executor;
	
	@BeforeEach
	public void setup(){
		executor = Executors.newFixedThreadPool(5);
	}

	@Test
	public void test(){
		RunnableA.arc.set(new Counter());
		executor.execute(new RunnableA());
		executor.execute(new RunnableA());
		while(true){
			System.out.println(RunnableA.arc.get().getCont());
		}
	}
}
class RunnableA implements Runnable{
	
	static AtomicReference<Counter> arc = new AtomicReference<>();

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			arc.getAndUpdate((Counter e) -> {e.setCont(e.getCont()+1);return e;});
		}
	}
}
class Counter{
	
	int cont;

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
	
}
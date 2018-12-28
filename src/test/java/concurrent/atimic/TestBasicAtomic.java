package concurrent.atimic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestBasicAtomic {

	@Test
	public void testLazySet(){
		AtomicInteger at = new AtomicInteger(0);
		at.set(1);
		at.set(2);
		at.set(3);
		at.lazySet(0);
		System.out.println(at.get());
	}
}

package concurrent.executor.CompleteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * 测试完成任务服务
 *
 * @author neo
 * 2018/9/17 下午6:31
 */
public class TestCompleteService {

	private ExecutorService es;

	private ExecutorCompletionService ecs;

	@BeforeEach
	public void setup(){
		es = Executors.newCachedThreadPool();
		ecs = new ExecutorCompletionService(es);
	}

	@Test
	public void test() throws Exception {
		Callable<String> a = new CallableB("abc");
		ecs.submit(a);
		TimeUnit.SECONDS.sleep(1);
		Callable<String> b = new CallableB("bbc");
		ecs.submit(b);
		TimeUnit.SECONDS.sleep(1);
		Callable<String> c = new CallableB("cbc");
		ecs.submit(c);
		TimeUnit.SECONDS.sleep(1);
		while(true){
			Future<String> f= ecs.poll();
			if(f != null){
				System.out.println("get:"+f.get());
			} else {
				System.out.println("not get");
			}
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
class CallableB implements Callable<String>{

	private String name;

	public CallableB(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(10);
		return name;
	}
}
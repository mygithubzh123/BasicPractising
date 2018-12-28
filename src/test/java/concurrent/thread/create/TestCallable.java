/**
*   (用一句话描述该文件做什么)
* @Filename TestCallable.java
* @Package concurrent.callable
* @author neo
* @since 2018年3月13日 下午4:01:37
* @Version V1.0
*/
package concurrent.thread.create;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestCallable
 * @author neo
 * @since 2018年3月13日 下午4:01:37
 */
public class TestCallable {
	
	@Test
	public void testCreate(){
		//构造函数
		Callable<String> ca = new CallableA();
		Callable<Integer> cb = new DelayedCallable();
		//匿名内部类
		Callable<String> cc = new Callable<String>(){
			@Override
			public String call() throws Exception {
				return "success";
			}
		};
		//函数式声明
		Callable<String> cd = () -> "success";
		System.out.println(ca.getClass());//...CallableA
		System.out.println(cb.getClass());//...DelayedCallable
		System.out.println(cc.getClass());//...TestCallable$1
		System.out.println(cd.getClass());//...TestCallable$$Lambda$1/245565335
	}

	@Test
	public void testUse()throws Exception{
		ExecutorService executor = Executors.newCachedThreadPool();
		Callable<Integer> tc = new DelayedCallable();
		Future<Integer> f = executor.submit(tc);
		System.out.println("异步提交任务等待结果返回...");
		System.out.println("取得返回结果:"+f.get());
	}

	@Test
	public void testCallVoid()throws Exception{
		Callable a = new CallableB();
		ExecutorService executor = Executors.newCachedThreadPool();
		Future f = executor.submit(a);
		System.out.println(f.get());


	}
}


class CallableA implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "success";
	}
	
}

class DelayedCallable implements Callable<Integer>{
	
	@Override
	public Integer call() throws Exception {
		System.out.println("进行计算任务【1+1= ?】");
		Thread.sleep(5_000);
		System.out.println("计算完毕,返回结果,耗时5s");
		return 2;
	}

}
class CallableB implements Callable<Void>{

	@Override
	public Void call() throws Exception {
		return null;
	}
}

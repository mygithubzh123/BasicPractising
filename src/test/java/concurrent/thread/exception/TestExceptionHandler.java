package concurrent.thread.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.reflect.Reflection;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * TestExceptionHandler
 * @author neo
 * @since 2018年3月13日 上午10:19:32
 */
public class TestExceptionHandler {
	
	Task1 t;
	
	Thread th;
	
	@BeforeEach
	public void setup(){
		t = new Task1();
		th = new Thread(t);
	}

	/**
	 * 线程不允许抛出已检查异常
	 * 如果run方法逻辑里面抛出未检查异常，那么线程将终止
	 * 
	 * 运行时出现未检查异常时，寻找UncaughtExceptionHandler来处理异常
	 * 
	 * 设置UncaughtExceptionHandler
	 * 	1,为线程设置单独UncaughtExceptionHandler
	 * 	2,Thread的静态方法setDefaultUncaughtExceptionHandler为所有线程都提供一个默认的方法
	 * 
	 */
	@Test	
	public void test()throws Exception{
		//Thread中检测到handler,执行此handler的uncaughtException方法而不执行ThreadGroup中的方法
		th.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		th.start();
	}
	
	/**
	 * 异常处理器中抛出的throwable会被执行默认行为-输出system.err
	 * @throws Exception
	 */
	@Test	
	public void testError()throws Exception{
		th.setUncaughtExceptionHandler(new ErrorUncaughtExceptionHandler());
		th.start();
	}
	
	@Test	
	public void testError2()throws Exception{
		Thread.setDefaultUncaughtExceptionHandler(new ErrorUncaughtExceptionHandler());
		th.start();
	}
	
	public static void main(String[] args) {
		Task1 t = new Task1();
		Thread th = new Thread(t);
		th.setUncaughtExceptionHandler(new ErrorUncaughtExceptionHandler());
		//Thread.setDefaultUncaughtExceptionHandler(new ErrorUncaughtExceptionHandler());
		th.start();
	}
}
class Task1 implements Runnable{

	@Override
	public void run() {
		System.out.println("run...");
		int[] a = {1};
		System.out.println(a[3]);
		System.out.println("abc");
	}
	
}
class MyUncaughtExceptionHandler implements UncaughtExceptionHandler{
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("deal "+e +" for thread "+t.getId());
	}
}
class ErrorUncaughtExceptionHandler implements UncaughtExceptionHandler{
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		Class<?> clazz = Reflection.getCallerClass();
		if(clazz != null){
			System.out.println("caller:"+clazz);
		}
		throw new RuntimeException("i am a runtime exception");
	}
}
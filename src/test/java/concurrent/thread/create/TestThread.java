package concurrent.thread.create;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TestThread {
	
	@Test
	public void testCreate(){
		//new Thread对象
		Thread a = new ThreadA();
		//匿名内部类
		Thread b = new Thread(){

			@Override
			public void run() {
				//do something
			}
		};
		//用Runnable 来实例化Thread
		//1
		Thread c = new Thread(new RunnableA());
		//2
		Thread d = new Thread(() -> {
			//do something
		});
		
		//用线程工厂实例化
		//1
		ThreadFactory tf = Executors.defaultThreadFactory();
		Thread e = tf.newThread(new RunnableA());
		//2-自定义线程工厂
		ThreadFactory ctf = new MyDefaultThreadFactory("MyThread",false);
		Thread f = ctf.newThread(new RunnableA());
		
		//自定义toString方法
		System.out.println(a);//Thread[Thread-0,5,main]
		System.out.println(b);//Thread[Thread-1,5,main]
		System.out.println(c);//Thread[Thread-2,5,main]
		System.out.println(d);//Thread[Thread-3,5,main]
		System.out.println(e);//Thread[pool-1-thread-1,5,main]
		System.out.println(f);//Thread[MyThread,5,main]
		
		
		System.out.println(a.getClass().getName());//concurrent.thread.create.ThreadA
		System.out.println(b.getClass().getName());//concurrent.thread.create.TestThread$1
		System.out.println(c.getClass().getName());//java.lang.Thread
		System.out.println(d.getClass().getName());//java.lang.Thread
		System.out.println(e.getClass().getName());//java.lang.Thread
		System.out.println(f.getClass().getName());//java.lang.Thread
	}

	@Test
	public void testMethod() {
		//主动调用run方法,就自身而言是个成员方法
		new ThreadA().run();
		//JVM调用run方法
		new ThreadA().start();
	}
	

	
}
class ThreadA extends Thread{

	@Override
	public void run() {
		System.out.println("I am thread A");
	}
}
class MyDefaultThreadFactory implements ThreadFactory {

	   private String threadName;
	   private boolean daemon;

	   public MyDefaultThreadFactory(String threadName, boolean daemon) {
	      this.threadName = threadName;
	      this.daemon = daemon;
	   }

	   @Override
	   public Thread newThread(Runnable r) {
	      Thread thread = new Thread(r, threadName);
	      thread.setDaemon(daemon);
	      return thread;
	   }
	}
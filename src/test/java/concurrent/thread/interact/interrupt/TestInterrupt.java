package concurrent.thread.interact.interrupt;

import org.junit.jupiter.api.Test;

public class TestInterrupt {

	/**
	 * 线程应该由自己控制中断或者停止
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testControl(){
		Thread a = new Thread();
		a.stop();
		a.suspend();
		a.resume();
		/**
		 * 不是直接中断线程,而是通知线程该中断
		 * 一般都是直接中断
		 * 正常状态	中断标志设为true,程序继续运行
		 * sleep,wait,join等阻塞方法 ,退出阻塞状态,上报InterruptException由被打断线程自行实现控制逻辑决定是否中断
		 */
		a.interrupt();
	}
}
class ThreadA extends Thread{

	boolean isRunning = true;
	
	@Override
	public void run() {
		while(isRunning){
			//1, 结束线程
			if(Thread.currentThread().isInterrupted()){
				System.out.println("收到中断请求,结束线程");
				isRunning = false;
				//资源回收
			}
			//2,继续线程，清楚中断标记，方便下次检测
			if(Thread.interrupted()){
				System.out.println("收到中断请求,记录日志,继续检测...");
			}
		}
	}
	
}
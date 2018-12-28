/**
*   (用一句话描述该文件做什么)
* @Filename TestConcurrent.java
* @Package java8.concurrent
* @author neo
* @since 2017年7月21日 下午4:14:07
* @Version V1.0
*/
package lang.jdk8.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestConcurrent
 * @author neo
 * @since 2017年7月21日 下午4:14:07
 */
public class TestConcurrent {
	
	static Map<String,AtomicLong> map = new ConcurrentHashMap<>();
	
	static ExecutorService executor = Executors.newCachedThreadPool();
	
	public static void main(String[] args) throws InterruptedException {
		executor.execute(new AddHandler());
		Thread.sleep(4100);
		executor.execute(new AddHandler());
		executor.execute(new AddHandler());
	}
}
class AddHandler implements Runnable{

	@Override
	public void run() {
		while(true){
			if(TestConcurrent.map.containsKey("a")){
				TestConcurrent.map.get("a").getAndIncrement();
			} else {
				TestConcurrent.map.put("a", new AtomicLong(1));
			}
			System.out.println(TestConcurrent.map);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

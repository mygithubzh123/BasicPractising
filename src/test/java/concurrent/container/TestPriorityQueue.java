/**
*   (用一句话描述该文件做什么)
* @Filename TestPriorityQueue.java
* @Package collection.queue
* @author neo
* @since 2018年3月9日 上午10:26:50
* @Version V1.0
*/
package concurrent.container;

import org.junit.jupiter.api.Test;

import java.util.concurrent.PriorityBlockingQueue;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestPriorityQueue
 * @author neo
 * @since 2018年3月9日 上午10:26:50
 */
public class TestPriorityQueue {
	
	@Test
	public void testNew()throws Exception{
		PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>();
		queue.add("abc");
		queue.add("1");
		queue.add("ccc");
		System.out.println("abc".compareTo("1") < 0 ? "abc".compareTo("ccc") <0?"abc":"ccc":"1".compareTo("ccc") <0 ? "1":"ccc");
		System.out.println(queue.take());
	}
	
	
	/**
	 * 添加元素时，只保证前一半的 优先级顺序
	 * 新添加元素只要大于中位元素，就放置到最末尾
	 * 
	 * 取元素时，从队列顶端开始取
	 */
	@Test
	public void testComparable()throws Exception{
		PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
		for(int i = 1;i<101;i++){
			queue.add(i);
		}
		System.out.println(queue);
		queue.add(80);
		System.out.println(queue);
		queue.add(90);
		System.out.println(queue);
		queue.add(95);
		System.out.println(queue);
		queue.add(96);
		System.out.println(queue);
		
		
		System.out.println(queue);
		System.out.println(queue.take());
		System.out.println(queue);
		System.out.println(queue.element());
		System.out.println(queue);
		
	}

}

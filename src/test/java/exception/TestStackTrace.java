/**
  *   (用一句话描述该文件做什么)
* @Filename TestStackTrace.java
* @Package exception
* @author neo
* @since 2018年3月8日 上午9:22:02
* @Version V1.0
*/
package exception;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestStackTrace
 * @author neo
 * @since 2018年3月8日 上午9:22:02
 */
public class TestStackTrace {

	@Test
	public void test()throws Exception{
		try{
			throw new Exception();
		} catch(Exception e){
			e.printStackTrace();
			StackTraceElement[] a = e.getStackTrace();
			Arrays.asList(a).stream().forEach(f -> printStack(f));
		}
	}
	
	@Test
	public void testAllStack()throws Exception{
		Map<Thread,StackTraceElement[]> threadTrace = Thread.getAllStackTraces();
		Arrays.asList(threadTrace.get(Thread.currentThread())).stream().forEach(f -> printStack(f));
	}
	
	public static void printStack(StackTraceElement f){
		System.out.println("\t"+"at "+f.getClassName()+"."+f.getMethodName()+"("+f.getFileName()+":"+f.getLineNumber()+")");	
	}
}

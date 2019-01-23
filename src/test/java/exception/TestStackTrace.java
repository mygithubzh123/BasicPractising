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
			Arrays.asList(a).forEach(TestStackTrace::printStack);
		}
	}
	
	@Test
	void testAllStack(){
		Map<Thread,StackTraceElement[]> threadTrace = Thread.getAllStackTraces();
		Arrays.stream(threadTrace.get(Thread.currentThread())).forEach(TestStackTrace::printStack);
	}
	
	private static void printStack(StackTraceElement f){
		System.out.println("\t"+"at "+f.getClassName()+"."+f.getMethodName()+"("+f.getFileName()+":"+f.getLineNumber()+")");	
	}

	@Test
	void testStackElement() {
		StackTraceElement stackTraceElement = new StackTraceElement("", "", null, Integer.MIN_VALUE);
		System.out.println(stackTraceElement);
	}
}

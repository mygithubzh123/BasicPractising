package bytebuffer;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

public class TestDirectMemory {
	public static void main(String[] args) throws Exception {
		ByteBuffer a = ByteBuffer.allocateDirect(1024);
		System.out.println(a);
	    System.out.println(sun.misc.VM.maxDirectMemory());  
        Class<?> c = Class.forName("java.nio.Bits");  
        Field maxMemory = c.getDeclaredField("maxMemory");  
        maxMemory.setAccessible(true);  
        synchronized (c) {  
            Long maxMemoryValue = (Long)maxMemory.get(null);  
            System.out.println("maxMemoryValue:"+maxMemoryValue);  
        }  
	}
}

package system;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

public class TestSystemTools {

	@Test
	public void testSystemIO(){
		InputStream is = System.in;
		OutputStream os = System.out;
		OutputStream es = System.err;
		System.out.println(is);
		System.out.println(os);
		System.out.println(es);
	}
	

	
	@Test
	public void testSystemMethod(){
//		String str = "abcd";
//		System.out.println(System.identityHashCode(str));
//		System.out.println(str.hashCode());
		
		Object obj = new Object();
		System.out.println(obj.hashCode());
		System.out.println(System.identityHashCode(obj));
		
		System.out.println(System.getSecurityManager());
		System.out.println(System.mapLibraryName("zip"));
		
	}
	
}

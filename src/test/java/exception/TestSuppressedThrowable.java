package exception;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 测试压制的异常
 *
 * @author neo
 * 2019/1/23 12:25 PM
 */
public class TestSuppressedThrowable {

	@Test
	void test() {
		try {
			testTraditionalTryCatchWithExceptionOnFinally();
		} catch (IOException e) {
			Throwable[] suppressed = e.getSuppressed();
			for (Throwable t : suppressed) {
				// Check T's type and decide on action to be taken
				t.printStackTrace();
			}
		}
	}

	public void testTraditionalTryCatchWithExceptionOnFinally() throws IOException{
		try (OutputStream os = new SampleStream()) {
			os.write(0); //抛出IOWriteException
		}
		//隐藏的os.close执行时报异常 close error，但是不会直接向上传递，而是放入压制的异常中
	}
}
class SampleStream extends OutputStream{

	@Override
	public void write(int b) throws IOException {
		throw new IOException(){
			@Override
			public String getMessage() {
				return "write error";
			}
		};
	}

	@Override
	public void close() throws IOException {
		throw new IOException(){
			@Override
			public String getMessage() {
				return "close error";
			}
		};
	}
}
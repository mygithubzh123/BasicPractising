package lang.jdk7;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestTryResource
 * @author neo
 * @since 2017年5月11日 下午12:35:55
 */
public class TestTryResource {

	@Test
	public void test() throws IOException {
		try(FileInputStream fileInput = new FileInputStream("C:\\Users\\lf\\Desktop\\07465961.pcap")){
			System.out.println(fileInput.read());
		}
	}
}

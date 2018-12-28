package nio.bio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestBufferStream
 * @author neo
 * @since 2018年4月8日 下午5:03:48
 */
public class TestBufferStream {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\neo\\Desktop\\75.pcap"))){
			System.out.println(bis.read());
		}
	}
}

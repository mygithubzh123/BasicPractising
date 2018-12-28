package bytebuffer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class TestBuffer {

	ByteBuffer bytebuf = ByteBuffer.allocate(100);
	
	@BeforeEach
	public void setup(){
		bytebuf.put((byte)1);
		bytebuf.put((byte)1);
		bytebuf.put((byte)1);
	}
	
	@Test
	public void test(){
		System.out.println(Arrays.toString(bytebuf.array()));
		bytebuf.rewind();
		ByteBuffer buf = bytebuf.compact();
		System.out.println(Arrays.toString(buf.array()));
	}
}

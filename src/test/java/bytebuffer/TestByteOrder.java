package bytebuffer;

import java.nio.ByteOrder;


public class TestByteOrder {
	public static void main(String[] args) {
		ByteOrder bo = ByteOrder.BIG_ENDIAN;
		System.out.println(bo);
		System.out.println(ByteOrder.nativeOrder().toString());
	}
	
	
}

package bytebuffer;

public class JVMEndianTest {
    
    public static void main(String[] args) {
         
//        int x = 0x01020304;
//        System.out.println(Integer.toHexString(x));
//         
//        ByteBuffer bb = ByteBuffer.wrap(new byte[4]);
//        bb.asIntBuffer().put(x);
//        //bb.asLongBuffer()
//        String ss_before = Arrays.toString(bb.array());
//         
//        System.out.println("默认字节序 " +  bb.order().toString() +  ","  +  " 内存数据 " +  ss_before);
//         
//        bb.order(ByteOrder.LITTLE_ENDIAN);
//        bb.asIntBuffer().put(x);
//        String ss_after = Arrays.toString(bb.array());
//         
//        System.out.println("修改字节序 " + bb.order().toString() +  ","  +  " 内存数据 " +  ss_after);
//        System.out.println(Integer.valueOf("0x"+"01020304").intValue());
    	  System.out.println(getLongBytes(149672686l));
    	  System.out.println(getLongBytes(4006800136l));
    	  
    }
    
    public static long getLongBytes(long a){
    	return ((a & 0x000000ff) << 24) | ((a & 0x0000ff00) << 8) 
    			| ((a & 0x00ff0000) >> 8) | ((a & 0xff000000) >>24);
    }
}
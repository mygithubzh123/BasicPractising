/**
*   (用一句话描述该文件做什么)
* @Filename TestFileOutPutStream.java
* @Package nio.bio
* @author neo
* @since 2018年4月8日 下午7:08:33
* @Version V1.0
*/
package nio.bio;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestFileOutPutStream
 * @author neo
 * @since 2018年4月8日 下午7:08:33
 */
public class TestPrintStream {
	
	String dirPath = "C:\\Users\\neo\\Desktop\\aaa\\aaa";
	
	/**
	 * FileOutputStream不能打开文件夹
	 */
	@Test
	public void test()throws Exception{
		try(PrintStream ps = new PrintStream(new FileOutputStream(dirPath))){
			ps.print(1);
			ps.print(2);
		}
	}
}

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

import java.io.File;
import java.io.FileOutputStream;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestFileOutPutStream
 * @author neo
 * @since 2018年4月8日 下午7:08:33
 */
public class TestFileStream {
	
	String dirPath = "C:\\Users\\neo\\Desktop\\aaa";
	
	/**
	 * FileOutputStream不能打开文件夹
	 */
	@Test
	public void test()throws Exception{
		try(FileOutputStream fos = new FileOutputStream(dirPath)){
			
		}
	}
	
	/**
	 * FileOutputStream 构造器会生成一个不存在的文件
	 */
	@Test
	public void test2()throws Exception{
		String filePath = dirPath + File.separator + "aaa";
		try(FileOutputStream fos = new FileOutputStream(filePath)){
			
		}
	}
}

/**
*   (用一句话描述该文件做什么)
* @Filename TestZipFile.java
* @Package zip
* @author neo
* @since 2018年3月19日 下午12:17:17
* @Version V1.0
*/
package zip;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import system.PathUtils;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *   (这里用一句话描述这个类的作用)
 *    TestZipFile
 * @author neo
 * @since 2018年3月19日 下午12:17:17
 */
public class TestZipFileSystem {
	
	String folder = null;
	
	@BeforeEach
	public void setup()throws Exception{
		folder = PathUtils.getBasePath()+File.separator+"file"+File.separator+"zip";
		Path a = Paths.get("");
		System.out.println(a);
		System.out.println(String.join("-", "abc"));
	}
	
	@Test
	public void test()throws Exception{
		FileSystem fs = FileSystems.newFileSystem(Paths.get(folder,"out.zip"), null);
		System.out.println(fs.getPath("/a.txt"));
	}

}

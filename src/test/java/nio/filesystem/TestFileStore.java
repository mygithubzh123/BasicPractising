/**
*   (用一句话描述该文件做什么)
* @Filename TestFS.java
* @Package nio.filesystem
* @author neo
* @since 2018年3月30日 上午10:38:54
* @Version V1.0
*/
package nio.filesystem;

import org.junit.jupiter.api.Test;

import java.nio.file.*;
import java.util.Set;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestFS
 * @author neo
 * @since 2018年3月30日 上午10:38:54
 */
public class TestFileStore {
	
	@Test
	public void test()throws Exception{
		for(FileStore fs:FileSystems.getDefault().getFileStores()){
			System.out.println(fs.toString() +" -> "+ fs.type() +" -> "+ fs.getTotalSpace()/1024/1024/1024);
		}
	}
	
	private static final String dir="C:\\Users\\neo\\Desktop\\任务20180413.txt";
	
	@Test
	public void test1()throws Exception{
		FileSystem sf = FileSystems.getDefault();
		Set<String> set = sf.supportedFileAttributeViews();
		set.stream().forEach(e -> System.out.println(e));
		Path p = Paths.get(dir);
		for(String name:set){
			System.out.println(name+":"+Files.getAttribute(p, name));
		}
	}
}

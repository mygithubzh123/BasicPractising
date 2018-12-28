/**
*   (用一句话描述该文件做什么)
* @Filename TestPath.java
* @Package nio
* @author neo
* @since 2017年9月4日 上午11:21:19
* @Version V1.0
*/
package nio.path;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestPath
 * @author neo
 * @since 2017年9月4日 上午11:21:19
 */
public class TestPath {
	
	private static final String FILE_NAME="C:\\Users\\neo\\Desktop\\abc.txt";
	
	private static final String FILE_NAME2="C:\\Program Files (x86)\\QQMailPlugin";
	
	private static final String FILE_NAME3="C:\\abc\\.\\..\\QQMailPlugin";
	
	private static final String FILE_NAME4 = "bbc/./../../abc";

	public static void main(String[] args) throws IOException {
		Path a = Paths.get(FILE_NAME);
		System.out.println("a:"+a);
		System.out.println(a.getFileName());
		//System.out.println(Files.getLastModifiedTime(a).toMillis());
		System.out.println(System.currentTimeMillis());
		
		Path a2 = Paths.get(FILE_NAME2);
		System.out.println("a2:"+a2);
		
		//解析路径
		//绝对路径直接返回，非绝对路径，在路径下新建
		Path b = a.resolve("../../Program Files (x86)\\QQMailPlugin");
		System.out.println("b:"+b);
		System.out.println(b.resolve(FILE_NAME));
		
	
		System.out.println(a);
		Path bs = a.resolveSibling("ddd");
		
		System.out.println("==========================");
		System.out.println(a.resolve("other"));
		
		System.out.println("bs:"+bs);
		
		//获取a到b的相对路径
		Path c = a.relativize(Paths.get(FILE_NAME2));
		System.out.println("c:"+c);


		Path d = Paths.get(FILE_NAME3);
		System.out.println(d.normalize());
				
		Path f = Paths.get(FILE_NAME4);
		System.out.println(f.normalize());
		
	}
	
	@Test
	public void test()throws Exception{
		Path path = Paths.get(FILE_NAME);
		System.out.println(Files.probeContentType(path));
	}
}

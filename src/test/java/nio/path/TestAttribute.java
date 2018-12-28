/**
*   (用一句话描述该文件做什么)
* @Filename TestAttribute.java
* @Package nio.path
* @author neo
* @since 2018年4月3日 下午7:10:10
* @Version V1.0
*/
package nio.path;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestAttribute
 * @author neo
 * @since 2018年4月3日 下午7:10:10
 */
public class TestAttribute {

	Path p = Paths.get("C:\\Users\\neo\\Desktop\\abc");
	
	@Test
	public void test() throws IOException{
		Files.createFile(p, new FileAttribute<String>() {

			@Override
			public String name() {
				return "length";
			}

			@Override
			public String value() {
				return "123";
			}
		});
	}
	
	@Test
	public void test1()throws Exception{
		BasicFileAttributes bfa = Files.readAttributes(p, BasicFileAttributes.class);
		System.out.println(bfa.creationTime());
		
		BasicFileAttributeView bfav = Files.getFileAttributeView(p, BasicFileAttributeView.class);
		System.out.println(bfav);
	}
}

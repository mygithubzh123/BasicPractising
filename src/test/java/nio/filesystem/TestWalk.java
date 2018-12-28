package nio.filesystem;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class TestWalk {

	private static final String dir="F:\\test-files\\com\\0\\merge";
	
	@Test
	public void test() throws IOException{
		Path path = Paths.get(dir);
		Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file.getFileName());
				return super.visitFile(file, attrs);
			}
			
		});
	}
	
	@Test
	public void testJustWalk()throws Exception{
		Path path = Paths.get("C:\\Users\\neo\\Desktop");
		Files.walk(path).forEach(e -> System.out.println(e));
	}
}

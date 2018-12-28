package nio.filesystem;

import org.junit.jupiter.api.Test;

import java.nio.file.FileSystems;

public class TestRootDir {

	@Test
	public void test()throws Exception{
		FileSystems.getDefault().getRootDirectories().forEach(e -> System.out.println(e));
	}
}

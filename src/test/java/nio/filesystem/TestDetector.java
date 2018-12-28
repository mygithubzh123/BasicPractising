package nio.filesystem;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDetector {

	private static final String dir="C:\\Users\\neo\\Desktop\\任务20180413.txt";
	
	@Test
	public void test()throws Exception{
		Path path = Paths.get(dir);
		System.out.println(Files.probeContentType(path));
	}
}

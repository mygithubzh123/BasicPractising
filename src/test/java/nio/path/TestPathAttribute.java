package nio.path;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class TestPathAttribute {

	Path path = Paths.get("C:\\Users\\neo\\Desktop","new.pcap");
	
	@Test
	public void testFileStore()throws Exception{
		System.out.println(Files.getFileStore(path));
	}
	
	@Test
	public void testFileAttributeView()throws Exception{
		BasicFileAttributeView bfav = Files.getFileAttributeView(path, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
		BasicFileAttributes bfa = bfav.readAttributes();
		System.out.println(bfa.creationTime());
	}
	
	@Test
	public void testReadAttributes()throws Exception{
		BasicFileAttributes bfa = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
		System.out.println(bfa.creationTime());
	}
}

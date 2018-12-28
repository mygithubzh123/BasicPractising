package nio.path;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TestLinkPath {

	public static String path = "C:\\Users\\neo\\Desktop\\new.pcap-快捷方式";
	
	public static void main(String[] args) {
		Path a = Paths.get(path);
		System.out.println(a);
		System.out.println(Files.exists(a));
	}
}

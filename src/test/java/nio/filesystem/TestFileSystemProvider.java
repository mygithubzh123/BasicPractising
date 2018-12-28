package nio.filesystem;

import java.nio.file.spi.FileSystemProvider;

public class TestFileSystemProvider {

	public static void main(String[] args) {
		for(FileSystemProvider provider: FileSystemProvider.installedProviders()){
			System.out.println(provider.getScheme() + ":"+provider.toString());
		}
	}
}

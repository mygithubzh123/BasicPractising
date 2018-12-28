/**
*   (用一句话描述该文件做什么)
* @Filename TestFileChannel.java
* @Package nio
* @author neo
* @since 2017年9月1日 下午6:32:42
* @Version V1.0
*/
package nio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestFileChannel
 * @author neo
 * @since 2017年9月1日 下午6:32:42
 */
public class TestFileChannel {

	private static final String FILE_NAME="C:\\Users\\neo\\Desktop\\abc.txt";
	
	private Path path;
	
	private ExecutorService executor;
	
	@BeforeEach
	public void setup() throws IOException{
		executor = Executors.newFixedThreadPool(2);
		path = Paths.get(FILE_NAME);
		if(!path.toFile().exists()){
			System.out.println("文件不存在，创建新文件");
			Files.createFile(Paths.get(FILE_NAME));	
		}
		
	}
	
	@Test
	public void test() throws InterruptedException{
		executor.execute(new Worker1(path));
		executor.execute(new Worker2(path));
		Thread.sleep(10000);
	}
	
	@AfterEach
	public void teardown(){
		System.out.println("文件删除"+ (path.toFile().exists()?"失败":"成功"));
	}
}
class Worker1 implements Runnable{
	
	private Path path;
	
	public Worker1(Path Path){
		this.path = Path;
	}

	@Override
	public void run() {
		try(FileOutputStream fis=new FileOutputStream(path.toFile())) {
			FileChannel channel = fis.getChannel();
			ByteBuffer buff = ByteBuffer.allocate(1);
			byte b = 1;
			buff.put(b);
			buff.flip();
			while(true){
				channel.write(buff);
				buff.rewind();
				Thread.sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
class Worker2 implements Runnable{

	private Path path;
	
	public Worker2(Path Path){
		this.path = Path;
	}
	
	@Override
	public void run() {
		try {
			Files.delete(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
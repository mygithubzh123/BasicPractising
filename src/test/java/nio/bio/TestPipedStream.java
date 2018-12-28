/**
*   (用一句话描述该文件做什么)
* @Filename TestPipedStream.java
* @Package nio.bio
* @author neo
* @since 2018年4月8日 下午6:15:08
* @Version V1.0
*/
package nio.bio;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestPipedStream
 * @author neo
 * @since 2018年4月8日 下午6:15:08
 */
public class TestPipedStream {
	
	public static void main(String[] args) throws IOException {
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream(pos);
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new Writer(pos));
		executorService.execute(new Reader(pis));
	}

}
class Writer implements Runnable{

	private PipedOutputStream pos;
	
	public Writer(PipedOutputStream pos) {
		super();
		this.pos = pos;
	}

	@Override
	public void run() {
		try(Scanner s = new Scanner(System.in)){
			while(s.hasNextLine()){
				try {
					pos.write(s.nextLine().getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
class Reader implements Runnable{

	private PipedInputStream pis;
	
	public Reader(PipedInputStream pis) {
		super();
		this.pis = pis;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				int i = pis.available();
				if(i > 0){
					byte[] bs = new byte[i];
					pis.read(bs);
					System.out.println("pipe in:"+new String(bs));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
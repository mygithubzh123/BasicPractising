package nio.filesystem;

import java.nio.file.*;
import java.util.List;

/**
 * watchService只能监听注册路径这个层的事件,子目录下事件监听不到
 * @author neo
 *
 */
public class TestWatchService implements Runnable{

	private WatchService watchService;
	
	private Path base;
	
	private boolean isExternalError;
	
	public void initialize()throws Exception{
		String capSavePath = "G:\\tprWatchPath";
		base = Paths.get(capSavePath);
		if(!Files.exists(base) || !Files.isDirectory(base)){
			throw new Exception();
		} else {
			System.out.println("开始监听pcap文件目录:【" + capSavePath + "】");
		}
		watchService = FileSystems.getDefault().newWatchService();
		base.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				WatchKey key = watchService.take();
				List<WatchEvent<?>> events = key.pollEvents();
				for (WatchEvent<?> event : events) {
					try {
						String context = String.valueOf(event.context());
						System.out.println(context);
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
				if (!key.reset()) {
					isExternalError = true;
					System.out.println("Pcap发现服务出现错误 | 错误原因 = 重置新建文件事件监听器失败");
					break;
				}
			} catch (Exception e) {
				if (!(e instanceof ClosedWatchServiceException)) {
					System.out.println("Pcap发现服务出现错误 | 错误原因 = ");
					isExternalError = true;
				}
				break;
			}
		}
		if (!isExternalError) {
			System.out.println("-------------------------Pcap发现服务结束-------------------------");
		} else {
			System.out.println("-------------------------Pcap发现服务异常中断----------------------");
		}
	}
	
	public static void main(String[] args) throws Exception {
		TestWatchService tw = new TestWatchService();
		tw.initialize();
		new Thread(tw).start();
	}
}

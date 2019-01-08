package concurrent.synchronizer.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 打印机管理员
 *
 * @author neo
 * 2019/1/8 11:18 AM
 */
public class SharedPrinterManager {

	private static List<Printer> printers = new ArrayList<>(3);

	static {
		printers.add(new Printer(100));
		printers.add(new Printer(101));
		printers.add(new Printer(102));
	}

	private static Semaphore semaphore = new Semaphore(3,false);

	public static Printer getPrinter(Worker worker) throws InterruptedException {
		semaphore.acquire();
		Printer printer = printers.remove(0);
		System.out.println(worker+" get "+ printer);
		return printer;
	}

	public static void returnPrinter(Printer printer){
		printers.add(printer);
		semaphore.release();
	}
}

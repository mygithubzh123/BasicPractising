package concurrent.synchronizer.semaphore;

/**
 * 打印任务
 *
 * @author liaofeng
 * 2019/1/8 11:16 AM
 */
public class PrintTask implements Runnable {

	private Worker worker;

	public PrintTask(Worker worker) {
		this.worker = worker;
	}

	@Override
	public void run() {
		try {
			Printer printer = SharedPrinterManager.getPrinter(worker);
			printer.print();
			SharedPrinterManager.returnPrinter(printer);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

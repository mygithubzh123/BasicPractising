package runtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ping {
	public static void main(String args[]) {
		List<String> ips = new ArrayList<String>();
		ips.add("192.168.0.37");
		ips.add("192.168.0.38");
		ips.add("192.168.0.157");
		ExecutorService executor = Executors.newFixedThreadPool(ips.size());
		for(String ip:ips){
			executor.execute(new PingIP(ip));
		}
	}
	public static void pingIP(String host){
		
	}
}
class PingIP implements Runnable{

	private String host;
	
	public PingIP(String host){
		this.host = host;
	}
	
	@Override
	public void run() {
		String line = null;
		try {
			while(true){
				Process pro = Runtime.getRuntime().exec("ping " + host);
				BufferedReader buf = new BufferedReader(new InputStreamReader(
						pro.getInputStream(),"GBK"));
				while ((line = buf.readLine()) != null){
					System.out.println(line);
				}
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}

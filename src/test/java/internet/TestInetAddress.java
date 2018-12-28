/**
*   (用一句话描述该文件做什么)
* @Filename TestInetAddress.java
* @Package internet
* @author neo
* @since 2018年2月24日 下午5:05:12
* @Version V1.0
*/
package internet;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.BitSet;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestInetAddress
 * @author neo
 * @since 2018年2月24日 下午5:05:12
 */
public class TestInetAddress {

	@Test
	public void test() throws UnknownHostException{
		InetAddress.getLocalHost();
		System.out.println(InetAddress.getLoopbackAddress().getHostAddress());
	}
	
	@Test
	public void testipport(){
		String ipRange = "192.168.0.1-10";
		//192.168.0.1-10
		String[] ipSplits = ipRange.split("-");
		//192.168.0.1
		String startIp = ipSplits[0];
		//192.168.0
		int lastDotIndex = startIp.lastIndexOf(".");
		String prefix = startIp.substring(0,lastDotIndex+1);
		BitSet ports = new BitSet(256);
		String aPortRange = "500-505";
		String[] portSplits = aPortRange.split("-");
		for(int port = Integer.parseInt(portSplits[0]);port <= Integer.parseInt(portSplits[1]);port++){
			ports.set(port);
		}
		for(int i = ipToInt(startIp);i<=ipToInt(ipSplits[1]);i++){
			String ip = prefix + i;
			System.out.println(ipToInt(ip)+ports.toString());
		}
	}
	
	private static int ipToInt(String ip) {
		String[] ipnum = ip.split("\\.");
		if(ipnum.length != 4) {
			throw new IllegalArgumentException("wrong ip string");
		} else {
			return (Integer.parseInt(ipnum[3])<<24) + 
				(Integer.parseInt(ipnum[2])<<16) + 
				(Integer.parseInt(ipnum[1])<<8) + 
				(Integer.parseInt(ipnum[0])) ;
		}
	}
}


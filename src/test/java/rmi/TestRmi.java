/**
*   (用一句话描述该文件做什么)
* @Filename TestRmi.java
* @Package rmi
* @author neo
* @since 2018年4月8日 上午11:10:20
* @Version V1.0
*/
package rmi;

import org.junit.jupiter.api.Test;

import java.rmi.Remote;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestRmi
 * @author neo
 * @since 2018年4月8日 上午11:10:20
 */
public class TestRmi {

	@Test
	public void test(){
		
	}
}
interface RemoteService extends Remote{
	
	public void getRemoteName();
}
class MyRemoteService implements RemoteService{

	@Override
	public void getRemoteName() {
		
	}
	
}
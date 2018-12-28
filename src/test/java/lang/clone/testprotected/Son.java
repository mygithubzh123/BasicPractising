/**
*   (用一句话描述该文件做什么)
* @Filename Son.java
* @Package lang.clone.testprotected
* @author neo
* @since 2018年2月28日 上午10:18:31
* @Version V1.0
*/
package lang.clone.testprotected;

/**
 *   (这里用一句话描述这个类的作用)
 *    Son
 * @author neo
 * @since 2018年2月28日 上午10:18:31
 */
public class Son extends Father{

	@Override
	protected void getMoney() throws Exception {
		System.out.print("when son ask,");
		super.getMoney();
	}
}

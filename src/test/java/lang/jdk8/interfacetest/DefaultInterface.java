package lang.jdk8.interfacetest;
/**
 *   (用一句话描述该文件做什么)
 * @Filename DefaultInterface.java
 * @Package 
 * @author neo
 * @since 2017年5月2日 下午5:12:48
 * @Version V1.0
 */

/**
 *   (这里用一句话描述这个类的作用)
 *    DefaultInterface
 * @author neo
 * @since 2017年5月2日 下午5:12:48
 */
public interface DefaultInterface {

	public default void defaultMethod(){
		System.out.println("default method");
	}
	
	public void method();
}
